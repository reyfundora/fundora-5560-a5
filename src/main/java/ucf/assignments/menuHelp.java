/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 Rey Fundora
 */

package ucf.assignments;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class menuHelp {
    static int testGettingStarted, testAbout;

    // Prompts a pop up with a detailed paragraph on how to use the app
    public void runGettingStarted() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("promptTutorial.fxml"));
            Scene scene = new Scene(root);

            Stage popStage = new Stage();
            popStage.setScene(scene);
            popStage.setTitle("Getting Started!");
            popStage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        testGettingStarted++;
    }

    // Prompts a pop up with creator name, school name, class and professor names,
    // and copyright info.
    public void runAbout() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("promptAbout.fxml"));
            Scene scene = new Scene(root);

            Stage popStage = new Stage();
            popStage.setScene(scene);
            popStage.setTitle("About the App!");
            popStage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }

        testAbout++;
    }
}