package com.entity.vo;

import com.entity.HuishouYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 垃圾出库申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("huishou_yuyue")
public class HuishouYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名编号
     */

    @TableField(value = "huishou_yuyue_uuid_number")
    private String huishouYuyueUuidNumber;


    /**
     * 垃圾回收
     */

    @TableField(value = "huishou_id")
    private Integer huishouId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 报名理由
     */

    @TableField(value = "huishou_yuyue_text")
    private String huishouYuyueText;


    /**
     * 出库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "huishou_chuku_time")
    private Date huishouChukuTime;


    /**
     * 申请状态
     */

    @TableField(value = "huishou_yuyue_yesno_types")
    private Integer huishouYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "huishou_yuyue_yesno_text")
    private String huishouYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "huishou_yuyue_shenhe_time")
    private Date huishouYuyueShenheTime;


    /**
     * 活动报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：报名编号
	 */
    public String getHuishouYuyueUuidNumber() {
        return huishouYuyueUuidNumber;
    }


    /**
	 * 获取：报名编号
	 */

    public void setHuishouYuyueUuidNumber(String huishouYuyueUuidNumber) {
        this.huishouYuyueUuidNumber = huishouYuyueUuidNumber;
    }
    /**
	 * 设置：垃圾回收
	 */
    public Integer getHuishouId() {
        return huishouId;
    }


    /**
	 * 获取：垃圾回收
	 */

    public void setHuishouId(Integer huishouId) {
        this.huishouId = huishouId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：报名理由
	 */
    public String getHuishouYuyueText() {
        return huishouYuyueText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setHuishouYuyueText(String huishouYuyueText) {
        this.huishouYuyueText = huishouYuyueText;
    }
    /**
	 * 设置：出库时间
	 */
    public Date getHuishouChukuTime() {
        return huishouChukuTime;
    }


    /**
	 * 获取：出库时间
	 */

    public void setHuishouChukuTime(Date huishouChukuTime) {
        this.huishouChukuTime = huishouChukuTime;
    }
    /**
	 * 设置：申请状态
	 */
    public Integer getHuishouYuyueYesnoTypes() {
        return huishouYuyueYesnoTypes;
    }


    /**
	 * 获取：申请状态
	 */

    public void setHuishouYuyueYesnoTypes(Integer huishouYuyueYesnoTypes) {
        this.huishouYuyueYesnoTypes = huishouYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getHuishouYuyueYesnoText() {
        return huishouYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setHuishouYuyueYesnoText(String huishouYuyueYesnoText) {
        this.huishouYuyueYesnoText = huishouYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getHuishouYuyueShenheTime() {
        return huishouYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setHuishouYuyueShenheTime(Date huishouYuyueShenheTime) {
        this.huishouYuyueShenheTime = huishouYuyueShenheTime;
    }
    /**
	 * 设置：活动报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：活动报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
