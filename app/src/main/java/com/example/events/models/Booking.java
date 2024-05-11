package com.example.events.models;

public class Booking {
    private String id,fullName,email,phoneNumber;
    private int quantity;
    private String time,calendar;
    private int cost;
    private String place;
    private String discount;
    private String payment;

    public Booking() {
    }
    public Booking(String id, String fullName, String email, String phoneNumber, int quantity, String time, String calendar, int cost, String place) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.quantity = quantity;
        this.time = time;
        this.calendar = calendar;
        this.cost = cost;
        this.place = place;
    }
    public Booking(String id, String fullName, String email, String phoneNumber, int quantity, String time, String calendar, int cost, String place, String discount, String payment) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.quantity = quantity;
        this.time = time;
        this.calendar = calendar;
        this.cost = cost;
        this.place = place;
        this.discount = discount;
        this.payment = payment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCalendar() {
        return calendar;
    }

    public void setCalendar(String calendar) {
        this.calendar = calendar;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
}
