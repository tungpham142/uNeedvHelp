package com.example.uneedvhelp;

public class CustomerRequest {
    int id;
    String endDate;
    String startDate;
    String title;
    String description;
    int customerId;
    String firstName;
    String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getServiceCategory(){
        return category;
    }
    String category;
    public void setServiceCategory(String category){
        this.category=category;
    }

    public String getName(){
        return firstName + " " + lastName;
    }

    public String getDate(){
        return startDate + "        " + endDate;
    }
}
