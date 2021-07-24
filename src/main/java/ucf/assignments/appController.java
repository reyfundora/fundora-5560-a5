package ucf.assignments;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ucf.assignments.menuEdit.*;

public class appController implements Initializable {

    // Controller section for File menu
    public void clickOpen() {
    }

    public void clickSave() {
    }

    public void clickClose() {
        Platform.exit();
    }

    // Controller section for Help menu
    public void clickGettingStarted() {
        new menuHelp().runGettingStarted();
    }

    public void clickAbout() {
        new menuHelp().runAbout();
    }

    // Controller section for Edit menu
    public void clickNew() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("promptNew.fxml"));
            Scene scene = new Scene(loader.load());

            menuEdit controller = loader.getController();
            controller.appController = this;

            Stage popStage = new Stage();
            popStage.setScene(scene);
            popStage.setTitle("New Item!");
            popStage.setResizable(false);
            popStage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    // Controller section for TableView
    @FXML public TableView<itemSetGet> tableView;
    @FXML public TableColumn<itemSetGet, Double> columnValue;
    @FXML public TableColumn<itemSetGet, String> columnSerial;
    @FXML public TableColumn<itemSetGet, String> columnName;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        columnValue.setCellValueFactory(new PropertyValueFactory<itemSetGet, Double>("value"));
        columnSerial.setCellValueFactory(new PropertyValueFactory<itemSetGet, String>("serial"));
        columnName.setCellValueFactory(new PropertyValueFactory<itemSetGet, String>("name"));
    }
}