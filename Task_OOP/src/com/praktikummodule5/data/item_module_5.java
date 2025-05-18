package com.praktikummodule5.data;

public class item_module_5 {
    private String itemName, itemDescription, itemLocation, itemStatus;

    public item_module_5(String itemName, String itemDescription, String itemLocation, String itemStatus) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemLocation = itemLocation;
        this.itemStatus = itemStatus;
    }

    public String getItemName() {
        return itemName;
    }

    public String getStatus() {
        return itemStatus;
    }

    public String getDescription() {
        return itemDescription;
    }

    public String getLocation() {
        return itemLocation;
    }

    public void setStatus(String claimed) {
        itemStatus = claimed;
    }
}
