
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
 * 垃圾回收
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/huishou")
public class HuishouController {
    private static final Logger logger = LoggerFactory.getLogger(HuishouController.class);

    private static final String TABLE_NAME = "huishou";

    @Autowired
    private HuishouService huishouService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private ChukuService chukuService;//运输
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//公告
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
        params.put("huishouDeleteStart",1);params.put("huishouDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = huishouService.queryPage(params);

        //字典表数据转换
        List<HuishouView> list =(List<HuishouView>)page.getList();
        for(HuishouView c:list){
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
        HuishouEntity huishou = huishouService.selectById(id);
        if(huishou !=null){
            //entity转view
            HuishouView view = new HuishouView();
            BeanUtils.copyProperties( huishou , view );//把实体数据重构到view中
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
    public R save(@RequestBody HuishouEntity huishou, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,huishou:{}",this.getClass().getName(),huishou.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<HuishouEntity> queryWrapper = new EntityWrapper<HuishouEntity>()
            .eq("huishou_name", huishou.getHuishouName())
            .eq("huishou_address", huishou.getHuishouAddress())
            .eq("huishou_types", huishou.getHuishouTypes())
            .eq("huishou_kucun_number", huishou.getHuishouKucunNumber())
            .eq("huishou_delete", huishou.getHuishouDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HuishouEntity huishouEntity = huishouService.selectOne(queryWrapper);
        if(huishouEntity==null){
            huishou.setHuishouDelete(1);
            huishou.setInsertTime(new Date());
            huishou.setCreateTime(new Date());
            huishouService.insert(huishou);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HuishouEntity huishou, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,huishou:{}",this.getClass().getName(),huishou.toString());
        HuishouEntity oldHuishouEntity = huishouService.selectById(huishou.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(huishou.getHuishouPhoto()) || "null".equals(huishou.getHuishouPhoto())){
                huishou.setHuishouPhoto(null);
        }

            huishouService.updateById(huishou);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<HuishouEntity> oldHuishouList =huishouService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<HuishouEntity> list = new ArrayList<>();
        for(Integer id:ids){
            HuishouEntity huishouEntity = new HuishouEntity();
            huishouEntity.setId(id);
            huishouEntity.setHuishouDelete(2);
            list.add(huishouEntity);
        }
        if(list != null && list.size() >0){
            huishouService.updateBatchById(list);
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
            List<HuishouEntity> huishouList = new ArrayList<>();//上传的东西
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
                            HuishouEntity huishouEntity = new HuishouEntity();
//                            huishouEntity.setHuishouName(data.get(0));                    //垃圾回收名称 要改的
//                            huishouEntity.setHuishouUuidNumber(data.get(0));                    //垃圾回收编号 要改的
//                            huishouEntity.setHuishouPhoto("");//详情和图片
//                            huishouEntity.setHuishouAddress(data.get(0));                    //垃圾回收地点 要改的
//                            huishouEntity.setHuishouTypes(Integer.valueOf(data.get(0)));   //垃圾回收类型 要改的
//                            huishouEntity.setHuishouKucunNumber(Integer.valueOf(data.get(0)));   //垃圾回收库存 要改的
//                            huishouEntity.setHuishouTime(sdf.parse(data.get(0)));          //入库时间 要改的
//                            huishouEntity.setHuishouContent("");//详情和图片
//                            huishouEntity.setHuishouDelete(1);//逻辑删除字段
//                            huishouEntity.setInsertTime(date);//时间
//                            huishouEntity.setCreateTime(date);//时间
                            huishouList.add(huishouEntity);


                            //把要查询是否重复的字段放入map中
                                //垃圾回收编号
                                if(seachFields.containsKey("huishouUuidNumber")){
                                    List<String> huishouUuidNumber = seachFields.get("huishouUuidNumber");
                                    huishouUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> huishouUuidNumber = new ArrayList<>();
                                    huishouUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("huishouUuidNumber",huishouUuidNumber);
                                }
                        }

                        //查询是否重复
                         //垃圾回收编号
                        List<HuishouEntity> huishouEntities_huishouUuidNumber = huishouService.selectList(new EntityWrapper<HuishouEntity>().in("huishou_uuid_number", seachFields.get("huishouUuidNumber")).eq("huishou_delete", 1));
                        if(huishouEntities_huishouUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(HuishouEntity s:huishouEntities_huishouUuidNumber){
                                repeatFields.add(s.getHuishouUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [垃圾回收编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        huishouService.insertBatch(huishouList);
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

