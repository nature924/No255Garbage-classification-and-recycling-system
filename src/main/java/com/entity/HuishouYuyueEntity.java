package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 垃圾出库申请
 *
 * @author 
 * @email
 */
@TableName("huishou_yuyue")
public class HuishouYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuishouYuyueEntity() {

	}

	public HuishouYuyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 报名编号
     */
    @ColumnInfo(comment="报名编号",type="varchar(200)")
    @TableField(value = "huishou_yuyue_uuid_number")

    private String huishouYuyueUuidNumber;


    /**
     * 垃圾回收
     */
    @ColumnInfo(comment="垃圾回收",type="int(11)")
    @TableField(value = "huishou_id")

    private Integer huishouId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 报名理由
     */
    @ColumnInfo(comment="报名理由",type="longtext")
    @TableField(value = "huishou_yuyue_text")

    private String huishouYuyueText;


    /**
     * 出库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="出库时间",type="timestamp")
    @TableField(value = "huishou_chuku_time")

    private Date huishouChukuTime;


    /**
     * 申请状态
     */
    @ColumnInfo(comment="申请状态",type="int(11)")
    @TableField(value = "huishou_yuyue_yesno_types")

    private Integer huishouYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="longtext")
    @TableField(value = "huishou_yuyue_yesno_text")

    private String huishouYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "huishou_yuyue_shenhe_time")

    private Date huishouYuyueShenheTime;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="活动报名时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：报名编号
	 */
    public String getHuishouYuyueUuidNumber() {
        return huishouYuyueUuidNumber;
    }
    /**
	 * 设置：报名编号
	 */

    public void setHuishouYuyueUuidNumber(String huishouYuyueUuidNumber) {
        this.huishouYuyueUuidNumber = huishouYuyueUuidNumber;
    }
    /**
	 * 获取：垃圾回收
	 */
    public Integer getHuishouId() {
        return huishouId;
    }
    /**
	 * 设置：垃圾回收
	 */

    public void setHuishouId(Integer huishouId) {
        this.huishouId = huishouId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：报名理由
	 */
    public String getHuishouYuyueText() {
        return huishouYuyueText;
    }
    /**
	 * 设置：报名理由
	 */

    public void setHuishouYuyueText(String huishouYuyueText) {
        this.huishouYuyueText = huishouYuyueText;
    }
    /**
	 * 获取：出库时间
	 */
    public Date getHuishouChukuTime() {
        return huishouChukuTime;
    }
    /**
	 * 设置：出库时间
	 */

    public void setHuishouChukuTime(Date huishouChukuTime) {
        this.huishouChukuTime = huishouChukuTime;
    }
    /**
	 * 获取：申请状态
	 */
    public Integer getHuishouYuyueYesnoTypes() {
        return huishouYuyueYesnoTypes;
    }
    /**
	 * 设置：申请状态
	 */

    public void setHuishouYuyueYesnoTypes(Integer huishouYuyueYesnoTypes) {
        this.huishouYuyueYesnoTypes = huishouYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getHuishouYuyueYesnoText() {
        return huishouYuyueYesnoText;
    }
    /**
	 * 设置：审核回复
	 */

    public void setHuishouYuyueYesnoText(String huishouYuyueYesnoText) {
        this.huishouYuyueYesnoText = huishouYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getHuishouYuyueShenheTime() {
        return huishouYuyueShenheTime;
    }
    /**
	 * 设置：审核时间
	 */

    public void setHuishouYuyueShenheTime(Date huishouYuyueShenheTime) {
        this.huishouYuyueShenheTime = huishouYuyueShenheTime;
    }
    /**
	 * 获取：活动报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：活动报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "HuishouYuyue{" +
            ", id=" + id +
            ", huishouYuyueUuidNumber=" + huishouYuyueUuidNumber +
            ", huishouId=" + huishouId +
            ", yonghuId=" + yonghuId +
            ", huishouYuyueText=" + huishouYuyueText +
            ", huishouChukuTime=" + DateUtil.convertString(huishouChukuTime,"yyyy-MM-dd") +
            ", huishouYuyueYesnoTypes=" + huishouYuyueYesnoTypes +
            ", huishouYuyueYesnoText=" + huishouYuyueYesnoText +
            ", huishouYuyueShenheTime=" + DateUtil.convertString(huishouYuyueShenheTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
