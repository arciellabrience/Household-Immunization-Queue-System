# Vaccine-Hospital-Prioritization-Program
Data Structures and Algorithms Laboratory (LBYCPA2) course using the Java programming language in IntelliJ IDEA software.

## Signficance and Social Impact
To aid the other LGUs in developing their vaccine plans, the
creation and utilization of the proposed household vaccination
queue system aims to give priority scheduling for households,
factoring in the overall composition of the family members. A
point system was imposed, wherein each point is dependent on
the the professional classification and the age of the individual, which is in accordance with the priority list of the Center for
Disease Control and Prevention (2021) of the United States,
which is supplementarily modified in accordance with the the
standards set by the DOH and the Inter-Agency Task Force
(2020).
As a functioning prototype, a sample area had been chosen
as a basis for the program’s utilizable graph, such that each fixed
vertex is represented by the surrounding hospitals within the
area. Additionally, since each barangay can be treated as
adjacent to each hospital, it is set as the arbitrary starting point
of the houses under its respective barangay. The sample area is
loosely based on the eight major hospitals of Las Pinas City,
with its barangays merged and separated into nine districts.
These barangays are displayed one-by-one, depending on the
user’s preference, and are set homeomorphic to the hospitals.
The weights of the paths and the adjacency matrices have
already been pre-determined through the utilization of mapping
software such as Google Maps.
With this regard, the program’s output can give a sorted
queue of the houses for each barangay, allowing LGUs with a
minimal / ineffective vaccination plan to have an extra layer of
efficacy in terms of its delivery and allocation.

## Six Data Structures Implemented in the Program
### Array
Holds the initial values of the database and
easily utilized during String operations

### Stack
Placeholder for elements that allow for the
undoing of a specific input / action

### Queue
Holds the sorted list of houses that will be
display the final sequence of the program

### Linked List
Holds the complex information of
families per household and utilized a myriad of times to
generate linked lists within linked lists

### Tree
Aids in the sorting of houses under the same
barangay

### Graph
Depicted through a created adjacency matrix
with values set in contrast to a sample area


## Program Features
To provide a better context, the professional classification of
a household’s individual is split into five, wherein, from highest
to lowest priority, include the (5) healthcare personnel, (4)
food and agriculture service, (3) transportation services, (2)
uniformed personnel, and the (1) remaining population. Additionally, the pointing system for those aged 14 below and
60 above are given (2) extra points, as shown priority by the
Philippines’ national government.

### Program Overview
At its initial runtime, a menu screen is presented explaining
the overall function of the program, such that a single button
allows the user to move to the next screen. The program
overview screen explains to the user that the main parameters
for prioritization scheme involve that of the number of people in
a household, as well as the respective age and profession of each
individual.

### Main Menu
The main menu gives the user five distinct actions in
executing the general functions of the program. Each button will
move the user to a specific screen, such that:
<ul>
  <li>Add Button – enables the user to add an entry to a
    database;</li>
  <li>Delete Button – allows the user to delete an existing
    entry within the database;</li>
  <li>View Current Data – views a list of people present
    within the database;</li>
  <li>Prioritization Button – launches the prioritization
    algorithm of the program;</li>
  <li>Exit Button – immediately closes the program.</li>
</ul>

### Add Entry Screen
Upon clicking the add button from the main menu, a form-
like screen will be presented to the user asking to input an individual’s name, age, gender, profession class, barangay, and
house number. The age, profession class, and numbers have a
prefix of “A”, “P”, and “H”, respectively, to ease the
manipulation of the input object within an array, along with
checkboxes to check the necessary conditions. If a certain
parameter was input, and a mistake was implemented, the user
is given the option to undo their action through the undo button,
which allows the user to revoke the previously added entry of
the text field.
To view the profession classes to be evaluated within the
program, as well as the available barangays of the sample city,
a simple hover over the text field will display the necessary
information for the user to go over. With regards to the house
number’s application within a real world setting, it can be
likened to that of the user’s input street and specific house
number.

