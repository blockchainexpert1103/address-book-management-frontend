package com.example.pms_client;

public class Contact {
    private String name;
    private String phoneNumber;
    private int iconResourceId;

    public Contact(String name, String phoneNumber, int iconResourceId) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.iconResourceId = iconResourceId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getIconResourceId() {
        return iconResourceId;
    }
}
