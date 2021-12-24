package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerHospitals implements Initializable {
    @FXML
    AnchorPane paneHospitals;

    @FXML
    MenuItem itemUno;

    @FXML
    MenuItem itemDos;

    @FXML
    MenuItem itemTres;

    @FXML
    MenuItem itemKuatro;

    @FXML
    MenuItem itemSingko;

    @FXML
    MenuItem itemSais;

    @FXML
    MenuItem itemSyete;

    @FXML
    MenuItem itemOtso;

    @FXML
    MenuItem itemNuebe;

    @FXML
    Line toA;

    @FXML
    Line toB;

    @FXML
    Line toC;

    @FXML
    Line toD;

    @FXML
    Line toE;

    @FXML
    Line toF;

    @FXML
    Line toG;

    @FXML
    Line toH;

    @FXML
    Line toI;

    @FXML
    Label labelMap;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //if barangay Uno is chosen, its path to hospital H will be thicker and the other lines will be thin to show the difference on the shortest path to be taken
        itemUno.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                toH.setStrokeWidth(7.0);

                toB.setStrokeWidth(0);
                toC.setStrokeWidth(0);
                toD.setStrokeWidth(0);
                toE.setStrokeWidth(0);
                toF.setStrokeWidth(0);
                toG.setStrokeWidth(0);
                toA.setStrokeWidth(0);
                toI.setStrokeWidth(0);

                labelMap.setText("1.) Hospital H\n2.) Hospital G\n3.) Hospital F\n4.) Hospital E\n5.) Hospital D\n6.) Hospital C\n7.) Hospital B\n8.) Hospital A");
            }
        });

        //if barangay Dos is chosen, its path to hospital B will be thicker and the other lines will be thin to show the difference on the shortest path to be taken
        itemDos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                toD.setStrokeWidth(7.0);

                toA.setStrokeWidth(0);
                toC.setStrokeWidth(0);
                toB.setStrokeWidth(0);
                toE.setStrokeWidth(0);
                toF.setStrokeWidth(0);
                toG.setStrokeWidth(0);
                toH.setStrokeWidth(0);
                toI.setStrokeWidth(0);

                labelMap.setText("1.) Hospital D\n2.) Hospital F\n3.) Hospital G\n4.) Hospital E\n5.) Hospital C\n6.) Hospital A\n7.) Hospital B\n8.) Hospital H");
            }
        });

        //if barangay Tres is chosen, its path to hospital A will be thicker and the other lines will be thin to show the difference on the shortest path to be taken
        itemTres.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                toA.setStrokeWidth(7.0);

                toC.setStrokeWidth(0);
                toB.setStrokeWidth(0);
                toD.setStrokeWidth(0);
                toE.setStrokeWidth(0);
                toF.setStrokeWidth(0);
                toG.setStrokeWidth(0);
                toH.setStrokeWidth(0);
                toI.setStrokeWidth(0);

                labelMap.setText("1.) Hospital A\n2.) Hospital C\n3.) Hospital E\n4.) Hospital F\n5.) Hospital G\n6.) Hospital D\n7.) Hospital B\n8.) Hospital H");
            }
        });

        //if barangay Kuatro is chosen, its path to hospital B will be thicker and the other lines will be thin to show the difference on the shortest path to be taken
        itemKuatro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                toB.setStrokeWidth(7.0);

                toA.setStrokeWidth(0);
                toD.setStrokeWidth(0);
                toC.setStrokeWidth(0);
                toE.setStrokeWidth(0);
                toF.setStrokeWidth(0);
                toG.setStrokeWidth(0);
                toH.setStrokeWidth(0);
                toI.setStrokeWidth(0);

                labelMap.setText("1.) Hospital B\n2.) Hospital D\n3.) Hospital F\n4.) Hospital G\n5.) Hospital E\n6.) Hospital C\n7.) Hospital A\n8.) Hospital H");
            }
        });

        //if barangay Singko is chosen, its path to hospital E will be thicker and the other lines will be thin to show the difference on the shortest path to be taken
        itemSingko.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                toE.setStrokeWidth(7.0);

                toA.setStrokeWidth(0);
                toB.setStrokeWidth(0);
                toC.setStrokeWidth(0);
                toD.setStrokeWidth(0);
                toF.setStrokeWidth(0);
                toG.setStrokeWidth(0);
                toH.setStrokeWidth(0);
                toI.setStrokeWidth(0);

                labelMap.setText("1.) Hospital E\n2.) Hospital F\n3.) Hospital G\n4.) Hospital D\n5.) Hospital B\n6.) Hospital A\n7.) Hospital C\n8.) Hospital H");
            }
        });

        //if barangay Sais is chosen, its path to hospital H will be thicker and the other lines will be thin to show the difference on the shortest path to be taken
        itemSais.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                toH.setStrokeWidth(7.0);

                toA.setStrokeWidth(0);
                toB.setStrokeWidth(0);
                toC.setStrokeWidth(0);
                toD.setStrokeWidth(0);
                toE.setStrokeWidth(0);
                toG.setStrokeWidth(0);
                toF.setStrokeWidth(0);
                toI.setStrokeWidth(0);

                labelMap.setText("1.) Hospital H\n2.) Hospital G\n3.) Hospital F\n4.) Hospital E\n5.) Hospital D\n6.) Hospital C\n7.) Hospital B\n8.) Hospital A");
            }
        });

        //if barangay Siete is chosen, its path to hospital B will be thicker and the other lines will be thin to show the difference on the shortest path to be taken
        itemSyete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                toB.setStrokeWidth(7.0);

                toA.setStrokeWidth(0);
                toH.setStrokeWidth(0);
                toC.setStrokeWidth(0);
                toD.setStrokeWidth(0);
                toE.setStrokeWidth(0);
                toF.setStrokeWidth(0);
                toH.setStrokeWidth(0);
                toI.setStrokeWidth(0);

                labelMap.setText("1.) Hospital B\n2.) Hospital D\n3.) Hospital F\n4.) Hospital G\n5.) Hospital E\n6.) Hospital C\n7.) Hospital A\n8.) Hospital H");
            }
        });

        //if barangay Otso is chosen, its path to hospital G will be thicker and the other lines will be thin to show the difference on the shortest path to be taken
        itemOtso.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                toG.setStrokeWidth(7.0);

                toA.setStrokeWidth(0);
                toB.setStrokeWidth(0);
                toC.setStrokeWidth(0);
                toD.setStrokeWidth(0);
                toE.setStrokeWidth(0);
                toF.setStrokeWidth(0);
                toH.setStrokeWidth(0);
                toI.setStrokeWidth(0);

                labelMap.setText("1.) Hospital G\n2.) Hospital F\n3.) Hospital D\n4.) Hospital E\n5.) Hospital C\n6.) Hospital A\n7.) Hospital B\n8.) Hospital H");
            }
        });

        //if barangay Nueve is chosen, its path to hospital F will be thicker and the other lines will be thin to show the difference on the shortest path to be taken
        itemNuebe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                toF.setStrokeWidth(7.0);

                toA.setStrokeWidth(0);
                toB.setStrokeWidth(0);
                toC.setStrokeWidth(0);
                toD.setStrokeWidth(0);
                toE.setStrokeWidth(0);
                toI.setStrokeWidth(0);
                toG.setStrokeWidth(0);
                toH.setStrokeWidth(0);

                labelMap.setText("1.) Hospital F\n2.) Hospital G\n3.) Hospital E\n4.) Hospital C\n5.) Hospital A\n6.) Hospital B\n7.) Hospital D\n8.) Hospital H");
            }
        });
    }

    //method that lets the user go back to the main menu
    public void actionBack(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Tree.fxml"));
        paneHospitals.getChildren().setAll(pane);
    }

    //method that lets the user view the adjacency matrices
    public void buttonNext(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Adjacency.fxml"));
        paneHospitals.getChildren().setAll(pane);
    }
}