package com.common.viewmodel;

/**
 * Created with IntelliJ IDEA.
 * User: flai
 * Date: 14-4-30
 * Time: 上午10:41
 * To change this template use File | Settings | File Templates.
 */
public class BaseSearchFilter {
    private Integer pageIndex;
    private Integer pageSize;
    private String sortField;
    private String sortOrder;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }
}