### Delete Entry Screen
The delete entry button presents to the user a list view of
every individual present within the current database. To add ease
in navigation, the list can be sorted into five ways, namely
sorting by default, age, barangay, and sorting by gender via
displaying male or female entries only. Afterwards, the user can
then, simply return to the main menu to perform other functions
as needed.

### View Current Data Sheet
Like that of the delete entry screen, the view current data
sheet allows the user to see a list view of the current individuals
present within the database, showing each of their respective
address, gender, age, and profession class. The task is initially
accomplished by reading the dynamically sized database, such
that the data can be easily viewed through a dropdown menu,
allowing the user to easily view the data as it can be sorted by
the five aforementioned methods.

### Launch Prioritization
Upon clicking the prioritization button from the main menu,
the user is immediately directed to a sorted list view of the
program’s current database. The provided list has already
accounted for the total score of a particular household, given that
it is the summation of the weights of the profession and age of
individuals, divided by their total number.
The user may then opt to return to the main menu to add,
delete, or view entries, or simply exit the program. Otherwise,
they may proceed to the next step which will show the nearest
hospital to their respective barangays.

The program then shows the traversable path of the user, given an
arbitrary barangay choice, which is positioned at the middle of
the K8 graph. For each barangay choice, they are directed to the
nearest hospital between them, and consequently shows the
succession of hospitals that they may visit through the depicted
sequence in a text field.
From this window, the user can then opt to return to the
sorted list from the previous window or choose to hit next to see
the adjacency matrix of the hospitals from one another, or the
adjacency matrix of a chosen barangay to the adjacent hospitals.

## Source Code Specifications

### Main Menu
The main menu screen offers multiple options that further
explore the different features of the program. When hovered
over by the cursor, each button has their short descriptions about
their functionality. Given that each button directs the user to a
new screen, a new fxml file was utilized along with necessary
Controller java file classes. Each AnchorPane per action event
created loads itself over the current AnchorPane, and so the user
is directed to another screen.

Tooltips were also utilized to display the short descriptions
about each button. The delay for this was set to zero milliseconds
so that the corresponding message will show up immediately,
and the duration was set to 60000 milliseconds, to ensure that
the short description about a button is read by the user.

### Add Entry Screen
The structure involving the adding of entries is handled by 
the ControllerAdd.java and the Add.fxml file. When accessed, 
the user is taken to a scene with different text fields to allow an 
input of entries per category, with corresponding checkboxes 
placed beside them. The user will then enter the necessary 
information needed and will be prompted to tick each checkbox 
once the input information is final. A prompt is then displayed 
stating that the entry has been successfully appended to the 
database of the program. If the program detects a repeated entry 
or an invalid input within the text fields, a prompt will be 
displaying the corresponding error and will not add the user 
entry to the database.
For the functions within the ControllerAdd.java class, it is 
split into three main parts, namely:
<ul>
  <li>Checking for input validity</li>
  <li>Adding valid entries</li>
  <li>Undo feature</li>
</ul>
To give highlight, the undo feature allows the “locked” text 
input, which is enabled via the ticking of the checkboxes, to be
revoked. This is an additional feature of the program that utilizes 
a stack data structure, allowing the program to return to its 
previous state and disregarding the latest entry of the user.<br /><br />
The function for checking the input validity as well as the 
addition of the valid entries into the directory are both handled 
by the Submit button. The function that corresponds to this 
button first checks all entries contained within the stack, such 
that no invalid characters are present within the necessary 
parameters for the text fields. With the use of a buffered reader, 
the function also reads the current directory to see if an instance 
of repetition may occur when compared to that of the pending 
user-input entry. The function handles any minor nuances that 
may cause loopholes in the source code such as the case 
sensitivity of two exact entries. <br /><br />
Once validated, the program saves each category of the entry 
into an array and creates a string to properly format the 
information that will be concatenated into the directory text file 
using a FileWriter variable.The format for each entry in the 
directory is set as such:<br /><br />
~NAME-AGE-SEX-PROFESSION_LEVEL-BARANGAY-HOUSE_NUMBER <br /><br />

