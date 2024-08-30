package com.example.pms_client;

public class FavoriteListItem {

    private String name = "";
    private String officePhone = "";
    private String mobilePhone = " ";
    private int iconResourceId = 0;

    public FavoriteListItem(String name, String officePhone, String mobilePhone, int iconResourceId) {

        this.name = name;
        this.officePhone = officePhone;
        this.mobilePhone = mobilePhone;
        this.iconResourceId = iconResourceId;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return name.substring(0, 1);
    }

    public String getOfficePhone() {
        return officePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public int getIconResourceId() {
        return iconResourceId;
    }
}
