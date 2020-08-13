package com.yys.dao;

import java.io.Serializable;
import javax.persistence.*;

public class Fragment implements Serializable {
    /**
     * 式神碎片表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 碎片名称
     */
    private String name;

    /**
     * 稀有度，0为联动，1为sp，2为ssr，3为sr，4为r，5为n
     */
    private Integer grade;

    private static final long serialVersionUID = 1L;

    /**
     * 获取式神碎片表
     *
     * @return id - 式神碎片表
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置式神碎片表
     *
     * @param id 式神碎片表
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取碎片名称
     *
     * @return name - 碎片名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置碎片名称
     *
     * @param name 碎片名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取稀有度，0为联动，1为sp，2为ssr，3为sr，4为r，5为n
     *
     * @return grade - 稀有度，0为联动，1为sp，2为ssr，3为sr，4为r，5为n
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 设置稀有度，0为联动，1为sp，2为ssr，3为sr，4为r，5为n
     *
     * @param grade 稀有度，0为联动，1为sp，2为ssr，3为sr，4为r，5为n
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
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
        Fragment other = (Fragment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGrade() == null ? other.getGrade() == null : this.getGrade().equals(other.getGrade()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGrade() == null) ? 0 : getGrade().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", grade=").append(grade);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}