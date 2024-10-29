
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
 * 运输
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chuku")
public class ChukuController {
    private static final Logger logger = LoggerFactory.getLogger(ChukuController.class);

    private static final String TABLE_NAME = "chuku";

    @Autowired
    private ChukuService chukuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private HuishouService huishouService;//垃圾回收
    @Autowired
    private HuishouYuyueService huishouYuyueService;//垃圾出库申请
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
        params.put("chukuDeleteStart",1);params.put("chukuDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = chukuService.queryPage(params);

        //字典表数据转换
        List<ChukuView> list =(List<ChukuView>)page.getList();
        for(ChukuView c:list){
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
        ChukuEntity chuku = chukuService.selectById(id);
        if(chuku !=null){
            //entity转view
            ChukuView view = new ChukuView();
            BeanUtils.copyProperties( chuku , view );//把实体数据重构到view中
            //级联表 垃圾出库申请
            //级联表
            HuishouYuyueEntity huishouYuyue = huishouYuyueService.selectById(chuku.getHuishouYuyueId());
            if(huishouYuyue != null){
            BeanUtils.copyProperties( huishouYuyue , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setHuishouYuyueId(huishouYuyue.getId());
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
    public R save(@RequestBody ChukuEntity chuku, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chuku:{}",this.getClass().getName(),chuku.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ChukuEntity> queryWrapper = new EntityWrapper<ChukuEntity>()
            .eq("huishou_yuyue_id", chuku.getHuishouYuyueId())
            .eq("chuku_name", chuku.getChukuName())
            .eq("chuku_address", chuku.getChukuAddress())
            .eq("chuku_types", chuku.getChukuTypes())
            .eq("chuku_mudi_address", chuku.getChukuMudiAddress())
            .eq("chuku_delete", chuku.getChukuDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChukuEntity chukuEntity = chukuService.selectOne(queryWrapper);
        if(chukuEntity==null){
            chuku.setChukuDelete(1);
            chuku.setInsertTime(new Date());
            chuku.setCreateTime(new Date());
            chukuService.insert(chuku);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChukuEntity chuku, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,chuku:{}",this.getClass().getName(),chuku.toString());
        ChukuEntity oldChukuEntity = chukuService.selectById(chuku.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(chuku.getChukuPhoto()) || "null".equals(chuku.getChukuPhoto())){
                chuku.setChukuPhoto(null);
        }

            chukuService.updateById(chuku);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<ChukuEntity> oldChukuList =chukuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<ChukuEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ChukuEntity chukuEntity = new ChukuEntity();
            chukuEntity.setId(id);
            chukuEntity.setChukuDelete(2);
            list.add(chukuEntity);
        }
        if(list != null && list.size() >0){
            chukuService.updateBatchById(list);
        }

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
            List<ChukuEntity> chukuList = new ArrayList<>();//上传的东西
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
                            ChukuEntity chukuEntity = new ChukuEntity();
//                            chukuEntity.setHuishouYuyueId(Integer.valueOf(data.get(0)));   //垃圾运输 要改的
//                            chukuEntity.setChukuName(data.get(0));                    //运输名称 要改的
//                            chukuEntity.setChukuUuidNumber(data.get(0));                    //运输编号 要改的
//                            chukuEntity.setChukuPhoto("");//详情和图片
//                            chukuEntity.setChukuAddress(data.get(0));                    //运输地点 要改的
//                            chukuEntity.setChukuTypes(Integer.valueOf(data.get(0)));   //运输类型 要改的
//                            chukuEntity.setChukuMudiAddress(data.get(0));                    //运输目的地 要改的
//                            chukuEntity.setChukuContent("");//详情和图片
//                            chukuEntity.setChukuDelete(1);//逻辑删除字段
//                            chukuEntity.setInsertTime(date);//时间
//                            chukuEntity.setCreateTime(date);//时间
                            chukuList.add(chukuEntity);


                            //把要查询是否重复的字段放入map中
                                //运输编号
                                if(seachFields.containsKey("chukuUuidNumber")){
                                    List<String> chukuUuidNumber = seachFields.get("chukuUuidNumber");
                                    chukuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chukuUuidNumber = new ArrayList<>();
                                    chukuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chukuUuidNumber",chukuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //运输编号
                        List<ChukuEntity> chukuEntities_chukuUuidNumber = chukuService.selectList(new EntityWrapper<ChukuEntity>().in("chuku_uuid_number", seachFields.get("chukuUuidNumber")).eq("chuku_delete", 1));
                        if(chukuEntities_chukuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChukuEntity s:chukuEntities_chukuUuidNumber){
                                repeatFields.add(s.getChukuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [运输编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chukuService.insertBatch(chukuList);
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

