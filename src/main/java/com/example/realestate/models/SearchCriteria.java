package com.example.realestate.models;

public class SearchCriteria {
    private Integer pageNumber;
    private Integer pageSize;
    private String sortField;
    private String sortDirection;
    private String searchQuery;
    private  String searchAddress;
    private String purpose;
    private String type;
    private Integer minArea;
    private Integer maxArea;

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public void setSearchAddress(String searchAddress) {
        this.searchAddress = searchAddress;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMinArea(Integer minArea) {
        this.minArea = minArea;
    }

    public void setMaxArea(Integer maxArea) {
        this.maxArea = maxArea;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public String getSortField() {
        return sortField;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public String getSearchQuery() {
        return searchQuery;
    }

    public String getSearchAddress() {
        return searchAddress;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getType() {
        return type;
    }

    public Integer getMinArea() {
        return minArea;
    }

    public Integer getMaxArea() {
        return maxArea;
    }

    @Override
    public String toString() {
        return "SearchCriteria{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", sortField='" + sortField + '\'' +
                ", sortDirection='" + sortDirection + '\'' +
                ", searchQuery='" + searchQuery + '\'' +
                ", searchAddress='" + searchAddress + '\'' +
                ", purpose='" + purpose + '\'' +
                ", type='" + type + '\'' +
                ", minArea=" + minArea +
                ", maxArea=" + maxArea +
                '}';
    }
}
