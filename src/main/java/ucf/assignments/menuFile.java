package ucf.assignments;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class menuFile {

    public void runOpen() {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TSV File", ".txt"),
                new FileChooser.ExtensionFilter("HTML File", ".html"),
                new FileChooser.ExtensionFilter("JSON File", ".json"));

        List<File> f = fc.showOpenMultipleDialog(null);
    }

    public void runSave() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save Inventory List");
        File selectedFile = null;
        while (selectedFile == null) {
            selectedFile = fc.showSaveDialog(null);
        }

        File file = new File(String.valueOf(selectedFile));

        PrintWriter outFile = null;
        try {
            outFile = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        outFile.close();
    }
}
