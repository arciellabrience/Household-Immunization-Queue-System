package sample;

import dataStructures.LinkedList;
import dataStructures.Queue;
import dataStructures.Tree;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControllerTree implements Initializable {

    @FXML
    ListView lvTree;    

    @FXML
    AnchorPane paneTree;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File f = new File("src/assets/Directory.txt");

        //serves as reader per line
        String s = null;

        //collects all house numbers listed in file, with repetition
        String[] dashes;

        BufferedReader houseRead  = null;
        try {
            houseRead = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //create empty arraylist<Tree>
        ArrayList<Tree> houseNumList = new ArrayList<>();

        while (true) {
            try {
                if ((s = houseRead.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
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
        try {
            houseRead.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader barangayRead = null;
        try {
            barangayRead = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //create empty arraylist<LinkedList>
        ArrayList<LinkedList> barangayList = new ArrayList<>();

        while (true) {
            try {
                if ((s = barangayRead.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
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

        //nested-for loop that handles prioritization and display
        for (LinkedList brgy : barangayList) {
            lvTree.getItems().add("Barangay " + brgy.front().toString().split("-")[4] + " Priority List:");

            //
            ArrayList<LinkedList> aa = new ArrayList();
            //

            for (Tree tree : houseNumList) {
                //finds the house numbers located in a specific barangay
                if (tree.root.data.toString().split("-")[4].equals(brgy.front().toString().split("-")[4]) && tree.root.data.toString().split("-")[5].equals(houseNumList.get(houseNumList.indexOf(tree)).root.data.toString().split("-")[5])) {
//                    lvTree.getItems().add("House Number " + tree.root.data.toString().split("-")[5]);
                    float houseScore = 0;
                    int x;

                    tree.inOrderTraversal(tree.root);
                    Queue priorityList = new Queue(tree.members.size());
                    //score calculation works fine
                    for (x = 0; x < tree.members.size(); x++) {
                        //sets initial score
                        int total = tree.members.size();
                        String[] split = tree.members.get(x).front().toString().split("-");
                        //adds scores based on age and profession level criteria
                        if (Integer.parseInt(split[1]) >= 60 || Integer.parseInt(split[1]) <= 14) total = total + 2;
                        total = total + Integer.parseInt(split[3]);
                        //
                        houseScore += total;
                        //
                        tree.members.get(x).push(total);
                    }

                    //Creates a linked list for each citizen with the house number
                    //as its head and its overall score as its tail
                    LinkedList z = new LinkedList(1);
                    z.push(tree.members.get(x-1).front().toString().split("-")[5]);
                    z.push(Math.round((houseScore/x)*100)/100.0);

                    //Pushes the linked list to an ArrayList for sorting
                    aa.add(z);

                    //Sorts contents of arraylist in descending order based on priority scores
                    for (int i = 0; i < aa.size(); i++) {
                        for (int j = i+1; j < aa.size(); j++) {
                            if (Float.parseFloat(aa.get(i).back().toString()) < Float.parseFloat(aa.get(j).back().toString())) {
                                LinkedList temp = aa.get(i);
                                aa.set(i, aa.get(j));
                                aa.set(j, temp);
                            }
                        }
                    }
                }
            }

            //adds the sorted list of houses to the GUI based on priority
            for (LinkedList item : aa) lvTree.getItems().add(aa.indexOf(item)+1 + ". House " + item.front() + " (Priority Score: " + item.back() + ")");
            lvTree.getItems().add("\n");
        }
        //closes BufferedReader
        try {
            barangayRead.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //returns the user to the previous page
    public void buttonBack(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("2.fxml"));
        paneTree.getChildren().setAll(pane);
    }

    //proceeds to the hospital path page
    public void buttonNext(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("Hospitals.fxml"));
        paneTree.getChildren().setAll(pane);
    }
}
