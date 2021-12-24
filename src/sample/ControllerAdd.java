package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;

import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;
import javafx.util.Duration;

public class ControllerAdd implements Initializable {
    @FXML
    private AnchorPane paneAdd;

    @FXML
    private TextField identityName;

    @FXML
    private TextField identityAge;

    @FXML
    private TextField identitySex;

    @FXML
    private TextField identityProf;

    @FXML
    private TextField identityBrgy;

    @FXML
    private TextField identityHouse;

    @FXML
    private Button identitySubmit;

    @FXML
    private Button identityUndo;

    @FXML
    private CheckBox identityCheckName;

    @FXML
    private CheckBox identityCheckAge;

    @FXML
    private CheckBox identityCheckSex;

    @FXML
    private CheckBox identityCheckProf;

    @FXML
    private CheckBox identityCheckBrgy;

    @FXML
    private CheckBox identityCheckHouse;

    Stack stack = new Stack<>();

    //submit button after the end of inputting information
    public void buttonSubmit(ActionEvent actionEvent) throws IOException {

        //if the text fields are empty
        if (identityName.getText().equals("") || identityAge.getText().equals("") || identitySex.getText().equals("") || identityHouse.getText().equals("") || identityBrgy.getText().equals("") || identityProf.getText().equals("")) {
            Window pop = identitySubmit.getScene().getWindow();
            AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, pop, "Error!", "Please enter the necessary information.");
        }

