// Programmer: Hannah Hendrickson
// Assignment 3 Database
// Class: CS145 Hybrid01
// Date:
// Purpose: Create a binary search tree for a database

// Notes:


package HHDatabase;

import java.util.ArrayList;

public class DatabaseMain 
{
    public static void main(String[] args)
    {
        try
        {
            BinarySearchTree bst = BinarySearchTree.buildTreeFromFile("src\\HHDatabase\\pokemon.csv");

            System.out.print(bst.root.toString());
            //bst.printTree(bst.root);
            
            //bst.printSideways(bst.root, 0);
        } // end of try
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.printf("%n%nSomething went wrong in main method.%n");
        } // end of catch
    
    }  // end of main method

} // end of DatabaseMain