The tilde (~) symbol acts as a separator for each entry as the 
program traverses through the file which serves a dual purpose 
of safely determining a valid input and the prevention of reading 
empty lines. The dashes that separate each user category serves 
as the regex that will be used to split the string as the program 
reads each line. This will result in an array with its contents 
separating each category into its elements for ease of access in data viewing and manipulation. The new entry will then be 
visible in windows that display the database and its contents.

### Delete Entry Screen
In deleting from the database, the data is displayed in list 
view. The button on the lower right side allows the user to pick 
their preference on how the data is to be displayed, while the 
button on the lower left allows the user to backtrack to the main 
menu. Initially, the data displayed in list view is set by default, 
such that the order of its presentation is based on how the 
database or file is read per line. The sorting of the database can 
be by set by age, barangay, and displayed by sex.<br /><br />
Throughout the program’s runtime, similar structures may 
be present in terms of the sorting options, file reading, string 
manipulation and displaying of data as an array. The reading of 
the file is done through Stream, which requires the file path to 
be read, which consequently requires a String list to be declared 
and initialized. This function filters and manipulates the text file 
line-by-line such as removing unnecessary symbols and
accessing specific indices. The list is then converted to an array 
and sets the text of the list view based on the data structure. 
Selection mode was set as single, and so deletion is done one at 
a time. <br /><br />
The delete button converts the selected item from the list 
view to a String, then extracts the name from both the list view 
and the file to string manipulation. Reading through the file will 
compare both Strings and check if they are similar. If they are, 
the line is deleted from the text file.

### View Current Data Sheet
Before the program can read the text file that serves as the 
database, its contents must first be modified to make the 
program’s traversal through it as simple as possible. This is done 
by saving all the necessary information of each entry in the 
database as a single line, with the data separated by a common 
symbol. The program then declares a BufferedReader to be able 
to traverse the database and its contents, such that each line read 
is stored as an array after having the string value the line 
converted into an array of strings after utilizing the split() 
function with the common separator as its regex. The contents 
are then manipulated to provide an organized output of data for 
each user, which is to be shown as an entry in the list view pane 
in the SceneBuilder. The program repeats the prior steps until it 
reaches the end of the text file or if the line it has read returns a 
null value. This ensures that all the entries in the database, 
whether predetermined or user-inputted, are properly organized 
and displayed in the GUI integration.<br /><br />
With sorting the age in ascending order, while reading 
through the file, the initial list of strings is traversed through a 
nested loop, such that each element is compared to one another 
through an if statement. The conversion of string to integer was 
done by accessing the index of the age in the line. A temp 
variable with data type String was declared, and the LinkedList 
in Java was utilized in pushing the lowest age belonging to a 
particular individual. String manipulation was done to convert 
the LinkedList to an array, and then once again displays the data 
as an array. <br /><br />
If sorted by sex, the same procedure is done for either sex, 
wherein the file is read, then compared for each line if the specific index is either equal to “Male” or “Female”. For 
instance, if sorted by gender is clicked, if “Male” is in the 
specific line, the entire line is pushed to a LinkedList. The 
display of the all-male individuals is stored in an array and 
displayed with string manipulation as well.<br /><br />
Lastly, if sorted by barangay, Trees are utilized to establish 
the relationship of the house numbers under it, such that 
BufferedReader classes was used to read through each house. 
An ArrayList variable, named houseNumList, of data type Tree 
is initially declared which accounts for the members of the same 
house number in a barangay. While reading the text file, the if 
statement, or the first run of the while loop adds a new Tree to 
the houseNumList and sets the first index as its root. For later 
use, a boolean variable houseExists was declared and initialized 
to be false.<br /><br />
The for loop that checks per Tree value to the houseNumList 
under this else statement checks if the house numbers are the 
same with each Tree through string manipulation once again. If 
they are indeed the same, the boolean houseExists is now true, 
and adds the current scanned line to the Tree. Outside the for 
loop is another if statement that checks if the boolean 
houseExists is true, such that a new Tree is added to the 
houseNumList and sets it as a root in the ArrayList. The 
BufferedReader is closed as this ends the traversal for reading 
house numbers.<br /><br />
A new BufferedReader is now declared for reading through 
the barangays, as well as a new ArrayList of LinkedList for 
barangays denoted as barangayList is declared. While reading 
through the text file, at the first run, barangayList adds a new 
LinkedList. A for loop inside this if statement checks per Tree 
in the houseNumList if all houses, depicted as Tree data 
structures, are in the same barangay such that if it does, 
barangayList pushes the Tree to a specific node. At each 
consecutive iteration, the boolean brgyExists is declared false, 
and a for loop traverses through the barangayList as a
LinkedList and checks if the current barangay read already 
exists in the barangayList. If it does exist, the house / Tree data 
structure is pushed to a specific barangay in the LinkedList. 
Outside the for loop, if boolean brgyExists is true, such that if 
the same barangay is detected, houseNumList is traversed, and 
looks for houses within the same barangay. If a match is found, 
the house is pushed to the LinkedList.<br /><br />
For the display in list view, the brgyList is traversed by a for 
loop and gets the index of the name of the barangay,
consequently presented within the list view; and another for loop 
for the Tree in houseNumList that checks if the houses belong 
to the same barangay, then displays this with the list view as 
well. Another for loop that traverses through the tree.members 
displays the rest of their basic information. After the necessary 
manipulation of the database, the BufferedReader is closed.

