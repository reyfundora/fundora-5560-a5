/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Rey Fundora
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.*;

public class menuEdit {
    public appController appController;
    public TextArea addValue, addSerial, addName;
    public Button buttonAdd, buttonOk;

    static ArrayList<Double> values = new ArrayList<>();
    static ArrayList<String> serials = new ArrayList<>();
    static ArrayList<String> names = new ArrayList<>();
    static int itemCounter;

    public void clickButtonAdd() {
        // Turns user input into readable variables
        Double value = Double.parseDouble(addValue.getText());
        String serial = addSerial.getText();
        String name = addName.getText();

        // Adds inputs to an organizable arraylist
        values.add(value);
        serials.add(serial);
        names.add(name);
        itemCounter++;

        Stage stage = (Stage) buttonAdd.getScene().getWindow();
        stage.close();

        appController.tableView.setItems(getTable());
    }

    // Method that is called once the 'Add' button is clicked
    public ObservableList<itemSetGet> getTable() {
        ObservableList<itemSetGet> list = FXCollections.observableArrayList();

        // Uses for loop to add all values from respective arraylists.
        for (int i = 0; i < itemCounter; i++)
            list.add(new itemSetGet(values.get(i), serials.get(i), names.get(i)));

        return list;
    }

    // Delete prompt is closed
    public void clickButtonOk() {
        Stage stage = (Stage) buttonOk.getScene().getWindow();
        stage.close();
    }
}