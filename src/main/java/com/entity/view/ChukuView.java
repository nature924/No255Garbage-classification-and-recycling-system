package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ChukuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 运输
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("chuku")
public class ChukuView extends ChukuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 运输类型的值
	*/
	@ColumnInfo(comment="运输类型的字典表值",type="varchar(200)")
	private String chukuValue;

	//级联表 垃圾出库申请
		/**
		* 报名编号
		*/

		@ColumnInfo(comment="报名编号",type="varchar(200)")
		private String huishouYuyueUuidNumber;
										 
		/**
		* 垃圾出库申请 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer huishouYuyueYonghuId;
		/**
		* 报名理由
		*/

		@ColumnInfo(comment="报名理由",type="longtext")
		private String huishouYuyueText;
		/**
		* 出库时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="出库时间",type="timestamp")
		private Date huishouChukuTime;
		/**
		* 申请状态
		*/
		@ColumnInfo(comment="申请状态",type="int(11)")
		private Integer huishouYuyueYesnoTypes;
			/**
			* 申请状态的值
			*/
			@ColumnInfo(comment="申请状态的字典表值",type="varchar(200)")
			private String huishouYuyueYesnoValue;
		/**
		* 审核回复
		*/

		@ColumnInfo(comment="审核回复",type="longtext")
		private String huishouYuyueYesnoText;
		/**
		* 审核时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="审核时间",type="timestamp")
		private Date huishouYuyueShenheTime;



	public ChukuView() {

	}

	public ChukuView(ChukuEntity chukuEntity) {
		try {
			BeanUtils.copyProperties(this, chukuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 运输类型的值
	*/
	public String getChukuValue() {
		return chukuValue;
	}
	/**
	* 设置： 运输类型的值
	*/
	public void setChukuValue(String chukuValue) {
		this.chukuValue = chukuValue;
	}


	//级联表的get和set 垃圾出库申请

		/**
		* 获取： 报名编号
		*/
		public String getHuishouYuyueUuidNumber() {
			return huishouYuyueUuidNumber;
		}
		/**
		* 设置： 报名编号
		*/
		public void setHuishouYuyueUuidNumber(String huishouYuyueUuidNumber) {
			this.huishouYuyueUuidNumber = huishouYuyueUuidNumber;
		}
		/**
		* 获取：垃圾出库申请 的 用户
		*/
		public Integer getHuishouYuyueYonghuId() {
			return huishouYuyueYonghuId;
		}
		/**
		* 设置：垃圾出库申请 的 用户
		*/
		public void setHuishouYuyueYonghuId(Integer huishouYuyueYonghuId) {
			this.huishouYuyueYonghuId = huishouYuyueYonghuId;
		}

		/**
		* 获取： 报名理由
		*/
		public String getHuishouYuyueText() {
			return huishouYuyueText;
		}
		/**
		* 设置： 报名理由
		*/
		public void setHuishouYuyueText(String huishouYuyueText) {
			this.huishouYuyueText = huishouYuyueText;
		}

		/**
		* 获取： 出库时间
		*/
		public Date getHuishouChukuTime() {
			return huishouChukuTime;
		}
		/**
		* 设置： 出库时间
		*/
		public void setHuishouChukuTime(Date huishouChukuTime) {
			this.huishouChukuTime = huishouChukuTime;
		}
		/**
		* 获取： 申请状态
		*/
		public Integer getHuishouYuyueYesnoTypes() {
			return huishouYuyueYesnoTypes;
		}
		/**
		* 设置： 申请状态
		*/
		public void setHuishouYuyueYesnoTypes(Integer huishouYuyueYesnoTypes) {
			this.huishouYuyueYesnoTypes = huishouYuyueYesnoTypes;
		}


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

		/**
		* 获取： 审核回复
		*/
		public String getHuishouYuyueYesnoText() {
			return huishouYuyueYesnoText;
		}
		/**
		* 设置： 审核回复
		*/
		public void setHuishouYuyueYesnoText(String huishouYuyueYesnoText) {
			this.huishouYuyueYesnoText = huishouYuyueYesnoText;
		}

		/**
		* 获取： 审核时间
		*/
		public Date getHuishouYuyueShenheTime() {
			return huishouYuyueShenheTime;
		}
		/**
		* 设置： 审核时间
		*/
		public void setHuishouYuyueShenheTime(Date huishouYuyueShenheTime) {
			this.huishouYuyueShenheTime = huishouYuyueShenheTime;
		}


	@Override
	public String toString() {
		return "ChukuView{" +
			", chukuValue=" + chukuValue +
			", huishouYuyueUuidNumber=" + huishouYuyueUuidNumber +
			", huishouYuyueText=" + huishouYuyueText +
			", huishouChukuTime=" + DateUtil.convertString(huishouChukuTime,"yyyy-MM-dd") +
			", huishouYuyueYesnoText=" + huishouYuyueYesnoText +
			", huishouYuyueShenheTime=" + DateUtil.convertString(huishouYuyueShenheTime,"yyyy-MM-dd") +
			"} " + super.toString();
	}
}
