package ucf.assignments;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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


}
