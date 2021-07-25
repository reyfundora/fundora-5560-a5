package ucf.assignments;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static ucf.assignments.menuEdit.*;

public class appController implements Initializable {
    public TextField textSearch;
    public Button buttonDone;

    // Controller section for File menu
    public void clickOpen() {
    }

    public void clickSave() {
    }

    // Closes the program
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

    // Controller section for TableView for search
    @FXML
    public TableView<itemSetGet> tableViewSearch;
    @FXML
    public TableColumn<itemSetGet, String> columnValueSearch;
    @FXML
    public TableColumn<itemSetGet, String> columnSerialSearch;
    @FXML
    public TableColumn<itemSetGet, String> columnNameSearch;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Initialize main table
            tableView.setEditable(true);

            columnValue.setCellValueFactory(new PropertyValueFactory<itemSetGet, String>("value"));
            columnValue.setCellFactory(TextFieldTableCell.forTableColumn());

            columnSerial.setCellValueFactory(new PropertyValueFactory<itemSetGet, String>("serial"));
            columnSerial.setCellFactory(TextFieldTableCell.forTableColumn());

            columnName.setCellValueFactory(new PropertyValueFactory<itemSetGet, String>("name"));
            columnName.setCellFactory(TextFieldTableCell.forTableColumn());

            // Initialize search results
            columnValueSearch.setCellValueFactory(new PropertyValueFactory<itemSetGet, String>("value"));
            columnSerialSearch.setCellValueFactory(new PropertyValueFactory<itemSetGet, String>("serial"));
            columnNameSearch.setCellValueFactory(new PropertyValueFactory<itemSetGet, String>("name"));
        } catch (NullPointerException e) { System.out.print("null"); }
    }

    // Checks to see is edited serial number is already in use
    public void checkSerialEdit(TableColumn.CellEditEvent<itemSetGet, String> itemSetGetStringCellEditEvent) throws IOException {
        try {
            String edit = itemSetGetStringCellEditEvent.getNewValue();
            for (int i = 0; i < itemCounter; i++) {
                if (serials.get(0).equals(edit)) {
                    int j = 10 / 0;
                }
                if (serials.get(itemCounter - 1).equals(edit)) {
                    int j = 10 / 0;
                }
                
            }
        }
        catch (ArithmeticException e) {
            Parent root = FXMLLoader.load(getClass().getResource("promptErrorFour.fxml"));
            Scene scene = new Scene(root);

            Stage popStage = new Stage();
            popStage.setScene(scene);
            popStage.setTitle("Serial Number Error");
            popStage.setResizable(false);
            popStage.show();
        }
    }

    public void clickSearch() {
        try {
            // Checks to see if there is any input
            if (itemCounter == 0) {
                System.out.print("No inputs");
                return;
            }

            // Prompts search results in a new window
            Parent root = FXMLLoader.load(getClass().getResource("promptSearchResult.fxml"));
            Scene scene = new Scene(root);

            Stage searchStage = new Stage();
            searchStage.setScene(scene);
            searchStage.setTitle("Search results: ");
            tableViewSearch.setItems(getTableSearch());
            searchStage.show();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public ObservableList<itemSetGet> getTableSearch() {
        ObservableList<itemSetGet> list = FXCollections.observableArrayList();

        list.add(new itemSetGet(values.get(0), serials.get(0), names.get(0)));

        return list;
    }

    public void clickDone() {
        Stage stage = (Stage) buttonDone.getScene().getWindow();
        stage.close();
    }


}