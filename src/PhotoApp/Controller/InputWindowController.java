package PhotoApp.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InputWindowController {
    @FXML
    private Button cancelButton;

    @FXML
    private Button confirmButton;

    @FXML
    private Label windowTitle;

    @FXML
    private Label windowMessage;

    @FXML
    private Label inputLabelA;

    @FXML
    private Label inputLabelB;

    @FXML
    private TextField inputA;

    @FXML
    private TextField inputB;

//    public InputWindowController(String wTitle, String wMessage, String inLabelA, String inLabelB){
//        windowTitle.setText(wTitle);
//        windowMessage.setText(wMessage);
//        inputLabelA.setText(inLabelA);
//        inputLabelB.setText(inLabelB);
//    }

    public void closeWindow() {
        ((Stage)cancelButton.getScene().getWindow()).close();
    }


    /**
     * Getter and Setters
     */

    public Button getCancelButton() {
        return cancelButton;
    }

    public Button getConfirmButton() {
        return confirmButton;
    }

    public void setWindowTitle(String wTitle) {
        windowTitle.setText(wTitle);
    }

    public void setWindowMessage(String wMess) {
        windowMessage.setText(wMess);
    }


    public void setInputLabelA(String inputLA) {
        inputLabelA.setText(inputLA);
    }

    public void setInputLabelB(String inputLB) {
        inputLabelB.setText(inputLB);
    }

    public TextField getInputA() {
        return inputA;
    }

    public void setInputA(TextField inputA) {
        this.inputA = inputA;
    }

    public TextField getInputB() {
        return inputB;
    }

    public void setInputB(TextField inputB) {
        this.inputB = inputB;
    }
}
