package imsclient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
        for (InventoryItem item : itemArrayList)
        {
            itemNameList.add(item.getName());
        }
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
    
    public String[] getNamesAsStringArray() {
        return (String[]) getItemNameList().toArray();
    }


}
