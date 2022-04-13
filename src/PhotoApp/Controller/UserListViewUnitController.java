package PhotoApp.Controller;

import PhotoApp.Model.User;
import PhotoApp.Model.UserMap;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;


public class UserListViewUnitController {

    @FXML
    private Label Username;

    @FXML
    private Button Edit;

    @FXML
    private Button Delete;

    public void setUsername(String uname){
        Username.setText(uname);
    }

    public void editUser(User user, HashMap<String, User> userMap) throws IOException {
        Edit.setOnAction(actionEvent -> {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/InputWindowController.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage window = new Stage();
            window.setScene(new Scene(root, 400, 400));
            window.show();
            InputWindowController inputWindowController = new InputWindowController();
            inputWindowController.setWindowTitle("Editing User");
            inputWindowController.setInputLabelA("New Username");
        });

    }
}
