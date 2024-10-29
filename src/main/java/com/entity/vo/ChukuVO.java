package com.entity.vo;

import com.entity.ChukuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 运输
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("chuku")
public class ChukuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 垃圾运输
     */

    @TableField(value = "huishou_yuyue_id")
    private Integer huishouYuyueId;


    /**
     * 运输名称
     */

    @TableField(value = "chuku_name")
    private String chukuName;


    /**
     * 运输编号
     */

    @TableField(value = "chuku_uuid_number")
    private String chukuUuidNumber;


    /**
     * 运输照片
     */

    @TableField(value = "chuku_photo")
    private String chukuPhoto;


    /**
     * 运输地点
     */

    @TableField(value = "chuku_address")
    private String chukuAddress;


    /**
     * 运输类型
     */

    @TableField(value = "chuku_types")
    private Integer chukuTypes;


    /**
     * 运输目的地
     */

    @TableField(value = "chuku_mudi_address")
    private String chukuMudiAddress;


    /**
     * 运输介绍
     */

    @TableField(value = "chuku_content")
    private String chukuContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "chuku_delete")
    private Integer chukuDelete;


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
	 * 设置：垃圾运输
	 */
    public Integer getHuishouYuyueId() {
        return huishouYuyueId;
    }


    /**
	 * 获取：垃圾运输
	 */

    public void setHuishouYuyueId(Integer huishouYuyueId) {
        this.huishouYuyueId = huishouYuyueId;
    }
    /**
	 * 设置：运输名称
	 */
    public String getChukuName() {
        return chukuName;
    }


    /**
	 * 获取：运输名称
	 */

    public void setChukuName(String chukuName) {
        this.chukuName = chukuName;
    }
    /**
	 * 设置：运输编号
	 */
    public String getChukuUuidNumber() {
        return chukuUuidNumber;
    }


    /**
	 * 获取：运输编号
	 */

    public void setChukuUuidNumber(String chukuUuidNumber) {
        this.chukuUuidNumber = chukuUuidNumber;
    }
    /**
	 * 设置：运输照片
	 */
    public String getChukuPhoto() {
        return chukuPhoto;
    }


    /**
	 * 获取：运输照片
	 */

    public void setChukuPhoto(String chukuPhoto) {
        this.chukuPhoto = chukuPhoto;
    }
    /**
	 * 设置：运输地点
	 */
    public String getChukuAddress() {
        return chukuAddress;
    }


    /**
	 * 获取：运输地点
	 */

    public void setChukuAddress(String chukuAddress) {
        this.chukuAddress = chukuAddress;
    }
    /**
	 * 设置：运输类型
	 */
    public Integer getChukuTypes() {
        return chukuTypes;
    }


    /**
	 * 获取：运输类型
	 */

    public void setChukuTypes(Integer chukuTypes) {
        this.chukuTypes = chukuTypes;
    }
    /**
	 * 设置：运输目的地
	 */
    public String getChukuMudiAddress() {
        return chukuMudiAddress;
    }


    /**
	 * 获取：运输目的地
	 */

    public void setChukuMudiAddress(String chukuMudiAddress) {
        this.chukuMudiAddress = chukuMudiAddress;
    }
    /**
	 * 设置：运输介绍
	 */
    public String getChukuContent() {
        return chukuContent;
    }


    /**
	 * 获取：运输介绍
	 */

    public void setChukuContent(String chukuContent) {
        this.chukuContent = chukuContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getChukuDelete() {
        return chukuDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setChukuDelete(Integer chukuDelete) {
        this.chukuDelete = chukuDelete;
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
