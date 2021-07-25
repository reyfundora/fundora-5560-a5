package ucf.assignments;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class menuFile {

    public Button buttonAdd, txtButton, htmlButton, jsonButton;
    public TextField openInput, txtInput, htmlInput, jsonInput;

    // Opens a file using a user inputted directory
    public void runOpen() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("promptFileOpen.fxml"));
            Scene scene = new Scene(root);

            Stage popStage = new Stage();
            popStage.setScene(scene);
            popStage.setTitle("Open a file!");
            popStage.setResizable(false);
            popStage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void clickFileOpen() {
    }

    // Saves a file dpeending on chosen text bar when prompted
    public void runSave() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("promptFileSave.fxml"));
            Scene scene = new Scene(root);

            Stage popStage = new Stage();
            popStage.setScene(scene);
            popStage.setTitle("Save a file!");
            popStage.setResizable(false);
            popStage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }



    public void clickhtmlButton(ActionEvent actionEvent) {
    }

    public void clicktxtButton(ActionEvent actionEvent) {
    }

    public void clickjsonButton(ActionEvent actionEvent) {
    }
}
