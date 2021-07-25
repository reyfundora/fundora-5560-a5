package ucf.assignments;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clickDelete() {
        // Prompt that explains to the user that you have to right click items to delete them
        try {
            Parent root = FXMLLoader.load(getClass().getResource("promptDelete.fxml"));
            Scene scene = new Scene(root);

            Stage popStage = new Stage();
            popStage.setScene(scene);
            popStage.setTitle("Delete Item!");
            popStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void rightClickDelete() {
        // Deletes selected items
        int index = tableView.getSelectionModel().getSelectedIndex();
        if (index >= 0) tableView.getItems().remove(index);
    }

    // Controller section for TableView
    @FXML
    public TableView<itemSetGet> tableView;
    @FXML
    public TableColumn<itemSetGet, String> columnValue;
    @FXML
    public TableColumn<itemSetGet, String> columnSerial;
    @FXML
    public TableColumn<itemSetGet, String> columnName;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            tableView.setEditable(true);

            columnValue.setCellValueFactory(new PropertyValueFactory<itemSetGet, String>("value"));
            columnValue.setCellFactory(TextFieldTableCell.forTableColumn());

            columnSerial.setCellValueFactory(new PropertyValueFactory<itemSetGet, String>("serial"));
            columnSerial.setCellFactory(TextFieldTableCell.forTableColumn());

            columnName.setCellValueFactory(new PropertyValueFactory<itemSetGet, String>("name"));
            columnName.setCellFactory(TextFieldTableCell.forTableColumn());

        } catch (NullPointerException e) { System.out.print("null"); }
    }


}