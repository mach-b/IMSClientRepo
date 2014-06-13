package imsclient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 * A class to represent a collection of InventoryItems
 *
 * @author markburton
 */
public class Inventory {

    private ArrayList<InventoryItem> itemArrayList;
    private ArrayList<String> itemNameList;

    public Inventory(ArrayList itemArrayList) {
        this.itemArrayList = itemArrayList;
    }

    /**
     * Returns the list of Items
     *
     * @return the itemArrayList
     */
    public ArrayList<InventoryItem> getItemArrayList() {
        return itemArrayList;
    }

    /**
     * Returns the names of all InventoryItems in this Inventory
     *
     * @return
     */
    public ArrayList<String> getItemNameList() {
        createItemNameList();
        return itemNameList;
    }

    /**
     * Creates an empty Inventory
     */
    public Inventory() {
        this.itemArrayList = new ArrayList<>();
    }

    /**
     * Returns Inventory in the form of a JSON
     *
     * @return the JSON
     */
    public String convertItemArrayToJSON() {
        return new Gson().toJson(this);
    }

    /**
     * Populates the nameList with all Items in the Inventory
     */
    public void createItemNameList() {
        itemNameList = new ArrayList<>();
        for (InventoryItem item : itemArrayList) {
            itemNameList.add(item.getName());
        }
    }

    /**
     * Returns an InventoryItem based on it's name
     *
     * @param name the name of the item to be returned
     * @return the InventoryItem
     */
    public InventoryItem getItem(String name) {
        for (InventoryItem item : itemArrayList) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Gets the price of an InventoryItem by its name reference
     *
     * @param name the name of the item
     * @return the price
     */
    public double getItemPrice(String name) {
        InventoryItem item = getItem(name);
        if (item != null) {
            return item.getPrice();
        }
        return -1;
    }

    /**
     * Gets the quantity of an InventoryItem by its name reference
     *
     * @param name the name of the item
     * @return the quantity
     */
    public int getItemQuantity(String name) {
        InventoryItem item = getItem(name);
        if (item != null) {
            return item.getQuantity();
        }
        return -1;
    }

    /**
     * Adds an InventoryItem to the Inventory
     *
     * @param item the item
     */
    public void addItem(InventoryItem item) {
        itemArrayList.add(item);
    }

    /**
     * Removes an InventoryItem from the Inventory
     *
     * @param item the item
     */
    public void removeItem(InventoryItem item) {
        itemArrayList.remove(item);
    }

    /**
     * Returns itemNameList as an Array
     *
     * @return the Array
     */
    public String[] getNamesAsStringArray() {
        return (String[]) getItemNameList().toArray();
    }

}
