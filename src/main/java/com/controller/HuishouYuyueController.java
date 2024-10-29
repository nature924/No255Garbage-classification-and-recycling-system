
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 垃圾出库申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huishouYuyue")
public class HuishouYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(HuishouYuyueController.class);

    private static final String TABLE_NAME = "huishouYuyue";

    @Autowired
    private HuishouYuyueService huishouYuyueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChukuService chukuService;//运输
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private HuishouService huishouService;//垃圾回收
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = huishouYuyueService.queryPage(params);

        //字典表数据转换
        List<HuishouYuyueView> list =(List<HuishouYuyueView>)page.getList();
        for(HuishouYuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        HuishouYuyueEntity huishouYuyue = huishouYuyueService.selectById(id);
        if(huishouYuyue !=null){
            //entity转view
            HuishouYuyueView view = new HuishouYuyueView();
            BeanUtils.copyProperties( huishouYuyue , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(huishouYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 垃圾回收
            //级联表
            HuishouEntity huishou = huishouService.selectById(huishouYuyue.getHuishouId());
            if(huishou != null){
            BeanUtils.copyProperties( huishou , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setHuishouId(huishou.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody HuishouYuyueEntity huishouYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huishouYuyue:{}",this.getClass().getName(),huishouYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            huishouYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<HuishouYuyueEntity> queryWrapper = new EntityWrapper<HuishouYuyueEntity>()
            .eq("huishou_id", huishouYuyue.getHuishouId())
            .eq("yonghu_id", huishouYuyue.getYonghuId())
            .in("huishou_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuishouYuyueEntity huishouYuyueEntity = huishouYuyueService.selectOne(queryWrapper);
        if(huishouYuyueEntity==null){
            huishouYuyue.setHuishouYuyueYesnoTypes(1);
            huishouYuyueService.insert(huishouYuyue);
            return R.ok();
        }else {
            if(huishouYuyueEntity.getHuishouYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(huishouYuyueEntity.getHuishouYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuishouYuyueEntity huishouYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,huishouYuyue:{}",this.getClass().getName(),huishouYuyue.toString());
        HuishouYuyueEntity oldHuishouYuyueEntity = huishouYuyueService.selectById(huishouYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            huishouYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            huishouYuyueService.updateById(huishouYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody HuishouYuyueEntity huishouYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,huishouYuyueEntity:{}",this.getClass().getName(),huishouYuyueEntity.toString());

        HuishouYuyueEntity oldHuishouYuyue = huishouYuyueService.selectById(huishouYuyueEntity.getId());//查询原先数据

//        if(huishouYuyueEntity.getHuishouYuyueYesnoTypes() == 2){//通过
//            huishouYuyueEntity.setHuishouYuyueTypes();
//        }else if(huishouYuyueEntity.getHuishouYuyueYesnoTypes() == 3){//拒绝
//            huishouYuyueEntity.setHuishouYuyueTypes();
//        }
        huishouYuyueEntity.setHuishouYuyueShenheTime(new Date());//审核时间
        huishouYuyueService.updateById(huishouYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<HuishouYuyueEntity> oldHuishouYuyueList =huishouYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        huishouYuyueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<HuishouYuyueEntity> huishouYuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            HuishouYuyueEntity huishouYuyueEntity = new HuishouYuyueEntity();
//                            huishouYuyueEntity.setHuishouYuyueUuidNumber(data.get(0));                    //报名编号 要改的
//                            huishouYuyueEntity.setHuishouId(Integer.valueOf(data.get(0)));   //垃圾回收 要改的
//                            huishouYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            huishouYuyueEntity.setHuishouYuyueText(data.get(0));                    //报名理由 要改的
//                            huishouYuyueEntity.setHuishouChukuTime(sdf.parse(data.get(0)));          //出库时间 要改的
//                            huishouYuyueEntity.setHuishouYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            huishouYuyueEntity.setHuishouYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            huishouYuyueEntity.setHuishouYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            huishouYuyueEntity.setInsertTime(date);//时间
//                            huishouYuyueEntity.setCreateTime(date);//时间
                            huishouYuyueList.add(huishouYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //报名编号
                                if(seachFields.containsKey("huishouYuyueUuidNumber")){
                                    List<String> huishouYuyueUuidNumber = seachFields.get("huishouYuyueUuidNumber");
                                    huishouYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> huishouYuyueUuidNumber = new ArrayList<>();
                                    huishouYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("huishouYuyueUuidNumber",huishouYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名编号
                        List<HuishouYuyueEntity> huishouYuyueEntities_huishouYuyueUuidNumber = huishouYuyueService.selectList(new EntityWrapper<HuishouYuyueEntity>().in("huishou_yuyue_uuid_number", seachFields.get("huishouYuyueUuidNumber")));
                        if(huishouYuyueEntities_huishouYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuishouYuyueEntity s:huishouYuyueEntities_huishouYuyueUuidNumber){
                                repeatFields.add(s.getHuishouYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huishouYuyueService.insertBatch(huishouYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




}

