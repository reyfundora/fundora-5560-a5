/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Rey Fundora
 */

package ucf.assignments;

import javafx.scene.control.*;
import java.util.*;

public class menuEdit {
    public appController appController;
    public TextArea addValue, addSerial, addName;

    static ArrayList<Double> values = new ArrayList<>();
    static ArrayList<String> serials = new ArrayList<>();
    static ArrayList<String> names = new ArrayList<>();

    public void clickButtonAdd() {
        // Turns user input into readable variables
        Double value = Double.parseDouble(addValue.getText());
        String serial = addSerial.getText();
        String name = addName.getText();

        // Adds inputs to an organizable list
        values.add(value);
        serials.add(serial);
        names.add(name);
    }
}
