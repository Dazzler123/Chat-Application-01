package util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class UINavigation {
    public static void loadUI(String URI, String username) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(UINavigation.class.getResource("../view/" + URI + ".fxml"))));
        stage.setTitle(username + " - Group Member");
//        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
