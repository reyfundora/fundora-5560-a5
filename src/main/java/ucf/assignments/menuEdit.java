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

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class menuEdit {
    public appController appController;
    public TextArea addValue, addSerial, addName;
    public Button buttonAdd, buttonOk;

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

            // Checks if inputted serial number is in the correct ten length format with no specials
            String serial = addSerial.getText();

            Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
            Matcher matcher = pattern.matcher(serial);

            if (serial.length() != 10 || !matcher.matches()) {
                int error = 10 / 0;
            }

            // Checks if serial number is already in use
            for (int i = 0; i < itemCounter; i++) {
                if (serials.get(itemCounter - 1).equals(serial)) {
                    String nullError = null;
                    if (nullError.equals("null error exception"))
                        System.out.print("error");
                }
            }

            // Checks if name is between 2 and 256 characters
            String name = addName.getText();
            if (name.length() < 2 || name.length() > 256) {
                int[] errorArray = new int[1];
                errorArray[5] = 1;
            }

            // Adds inputs to an organizable arraylist
            serials.add(serial);
            names.add(name);
            itemCounter++;

            Stage stage = (Stage) buttonAdd.getScene().getWindow();
            stage.close();

            appController.tableView.setItems(getTable());
        }
        // Error prompt that explains the need for only numerical input
        catch (NumberFormatException e) {
                Parent root = FXMLLoader.load(getClass().getResource("promptErrorOne.fxml"));
                Scene scene = new Scene(root);

                Stage popStage = new Stage();
                popStage.setScene(scene);
                popStage.setTitle("Value Error");
                popStage.setResizable(false);
                popStage.show();
        }
        // Error prompt that explains the need for correct serial format
        catch (ArithmeticException e) {
            Parent root = FXMLLoader.load(getClass().getResource("promptErrorTwo.fxml"));
            Scene scene = new Scene(root);

            Stage popStage = new Stage();
            popStage.setScene(scene);
            popStage.setTitle("Serial Number Error");
            popStage.setResizable(false);
            popStage.show();
        }
        // Error prompt that shows when serial number is already in use
        catch (NullPointerException e) {
            Parent root = FXMLLoader.load(getClass().getResource("promptErrorFour.fxml"));
            Scene scene = new Scene(root);

            Stage popStage = new Stage();
            popStage.setScene(scene);
            popStage.setTitle("Serial Number Error");
            popStage.setResizable(false);
            popStage.show();
        }
        // Error prompt that explains the need for 2 to 256 characters in name
        catch (ArrayIndexOutOfBoundsException e) {
            Parent root = FXMLLoader.load(getClass().getResource("promptErrorThree.fxml"));
            Scene scene = new Scene(root);

            Stage popStage = new Stage();
            popStage.setScene(scene);
            popStage.setTitle("Serial Number Error");
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

    // Delete/Error prompt is closed
    public void clickButtonOk() {
        Stage stage = (Stage) buttonOk.getScene().getWindow();
        stage.close();
    }
}