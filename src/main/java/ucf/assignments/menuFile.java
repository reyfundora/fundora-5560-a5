package ucf.assignments;

import javafx.application.Application;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
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
            fc.setInitialDirectory(new File("C:\\temp"));

            fc.setTitle("Save Inventory List");
            fc.setInitialFileName("inventory");

            fc.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("TSV File", ".txt"),
                    new FileChooser.ExtensionFilter("HTML File", ".html"),
                    new FileChooser.ExtensionFilter("JSON File", ".json"));

            try
            {
                File file = fc.showSaveDialog(null);
                fc.setInitialDirectory(file.getParentFile());
                //TODO save
            }
            catch (Exception e) { System.out.print("");}
    }
}