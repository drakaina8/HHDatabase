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

import javax.lang.model.util.ElementScanner14;

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
    // TODO maybe delete, unused
    public Node getRoot()
    {
        return this.root;
    } // end of getRoot method

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
            else if(currentNode.getNum() > newNode.getNum())
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
            } // end of else if
            else 
            {
                ui.printf("%nA new entry may not have the same number as an existing entry,%n"
                        + "please try again.%n%n");
                break;
            } // end of else
        } // end of while
        
    } // end of add method

    // delete method, deletes a node from the Binary Search Tree
    public void delete(Node root, int num)
    {
        if (root == null)
        {
            return;
        } // end of if
        if (root.getNum() > num)
        {
             
        } // end of if
    } // end of delete method

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

    // searchByNum method, searches the tree for an entry with the given key
    // prints the full node data if found
    public Node searchByNum()
    {
        int numToFind;
        ui.printf("%nEnter the Pokedex number of the entry you'd like to find: ");
        numToFind = ui.nextInt();

        while (root != null)
        {
            if (root.getNum() == numToFind)
            {
                //ui.printf(root.toString());
                return root;
            } // end of if
            if (root.getNum() >= numToFind)
            {
                root = root.left;
            } // end of if
            else if (root.getNum() <= numToFind)
            {
                root = root.right;
            } // end of else
        } // end of while
        ui.printf("%nThe number you entered does not exist in the database.%n");
        return null;
    } // end of searchByNum method


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
