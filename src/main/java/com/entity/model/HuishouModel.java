package com.entity.model;

import com.entity.HuishouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 垃圾回收
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuishouModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 垃圾回收名称
     */
    private String huishouName;


    /**
     * 垃圾回收编号
     */
    private String huishouUuidNumber;


    /**
     * 垃圾回收照片
     */
    private String huishouPhoto;


    /**
     * 垃圾回收地点
     */
    private String huishouAddress;


    /**
     * 垃圾回收类型
     */
    private Integer huishouTypes;


    /**
     * 垃圾回收库存
     */
    private Integer huishouKucunNumber;


    /**
     * 入库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date huishouTime;


    /**
     * 垃圾回收介绍
     */
    private String huishouContent;


    /**
     * 逻辑删除
     */
    private Integer huishouDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
