package com.yys.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Pray implements Serializable {
    /**
     * 祈愿表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 对应的式神碎片id
     */
    @Column(name = "fragment_id")
    private Integer fragmentId;

    /**
     * 阴阳师id
     */
    @Column(name = "member_id")
    private Integer memberId;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 类型，1祈愿，2提供
     */
    @Column(name = "fragment_type")
    private String fragmentType;

    private static final long serialVersionUID = 1L;

    /**
     * 获取祈愿表
     *
     * @return id - 祈愿表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置祈愿表
     *
     * @param id 祈愿表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取对应的式神碎片id
     *
     * @return fragment_id - 对应的式神碎片id
     */
    public Integer getFragmentId() {
        return fragmentId;
    }

    /**
     * 设置对应的式神碎片id
     *
     * @param fragmentId 对应的式神碎片id
     */
    public void setFragmentId(Integer fragmentId) {
        this.fragmentId = fragmentId;
    }

    /**
     * 获取阴阳师id
     *
     * @return member_id - 阴阳师id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 设置阴阳师id
     *
     * @param memberId 阴阳师id
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
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

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取类型，1祈愿，2提供
     *
     * @return fragment_type - 类型，1祈愿，2提供
     */
    public String getFragmentType() {
        return fragmentType;
    }

    /**
     * 设置类型，1祈愿，2提供
     *
     * @param fragmentType 类型，1祈愿，2提供
     */
    public void setFragmentType(String fragmentType) {
        this.fragmentType = fragmentType;
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
        Pray other = (Pray) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFragmentId() == null ? other.getFragmentId() == null : this.getFragmentId().equals(other.getFragmentId()))
            && (this.getMemberId() == null ? other.getMemberId() == null : this.getMemberId().equals(other.getMemberId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getFragmentType() == null ? other.getFragmentType() == null : this.getFragmentType().equals(other.getFragmentType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFragmentId() == null) ? 0 : getFragmentId().hashCode());
        result = prime * result + ((getMemberId() == null) ? 0 : getMemberId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getFragmentType() == null) ? 0 : getFragmentType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fragmentId=").append(fragmentId);
        sb.append(", memberId=").append(memberId);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", fragmentType=").append(fragmentType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}