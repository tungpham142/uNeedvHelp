package com.example.uneedvhelp;

public class CustomerRequest {
    String id;
    String endDate;
    String startDate;
    String title;
    String description;
    String customerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getCustomerId() {
        return customerId;
    }

    public void getCustomerId(String customerId) {
        this.customerId = customerId;
    }



    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getDescription(){
        return description;

    }
    public void setDescription(String description) {
        this.description = description;
    }
}
