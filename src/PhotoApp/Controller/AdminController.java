package PhotoApp.Controller;

import PhotoApp.Model.User;
import PhotoApp.Model.UserMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AdminController {

    @FXML
    private VBox usersContainer;

    @FXML
    private Button logoutButton;

    @FXML
    private Button adminAddNewUser;

    @FXML
    public void logout(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginController.fxml"));
        Parent root = loader.load();
        Node n = (Node) actionEvent.getSource();
        Stage stage=(Stage) n.getScene().getWindow();
        Scene scene = new Scene(root, 1280, 720);
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() throws IOException {
        showUserMap();

    }

    private void showUserMap() throws IOException {
        UserMap userMap = new UserMap();
        HashMap<String,User> map = userMap.getUserMap();

        usersContainer.getChildren().clear();

        for(Map.Entry<String,User> entry: map.entrySet() ){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/UserListViewUnit.fxml"));
            Parent root = loader.load();
            UserListViewUnitController userListViewUnitController = loader.getController();
            userListViewUnitController.setUsername(entry.getKey());
            Scene scene = new Scene(root);
            scene.setFill(Color.web("#ADD8E6"));
            usersContainer.getChildren().add(root);
        }
    }


    public void adminCreateUser(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NewUserOrAlbumInputWindowController.fxml"));
        Parent root = loader.load();
        Stage window = new Stage();
        window.setScene(new Scene(root, 400, 400));
        window.show();

        InputWindowController inputWindowController = loader.getController();
        inputWindowController.setInputLabelA("Username");
        inputWindowController.setInputLabelB("Password");
        inputWindowController.setWindowTitle("Create New User");
        inputWindowController.setWindowMessage("Please enter username and password");
        Button confirmButton = inputWindowController.getConfirmButton();
        EventHandler<ActionEvent> var = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                UserMap userMap  = new UserMap();
                String username = inputWindowController.getInputA().getText().trim();
                String password = inputWindowController.getInputB().getText().trim();

                User user = new User(username, password);
                try {
                    userMap.getUserMap().put(username, user);
                    userMap.saveSerializedFile();
                    inputWindowController.closeWindow();
                    initialize();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        confirmButton.setOnAction(var);
    }
}
