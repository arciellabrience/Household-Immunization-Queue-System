package sample;

import javafx.scene.control.Alert;
import javafx.stage.Window;

//class that alerts user contains a message for confirmation, error, information, none, or warning
public class AlertHelper {
    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
