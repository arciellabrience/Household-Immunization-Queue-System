package sample;

import dataStructures.LinkedList;
import dataStructures.Tree;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Window;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ControllerDelete implements Initializable {

    @FXML
    AnchorPane paneDelete;

    @FXML
    ListView lv;

    @FXML
    Button identityDelete;

    @FXML
    private MenuButton sortBar;

    @FXML
    private MenuItem defaultSort;

    @FXML
    private MenuItem ageSort;

    @FXML
    private MenuItem barangaySort;

    @FXML
    private MenuItem maleSort;

    @FXML
    private MenuItem femaleSort;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //displays txt file through listview
        defaultSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                sortBar.setText("Sort By: Default");
                lv.getItems().clear();

                try (Stream<String> stream = Files.lines(Paths.get("src/assets/Directory.txt"))) {
                    List<String> list = stream.filter(str -> str.startsWith("~")).map(s -> s.split("~")[1].split("-")[0] + " (Barangay " + s.split("-")[4] + "; House " + s.split("-")[3] + "; Profession Level: " + s.split("-")[5] + "; " + s.split("-")[2] + "; " + s.split("-")[1] + " years old)").collect(Collectors.toList());

                    String[] a = list.toArray(new String[list.size()]);
                    lv.getItems().addAll(a);

                    lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        ageSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                changes sort caption
                sortBar.setText("Sort By: Age");
//                clears list
                lv.getItems().clear();

                try (Stream<String> stream = Files.lines(Paths.get("src/assets/Directory.txt"))) {
                    List<String> list = stream.filter(str -> str.startsWith("~")).map(s -> s.split("~")[1]).collect(Collectors.toList());
                    String temp;
                    LinkedList sorted = new LinkedList(list.size() + 1);
//                    sorts entries based on age in ascending order
                    for (int i = 0; i < list.size(); i++) {
                        for (int j = i + 1; j < list.size(); j++) {
                            if (Integer.parseInt(list.get(i).split("-")[1]) > Integer.parseInt(list.get(j).split("-")[1])) {
                                temp = list.get(i);
                                list.set(i, list.get(j));
                                list.set(j, temp);
                            }
                        }
//                        enter lowest age to linked list
                        sorted.push(list.get(i));
                    }

//                    transfers contents of linked list to array to display in ListView
                    String[] l = new String[list.size()];
                    for (int k = 0; k < list.size(); k++) {
                        String[] sliced = sorted.pop().toString().split("~")[0].split("-");
                        l[k] = sliced[0] + " (" + sliced[1] + " years old; " + sliced[2] + "; Barangay " + sliced[4] + "; House " + sliced[5] + "; Profession Level: " + sliced[3] + ")";
                    }

                    lv.getItems().addAll(l);
                    lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        barangaySort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                changes sort caption
                sortBar.setText("Sort By: Barangay");
//                clears list
                lv.getItems().clear();

                File f = new File("src/assets/Directory.txt");

                //serves as reader per line
                String s;

                //collects all house numbers listed in file, with repetition
                String[] dashes;

                BufferedReader houseRead;
                try {
                    houseRead = new BufferedReader(new FileReader(f));

                    //create empty arraylist<Tree>
                    ArrayList<Tree> houseNumList = new ArrayList<>();

                    while ((s = houseRead.readLine()) != null) {
                        dashes = s.split("-");
                        //adds first tree to empty arraylist
                        if (houseNumList.isEmpty()) {
                            houseNumList.add(new Tree());
                            houseNumList.get(0).root = houseNumList.get(0).createNode(s);
                        }
                        else {
                            boolean houseExists = false;
                            for (Tree value : houseNumList) {
                                //checks if house number in scanned line is same as house number in each tree
                                if (dashes[5].equals(value.root.data.toString().split("-")[5]) && dashes[4].equals(value.root.data.toString().split("-")[4])) {
                                    //adds scanned line to tree
                                    value.insert(value.root, s);
                                    houseExists = true;
                                }
                            }
                            //if same house number is detected
                            if (!houseExists) {
                                //creates new tree in arrayList
                                houseNumList.add(new Tree());
                                //sets root to the line read in directory
                                houseNumList.get(houseNumList.size()-1).root = houseNumList.get(houseNumList.size()-1).createNode(s);
                            }
                        }
                    }

                    //closes BufferedReader (important)
                    houseRead.close();

                    BufferedReader barangayRead = new BufferedReader(new FileReader(f));
                    //create empty arraylist<LinkedList>
                    ArrayList<LinkedList> barangayList = new ArrayList<>();

                    while ((s = barangayRead.readLine()) != null) {
                        dashes = s.split("-");
                        //adds linkedlist to empty arraylist
                        if (barangayList.isEmpty()) {
                            barangayList.add(new LinkedList(1));
                            //searches arraylist<Tree> for all houses (tree) located in the specific barangay
                            for (Tree j : houseNumList) {
                                if (j.root.data.toString().split("-")[4].equals(dashes[4])) {
                                    //pushes each tree to the linked list as a specific node
                                    barangayList.get(0).push(houseNumList.get(houseNumList.indexOf(j)).root.data.toString());
                                }
                            }
                        }
                        else {
                            boolean brgyExists = false;
                            for (LinkedList value : barangayList) {
                                //checks if barangay in the line read already exists in the arraylist
                                if ((dashes[4]).equals(value.front().toString().split("-")[4])) {
                                    //pushes house (tree) located in specific barangay to linked list
                                    value.push(houseNumList.get(barangayList.indexOf(value)).root.data.toString());
                                    brgyExists = true;
                                }
                            }
                            //if same barangay is detected
                            if (!brgyExists) {
                                //creates new linked list in arraylist
                                barangayList.add(new LinkedList(1));
                                for (Tree j : houseNumList) {
                                    //traverses arraylist to find houses located in the same barangay
                                    if (j.root.data.toString().split("-")[4].equals(dashes[4])) {
                                        //adds house (tree) to linked list
                                        barangayList.get(barangayList.size()-1).push(houseNumList.get(houseNumList.indexOf(j)).root.data.toString());
                                    }
                                }
                            }
                        }
                    }

                    for (LinkedList brgy : barangayList) {
                        lv.getItems().add("Barangay " + brgy.front().toString().split("-")[4] + " Residents:");
                        for (Tree tree : houseNumList) {
                            if (tree.root.data.toString().split("-")[4].equals(brgy.front().toString().split("-")[4]) && tree.root.data.toString().split("-")[5].equals(houseNumList.get(houseNumList.indexOf(tree)).root.data.toString().split("-")[5])) {
                                lv.getItems().add("House Number " + tree.root.data.toString().split("-")[5]);
                                tree.inOrderTraversal(tree.root);
                                for (LinkedList item : tree.members) {
                                    String[] split = item.front().toString().split("~")[0].split("-");
                                    lv.getItems().add("-> " + split[0] + " (" + split[1] + " years old; " + split[2] + "; " + "Profession Level: " +split[3] + ")");
                                }
                            }
                        }
                        if(barangayList.indexOf(brgy) != barangayList.size()-1) lv.getItems().add("\n");
                    }

                    //closes BufferedReader
                    barangayRead.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        //alphabetization sort
        maleSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                changes sort caption
                sortBar.setText("Sort By: Gender (Male)");
//                clears list
                lv.getItems().clear();

                try (Stream<String> stream = Files.lines(Paths.get("src/assets/Directory.txt"))) {
                    List<String> list = stream.filter(str -> str.startsWith("~")).map(s -> s.split("~")[1]).collect(Collectors.toList());
                    String temp;
                    LinkedList sorted = new LinkedList(1);
//                    sorts entries based on age in ascending order
                    for (String s : list) if (s.split("-")[2].equals("Male")) sorted.push(s);

//                    transfers contents of linked list to array to display in ListView
                    int x = sorted.size();
                    String[] l = new String[x];
                    for (int k = 0; k < x; k++) {
                        String[] sliced = sorted.pop().toString().split("~")[0].split("-");
                        l[k] = sliced[0] + " (" + sliced[2] + "; " + sliced[1] + " years old; House Number " + sliced[5] + "; Barangay " + sliced[4] + "; Profession Level: " + sliced[3] + ")";
                    }

                    lv.getItems().addAll(l);
                    lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        femaleSort.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                changes sort caption
                sortBar.setText("Sort By: Gender (Female)");
//                clears list
                lv.getItems().clear();

                try (Stream<String> stream = Files.lines(Paths.get("src/assets/Directory.txt"))) {
                    List<String> list = stream.filter(str -> str.startsWith("~")).map(s -> s.split("~")[1]).collect(Collectors.toList());
                    String temp;
                    LinkedList sorted = new LinkedList(1);
//                    sorts entries based on age in ascending order
                    for (String s : list) {
                        if (s.split("-")[3].equals("Female")) sorted.push(s);
                    }

//                    transfers contents of linked list to array to display in ListView
                    int x = sorted.size();
                    String[] l = new String[x];
                    for (int k = 0; k < x; k++) {
                        String[] sliced = sorted.pop().toString().split("~")[0].split("-");
//                        sorted.pop();
                        l[k] = sliced[0] + " (" + sliced[2] + "; " + sliced[1] + " years old; House Number " + sliced[5] + "; Barangay " + sliced[4] + "; Profession Level: " + sliced[3] + ")";
                    }

                    lv.getItems().addAll(l);
                    lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                } catch (IOException e) {
                    e.printStackTrace();
                }            }
        });

        try (Stream<String> stream = Files.lines(Paths.get("src/assets/Directory.txt"))) {
            List<String> list = stream.filter(str -> str.startsWith("~")).map(s -> s.split("~")[1].split("-")[0] + " (Barangay " + s.split("-")[4] + "; House " + s.split("-")[3] + "; Profession Level: " + s.split("-")[5] + "; " + s.split("-")[2] + "; " + s.split("-")[1] + " years old)").collect(Collectors.toList());

            String[] a = list.toArray(new String[list.size()]);
            lv.getItems().addAll(a);

            lv.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        }

        catch (IOException e) {
            e.printStackTrace();
        }

    }

    //method that lets the user go back to the main menu
    public void buttonBack(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("2.fxml"));
        paneDelete.getChildren().setAll(pane);
    }

    //deletes data from txt file if name exists
    public void buttonDelete(ActionEvent actionEvent) throws IOException {
        String selectedItem = lv.getSelectionModel().getSelectedItem().toString();
        String id = selectedItem.split(" ")[1] + " " + selectedItem.split(" ")[2];
        String[] words;
        String s;
        File f1 = new File("src/assets/Directory.txt");
        BufferedReader br = new BufferedReader(new FileReader(f1));
        int count = 0;
        boolean found = false;
        Window pop = identityDelete.getScene().getWindow();

        while ((s = br.readLine()) != null) {
            words = s.split("~")[1].split("-");
            if (words[0].equals(id)) {
                found = true;
                break;
            }
        }

        if (found) {
            try {
                File file = new File("src/assets/Directory.txt");
                List<String> out = Files.lines(file.toPath()).filter(line -> !line.contains(id)).collect(Collectors.toList());
                Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
                AlertHelper.showAlert(Alert.AlertType.CONFIRMATION, pop, "Success!", id + " has been removed from the database.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        else AlertHelper.showAlert(Alert.AlertType.ERROR, pop, "Error", "Invalid Entry");

        br.close();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("2.fxml"));
        paneDelete.getChildren().setAll(pane);
    }
}