### Launch Prioritizatiion
This prioritization function of the program contains three 
different scenes that determine the prioritization levels of 
households in a barangay and the medical facilities that they will 
be addressed to, including an additional visualization of how 
these results came to be. The first scene that the user will be 
directed to is one with a list view showing the sorted result of the house numbers of each barangay which is based on the 
individual priority scores of each member of the household. The 
calculation of the overall household scores are executed inside a 
large, nested for-loop that runs every other necessary function 
such as sorting and displaying the sorted values. As the user is 
directed to the window, the listview of the prioritized list is accomplished by first creating an ArrayList 
that stores Tree data structures containing the data on each 
person in a specific household. A BufferedReader of the 
directory is then initialized and sequentially reads each line of 
the directory using a while loop such that if the read string is not 
null, the program saves the line it reads into a string. Each line 
in the database is formatted the same way as aforementioned in 
the entry screen section and is split using the same regex to 
create an array containing specific information about each 
patient. <br /><br />
The file reader continues, and a Tree 
is created for the corresponding address of the patient read if one 
has not been made yet. This is to ensure that there will be no 
duplicates and the individuals of a specific household will be 
properly grouped together in their corresponding Tree. The
sequence is repeated until the BufferedReader reaches the end 
of the file, which results in the array list containing Trees of each 
house in every barangay that contain their respective residents. 
The BufferedReader is closed, and another array list is created 
but will now contain linked lists that hold specific trees as 
houses in the previous ArrayList that are in the same barangay 
as the one being referenced. This would then result in an 
ArrayList that acts as a storage structure at the very top for ease
of access. <br /><br />
To properly summarize, the main array list would contain 
linked lists (barangays), which would contain grouped trees 
(households) of the same barangay, which would contain string 
values (individuals) that are of the same household. This method
of grouping multiple different data structures, albeit not efficient 
in terms of time complexity, serves as a way to prevent 
hardcoding and allows the program to be dynamic, which means 
the source code would not require any changes if it were given 
a different directory, or if new entries are added at any given 
time as the only variable declarations made in this whole 
segment would be those of the two array lists and some 
placeholder variables. <br /><br />
Once complete, the program would then need to determine 
the overall priority score of each household to begin prioritizing,
which would the most amount of attention. In its execution the program would traverse through each barangay (linked list)
before it is able to traverse through each house (tree) using the 
in-order traversal method to read information on each individual 
in the family. The computation processes are shown in the 
formulas below: <br /><br />
Individual score = number of people in the household + 
profession level + age score <br /><br />
House score = (total individual scores) / (number of people 
in the household) <br /><br />
The profession level of an individual is a rating from 1 to 5 
depending on the occupation of the individual and its risk factor 
in terms of susceptibility to infection. The age score is a factor 
that is included in only some individuals that are known to have 
weaker immune systems than most people, namely the elderly 
and young people. After having calculated the scores of each 
household in a barangay, they are then sorted based on their 
calculated priority and are sorted and placed in a queue data 
structure. The resulting queue is now popped one by one as it is 
displayed, along with the corresponding priority score. <br /><br />
With regards to the second scene, the display of the K8 graph 
is simply a visual representation of the barangay’s location with 
its distances from each hospital is set as the graph’s edges. 
Though not drawn to scale, it depicts the relationship from one 
vertex to another, as if it is a map. The current data is set from 
the sample area as chosen by the group and is accurately 
programmed based on the results of mapping software such as 
Google Maps. The sequence of the hospitals near a certain 
barangay is printed on the other side, to show which hospital is 
nearer from a certain vertex. These visual aids serve as 
supplementary understanding on how graphs can be applied in 
the real world. <br /><br />
For the final scene of the program, two adjacency matrices 
are displayed, wherein the first shows a representation of the 
distances of hospitals with one another, while the second one 
depicts the distances of each barangay to its adjacent hospitals. 
A custom Graph class was implemented which considers the 
total number of nodes in a graph and accepts two additional 
boolean values to determine on whether the graph is directed or 
undirected, and whether it is weighted or unweighted. The class 
is called and instantiated within the ControllerAdjacency.java 
file, wherein the weighted edges are set, manipulated, and 
ultimately displayed through the custom functions of addEdge(), 
returnMatrix(), returnBool(), returnNode(). The necessary 
JavaFX functions were also utilized to display the final matrix 
of the graph.

