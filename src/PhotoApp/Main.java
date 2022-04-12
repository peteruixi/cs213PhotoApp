package PhotoApp;

import PhotoApp.Model.UserMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/UserListViewUnit.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/AdminController.fxml"));
        UserMap usermap = new UserMap();
        usermap.loadSerializedFile();
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/NewUserOrAlbumInputWindowController.fxml"));
//        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
