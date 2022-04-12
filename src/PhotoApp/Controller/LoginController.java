package PhotoApp.Controller;

import PhotoApp.Model.User;
import PhotoApp.Model.UserMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.prefs.BackingStoreException;

public class LoginController {
    @FXML
    Label message;

    @FXML
    TextField userNameField;

    @FXML
    TextField passwordField;

    @FXML
    Button LoginButton;


    public void initialize() {
        message.setVisible(false);
    }

    @FXML
    public void login(ActionEvent actionEvent) throws IOException {
        String userName = userNameField.getText().trim();
        String password = passwordField.getText().trim();
        UserMap userMap = new UserMap();
        HashMap<String, User> map = userMap.getUserMap();
        FXMLLoader loader;


        if(userName.equals("admin") && password.equals("admin")){
            loader = new FXMLLoader((getClass().getResource("/fxml/adminController.fxml")));
            Parent root = loader.load();
            Node node = (Node) actionEvent.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            Scene scene = new Scene(root, 1280, 720);
            stage.setScene(scene);
            stage.show();
            return;
        }
        if(map.containsKey(userName)){
            /**
             * User login
             * 1. Album
             *      1.1 Stock
             *      1.2 Create, Edit Delete
             * 2. Photo
             *      2.1 edit, delete
             *      2.2 Slideshow
             */
        }
    }
}
