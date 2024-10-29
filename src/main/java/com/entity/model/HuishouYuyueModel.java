package com.entity.model;

import com.entity.HuishouYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 垃圾出库申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class HuishouYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名编号
     */
    private String huishouYuyueUuidNumber;


    /**
     * 垃圾回收
     */
    private Integer huishouId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 报名理由
     */
    private String huishouYuyueText;


    /**
     * 出库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date huishouChukuTime;


    /**
     * 申请状态
     */
    private Integer huishouYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String huishouYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date huishouYuyueShenheTime;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