        //if everything else is inputted with the correct format
        else {

            //converted array from a stack
            Object[] array = stack.toArray();

            //new array that sets
            Object[] newArray = new Object[10];

            //counter variables per text field
            int tempName = 0;
            int tempAge = 0;
            int tempSex = 0;
            int tempHouse = 0;
            int tempProf = 0;
            int tempBrgy = 0;

            //boolean variables per text field
            boolean boolName = false;
            boolean boolAge = false;
            boolean boolSex = false;
            boolean boolHouse = false;
            boolean boolProf = false;
            boolean boolBrgy = false;

            //for loop that arranges the variables "in order" to the new array to be written in the text file
            for (int i = 0; i < array.length; i++) {

                //if specific index in element is a name
                if (array[i].toString().contains(" ") && array[i].toString().length() >= 3) {
                    if (boolName == false) {
                        boolName = true;
                        tempName++;
                        newArray[0] = array[i];
                    }
                }

                //if specific index in element is a brgy
                if (array[i].toString().equals("UNO") || array[i].toString().equals("DOS") || array[i].toString().equals("TRES") || array[i].toString().equals("KUATRO") || array[i].toString().equals("SINGKO") || array[i].toString().equals("SAIS") || array[i].toString().equals("SYETE") || array[i].toString().equals("OTSO") || array[i].toString().equals("NUEVE")) {
                    if (boolBrgy == false) {
                        boolBrgy = true;
                        tempBrgy++;
                        newArray[4] = array[i];
                    }
                }

                //if specific index in element is a sex
                if (array[i].toString().equals("Female") || array[i].toString().equals("Male")) {
                    if (boolSex == false) {
                        boolSex = true;
                        tempSex++;
                        newArray[2] = array[i];
                    }
                }

                //if specific index in element is a profession class
                if (array[i].toString().startsWith("P") && (array[i].toString().length() == 2)) {
                    if (boolProf == false) {
                        boolProf = true;
                        tempProf++;
                        newArray[3] = array[i];
                    }
                }

                //if specific index in element is a age
                if (array[i].toString().startsWith("A") && (array[i].toString().length() == 2 || array[i].toString().length() == 3)) {
                    if (boolAge == false) {
                        boolAge = true;
                        tempAge++;
                        newArray[1] = array[i];
                    }
                }

                //if specific index in element is a house
                else if (array[i].toString().startsWith("H") && array[i].toString().length() >= 2){
                    if (boolHouse == false) {
                        boolHouse = true;
                        tempHouse++;
                        newArray[5] = array[i];
                    }
                }
            }

            //new String declarations that remove unnecessary letters from integers such as age, house number, and profession class
            String one = (String) newArray[1];
            String three = (String) newArray[3];
            String five = (String) newArray[5];

            String newOne = one.replace("A", "");
            String newThree = three.replace("P", "");
            String newFive = five.replace("H", "");

            //newly declared Strings are changed/updated inside the new array
            for (int i = 0; i < newArray.length; i++) {
                if (i == 1) {
                    newArray[i] = newOne;
                }

                if (i == 3) {
                    newArray[i] = newThree;
                }

                if (i == 5) {
                    newArray[i] = newFive;
                }
            }

            //String that formats the elements from the new array to the file
            String temp = "~" + newArray[0] + "-" + newArray[1] + "-" + newArray[2] + "-" + newArray[3] + "-" + newArray[4] + "-" + newArray[5];

            //reads the file and checks if line/data already exists
            BufferedReader reader = new BufferedReader(new FileReader(new File("src/assets/Directory.txt")));
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.toUpperCase().equals(temp.toUpperCase())) {
                    found = true;
                    break;
                }
            }

            //if data already exists, show error
            if (found) {
                Window pop = identitySubmit.getScene().getWindow();
                AlertHelper.showAlert(Alert.AlertType.ERROR, pop, "Oops!", "Information already exists in the database.");
            }


            else {

                //splitted array of Strings contain elements from String temp separated by a whitespace
                String[] splitted;
                splitted = temp.split(" ");

                //new String declarations to get the first half and the second half
                String first = splitted[0];
                String second = splitted[1];

                //capitalizes the first letter of the first name and the first letter of the surname
                String updatedFirst = first.substring(1, 2).toUpperCase() + first.substring(2).toLowerCase();

                //splits the second half with dash as regex
                String[] newerSecond = second.split("-");

                //gets the surname
                String secondSecond = newerSecond[0];

                //capitalizes surname properly with the addition of the other parts of the line
                String lastSecond = secondSecond.substring(0, 1).toUpperCase() + secondSecond.substring(1).toLowerCase() + "-" + newerSecond[1] + "-" + newerSecond[2] + "-" + newerSecond[3] + "-" + newerSecond[4] + "-" + newerSecond[5] ;

                //updates temp with new capitalizations
                temp = "~" + updatedFirst + " " + lastSecond;

                File file = new File("src/assets/Directory.txt");
                FileWriter fr = new FileWriter(file, true);

                fr.write("\n" + temp);
                fr.close();

                Window pop = identitySubmit.getScene().getWindow();
                AlertHelper.showAlert(Alert.AlertType.INFORMATION, pop, "Success!", "The database has been updated.");
            }

            AnchorPane pane = FXMLLoader.load(getClass().getResource("2.fxml"));
            paneAdd.getChildren().setAll(pane);
        }
    }

    //method that lets the user go back to the main menu
    public void buttonBack(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("2.fxml"));
        paneAdd.getChildren().setAll(pane);
    }

    //method that is basically the undo button
    public void buttonUndo(ActionEvent actionEvent) {

        //first checks if stack is empty, then notifies the user
        if (stack.isEmpty()) {
            Window pop = identityUndo.getScene().getWindow();
            AlertHelper.showAlert(Alert.AlertType.WARNING, pop, "Oops!", "No more actions left to undo.");
        }

        /**
         * NAME
         */
        //if the top of the stack is the user's name
        else if (top().contains(" ")) {
            identityName.setText("");
            identityCheckName.setSelected(false);
            stack.pop();
        }

        /**
         * SEX
         */
        //if the top of the stack is the user's sex
        else if (top().equals("M") || top().equals("F") || top().equals("m") || top().equals("f")) {
            identitySex.setText("");
            identityCheckSex.setSelected(false);
            stack.pop();
        }

        /**
         * HOUSE NUMBER
         */
        //if the top of the stack is the user's house number
        else if ((top().startsWith("H") || top().startsWith("h")) && top().length() == 2) {
            identityHouse.setText("");
            identityCheckHouse.setSelected(false);
            stack.pop();
        }

        /**
         * PROFESSION CLASS
         */
        //if the top of the stack is the user's profession class
        else if ((top().startsWith("P") || top().startsWith("p")) && top().length() == 2) {
            identityProf.setText("");
            identityCheckProf.setSelected(false);
            stack.pop();
        }

        /**
         * AGE
         */
        //if the top of the stack is the user's age
        else if ((top().startsWith("A") || top().startsWith("a")) && (top().length() == 2 || top().length() == 3)) {
            identityAge.setText("");
            identityCheckAge.setSelected(false);
            stack.pop();
        }

        /**
         * BRGY
         */
        //if the top of the stack is the user's barangay
        else {
            identityBrgy.setText("");
            identityCheckBrgy.setSelected(false);
            stack.pop();
        }
    }

    //method that pushes information about the individual's name once the checkbox is ticked
    public void checkboxName(ActionEvent actionEvent) throws IOException{
        if (identityCheckName.isSelected() && !identityCheckName.isIndeterminate()) {

            //if textbox contains a space
            if (identityName.getText().contains(" ")) {
                stack.push(identityName.getText());
            }

            else {
                Window pop = identityCheckName.getScene().getWindow();
                AlertHelper.showAlert(Alert.AlertType.ERROR, pop, "Error!", "Please enter your full name.");

                AnchorPane pane = FXMLLoader.load(getClass().getResource("Add.fxml"));
                paneAdd.getChildren().setAll(pane);
            }
        }
    }

    //method that pushes information about the individual's age once the checkbox is ticked
    public void checkboxAge(ActionEvent actionEvent) throws IOException {
        if (identityCheckAge.isSelected() && !identityCheckAge.isIndeterminate()) {

            //if textbox starts with letter 'A' and has an overall length of 2 and 3
            if (identityAge.getText().toUpperCase().startsWith("A") && (identityAge.getLength() == 2 || identityAge.getLength() == 3) ) {
                stack.push(identityAge.getText());
            }

            else {
                Window pop = identityCheckAge.getScene().getWindow();
                AlertHelper.showAlert(Alert.AlertType.ERROR, pop, "Error!", "Please enter information based on the specified format.");

                AnchorPane pane = FXMLLoader.load(getClass().getResource("Add.fxml"));
                paneAdd.getChildren().setAll(pane);
            }
        }
    }

    //method that pushes information about the individual's sex once the checkbox is ticked
    public void checkboxSex(ActionEvent actionEvent) throws IOException{
        if (identityCheckSex.isSelected() && !identityCheckSex.isIndeterminate()) {

            //if inputted letter is either capital F or small f
            if (identitySex.getText().equals("F") || identitySex.getText().equals("f")) {
                stack.push("Female");
            }

            //if inputted letter is either capital M or small m
            else if (identitySex.getText().equals("M") || identitySex.getText().equals("m")){
                stack.push("Male");
            }

            else {
                Window pop = identityCheckSex.getScene().getWindow();
                AlertHelper.showAlert(Alert.AlertType.ERROR, pop, "Error!", "Please enter information based on the specified format.");

                AnchorPane pane = FXMLLoader.load(getClass().getResource("Add.fxml"));
                paneAdd.getChildren().setAll(pane);
            }
        }
    }

    //method that returns the data on the top of the stack
    public String top() {
        return (String) stack.peek();
    }

    public void checkboxHouse(ActionEvent actionEvent) throws IOException {
        if (identityCheckHouse.isSelected() && !identityCheckHouse.isIndeterminate()) {

            //if text field starts with letter H
            if (identityHouse.getText().toUpperCase().startsWith("H")) {
                stack.push(identityHouse.getText());
            }

            else {
                Window pop = identityCheckHouse.getScene().getWindow();
                AlertHelper.showAlert(Alert.AlertType.ERROR, pop, "Error!", "Please enter information based on the specified format.");

                AnchorPane pane = FXMLLoader.load(getClass().getResource("Add.fxml"));
                paneAdd.getChildren().setAll(pane);
            }
        }
    }

    public void checkboxBrgy(ActionEvent actionEvent) throws IOException {
        if (identityCheckBrgy.isSelected() && !identityCheckBrgy.isIndeterminate()) {

            //if inputted barangays are equal to those provided
            if (identityBrgy.getText().toUpperCase().equals("UNO") || identityBrgy.getText().toUpperCase().equals("DOS") || identityBrgy.getText().toUpperCase().equals("TRES") || identityBrgy.getText().toUpperCase().equals("KUATRO") || identityBrgy.getText().toUpperCase().equals("SINGKO") || identityBrgy.getText().toUpperCase().equals("SAIS") || identityBrgy.getText().toUpperCase().equals("SYETE") || identityBrgy.getText().toUpperCase().equals("OTSO") || identityBrgy.getText().toUpperCase().equals("NUEVE")) {
                stack.push(identityBrgy.getText());
            }

            else {
                Window pop = identityCheckBrgy.getScene().getWindow();
                AlertHelper.showAlert(Alert.AlertType.ERROR, pop, "Error!", "Please enter information based on the specified format.");

                AnchorPane pane = FXMLLoader.load(getClass().getResource("Add.fxml"));
                paneAdd.getChildren().setAll(pane);
            }
        }
    }

    public void checkBoxProf(ActionEvent actionEvent) throws IOException {
        if (identityCheckProf.isSelected() && !identityCheckProf.isIndeterminate()) {

            //if inputted profession classes are equal to those provided
            if (identityProf.getText().toUpperCase().equals("P1") || identityProf.getText().toUpperCase().equals("P2") || identityProf.getText().toUpperCase().equals("P3") || identityProf.getText().toUpperCase().equals("P4") || identityProf.getText().toUpperCase().equals("P5")) {
                stack.push(identityProf.getText());
            } else {
                Window pop = identityCheckProf.getScene().getWindow();
                AlertHelper.showAlert(Alert.AlertType.ERROR, pop, "Error!", "Please enter information based on the specified format.");

                AnchorPane pane = FXMLLoader.load(getClass().getResource("Add.fxml"));
                paneAdd.getChildren().setAll(pane);
            }
        }
    }

    //tooltips that offer additional information to be inputted
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final Tooltip tooltipBarangayInfo = new Tooltip();
        tooltipBarangayInfo.setText("X City's Barangays:\nUNO, DOS, TRES, KUATRO, SINGKO,\nSAIS, SIETE, OTSO, NUEVE");
        tooltipBarangayInfo.setShowDelay(Duration.millis(0));
        tooltipBarangayInfo.setShowDuration(Duration.millis(60000));
        identityBrgy.setTooltip(tooltipBarangayInfo);

        final Tooltip tooltipProfessionList = new Tooltip();
        tooltipProfessionList.setText("Profession Levels:\n[P5] Healthcare Workers\n[P4] Food and Agriculture Industry\n" +
                "[P3] Transportation Services\n[P2] Uniformed Personnel\n[P1] Remaining Population");
        tooltipProfessionList.setShowDelay(Duration.millis(0));
        tooltipProfessionList.setShowDuration(Duration.millis(60000));
        identityProf.setTooltip(tooltipProfessionList);
    }
}