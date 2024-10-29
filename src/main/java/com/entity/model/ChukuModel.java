package com.entity.model;

import com.entity.ChukuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 运输
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ChukuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 垃圾运输
     */
    private Integer huishouYuyueId;


    /**
     * 运输名称
     */
    private String chukuName;


    /**
     * 运输编号
     */
    private String chukuUuidNumber;


    /**
     * 运输照片
     */
    private String chukuPhoto;


    /**
     * 运输地点
     */
    private String chukuAddress;


    /**
     * 运输类型
     */
    private Integer chukuTypes;


    /**
     * 运输目的地
     */
    private String chukuMudiAddress;


    /**
     * 运输介绍
     */
    private String chukuContent;


    /**
     * 逻辑删除
     */
    private Integer chukuDelete;


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
