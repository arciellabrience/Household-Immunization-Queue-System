package dataStructures;

import java.util.ArrayList;

public class Tree extends TreeNode {

    public TreeNode root;
    public ArrayList<LinkedList> members = new ArrayList<>();


    public Tree() {
        this.root = null;
    }

    //method of the creation of node
    public TreeNode createNode (Object data) {
        TreeNode temp = new TreeNode();
        temp.data = data;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    //method of the printing of in-order traversal of given sentence
    public void inOrderTraversal (TreeNode root) {
        LinkedList test = new LinkedList(1);
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        test.push(root.data.toString().split("~")[1]);
//        System.out.println("-> " + root.data.toString().split("~")[1].split("-")[0]);
        members.add(test);
        inOrderTraversal(root.right);
    }

    //method that inserts data in a tree with a parent node as a basis
    public TreeNode insert(TreeNode parent, Object t) {
        if (parent == null) {
            return createNode (t);
        }

        else {

            //if the parent node and word from array words are less than 0 in comparison,
            //should be on the left side
            if (t.toString().toLowerCase().compareTo(parent.data.toString().toLowerCase()) <= 0){
                parent.left = insert(parent.left, t);
            }

            //otherwise, data should be on the right side
            else {
                parent.right = insert(parent.right, t);
            }

            return parent;
        }
    }
}
