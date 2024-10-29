package com.entity.vo;

import com.entity.HuishouEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 垃圾回收
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("huishou")
public class HuishouVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 垃圾回收名称
     */

    @TableField(value = "huishou_name")
    private String huishouName;


    /**
     * 垃圾回收编号
     */

    @TableField(value = "huishou_uuid_number")
    private String huishouUuidNumber;


    /**
     * 垃圾回收照片
     */

    @TableField(value = "huishou_photo")
    private String huishouPhoto;


    /**
     * 垃圾回收地点
     */

    @TableField(value = "huishou_address")
    private String huishouAddress;


    /**
     * 垃圾回收类型
     */

    @TableField(value = "huishou_types")
    private Integer huishouTypes;


    /**
     * 垃圾回收库存
     */

    @TableField(value = "huishou_kucun_number")
    private Integer huishouKucunNumber;


    /**
     * 入库时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "huishou_time")
    private Date huishouTime;


    /**
     * 垃圾回收介绍
     */

    @TableField(value = "huishou_content")
    private String huishouContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "huishou_delete")
    private Integer huishouDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：垃圾回收名称
	 */
    public String getHuishouName() {
        return huishouName;
    }


    /**
	 * 获取：垃圾回收名称
	 */

    public void setHuishouName(String huishouName) {
        this.huishouName = huishouName;
    }
    /**
	 * 设置：垃圾回收编号
	 */
    public String getHuishouUuidNumber() {
        return huishouUuidNumber;
    }


    /**
	 * 获取：垃圾回收编号
	 */

    public void setHuishouUuidNumber(String huishouUuidNumber) {
        this.huishouUuidNumber = huishouUuidNumber;
    }
    /**
	 * 设置：垃圾回收照片
	 */
    public String getHuishouPhoto() {
        return huishouPhoto;
    }


    /**
	 * 获取：垃圾回收照片
	 */

    public void setHuishouPhoto(String huishouPhoto) {
        this.huishouPhoto = huishouPhoto;
    }
    /**
	 * 设置：垃圾回收地点
	 */
    public String getHuishouAddress() {
        return huishouAddress;
    }


    /**
	 * 获取：垃圾回收地点
	 */

    public void setHuishouAddress(String huishouAddress) {
        this.huishouAddress = huishouAddress;
    }
    /**
	 * 设置：垃圾回收类型
	 */
    public Integer getHuishouTypes() {
        return huishouTypes;
    }


    /**
	 * 获取：垃圾回收类型
	 */

    public void setHuishouTypes(Integer huishouTypes) {
        this.huishouTypes = huishouTypes;
    }
    /**
	 * 设置：垃圾回收库存
	 */
    public Integer getHuishouKucunNumber() {
        return huishouKucunNumber;
    }


    /**
	 * 获取：垃圾回收库存
	 */

    public void setHuishouKucunNumber(Integer huishouKucunNumber) {
        this.huishouKucunNumber = huishouKucunNumber;
    }
    /**
	 * 设置：入库时间
	 */
    public Date getHuishouTime() {
        return huishouTime;
    }


    /**
	 * 获取：入库时间
	 */

    public void setHuishouTime(Date huishouTime) {
        this.huishouTime = huishouTime;
    }
    /**
	 * 设置：垃圾回收介绍
	 */
    public String getHuishouContent() {
        return huishouContent;
    }


    /**
	 * 获取：垃圾回收介绍
	 */

    public void setHuishouContent(String huishouContent) {
        this.huishouContent = huishouContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getHuishouDelete() {
        return huishouDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setHuishouDelete(Integer huishouDelete) {
        this.huishouDelete = huishouDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