## Conclusion and Recommendations
To conclude, the creation of a House Immunization Queue 
System effectively returns a house prioritization list based on the 
input values involving individuals within a certain household. 
The parameters of age, profession class, and number of people 
were used as a basis in the calculation of scores, which as 
mentioned, returns a prioritization list given as it is input in a 
queue. Each data structure within the LBYCPA2 course was 
also utilized, such that its application has been specifically 
present in the manipulation and storage of data sets. It is also 
worth mentioning that sorting algorithms were also beneficial in 
displaying the setting the order of the elements present within 
the prioritization list view.
Given that the program is a prototype with the scope limited 
to that of the chosen area, it can be recommended that additional 
software tools may be utilized to dynamically create and 
determine the barangay-to-hospital graph, such that the distance 
between these two objects become its connecting edges. Another 
scenario may have been applied to the program, such that in the 
event a hospital runs out of the vaccine, a boolean value set on 
whether that hospital should still be counted as a vertex of the 
graph.
In the program’s application in a real-world setting, it is 
highly recommended that more data should be retrieved from 
the user, such that it becomes substantial to a point that 
verification IDs are necessary to participate in the vaccination 
program.

## Authors

#### Arciella Brience C. Crisostomo [arciella_brience_crisostomo@dlsu.edu.ph]

#### Dustin Kyle D. Landicho [dustin_kyle_landicho@dlsu.edu.ph]
  
#### John Emmanuel E. Pareja [j-em_pareja@dlsu.edu.ph]
