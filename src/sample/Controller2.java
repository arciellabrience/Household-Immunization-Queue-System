package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {

    @FXML
    private Button identityAdd;

    @FXML
    private Button identityDelete;

    @FXML
    private Button identityView;

    @FXML
    private Button identityPrio;

    @FXML
    private Button identityExit;

    @FXML
    private AnchorPane pane2;

    //method that lets the user input an individual's personal information to the database
    public void buttonAdd(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Add.fxml"));
        pane2.getChildren().setAll(pane);
    }

    //method that lets the user delete information from the database
    public void buttonDelete(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Delete.fxml"));
        pane2.getChildren().setAll(pane);
    }

    //method that lets the user view all the information in the database
    public void buttonView(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("View.fxml"));
        pane2.getChildren().setAll(pane);
    }

    //method that lets the user view the adjacency matrices, the graph, and queue of the vaccine prioritization
    public void buttonPrio(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Tree.fxml"));
        pane2.getChildren().setAll(pane);
    }

    public void buttonExit(ActionEvent actionEvent) {
        System.exit(0);
    }

    //method initializes tooltip over the main menu's buttons
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final Tooltip tooltipAdd = new Tooltip();
        tooltipAdd.setText("Information to be inputted can either be about\nthe individual's personal information, or a file.");
        tooltipAdd.setShowDelay(Duration.millis(0));
        tooltipAdd.setShowDuration(Duration.millis(60000));
        identityAdd.setTooltip(tooltipAdd);

        final Tooltip tooltipDelete = new Tooltip();
        tooltipDelete.setText("There is a corresponding number assigned to\nan individual to delete his/her information.");
        tooltipDelete.setShowDelay(Duration.millis(0));
        tooltipDelete.setShowDuration(Duration.millis(60000));
        identityDelete.setTooltip(tooltipDelete);

        final Tooltip tooltipView = new Tooltip();
        tooltipView.setText("Displays the current database.");
        tooltipView.setShowDelay(Duration.millis(0));
        tooltipView.setShowDuration(Duration.millis(60000));
        identityView.setTooltip(tooltipView);

        final Tooltip tooltipPrio = new Tooltip();
        tooltipPrio.setText("Prints the order of prioritization and directs\nthem to the closest hospital.");
        tooltipPrio.setShowDelay(Duration.millis(0));
        tooltipPrio.setShowDuration(Duration.millis(60000));
        identityPrio.setTooltip(tooltipPrio);

        final Tooltip tooltipExit = new Tooltip();
        tooltipExit.setText("Exits the program.");
        tooltipExit.setShowDelay(Duration.millis(0));
        tooltipExit.setShowDuration(Duration.millis(60000));
        identityExit.setTooltip(tooltipExit);
    }
}
