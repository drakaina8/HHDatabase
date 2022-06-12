// Programmer: Hannah Hendrickson
// Assignment 3 Database
// Class: CS145 Hybrid01
// Date:
// Purpose: Create a binary search tree for a database

// Notes:


package HHDatabase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BinarySearchTree 
{
    protected Node root;
    private final UserInterface ui;

    public BinarySearchTree(UserInterface ui)
    {
        this.root = null;
        this.ui = ui;
    } // end of BinarySearchTree constructor

    // getRoot getter method, returns root Node
    public Node getRoot()
    {
        return this.root;
    } // end of getRoot method

    /* TODO maybe delete, always throws NullPointerException
    // addRecursive method, inserts a new node using recursion
    public Node addRecursive(Node root, Node node)
    {
        if (this.root == null)
        {
            this.root = node;
        } // end of if
        else if (node.getKey() < root.getKey())
        {
            root.left = addRecursive(root.left, node);
        } // end of if
        else if (node.getKey() > root.getKey())
        {
            root.right = addRecursive(root.right, node);
        } // end of else if

        return node;
    } // end of addNode method
    */

    // add method, inserts a new node non-recursively into the BST
    public void add(Node newNode)
    {
        Node currentNode = this.root;
        if (this.root == null)
        {
            this.root = newNode;
            return;
        } // end of if
        
        while (true)
        {
            if(currentNode.getNum() < newNode.getNum())
            {
                if (currentNode.right != null)
                {
                    currentNode = currentNode.right;
                } // end of if
                else
                {
                    currentNode.right = newNode;
                    break;
                } // end of else
            } // end of if
            else
            {
                if (currentNode.left != null)
                {
                    currentNode = currentNode.left;
                } // end of if
                else
                {
                    currentNode.left = newNode;
                    break;
                } // end of else
            } // end of else
        } // end of while
        
    } // end of add method

    // buildTreeFromFile method
    public BinarySearchTree buildTreeFromFile(File file) 
        throws FileNotFoundException, IOException
    {
        String row = "";
        String[] rowValues;
        int num;
        boolean legendary;
        ArrayList<Node> nodeList = new ArrayList<>();

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while ((row = reader.readLine()) != null)
            {
                rowValues = row.split(",");
                num = Integer.parseInt(rowValues[0]);
                legendary = Boolean.parseBoolean(rowValues[4]);
                nodeList.add(new Node(num, rowValues[1], rowValues[2], rowValues[3], legendary));
                //bst.add(bst.root, new Node(num, rowValues[1], rowValues[2], rowValues[3], legendary));
            } // end of while
            reader.close();
            int middleNum = nodeList.size() /2;
            // adds node at middleNum index as root
            // adds all subsequent indexes to binary search tree
            for (int i = middleNum; i <= nodeList.size() -1; i++)
            {
                this.add(nodeList.get(i));
            } // end of for
            // adds indexes smaller than middNum
            for (int i = middleNum -1; i >= 0; i--)
            {
                this.add(nodeList.get(i));
            } // end of for
        } // end of try
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } // end of catch

        return this;
    } // end of buildTreeFromFile


    // treeFromList method
    // public static 


    // printSideways method
    public void printSideways(Node root, int level)
    {
        if (root != null)
        {
            printSideways(root.right, level + 1);
            for (int i = 0; i < level; i++)
            {
                System.out.print("    ");
            }
            System.out.println(root.toString());
            printSideways(root.left, level + 1);
        }
    } // end of printSideways method

    // printTree method
    public void printTree(Node root)
    {
        //Node tempNode = this.root;
        if (this.root != null)
        {
            System.out.print(" " + root.toString());
            printTree(root.left);
            printTree(root.right);
            
        }
    } // end of printTree method

    // printTreeAsList method, prints the BST linearly in order
    public void printTreeAsList(Node node)
    {
        if (node == null)
        {
            return;
        } // end of if

        printTreeAsList(node.left);
        ui.printf(node.toString() + "%n");
        printTreeAsList(node.right);
    } // end of printTreeAsList method

} // end of BinarySearchTree class
