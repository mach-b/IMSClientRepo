package imsclient;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 * The Inventory Management Service JavaSE Client
 *
 * @author markburton
 */
public class InventoryClientJFrame extends javax.swing.JFrame {

    private String serverURL = "http://localhost:8080/InventoryManagementSystem/";
    //private String serverURL = "http://localhost:8080/InventoryManagementSystem/webresources/";
    private final HttpHelper httpHelper;

    private final String requestAddItem = "manager/create/";
    private final String requestUpdateItem = "manager/update/";
    private final String requestRemoveItem = "manager/remove/";
    private final String requestGetInventory = "manager";

    /**
     * Creates new form InventoryClientJFrame
     */
    public InventoryClientJFrame() {
        initComponents();
        httpHelper = new HttpHelper();
        this.setLocationRelativeTo(null);
        if (serverURL == null) {
            try {
                Document doc = outputWindow.getDocument();
                doc.insertString(doc.getLength(), "Welcome to Inventory Management System.", null);
            } catch (BadLocationException ex) {
                Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Sets the URL endpoint of the server
     *
     * @param url
     */
    private void setServerURL(String url) {
        this.serverURL = url;
        if (!(serverURL == null) && !("".equals(serverURL))) {
            try {
                Document doc = outputWindow.getDocument();
                doc.insertString(doc.getLength(), "You have specified the server URL as: " + serverURL + "\n", null);
            } catch (BadLocationException ex) {
                Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Document doc = outputWindow.getDocument();
                doc.insertString(doc.getLength(), "The specified URL is not a valid format." + serverURL + "\n", null);
            } catch (BadLocationException ex) {
                Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Clears outputWindow and writes a String to it.
     *
     * @param s the string to be written
     * @throws BadLocationException
     */
    private void writeStringToNewOutputWindow(String s) throws BadLocationException {
        Document doc = outputWindow.getDocument();
        doc.remove(0, doc.getLength());
        doc.insertString(doc.getLength(), s, null);
    }

    /**
     * Appends a String to the outputWindow
     *
     * @param s the string to be written
     * @throws BadLocationException
     */
    private void appendStringToOutputWindow(String s) throws BadLocationException {
        Document doc = outputWindow.getDocument();
        doc.insertString(doc.getLength(), s, null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        findButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        listAllButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        outputScrollPane = new javax.swing.JScrollPane();
        outputWindow = new javax.swing.JTextPane();
        menuBar = new javax.swing.JMenuBar();
        menuJMenu = new javax.swing.JMenu();
        settingsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();
        helpMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory Managent System");
        setBounds(new java.awt.Rectangle(0, 0, 500, 500));
        setMinimumSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        logoPanel.setMaximumSize(new java.awt.Dimension(500, 100));
        logoPanel.setMinimumSize(new java.awt.Dimension(500, 100));
        logoPanel.setPreferredSize(new java.awt.Dimension(500, 100));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imsclient/logoIMS.png"))); // NOI18N
        logoPanel.add(jLabel1);

        getContentPane().add(logoPanel);

        buttonPanel.setMaximumSize(new java.awt.Dimension(500, 50));
        buttonPanel.setPreferredSize(new java.awt.Dimension(500, 50));
        buttonPanel.setLayout(new java.awt.GridLayout(1, 0));

        findButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        findButton.setText("Find Item");
        findButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(findButton);

        addButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        addButton.setText("Add Item");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(addButton);

        listAllButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        listAllButton.setText("List All Items");
        listAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listAllButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(listAllButton);

        removeButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        removeButton.setText("Remove Item");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });
        buttonPanel.add(removeButton);

        getContentPane().add(buttonPanel);

        outputScrollPane.setMaximumSize(new java.awt.Dimension(500, 400));
        outputScrollPane.setMinimumSize(new java.awt.Dimension(500, 400));
        outputScrollPane.setPreferredSize(new java.awt.Dimension(500, 400));

        outputWindow.setEditable(false);
        outputWindow.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        outputWindow.setMaximumSize(new java.awt.Dimension(500, 400));
        outputWindow.setMinimumSize(new java.awt.Dimension(450, 400));
        outputWindow.setPreferredSize(new java.awt.Dimension(500, 400));
        outputScrollPane.setViewportView(outputWindow);

        getContentPane().add(outputScrollPane);

        menuJMenu.setText("Menu");

        settingsMenuItem.setText("Settings");
        settingsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsMenuItemActionPerformed(evt);
            }
        });
        menuJMenu.add(settingsMenuItem);

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        menuJMenu.add(aboutMenuItem);

        helpMenuItem.setText("Help");
        helpMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpMenuItemActionPerformed(evt);
            }
        });
        menuJMenu.add(helpMenuItem);

        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        menuJMenu.add(exitMenuItem);

