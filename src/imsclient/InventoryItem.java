package imsclient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import java.text.NumberFormat;

/**
 * An entry in the Inventory
 *
 * @author markburton
 */
public class InventoryItem {

    private String name;
    private double price;
    private int quantity;

    public InventoryItem() {
    }

    /**
     * Constructor that passes all values as strings
     *
     * @param name the name
     * @param price the price
     * @param quantity the quantity
     */
    public InventoryItem(String name, String price, String quantity) {
        this.name = name;
        if (isDouble(price)) {
            this.price = Double.parseDouble(price);
        }
        if (isDouble(quantity)) {
            this.quantity = Integer.parseInt(quantity);
        }
    }

    /**
     * Constructor that passes all values in their correct form
     *
     * @param name the name
     * @param price the price
     * @param quantity the quantity
     */
    public InventoryItem(String name, Double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Checks String is Double
     *
     * @param str the String
     * @return true if Double
     */
    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPriceAsCurrency() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(price);
    }

    /**
     * Convert to JSON
     *
     * @return an Sting/JSON
     */
    public String convertItemToJSON() {
        return new Gson().toJson(this);
    }

    /**
     * Lists all attributes of the Item
     *
     * @return a string representation of the InventoryItem
     */
    @Override
    public String toString() {
        return "ITEM - Name: " + name + ", Price: " + getPriceAsCurrency() + ", Quantity: " + quantity;
    }

}
