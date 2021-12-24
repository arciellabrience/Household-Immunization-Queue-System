package sample;

import dataStructures.Graph;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAdjacency implements Initializable {
    @FXML
    Label textH;

    @FXML
    Label textB;

    @FXML
    AnchorPane paneAdjacency;

    private float[][] matrixFXH;
    private boolean[][] boolFXH;
    private int numNodesH;

    private float[][] matrixFXB;
    private boolean[][] boolFXB;
    private int numNodesB;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Graph(numOfNodes, directed, weighted)
        Graph graph = new Graph(8, false, true);

        /**
         * 0 = A
         * 1 = B
         * 2 = C
         * 3 = D
         * 4 = E
         * 5 = F
         * 6 = G
         * 7 = H
         *
         * HOSPITALS ONLY
         */
        graph.addEdge(0, 1, 3);
        graph.addEdge(0, 2, (float) 1.7);
        graph.addEdge(0, 3, (float) 3.4);
        graph.addEdge(0, 4, (float) 3.8);
        graph.addEdge(0, 5, 5);
        graph.addEdge(0, 6, (float) 5.1);
        graph.addEdge(0, 7, (float) 7.3);

        graph.addEdge(1, 0, 3);
        graph.addEdge(1, 2, (float) 2.9);
        graph.addEdge(1, 3, (float) 2.3);
        graph.addEdge(1, 4, (float) 3.2);
        graph.addEdge(1, 5, (float) 3.4);
        graph.addEdge(1, 6, 4);
        graph.addEdge(1, 7, (float) 6.2);

        graph.addEdge(2, 0, (float) 1.7);
        graph.addEdge(2, 1, (float) 2.9);
        graph.addEdge(2, 3, (float) 4.4);
        graph.addEdge(2, 4, (float) 2.1);
        graph.addEdge(2, 5, (float) 3.3);
        graph.addEdge(2, 6, (float) 3.4);
        graph.addEdge(2, 7, (float) 5.6);

        graph.addEdge(3, 0, (float) 3.4);
        graph.addEdge(3, 1, (float) 2.3);
        graph.addEdge(3, 2, (float) 4.4);
        graph.addEdge(3, 4, (float) 2.3);
        graph.addEdge(3, 5, (float) 1.1);
        graph.addEdge(3, 6, (float) 1.6);
        graph.addEdge(3, 7, (float) 3.8);

        graph.addEdge(4, 0, (float) 3.8);
        graph.addEdge(4, 1, (float) 3.2);
        graph.addEdge(4, 2, (float) 2.1);
        graph.addEdge(4, 3, (float) 2.3);
        graph.addEdge(4, 5, (float) 1.2);
        graph.addEdge(4, 6, (float) 1.3);
        graph.addEdge(4, 7, (float) 3.5);

        graph.addEdge(5, 0, 5);
        graph.addEdge(5, 1, (float) 3.4);
        graph.addEdge(5, 2, (float) 3.3);
        graph.addEdge(5, 3, (float) 1.1);
        graph.addEdge(5, 4, (float) 1.2);
        graph.addEdge(5, 6, (float) 0.5);
        graph.addEdge(5, 7, (float) 2.8);

        graph.addEdge(6, 0, (float) 5.1);
        graph.addEdge(6, 1, 4);
        graph.addEdge(6, 2, (float) 3.4);
        graph.addEdge(6, 3, (float) 1.6);
        graph.addEdge(6, 4, (float) 1.3);
        graph.addEdge(6, 5, (float) 0.5);
        graph.addEdge(6, 7, (float) 2.2);

        graph.addEdge(7, 0, (float) 7.3);
        graph.addEdge(7, 1, (float) 6.2);
        graph.addEdge(7, 2, (float) 5.6);
        graph.addEdge(7, 3, (float) 3.8);
        graph.addEdge(7, 4, (float) 3.5);
        graph.addEdge(7, 5, (float) 2.8);
        graph.addEdge(7, 6, (float) 2.2);

        matrixFXH = graph.returnMatrix();
        boolFXH = graph.returnBool();
        numNodesH = graph.returnNodes();

        textH.setText(" ");
        for(int i = 0; i < 9; i++) {
            if (i != 8) textH.setText(textH.getText() + Character.toString(65+i) + "   ");
            else textH.setText(textH.getText() + Character.toString(65+i));
        }
        textH.setText(textH.getText() + "\n");

        for (int i = 0; i < numNodesH; i++) {
            textH.setText(textH.getText() + Character.toString(65+i) + "  ");
            for (int j = 0; j < numNodesH; j++) {

                if (boolFXH[i][j]) {
                    textH.setText(textH.getText() + matrixFXH[i][j] + " ");
                }

                else {
                    textH.setText(textH.getText() + "X ");
                }
            }
            textH.setText(textH.getText() + "\n");
        }

        /**
         * source: barangay
         * destination: hospital
         *
         * 0 = A
         * 1 = B
         * 2 = C
         * 3 = D
         * 4 = E
         * 5 = F
         * 6 = G
         * 7 = H
         *
         * BARANGAY TO HOSPITAL
         */

        Graph g2 = new Graph(9, false, true);

//        g2.addEdge(0, 0, (float) 7.2);
//        g2.addEdge(0, 1, (float) 3.2);
//        g2.addEdge(0, 2, (float) 1.5);
//        g2.addEdge(0, 3, (float) 2.3);
//        g2.addEdge(0, 4, (float) 3.6);
//        g2.addEdge(0, 5, (float) 10.7);
//        g2.addEdge(0, 6, (float) 2);
//        g2.addEdge(0, 7, (float) 5.9);
//        g2.addEdge(0, 8, (float) 7.6);

        g2.addEdge(0, 0, (float) 7.2);
        g2.addEdge(0, 1, (float) 6.7);
        g2.addEdge(0, 2, (float) 5.6);
        g2.addEdge(0, 3, (float) 3.8);
        g2.addEdge(0, 4, (float) 3.4);
        g2.addEdge(0, 5, (float) 2.7);
        g2.addEdge(0, 6, (float) 2.2);
        g2.addEdge(0, 7, (float) 1.7);

//        g2.addEdge(1, 0, (float) 6.7);
//        g2.addEdge(1, 1, (float) 2.2);
//        g2.addEdge(1, 2, (float) 1.8);
//        g2.addEdge(1, 3, 2);
//        g2.addEdge(1, 4, (float) 2.6);
//        g2.addEdge(1, 5, 10);
//        g2.addEdge(1, 6, 1);
//        g2.addEdge(1, 7, (float) 4.8);
//        g2.addEdge(1, 8, (float) 6.5);

        g2.addEdge(1, 0, (float) 3.2);
        g2.addEdge(1, 1, (float) 2.2);
        g2.addEdge(1, 2, (float) 4.6);
        g2.addEdge(1, 3, (float) 0.2);
        g2.addEdge(1, 4, (float) 3.1);
        g2.addEdge(1, 5, (float) 1.9);
        g2.addEdge(1, 6, (float) 2.4);
        g2.addEdge(1, 7, 4);

//        g2.addEdge(2, 0, (float) 5.6);
//        g2.addEdge(2, 1, (float) 4.6);
//        g2.addEdge(2, 2, (float) 3.2);
//        g2.addEdge(2, 3, 4);
//        g2.addEdge(2, 4, (float) 4.9);
//        g2.addEdge(2, 5, (float) 9.5);
//        g2.addEdge(2, 6, (float) 3.2);
//        g2.addEdge(2, 7, (float) 4.2);

        g2.addEdge(2, 0, (float) 1.5);
        g2.addEdge(2, 1, (float) 1.8);
        g2.addEdge(2, 2, (float) 3.2);
        g2.addEdge(2, 3, 6);
        g2.addEdge(2, 4, (float) 5.3);
        g2.addEdge(2, 5, (float) 6.5);
        g2.addEdge(2, 6, (float) 6.6);
        g2.addEdge(2, 7, (float) 8.8);

//        g2.addEdge(3, 0, (float) 3.8);
//        g2.addEdge(3, 1, (float) 0.2);
//        g2.addEdge(3, 2, 6);
//        g2.addEdge(3, 3, (float) 5.5);
//        g2.addEdge(3, 4, (float) 3.9);
//        g2.addEdge(3, 5, (float) 7.7);
//        g2.addEdge(3, 6, (float) 4.6);
//        g2.addEdge(3, 7, (float) 2.5);
//        g2.addEdge(3, 8, (float) 4.1);

        g2.addEdge(3, 0, (float) 2.3);
        g2.addEdge(3, 1, 2);
        g2.addEdge(3, 2, 4);
        g2.addEdge(3, 3, (float) 5.5);
        g2.addEdge(3, 4, (float) 5.6);
        g2.addEdge(3, 5, (float) 6.6);
        g2.addEdge(3, 6, (float) 6.8);
        g2.addEdge(3, 7, 9);

        g2.addEdge(4, 0, (float) 3.6);
        g2.addEdge(4, 1, (float) 2.6);
        g2.addEdge(4, 2, (float) 4.9);
        g2.addEdge(4, 3, (float) 3.9);
        g2.addEdge(4, 4, (float) 1.6);
        g2.addEdge(4, 5, (float) 2.8);
        g2.addEdge(4, 6, (float) 2.9);
        g2.addEdge(4, 7, (float) 5.1);

        g2.addEdge(5, 0, (float) 10.7);
        g2.addEdge(5, 1, 10);
        g2.addEdge(5, 2, (float) 9.5);
        g2.addEdge(5, 3, (float) 7.7);
        g2.addEdge(5, 4, (float) 7.3);
        g2.addEdge(5, 5, (float) 6.6);
        g2.addEdge(5, 6, (float) 6.1);
        g2.addEdge(5, 7, (float) 3.8);

        g2.addEdge(6, 0, 2);
        g2.addEdge(6, 1, 1);
        g2.addEdge(6, 2, (float) 3.2);
        g2.addEdge(6, 3, (float) 4.6);
        g2.addEdge(6, 4, (float) 2.3);
        g2.addEdge(6, 5, (float) 3.5);
        g2.addEdge(6, 6, (float) 3.6);
        g2.addEdge(6, 7, (float) 5.8);

        g2.addEdge(7, 0, (float) 5.9);
        g2.addEdge(7, 1, (float) 4.8);
        g2.addEdge(7, 2, (float) 4.2);
        g2.addEdge(7, 3, (float) 2.5);
        g2.addEdge(7, 4, (float) 2.1);
        g2.addEdge(7, 5, (float) 1.5);
        g2.addEdge(7, 6, (float) 0.9);
        g2.addEdge(7, 7, (float) 1.4);

        g2.addEdge(8, 0, (float) 7.6);
        g2.addEdge(8, 1, (float) 6.5);
        g2.addEdge(8, 2, (float) 5.9);
        g2.addEdge(8, 3, (float) 4.1);
        g2.addEdge(8, 4, (float) 3.8);
        g2.addEdge(8, 5, 3);
        g2.addEdge(8, 6, (float) 3.1);
        g2.addEdge(8, 7, (float) 1.5);

        matrixFXB = g2.returnMatrix();
        boolFXB = g2.returnBool();
        numNodesB = g2.returnNodes();

        for(int i = 0; i < 9; i++) {
            if (i != 8) textB.setText(textB.getText() + Character.toString(65+i) + "    ");
            else textB.setText(textB.getText() + Character.toString(65+i));
        }
        textB.setText(textB.getText() + "\n");

        for (int i = 0; i < 9; i++) {
            if(i != 5) textB.setText(textB.getText() + Character.toString(65+i) + "  ");
            else textB.setText(textB.getText() + Character.toString(65+i) + " ");
            for (int j = 0; j < 8; j++) {
                if (boolFXB[i][j]) {
                    String sample = String.valueOf(matrixFXB[i][j]);
                    if (matrixFXB[i][j] < 10) {
                        sample += " ";
                    }
                    textB.setText(textB.getText() + sample + " ");
                }
            }
            textB.setText(textB.getText() + "\n");
        }
    }

    public void buttonBack(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Hospitals.fxml"));
        paneAdjacency.getChildren().setAll(pane);
    }

    public void buttonQuit(ActionEvent actionEvent) {
        System.exit(0);
    }
}