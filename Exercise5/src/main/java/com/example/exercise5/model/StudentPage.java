package com.example.exercise5.model;

import org.springframework.data.domain.Sort;

public class StudentPage {
    private int pageNumber = 0;
    private int pageSize = 10;
    private Sort.Direction sortDirectionAge = Sort.Direction.DESC;
    private Sort.Direction sortDirectionIelts = Sort.Direction.ASC;
    private String sortByAge = "age";
    private String sortByIelts = "ielts";

    public String getSortByIelts() {
        return sortByIelts;
    }

    public void setSortByIelts(String sortByIelts) {
        this.sortByIelts = sortByIelts;
    }

    public Sort.Direction getSortDirectionAge() {
        return sortDirectionAge;
    }

    public void setSortDirectionAge(Sort.Direction sortDirectionAge) {
        this.sortDirectionAge = sortDirectionAge;
    }

    public Sort.Direction getSortDirectionIelts() {
        return sortDirectionIelts;
    }

    public void setSortDirectionIelts(Sort.Direction sortDirectionIelts) {
        this.sortDirectionIelts = sortDirectionIelts;
    }


    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortByAge() {
        return sortByAge;
    }

    public void setSortByAge(String sortByAge) {
        this.sortByAge = sortByAge;
    }
}

