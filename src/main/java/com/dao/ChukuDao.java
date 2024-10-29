package com.dao;

import com.entity.ChukuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ChukuView;

/**
 * 运输 Dao 接口
 *
 * @author 
 */
public interface ChukuDao extends BaseMapper<ChukuEntity> {

   List<ChukuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
