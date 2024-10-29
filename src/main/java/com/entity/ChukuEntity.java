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
 * 运输
 *
 * @author 
 * @email
 */
@TableName("chuku")
public class ChukuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ChukuEntity() {

	}

	public ChukuEntity(T t) {
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
     * 垃圾运输
     */
    @ColumnInfo(comment="垃圾运输",type="int(11)")
    @TableField(value = "huishou_yuyue_id")

    private Integer huishouYuyueId;


    /**
     * 运输名称
     */
    @ColumnInfo(comment="运输名称",type="varchar(200)")
    @TableField(value = "chuku_name")

    private String chukuName;


    /**
     * 运输编号
     */
    @ColumnInfo(comment="运输编号",type="varchar(200)")
    @TableField(value = "chuku_uuid_number")

    private String chukuUuidNumber;


    /**
     * 运输照片
     */
    @ColumnInfo(comment="运输照片",type="varchar(200)")
    @TableField(value = "chuku_photo")

    private String chukuPhoto;


    /**
     * 运输地点
     */
    @ColumnInfo(comment="运输地点",type="varchar(200)")
    @TableField(value = "chuku_address")

    private String chukuAddress;


    /**
     * 运输类型
     */
    @ColumnInfo(comment="运输类型",type="int(11)")
    @TableField(value = "chuku_types")

    private Integer chukuTypes;


    /**
     * 运输目的地
     */
    @ColumnInfo(comment="运输目的地",type="varchar(200)")
    @TableField(value = "chuku_mudi_address")

    private String chukuMudiAddress;


    /**
     * 运输介绍
     */
    @ColumnInfo(comment="运输介绍",type="longtext")
    @TableField(value = "chuku_content")

    private String chukuContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "chuku_delete")

    private Integer chukuDelete;


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
	 * 获取：垃圾运输
	 */
    public Integer getHuishouYuyueId() {
        return huishouYuyueId;
    }
    /**
	 * 设置：垃圾运输
	 */

    public void setHuishouYuyueId(Integer huishouYuyueId) {
        this.huishouYuyueId = huishouYuyueId;
    }
    /**
	 * 获取：运输名称
	 */
    public String getChukuName() {
        return chukuName;
    }
    /**
	 * 设置：运输名称
	 */

    public void setChukuName(String chukuName) {
        this.chukuName = chukuName;
    }
    /**
	 * 获取：运输编号
	 */
    public String getChukuUuidNumber() {
        return chukuUuidNumber;
    }
    /**
	 * 设置：运输编号
	 */

    public void setChukuUuidNumber(String chukuUuidNumber) {
        this.chukuUuidNumber = chukuUuidNumber;
    }
    /**
	 * 获取：运输照片
	 */
    public String getChukuPhoto() {
        return chukuPhoto;
    }
    /**
	 * 设置：运输照片
	 */

    public void setChukuPhoto(String chukuPhoto) {
        this.chukuPhoto = chukuPhoto;
    }
    /**
	 * 获取：运输地点
	 */
    public String getChukuAddress() {
        return chukuAddress;
    }
    /**
	 * 设置：运输地点
	 */

    public void setChukuAddress(String chukuAddress) {
        this.chukuAddress = chukuAddress;
    }
    /**
	 * 获取：运输类型
	 */
    public Integer getChukuTypes() {
        return chukuTypes;
    }
    /**
	 * 设置：运输类型
	 */

    public void setChukuTypes(Integer chukuTypes) {
        this.chukuTypes = chukuTypes;
    }
    /**
	 * 获取：运输目的地
	 */
    public String getChukuMudiAddress() {
        return chukuMudiAddress;
    }
    /**
	 * 设置：运输目的地
	 */

    public void setChukuMudiAddress(String chukuMudiAddress) {
        this.chukuMudiAddress = chukuMudiAddress;
    }
    /**
	 * 获取：运输介绍
	 */
    public String getChukuContent() {
        return chukuContent;
    }
    /**
	 * 设置：运输介绍
	 */

    public void setChukuContent(String chukuContent) {
        this.chukuContent = chukuContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getChukuDelete() {
        return chukuDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setChukuDelete(Integer chukuDelete) {
        this.chukuDelete = chukuDelete;
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
        return "Chuku{" +
            ", id=" + id +
            ", huishouYuyueId=" + huishouYuyueId +
            ", chukuName=" + chukuName +
            ", chukuUuidNumber=" + chukuUuidNumber +
            ", chukuPhoto=" + chukuPhoto +
            ", chukuAddress=" + chukuAddress +
            ", chukuTypes=" + chukuTypes +
            ", chukuMudiAddress=" + chukuMudiAddress +
            ", chukuContent=" + chukuContent +
            ", chukuDelete=" + chukuDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
