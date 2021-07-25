/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Rey Fundora
 */

package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class menuEdit {
    public appController appController;
    public TextArea addValue, addSerial, addName;
    public Button buttonAdd, buttonOk, buttonOkTwo;

    static ArrayList<String> values = new ArrayList<>();
    static ArrayList<String> serials = new ArrayList<>();
    static ArrayList<String> names = new ArrayList<>();
    static int itemCounter;

    public void clickButtonAdd() throws IOException {
        try {
            // Checks if inputted value is compatible with dollar output
            Double value = Double.parseDouble(addValue.getText());
            BigDecimal bdValue = new BigDecimal(value).setScale(2, RoundingMode.HALF_DOWN);
            String bdValueString = String.valueOf(bdValue);
            String outputValue = "$" + bdValueString;
            values.add(outputValue);

            // Turns user input for serial and name into readable variables
            String serial = addSerial.getText();
            String name = addName.getText();

            // Adds inputs to an organizable arraylist
            serials.add(serial);
            names.add(name);
            itemCounter++;

            Stage stage = (Stage) buttonAdd.getScene().getWindow();
            stage.close();

            appController.tableView.setItems(getTable());
        }
        // Error prompt that explains the need for only numerical input
        catch (Exception e) {
                Parent root = FXMLLoader.load(getClass().getResource("promptErrorOne.fxml"));
                Scene scene = new Scene(root);

                Stage popStage = new Stage();
                popStage.setScene(scene);
                popStage.setTitle("About the App!");
                popStage.setResizable(false);
                popStage.show();
        }
    }

    // Method that is called once the 'Add' button is clicked
    public ObservableList<itemSetGet> getTable() {
        ObservableList<itemSetGet> list = FXCollections.observableArrayList();

        // Uses for loop to add all values from respective arraylists.
        for (int i =0; i < itemCounter; i++)
            list.add(new itemSetGet(values.get(i), serials.get(i), names.get(i)));

        return list;
    }

    // Delete prompt is closed
    public void clickButtonOk() {
        Stage stage = (Stage) buttonOk.getScene().getWindow();
        stage.close();
    }

    // Error prompt is closed
    public void clickButtonOkTwo() {
        Stage stage = (Stage) buttonOkTwo.getScene().getWindow();
        stage.close();
    }
}