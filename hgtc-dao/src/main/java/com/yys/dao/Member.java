package com.yys.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Member implements Serializable {
    /**
     * 寮成员表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 游戏名
     */
    @Column(name = "yys_name")
    private String yysName;

    /**
     * 游戏id
     */
    @Column(name = "yys_id")
    private String yysId;

    /**
     * 阴阳寮id
     */
    @Column(name = "yys_house_id")
    private Integer yysHouseId;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * qq号码
     */
    private String qq;

    @Column(name = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * 获取寮成员表
     *
     * @return id - 寮成员表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置寮成员表
     *
     * @param id 寮成员表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取游戏名
     *
     * @return yys_name - 游戏名
     */
    public String getYysName() {
        return yysName;
    }

    /**
     * 设置游戏名
     *
     * @param yysName 游戏名
     */
    public void setYysName(String yysName) {
        this.yysName = yysName;
    }

    /**
     * 获取游戏id
     *
     * @return yys_id - 游戏id
     */
    public String getYysId() {
        return yysId;
    }

    /**
     * 设置游戏id
     *
     * @param yysId 游戏id
     */
    public void setYysId(String yysId) {
        this.yysId = yysId;
    }

    /**
     * 获取阴阳寮id
     *
     * @return yys_house_id - 阴阳寮id
     */
    public Integer getYysHouseId() {
        return yysHouseId;
    }

    /**
     * 设置阴阳寮id
     *
     * @param yysHouseId 阴阳寮id
     */
    public void setYysHouseId(Integer yysHouseId) {
        this.yysHouseId = yysHouseId;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取手机号码
     *
     * @return phone - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取qq号码
     *
     * @return qq - qq号码
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置qq号码
     *
     * @param qq qq号码
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Member other = (Member) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getYysName() == null ? other.getYysName() == null : this.getYysName().equals(other.getYysName()))
            && (this.getYysId() == null ? other.getYysId() == null : this.getYysId().equals(other.getYysId()))
            && (this.getYysHouseId() == null ? other.getYysHouseId() == null : this.getYysHouseId().equals(other.getYysHouseId()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getQq() == null ? other.getQq() == null : this.getQq().equals(other.getQq()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getYysName() == null) ? 0 : getYysName().hashCode());
        result = prime * result + ((getYysId() == null) ? 0 : getYysId().hashCode());
        result = prime * result + ((getYysHouseId() == null) ? 0 : getYysHouseId().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getQq() == null) ? 0 : getQq().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", yysName=").append(yysName);
        sb.append(", yysId=").append(yysId);
        sb.append(", yysHouseId=").append(yysHouseId);
        sb.append(", password=").append(password);
        sb.append(", phone=").append(phone);
        sb.append(", qq=").append(qq);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}