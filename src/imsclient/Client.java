/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package imsclient;

import java.util.ArrayList;

/**
 *
 * @author markburton
 */
public class Client {
    
        private final ArrayList<InventoryItem> itemList;
    
    public Client() {
        itemList = new ArrayList<>();    
    }
    
    public void insertEntryInItemList(InventoryItem item) {
        itemList.add(item);
    }
    
    public ArrayList<InventoryItem> getItemList() {
        return itemList;
    }
    
}
