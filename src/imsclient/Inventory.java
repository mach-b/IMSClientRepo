/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imsclient;

import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author markburton
 */
public class Inventory {

    private ArrayList<InventoryItem> itemArrayList;
    private ArrayList<String> itemNameList;

    public Inventory(ArrayList itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    public ArrayList<InventoryItem> getItemArrayList() {
        return itemArrayList;
    }

    public ArrayList<String> getItemNameList() {
        return itemNameList;
    }

    public Inventory() {
        this.itemArrayList = new ArrayList<>();
    }

    public Inventory(String json) {
        this.equals(new Gson().fromJson(json, Inventory.class));
    }

    public String convertItemArrayToJSON() {
        return new Gson().toJson(this);
    }

    public void createItemNameList() {
        itemNameList = new ArrayList<>();
        itemArrayList.stream().forEach((item) -> {
            itemNameList.add(item.getName());
        });
    }

    public InventoryItem getItem(String name) {
        for (InventoryItem item : itemArrayList) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public double getItemPrice(String name) {
        InventoryItem item = getItem(name);
        if (item != null) {
            return item.getPrice();
        }
        return -1;
    }

    public int getItemQuantity(String name) {
        InventoryItem item = getItem(name);
        if (item != null) {
            return item.getQuantity();
        }
        return -1;
    }

    public void addItem(InventoryItem item) {
        itemArrayList.add(item);
    }

    public void removeItem(InventoryItem item) {
        itemArrayList.remove(item);
    }

    public InventoryItem getItemFromInventory(String name) {
        double price = getItemPrice(name);
        int quantity = getItemQuantity(name);
        InventoryItem item = new InventoryItem();
        if(!name.equalsIgnoreCase("")) {
            item.setName(name);
        }
        if(price>=0) {  // Check is 0 ok?
            item.setPrice(price);
        }
        if(quantity>=0) {   // Check is 0 ok?
            item.setQuantity(quantity);
        }
        return item;
    }
}
