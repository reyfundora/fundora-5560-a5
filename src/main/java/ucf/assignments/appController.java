package ucf.assignments;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static ucf.assignments.menuEdit.*;

public class appController implements Initializable {
    public TextField textSearch;
    public Button buttonDone;

    static ArrayList<String> edits = new ArrayList<>();
    static int editCounter;

    // Controller section for File menu
    public void clickOpen() {
        new menuFile().runOpen();
    }
    public void clickSave() {
        new menuFile().runSave();
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

        values.remove(index);
        serials.remove(index);
        names.remove(index);
        itemCounter--;
    }

    // Controller section for TableView
    @FXML public TableView<itemSetGet> tableView;
    @FXML public TableColumn<itemSetGet, String> columnValue;
    @FXML public TableColumn<itemSetGet, String> columnSerial;
    @FXML public TableColumn<itemSetGet, String> columnName;

    @FXML public ListView<String> listView;
    ObservableList<String> search = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // Initialize main table
            tableView.setEditable(true);

            columnValue.setCellValueFactory(new PropertyValueFactory<itemSetGet, String>("value"));
            columnValue.setCellFactory(TextFieldTableCell.forTableColumn());

            columnSerial.setCellValueFactory(new PropertyValueFactory<itemSetGet, String>("serial"));
            columnSerial.setCellFactory(TextFieldTableCell.forTableColumn());
            columnSerial.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<itemSetGet, String>>() {

                // Checks to see if serial number is the same as an existing number on edit
                @Override
                public void handle(TableColumn.CellEditEvent<itemSetGet, String> event) {
                    try {
                        itemSetGet serial = event.getRowValue();
                        String edit = event.getNewValue();
                        for (int i = 0; i < itemCounter; i++) {
                            if (serials.get(0).equals(edit)) {
                                int j = 10 / 0;
                            }
                            if (serials.get(itemCounter - 1).equals(edit)) {
                                int j = 10 / 0;
                            }
                            if (editCounter > 0) {
                                if (edits.get(editCounter - 1).equals(edit)) {
                                    int j = 10 / 0;
                                }
                            }
                        }
                        // Checks to see if new edit is correct serial format
                        if (edit.length() != 10) {
                            int[] errorArray = new int[1];
                            errorArray[5] = 1;
                        }

                        edits.add(edit);
                        editCounter++;
                        serial.setSerial(event.getNewValue());
                    }
                    catch (ArithmeticException e) {
                        try {
                            Parent root = FXMLLoader.load(getClass().getResource("promptErrorFour.fxml"));
                            Scene scene = new Scene(root);

                            Stage popStage = new Stage();
                            popStage.setScene(scene);
                            popStage.setTitle("Serial Number Error");
                            popStage.setResizable(false);
                            popStage.show();
                        }
                        catch (IOException r) {System.out.print("");}
                    }
                    catch (ArrayIndexOutOfBoundsException e) {
                        try {
                            Parent root = FXMLLoader.load(getClass().getResource("promptErrorTwo.fxml"));
                            Scene scene = new Scene(root);

                            Stage popStage = new Stage();
                            popStage.setScene(scene);
                            popStage.setTitle("Serial Number Error");
                            popStage.setResizable(false);
                            popStage.show();
                        }
                        catch (IOException r) {System.out.print("");}
                    }
                }
            });

            columnName.setCellValueFactory(new PropertyValueFactory<itemSetGet, String>("name"));
            columnName.setCellFactory(TextFieldTableCell.forTableColumn());
        } catch (NullPointerException e) { System.out.print("null"); }

        // Initialize list that has search results
        try {
            listView.setCellFactory(TextFieldListCell.forListView());
        } catch (NullPointerException e) { System.out.print(""); }
    }

    public void clickSearch() {
        try {
            // Checks to see if there is any input
            if (itemCounter == 0) {
                System.out.print("No inputs");
            }

            if (itemCounter > 0) {
                // Prompts search results in a new window
                FXMLLoader loader = new FXMLLoader(getClass().getResource("promptSearchResult.fxml"));
                Scene scene = new Scene(loader.load());

                Stage searchStage = new Stage();
                searchStage.setScene(scene);
                searchStage.setTitle("Search results: ");
                searchStage.show();

                runSearch(values.get(0));
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void runSearch(String items) {
        listView.getItems().add(items);
    }

    public void clickDone() {
        Stage stage = (Stage) buttonDone.getScene().getWindow();
        stage.close();
    }
}