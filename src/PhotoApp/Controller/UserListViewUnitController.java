package PhotoApp.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


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
}
