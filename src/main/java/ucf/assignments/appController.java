package ucf.assignments;

import javafx.event.ActionEvent;

public class appController {

    public void clickOpen(ActionEvent actionEvent) {
    }

    public void clickSave(ActionEvent actionEvent) {
    }

    public void clickClose(ActionEvent actionEvent) {
    }

    public void clickGettingStarted(ActionEvent actionEvent) {
        new menuHelp().runGettingStarted();
    }

    public void clickAbout(ActionEvent actionEvent) {
        new menuHelp().runAbout();
    }

}
