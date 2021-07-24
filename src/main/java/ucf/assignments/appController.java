package ucf.assignments;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.text.html.ListView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class appController {

    // Controller section for File menu
    public void clickOpen() {
    }

    public void clickSave() {
    }

    public void clickClose() {
        Platform.exit();
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

    // Controller section for Help menu
    public void clickGettingStarted() {
        new menuHelp().runGettingStarted();
    }

    public void clickAbout() {
        new menuHelp().runAbout();
    }

    // Controller section for TableView
    @FXML public TableView<tableSetGet> tableView;
    @FXML public TableColumn<tableSetGet, String> dateColumn;
    @FXML public TableColumn<tableSetGet, String> descriptionColumn;
    @FXML private ListView<String> listView;

    public void refresh() { listView.refresh(); }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            dateColumn.setCellValueFactory(new PropertyValueFactory("date"));
            descriptionColumn.setCellValueFactory(new PropertyValueFactory("description"));

            tableView.setItems(getTable());
            listView.getItems().addAll(items[0]);
            listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        }
        catch (NullPointerException e) {System.out.print("null");}
    }

    public ObservableList<tableSetGet> getTable() {
        ObservableList<tableSetGet> test = FXCollections.observableArrayList();
        test.add(new tableSetGet(items[0], items[1]));

        return test;
    }
}



