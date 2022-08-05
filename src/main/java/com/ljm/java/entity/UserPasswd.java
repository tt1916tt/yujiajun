package com.ljm.java.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author lijiamign
 * @since 2021-12-21
 */
@TableName("user_passwd")
public class UserPasswd extends Model<UserPasswd> {

    private static final long serialVersionUID = 1L;
    @TableId(type= IdType.ASSIGN_ID)
    private Long id;
    /**
     * 用户编号
     */
    @TableField("user_no")
    private String userNo;
    /**
     * 用户密码
     */
    private String passwd;
    @TableField("gmt_create")
    private Date gmtCreate;
    @TableField("gmt_modified")
    private Date gmtModified;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }




    @Override
    public String toString() {
        return "UserPasswd{" +
        ", id=" + id +
        ", userNo=" + userNo +
        ", passwd=" + passwd +
        ", gmtCreate=" + gmtCreate +
        ", gmtModified=" + gmtModified +
        "}";
    }
}
