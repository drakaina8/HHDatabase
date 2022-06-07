// Programmer: Hannah Hendrickson
// Assignment 3 Database
// Class: CS145 Hybrid01
// Date:
// Purpose: Create a binary search tree for a database

// Notes:


package HHDatabase;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DatabaseMain 
{
    public static void main(String[] args)
    {
        try
        {
            BinarySearchTree bst = buildTreeFromFile("src\\HHDatabase\\pokemon.csv");
            bst.printSideways(bst.root, 0);
        } // end of try
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.printf("%n%nSomething went wrong in main method.%n");
        } // end of catch
    
    }  // end of main method

    public static BinarySearchTree buildTreeFromFile(String path) 
        throws FileNotFoundException, IOException
    {
        String row = "";
        String[] rowValues;
        int num;
        boolean legendary;
        BinarySearchTree bst = new BinarySearchTree();

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            while ((row = reader.readLine()) != null)
            {
                rowValues = row.split(",");
                num = Integer.parseInt(rowValues[0]);
                legendary = Boolean.parseBoolean(rowValues[4]);
                bst.add(bst.root, new Node(num, rowValues[1], rowValues[2], rowValues[3], legendary));
            } // end of while
            reader.close();
        } // end of try
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } // end of catch

        return bst;
    } // end of buildTreeFromFile
} // end of DatabaseMain
