package com.dao;

import com.entity.HuishouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.HuishouView;

/**
 * 垃圾回收 Dao 接口
 *
 * @author 
 */
public interface HuishouDao extends BaseMapper<HuishouEntity> {

   List<HuishouView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
