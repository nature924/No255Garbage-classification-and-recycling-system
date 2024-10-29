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
 * 垃圾回收
 *
 * @author 
 * @email
 */
@TableName("huishou")
public class HuishouEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public HuishouEntity() {

	}

	public HuishouEntity(T t) {
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
     * 垃圾回收名称
     */
    @ColumnInfo(comment="垃圾回收名称",type="varchar(200)")
    @TableField(value = "huishou_name")

    private String huishouName;


    /**
     * 垃圾回收编号
     */
    @ColumnInfo(comment="垃圾回收编号",type="varchar(200)")
    @TableField(value = "huishou_uuid_number")

    private String huishouUuidNumber;


    /**
     * 垃圾回收照片
     */
    @ColumnInfo(comment="垃圾回收照片",type="varchar(200)")
    @TableField(value = "huishou_photo")

    private String huishouPhoto;


    /**
     * 垃圾回收地点
     */
    @ColumnInfo(comment="垃圾回收地点",type="varchar(200)")
    @TableField(value = "huishou_address")

    private String huishouAddress;


    /**
     * 垃圾回收类型
     */
    @ColumnInfo(comment="垃圾回收类型",type="int(11)")
    @TableField(value = "huishou_types")

    private Integer huishouTypes;


    /**
     * 垃圾回收库存
     */
    @ColumnInfo(comment="垃圾回收库存",type="int(11)")
    @TableField(value = "huishou_kucun_number")

    private Integer huishouKucunNumber;


    /**
     * 入库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="入库时间",type="timestamp")
    @TableField(value = "huishou_time")

    private Date huishouTime;


    /**
     * 垃圾回收介绍
     */
    @ColumnInfo(comment="垃圾回收介绍",type="longtext")
    @TableField(value = "huishou_content")

    private String huishouContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "huishou_delete")

    private Integer huishouDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：垃圾回收名称
	 */
    public String getHuishouName() {
        return huishouName;
    }
    /**
	 * 设置：垃圾回收名称
	 */

    public void setHuishouName(String huishouName) {
        this.huishouName = huishouName;
    }
    /**
	 * 获取：垃圾回收编号
	 */
    public String getHuishouUuidNumber() {
        return huishouUuidNumber;
    }
    /**
	 * 设置：垃圾回收编号
	 */

    public void setHuishouUuidNumber(String huishouUuidNumber) {
        this.huishouUuidNumber = huishouUuidNumber;
    }
    /**
	 * 获取：垃圾回收照片
	 */
    public String getHuishouPhoto() {
        return huishouPhoto;
    }
    /**
	 * 设置：垃圾回收照片
	 */

    public void setHuishouPhoto(String huishouPhoto) {
        this.huishouPhoto = huishouPhoto;
    }
    /**
	 * 获取：垃圾回收地点
	 */
    public String getHuishouAddress() {
        return huishouAddress;
    }
    /**
	 * 设置：垃圾回收地点
	 */

    public void setHuishouAddress(String huishouAddress) {
        this.huishouAddress = huishouAddress;
    }
    /**
	 * 获取：垃圾回收类型
	 */
    public Integer getHuishouTypes() {
        return huishouTypes;
    }
    /**
	 * 设置：垃圾回收类型
	 */

    public void setHuishouTypes(Integer huishouTypes) {
        this.huishouTypes = huishouTypes;
    }
    /**
	 * 获取：垃圾回收库存
	 */
    public Integer getHuishouKucunNumber() {
        return huishouKucunNumber;
    }
    /**
	 * 设置：垃圾回收库存
	 */

    public void setHuishouKucunNumber(Integer huishouKucunNumber) {
        this.huishouKucunNumber = huishouKucunNumber;
    }
    /**
	 * 获取：入库时间
	 */
    public Date getHuishouTime() {
        return huishouTime;
    }
    /**
	 * 设置：入库时间
	 */

    public void setHuishouTime(Date huishouTime) {
        this.huishouTime = huishouTime;
    }
    /**
	 * 获取：垃圾回收介绍
	 */
    public String getHuishouContent() {
        return huishouContent;
    }
    /**
	 * 设置：垃圾回收介绍
	 */

    public void setHuishouContent(String huishouContent) {
        this.huishouContent = huishouContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getHuishouDelete() {
        return huishouDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setHuishouDelete(Integer huishouDelete) {
        this.huishouDelete = huishouDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Huishou{" +
            ", id=" + id +
            ", huishouName=" + huishouName +
            ", huishouUuidNumber=" + huishouUuidNumber +
            ", huishouPhoto=" + huishouPhoto +
            ", huishouAddress=" + huishouAddress +
            ", huishouTypes=" + huishouTypes +
            ", huishouKucunNumber=" + huishouKucunNumber +
            ", huishouTime=" + DateUtil.convertString(huishouTime,"yyyy-MM-dd") +
            ", huishouContent=" + huishouContent +
            ", huishouDelete=" + huishouDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
