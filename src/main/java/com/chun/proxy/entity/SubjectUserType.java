package com.chun.proxy.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 专题用户类型关联表
 * </p>
 *
 * @author zhangbin
 * @since 2017-04-18
 */
@TableName("subject_user_type")
public class SubjectUserType extends Model<SubjectUserType> {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 平台ID
     */
    @TableField("app_id")
    private Long appId;
    /**
     * 专题ID
     */
    @TableField("subject_id")
    private Long subjectId;
    /**
     * 用户类型
     */
    @TableField("user_type_id")
    private Long userTypeId;
    /**
     * 创建人
     */
    @TableField("created_by")
    private Long createdBy;
    /**
     * 创建时间
     */
    @TableField("created_time")
    private Long createdTime;
    /**
     * 更新人
     */
    @TableField("updated_by")
    private Long updatedBy;
    /**
     * 更新时间
     */
    @TableField("updated_time")
    private Long updatedTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Long userTypeId) {
        this.userTypeId = userTypeId;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Long updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
