package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.HuishouEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 垃圾回收
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("huishou")
public class HuishouView extends HuishouEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 垃圾回收类型的值
	*/
	@ColumnInfo(comment="垃圾回收类型的字典表值",type="varchar(200)")
	private String huishouValue;




	public HuishouView() {

	}

	public HuishouView(HuishouEntity huishouEntity) {
		try {
			BeanUtils.copyProperties(this, huishouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 垃圾回收类型的值
	*/
	public String getHuishouValue() {
		return huishouValue;
	}
	/**
	* 设置： 垃圾回收类型的值
	*/
	public void setHuishouValue(String huishouValue) {
		this.huishouValue = huishouValue;
	}




	@Override
	public String toString() {
		return "HuishouView{" +
			", huishouValue=" + huishouValue +
			"} " + super.toString();
	}
}
