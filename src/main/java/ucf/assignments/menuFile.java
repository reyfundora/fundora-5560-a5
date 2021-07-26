package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.stage.Stage;
import java.io.*;

import static ucf.assignments.menuEdit.*;

public class menuFile {

    public Button buttonAdd, saveButton;
    public TextField openInput, inputName, inputDir;


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

    public void clickAdd() throws IOException {
        File name = new File(String.valueOf(inputName));
        FileWriter tsv = new FileWriter(String.valueOf(inputName));
        for (int i = 0; i < itemCounter; i++) {
            tsv.write(values.get(itemCounter - 1) + "\t" + serials.get(itemCounter - 1) + "\t" +
                    names.get(itemCounter - 1) + "\t");
            tsv.write("\n");
            tsv.close();
        }

        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();
    }
}