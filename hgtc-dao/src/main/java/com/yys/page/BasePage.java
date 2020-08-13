package com.yys.page;

import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

/*******************************

 * * 创建日期: 2019/7/26 17:47
 * * 创建作者: Kevin
 * * 版本:  1.0
 * * 功能:
 * * 最后修改时间:
 * * 修改记录:
 ********************************/
public class BasePage implements Serializable{

    @ApiModelProperty(value = "页码,默认为1", example = "1")
    private int pageNum = 1;
    @ApiModelProperty(value = "每页显示数量，默认10，最大100", example = "10")
    private int pageSize = 10;
    @ApiModelProperty(value = "排序方式，desc/asc,默认desc", example = "desc")
    private String order = "desc";
    @ApiModelProperty(value = "排序字段，默认id", example = "id")
    private String sort = "id";
    @ApiModelProperty(hidden = true)
    private String orderAndSort;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        if (pageNum < 1) {
            pageNum = 1;
        }
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 100) {
            pageSize = 100;
        }
        this.pageSize = pageSize;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public BasePage setOrderAndSort(String orderAndSort) {
        this.orderAndSort = orderAndSort;
        return this;
    }

    public String getOrderAndSort() {

        return StringUtils.isBlank(orderAndSort)?columnCnvert(sort, order):orderAndSort;
    }

    public String columnCnvert(String sort, String order) {
        String sortx;
        if (StringUtils.isNotBlank(sort)) {
            order = order == null ? "desc" : order;
            sortx = sort.toLowerCase();
            for (int i = sort.length() - 1; i >= 0; i--) {
                if (!sort.substring(i, i + 1).equals(sortx.substring(i, i + 1))) {
                    sortx = sortx.substring(0, i) + "_" + sortx.substring(i);
                }
            }
            sortx += "  " + order;
        } else {
            sortx = "";
        }
        return sortx;
    }
}
