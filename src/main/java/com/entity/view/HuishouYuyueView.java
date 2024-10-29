package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.HuishouYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 垃圾出库申请
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("huishou_yuyue")
public class HuishouYuyueView extends HuishouYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 申请状态的值
	*/
	@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
	private String huishouYuyueYesnoValue;

	//级联表 垃圾回收
		/**
		* 垃圾回收名称
		*/

		@ColumnInfo(comment="垃圾回收名称",type="varchar(200)")
		private String huishouName;
		/**
		* 垃圾回收编号
		*/

		@ColumnInfo(comment="垃圾回收编号",type="varchar(200)")
		private String huishouUuidNumber;
		/**
		* 垃圾回收照片
		*/

		@ColumnInfo(comment="垃圾回收照片",type="varchar(200)")
		private String huishouPhoto;
		/**
		* 垃圾回收地点
		*/

		@ColumnInfo(comment="垃圾回收地点",type="varchar(200)")
		private String huishouAddress;
		/**
		* 垃圾回收类型
		*/
		@ColumnInfo(comment="垃圾回收类型",type="int(11)")
		private Integer huishouTypes;
			/**
			* 垃圾回收类型的值
			*/
			@ColumnInfo(comment="垃圾回收类型的字典表值",type="varchar(200)")
			private String huishouValue;
		/**
		* 垃圾回收库存
		*/

		@ColumnInfo(comment="垃圾回收库存",type="int(11)")
		private Integer huishouKucunNumber;
		/**
		* 入库时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="入库时间",type="timestamp")
		private Date huishouTime;
		/**
		* 垃圾回收介绍
		*/

		@ColumnInfo(comment="垃圾回收介绍",type="longtext")
		private String huishouContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer huishouDelete;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;



	public HuishouYuyueView() {

	}

	public HuishouYuyueView(HuishouYuyueEntity huishouYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, huishouYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 申请状态的值
	*/
	public String getHuishouYuyueYesnoValue() {
		return huishouYuyueYesnoValue;
	}
	/**
	* 设置： 申请状态的值
	*/
	public void setHuishouYuyueYesnoValue(String huishouYuyueYesnoValue) {
		this.huishouYuyueYesnoValue = huishouYuyueYesnoValue;
	}


	//级联表的get和set 垃圾回收

		/**
		* 获取： 垃圾回收名称
		*/
		public String getHuishouName() {
			return huishouName;
		}
		/**
		* 设置： 垃圾回收名称
		*/
		public void setHuishouName(String huishouName) {
			this.huishouName = huishouName;
		}

		/**
		* 获取： 垃圾回收编号
		*/
		public String getHuishouUuidNumber() {
			return huishouUuidNumber;
		}
		/**
		* 设置： 垃圾回收编号
		*/
		public void setHuishouUuidNumber(String huishouUuidNumber) {
			this.huishouUuidNumber = huishouUuidNumber;
		}

		/**
		* 获取： 垃圾回收照片
		*/
		public String getHuishouPhoto() {
			return huishouPhoto;
		}
		/**
		* 设置： 垃圾回收照片
		*/
		public void setHuishouPhoto(String huishouPhoto) {
			this.huishouPhoto = huishouPhoto;
		}

		/**
		* 获取： 垃圾回收地点
		*/
		public String getHuishouAddress() {
			return huishouAddress;
		}
		/**
		* 设置： 垃圾回收地点
		*/
		public void setHuishouAddress(String huishouAddress) {
			this.huishouAddress = huishouAddress;
		}
		/**
		* 获取： 垃圾回收类型
		*/
		public Integer getHuishouTypes() {
			return huishouTypes;
		}
		/**
		* 设置： 垃圾回收类型
		*/
		public void setHuishouTypes(Integer huishouTypes) {
			this.huishouTypes = huishouTypes;
		}


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

		/**
		* 获取： 垃圾回收库存
		*/
		public Integer getHuishouKucunNumber() {
			return huishouKucunNumber;
		}
		/**
		* 设置： 垃圾回收库存
		*/
		public void setHuishouKucunNumber(Integer huishouKucunNumber) {
			this.huishouKucunNumber = huishouKucunNumber;
		}

		/**
		* 获取： 入库时间
		*/
		public Date getHuishouTime() {
			return huishouTime;
		}
		/**
		* 设置： 入库时间
		*/
		public void setHuishouTime(Date huishouTime) {
			this.huishouTime = huishouTime;
		}

		/**
		* 获取： 垃圾回收介绍
		*/
		public String getHuishouContent() {
			return huishouContent;
		}
		/**
		* 设置： 垃圾回收介绍
		*/
		public void setHuishouContent(String huishouContent) {
			this.huishouContent = huishouContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getHuishouDelete() {
			return huishouDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setHuishouDelete(Integer huishouDelete) {
			this.huishouDelete = huishouDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}


	@Override
	public String toString() {
		return "HuishouYuyueView{" +
			", huishouYuyueYesnoValue=" + huishouYuyueYesnoValue +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", huishouName=" + huishouName +
			", huishouUuidNumber=" + huishouUuidNumber +
			", huishouPhoto=" + huishouPhoto +
			", huishouAddress=" + huishouAddress +
			", huishouKucunNumber=" + huishouKucunNumber +
			", huishouTime=" + DateUtil.convertString(huishouTime,"yyyy-MM-dd") +
			", huishouContent=" + huishouContent +
			", huishouDelete=" + huishouDelete +
			"} " + super.toString();
	}
}