        menuBar.add(menuJMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Button that lists all inventory items to the outputWindow
     *
     * @param evt a mouse click event
     */
    private void listAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listAllButtonActionPerformed
        // Get Inventory from server
        String s = "";
        try {
            s = httpHelper.sendGetRequest(serverURL + requestGetInventory);
        } catch (IOException ex) {
            Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (isJSON(s)) {
            Inventory inv = new Gson().fromJson(s, Inventory.class);
            try {
                writeStringToNewOutputWindow("LIST OF ALL ITEMS IN INVENTORY...\n");
                for (InventoryItem item : inv.getItemArrayList()) {
                    appendStringToOutputWindow("\n" + item.toString() + "\n");
                }
            } catch (BadLocationException ex) {
                Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Invalid Inventory Returned: \n" + s);
            // Display error message to client
            try {
                writeStringToNewOutputWindow("ERROR: Invalid Inventory supplied by Server.");
            } catch (BadLocationException ex) {
                Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_listAllButtonActionPerformed

    /**
     * Facilitates the addition of an Item to the Inventory
     *
     * @param evt a mouse click event
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        //Add item to clients itemList via JOptionPane
        JTextField itemName = new JTextField();
        JTextField itemPrice = new JTextField();
        JTextField itemQuantity = new JTextField();
        final JComponent[] inputs = new JComponent[]{
            new JLabel("Item Name:"),
            itemName,
            new JLabel("Item Price:"),
            itemPrice,
            new JLabel("Quantity:"),
            itemQuantity,};
        JOptionPane.showConfirmDialog(null, inputs, "Enter Item to Add Details.",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        // Check input valid CANNOT ASSUME USER HAS ENTERED CORRECTLY

        boolean validFormat = true;
        if (!itemName.getText().equalsIgnoreCase("") && itemName.getText() != null) {
            if (isPriceValid(itemPrice.getText())) {
                if (isQuantityValid(itemQuantity.getText())) {

                } else {
                    validFormat = false;
                    System.out.println("ERROR: Item quantity is not valid, add cancelled");
                }
            } else {
                validFormat = false;
                System.out.println("ERROR: Item price is not valid, add cancelled");
            }
        } else {
            validFormat = false;
            System.out.println("ERROR: Item name is not valid, add cancelled");
        }
        if (validFormat) {
            // Get confirmation of addition.
            int i = JOptionPane.showConfirmDialog(null, "You requested addition of\n"
                    + itemQuantity.getText() + " x "
                    + itemName.getText() + " at $" + itemPrice.getText()
                    + "\nclick OK to proceed.",
                    "Confirm Removal", JOptionPane.OK_CANCEL_OPTION);
            if (i == JOptionPane.OK_OPTION) {
                // POST ADDITION OF OBJECT - CAN ASSUME VALID FORMAT AS ALREADY CHECKED
                // CHANGE FROM PASSING STRINGS IF UNSURE OF VALIDITY, OK FOR NOW.
                InventoryItem itemToRemove = new InventoryItem(itemName.getText(),
                        itemPrice.getText(), itemQuantity.getText());
                String json = new Gson().toJson(itemToRemove);
                try {
                    //httpHelper.sendPostRequest((serverURL + requestAddItem), json);
                    httpHelper.sendGetRequest(serverURL+requestAddItem+"?json="+json);
                    System.out.println("Post request sent.");
                    try {
                        writeStringToNewOutputWindow("Request for addition of " + itemQuantity.getText()
                                + " " + itemName.getText() + "(s) valued at $" + itemPrice.getText() + ",\n"
                                + " this request has been submitted to the server.");
                    } catch (BadLocationException ex) {
                        Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            try {
                writeStringToNewOutputWindow("ERROR: Entered Item Format invalid.\n"
                        + "\nRequired Format as follows:\nName must contain at least 1 character."
                        + "\nPrice must be a non negative number. (Decimal value ok, but no other symbols or letters allowed)"
                        + "\nQuantity must be a non negative 'whole' number.\n"
                        + "\nYou entered:\nItem Name:"
                        + itemName.getText() + ", Item Price:"
                        + itemPrice.getText() + ", Quantity:"
                        + itemQuantity.getText());
            } catch (BadLocationException ex) {
                Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_addButtonActionPerformed

    /**
     * Displays a drop down list of items in the inventory, the selected items
     * name, price, and quantity will be displayed on the outputWindow.
     *
     * @param evt a mouse click event
     */
    private void findButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findButtonActionPerformed
        // Get Inventory from server
        String s = "";
        try {
            s = httpHelper.sendGetRequest(serverURL + requestGetInventory);
        } catch (IOException ex) {
            Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (isJSON(s)) {
            Inventory inv = new Gson().fromJson(s, Inventory.class);
            inv.createItemNameList();

            // Pass name list to JoptionPane
            String[] nameList = inv.getNamesAsStringArray();
            JComboBox itemNameComboBox = new JComboBox(nameList);
            final JComponent[] input = new JComponent[]{
                new JLabel("Select Item:"),
                itemNameComboBox,};
            int i = JOptionPane.showConfirmDialog(null, input, "Find Item.",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            InventoryItem item = inv.getItem((String) itemNameComboBox.getSelectedItem());

            // Get Item details
            String itemName = item.getName();
            // Convert double to Currency.
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String itemPrice = formatter.format(item.getPrice());
            String itemQuantity = String.valueOf(item.getQuantity());
            // Build String to display.
            String itemDescription = "ITEM: " + itemName
                    + "\nPRICE: " + itemPrice + "\nQUANTITY: " + itemQuantity;

            // Write to outputWindow
            try {
                writeStringToNewOutputWindow(itemDescription);
            } catch (BadLocationException ex) {
                Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("Invalid Inventory Returned: \n" + s);
            // Display error message to client
            try {
                writeStringToNewOutputWindow("ERROR: Invalid Inventory supplied by Server.");
            } catch (BadLocationException ex) {
                Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_findButtonActionPerformed

    /**
     * Displays a drop down list of items in the inventory, the user can then
     * select to remove a quantity of the item.
     *
     * @param evt a mouse click event
     */
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // Get Inventory from server
        String s = "";
        try {
            s = httpHelper.sendGetRequest(serverURL + requestGetInventory);
        } catch (IOException ex) {
            Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (isJSON(s)) {
            Inventory inv = new Gson().fromJson(s, Inventory.class);
            inv.createItemNameList();

            String[] nameList = inv.getNamesAsStringArray();
            JComboBox itemNameComboBox = new JComboBox(nameList);
            final JComponent[] input = new JComponent[]{
                new JLabel("Select Item to Remove:"),
                itemNameComboBox,};
            int i = JOptionPane.showConfirmDialog(null, input, "Remove Item.",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            // Check user selected OK
            if (i == JOptionPane.OK_OPTION) {
                InventoryItem item = inv.getItem((String) itemNameComboBox.getSelectedItem());
                // Create array of values that could be removed
                String[] quantityArray = getItemQuantityArray(item.getQuantity());
                JComboBox itemQuantityComboBox = new JComboBox(quantityArray);
                JComponent[] quantityInput = new JComponent[]{
                    new JLabel("Quantity to Remove:"),
                    itemQuantityComboBox,};
                i = JOptionPane.showConfirmDialog(null, quantityInput, "How many "
                        + (String) itemNameComboBox.getSelectedItem() + " would you like to remove?",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (i == JOptionPane.OK_OPTION) {
                    // Confirm removal
                    i = JOptionPane.showConfirmDialog(null, "You requested removal of "
                            + (String) itemQuantityComboBox.getSelectedItem() + " "
                            + (String) itemNameComboBox.getSelectedItem() + " click OK to proceed.",
                            "Confirm Removal", JOptionPane.OK_CANCEL_OPTION);
                    if (i == JOptionPane.OK_OPTION) {
                        // POST REMOVAL OF OBJECT - CAN ASSUME VALID FORMAT AS SOURCED FROM SERVER
                        // CHANGE FROM PASSING STRINGS IF UNSURE OF VALIDITY, OK FOR NOW.
                        InventoryItem itemToRemove = new InventoryItem(item.getName(),
                                String.valueOf(item.getPrice()), (String) itemQuantityComboBox.getSelectedItem());

                        String json = new Gson().toJson(itemToRemove);
                        try {
                            //httpHelper.sendPostRequest((serverURL + requestRemoveItem), json);
                            httpHelper.sendGetRequest(serverURL+requestRemoveItem+"?json="+json);
                            System.out.println("Post request sent.");
                            try {
                                writeStringToNewOutputWindow("Your request for removal of " + (String) itemQuantityComboBox.getSelectedItem()
                                        + " " + item.getName() + "(s)\nhas been submitted to the server.");
                            } catch (BadLocationException ex) {
                                Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        System.out.println("Removal cancelled by user.");
                    }
                } else {
                    System.out.println("Removal cancelled by user.");
                }

            } else {
                System.out.println("Removal cancelled by user.");
            }

        } else {
            System.out.println("Invalid Inventory Returned: \n" + s);
            // Display error message to client
            try {
                writeStringToNewOutputWindow("ERROR: Invalid Inventory supplied by Server.");
            } catch (BadLocationException ex) {
                Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_removeButtonActionPerformed

    /**
     * Facilitates exiting the system.
     *
     * @param evt a mouse click event
     */
    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        // TODO add your handling code here:
        int exit = JOptionPane.showConfirmDialog(null, "Are you sure you want to Exit?", null,
                JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitMenuItemActionPerformed

    /**
     * Displays the solution to all your questions.
     *
     * @param evt a mouse click event
     */
    private void helpMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpMenuItemActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon();
        JOptionPane.showMessageDialog(null, "If you experience any problems with this product\n"
                + "please contact Andrew Ensor: aensor@aut.ac.nz", "Help", JOptionPane.OK_OPTION, icon);
    }//GEN-LAST:event_helpMenuItemActionPerformed

    /**
     * Describes the product and the currently defined server URL.
     *
     * @param evt a mouse click event
     */
    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon();
        System.out.println("" + !("".equalsIgnoreCase(serverURL)));
        if (!("".equalsIgnoreCase(serverURL)) && (serverURL != null)) {
            JOptionPane.showMessageDialog(null, "<html><center>Message Inventory System v0.1<center><br>"
                    + "<br><center>Developed by:<br>"
                    + "Tomas Morton and Mark Burton<br><center><br>"
                    + "<br><center>Your specified Server URL is:<br>" + serverURL + "<center><br><html>", "About", JOptionPane.OK_OPTION, icon);
        } else {
            JOptionPane.showMessageDialog(null, "<html><center>Message Inventory System v0.1<center><br>"
                    + "<br><center>Developed by<center>"
                    + "<center>Tomas Morton and Mark Burton<br><center><br>"
                    + "<br><center>Your specified Server URL is not set.<center><br><html>", "About", JOptionPane.OK_OPTION, icon);
        }
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    /**
     * Allows a new server URL to be set.
     *
     * @param evt a mouse click event
     */
    private void settingsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsMenuItemActionPerformed
        // TODO add your handling code here:
        JTextField serverAddress = new JTextField();
        final JComponent[] inputs = new JComponent[]{
            new JLabel("Set Server URL:"),
            serverAddress};
        int i = JOptionPane.showConfirmDialog(null, inputs, "Enter Server URL.",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        // Confirmation of removal
        if (i == JOptionPane.OK_OPTION) {
            i = JOptionPane.showConfirmDialog(null, "You Specified a URL: "
                    + serverAddress.getText() + " click OK to confirm.", "Confirm Server URL", JOptionPane.OK_CANCEL_OPTION);
            if (i == JOptionPane.OK_OPTION) {
                try {
                    appendStringToOutputWindow("You specified the Server URL: "
                            + serverAddress.getText() + "\n");
                } catch (BadLocationException ex) {
                    Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (!("".equalsIgnoreCase(serverAddress.getText())) && (serverAddress.getText() != null)) {
                    // Set serverURL
                    serverURL = serverAddress.getText();
                    try {
                        appendStringToOutputWindow("Server URL set as: "
                                + serverAddress.getText() + "\n");
                    } catch (BadLocationException ex) {
                        Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        appendStringToOutputWindow("The URL you specified is invalid, Server URL not set!\n");
                    } catch (BadLocationException ex) {
                        Logger.getLogger(InventoryClientJFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_settingsMenuItemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InventoryClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventoryClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventoryClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventoryClientJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventoryClientJFrame().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton addButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JButton findButton;
    private javax.swing.JMenuItem helpMenuItem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton listAllButton;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuJMenu;
    private javax.swing.JScrollPane outputScrollPane;
    private javax.swing.JTextPane outputWindow;
    private javax.swing.JButton removeButton;
    private javax.swing.JMenuItem settingsMenuItem;
    // End of variables declaration//GEN-END:variables

    /**
     * Creates and returns an array of values from 1 to the quantity parameter.
     * Used for number of items to remove selection
     *
     * @param quantity the upper bound of the array
     * @return the array
     */
    private String[] getItemQuantityArray(int quantity) {
        String[] toReturn = new String[quantity];
        for (int i = 0; i < quantity; i++) {
            toReturn[i] = ("" + (i + 1));
        }
        return toReturn;
    }

    /**
     * Confirms string is JSON or not
     *
     * @param s the candidate JSON
     * @return true if JSON
     */
    private boolean isJSON(String s) {
        try {
            Inventory test = new Gson().fromJson(s, Inventory.class);
            return true;
        } catch (JsonSyntaxException e) {
            return false;
        }
    }

    /**
     * Checks string price is not negative and represents a Double
     *
     * @param text the string to check
     * @return true if valid
     */
    private boolean isPriceValid(String text) {
        try {
            double price = Double.parseDouble(text);
            return price >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks string quantity is not negative and represents an Integer
     *
     * @param text the string to check
     * @return true if valid
     */
    private boolean isQuantityValid(String text) {
        try {
            int quantity = Integer.parseInt(text);
            return quantity >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
