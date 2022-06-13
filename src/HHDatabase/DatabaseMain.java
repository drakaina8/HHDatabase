// Programmer: Hannah Hendrickson
// Assignment 3 Database
// Class: CS145 Hybrid01
// Date:
// Purpose: Create a binary search tree for a database

// Notes: the pokemon2.csv file staggers the order of pokemon
// This helps display the binary search tree a little better.
// The pokemon.csv file has the same entries but in numerical order.

// I chose to use a small database of pokemon for this assignment
// because pokemon numbers are already reminiscent of primary keys.


package HHDatabase;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DatabaseMain implements UserInterface
{
    private Scanner console;
    private BinarySearchTree bst;
    
    public static void main(String[] args)
    {
        DatabaseMain dbMain = new DatabaseMain();
        try
        {
            //dbMain.printMainMenu();
            dbMain.userSelect(dbMain.bst);

        } // end of try
        catch (Exception e)
        {
            e.printStackTrace();
            //System.out.printf("%n%nSomething went wrong in main method.%n");
        } // end of catch
    
    }  // end of main method

    public DatabaseMain()
    {
        console = new Scanner(System.in);
        bst = new BinarySearchTree(this);
    } // end of DatabaseMain constructor

    // printMenu method, displays menu options to user
    public void printMainMenu()
    {
        printf("%n%n~Database Menu~%n");
        printf("|l| Load Database into Binary Search Tree%n");
        printf("|s| Search for an entry%n");
        printf("|a| Add an entry to the Binary Search Tree%n");
        printf("|d| Delete an entry from the Binary Search Tree%n");
        printf("|v| View Binary Search Tree%n");
        printf("|q| Quit the program%n%n");
    } // end of mainMenu method

    // userSelect method, processes user's menu selection
    public void userSelect(BinarySearchTree bst)
    {
        boolean validSelection;
        char userSelection;
        do
        {
            printMainMenu();
            printf("Please enter the corresponding letter of your choice.%n");
            userSelection = userEnterChar();
            printf("%n");
            // validSelection only changes to false if one of the menu options is not selected
            validSelection = true;
            switch (userSelection)
            {
                case 'l':
                    try
                    {
                        bst.buildTreeFromFile(getFile());
                    } // end of try
                    catch (Exception e)
                    {
                        e.printStackTrace();
                        printf("Something went wrong with loading the file.");
                    } // end of catch
                    break;
                case 's':
                    printf(bst.searchByNum().toString());
                    break;
                case 'a':
                    bst.add(userCreateNode());
                    break;
                case 'd':
                    //bst.delete();
                    break;
                case 'v':
                    printTreeMenu();
                    break;
                case 'q':
                    return;
                default:
                    validSelection = false;
                    break;
            } // end of switch case
        } while (!validSelection || userSelection != 'q');
    } // end of menuSelect method

    // printMenu method, presents options for printing the tree
    // processes user's selection
    public void printTreeMenu()
    {
        boolean validSelection;
        char userSelection;
        do
        {
            printf("%n~Binary Search Tree Printing Menu~%n");
            printf("|l| Print as list%n");
            printf("|s| Print sideways%n");
            printf("%nPlease enter the corresponding letter of your choice.%n");
            userSelection = userEnterChar();

            // validSelection only changes to false if one of the menu options is not selected
            validSelection = true;
            switch (userSelection)
            {
                case 'l':
                    bst.printTreeAsList(bst.root);
                    break;
                case 's':
                    bst.printSideways(bst.root, 0);
                    break;
                default:
                    validSelection = false;
            } // end of switch case

        } while (!validSelection);
    } // end of printTreeMenu method

    // Evaluates the user's response to a yes/no question
    // returns a boolean value
    public boolean nextBoolean()
    {
        String answer = console.nextLine();
        return answer.trim().toLowerCase().startsWith("y");
    } // end of nextBoolean

    // nextInt method, returns user's int value
    public int nextInt()
    {
        int userInt = -1;
        boolean success = false;
        while (!success)
        {
            //printf("%nEnter an integer:");
            try
            {
                userInt = console.nextInt();
                success = true;
                nextLine();
            }
            catch (Exception e)
            {
                printf("%nThere was something wrong with your entry. Try again.%n");
            } // end of catch
        } // end of while
        return userInt;
    } // end of nextInt method

    // Intakes a line of user input and returns it as a String value
    public String nextLine()
    {
        return console.nextLine();
    } // end of nextLine

    // Prints a formatted String to the console
    public void printf(String message)
    {
        System.out.printf(message);
    } // end of printf

    // userEnterChar method, returns the first char entered by the user
    // the char returned will be lowercase
    public char userEnterChar()
    {
        char userCharEntry = console.next().charAt(0);
        userCharEntry = Character.toLowerCase(userCharEntry);

        // consumes rest of line so Scanner starts fresh on a new line
        console.nextLine();

        return userCharEntry;
    } // end of userEnterChar method

    public File getFile()
        throws FileNotFoundException
    {
        boolean fileExists = false;
        String userFileName;
        File file = new File("");
        while (!fileExists)
        {
            printf("%nPlease enter the file name you wish to upload.%n");
            userFileName = nextLine();
            try
            {
                file = new File("src\\HHDatabase\\" + userFileName);
                fileExists = true;
            } // end of try
            catch (Exception e)
            {
                printf("%nThere was an issue with your file. Try again.%n");
            } // end of catch
        } // end of while
        return file;
    } // end of getFilePath method

    public Node userCreateNode()
    {
        Node newNode = new Node(-1, "", "", "", false);
        int userInt;
        String userName;
        String userType1;
        String userType2;
        boolean userLegendary;

        boolean success = false;

        while (!success)
        {
            try
            {
                printf("To add a pokemon to the database,%nplease enter the following information.%n");
                printf("%nPokedex number: ");
                userInt = nextInt();
                printf("%nPokemon name: ");
                userName = nextLine();
                printf("%nPokemon type: ");
                userType1 = nextLine();
                printf("%nPokemon second type (press enter if no second type): ");
                userType2 = nextLine();
                printf("Is it a legendary pokemon? Type yes/no: ");
                userLegendary = nextBoolean();

                newNode = new Node(userInt, userName, userType1, userType2, userLegendary);
                success = true;
            } // end of try
            catch (Exception e)
            {
                success = false;
                e.printStackTrace();
                printf("%nSomething went wrong with manual node creation. Try again.%n");
            } // end of catch
        } // end of while
        saveEntryToFile(newNode);
        return newNode;
    } // end of userCreateNode

    // saveEntryToFile method, saves user's new node to csv file
    public void saveEntryToFile(Node node)
    {
        printf("Would you like to save your entry to the database file? ");
        if (nextBoolean())
        {
            try
            {
                FileWriter fw = new FileWriter(getFile(), true);
                BufferedWriter myWriter = new BufferedWriter(fw);
                myWriter.newLine();
                myWriter.write(node.getNum() + "," + node.getName() + "," 
                    + node.getType1() + "," + node.getType2() + "," + node.getStringLegendary());
                printf("%nSaved entry to file.%n");
                myWriter.close();
            } // end of try
            catch (IOException e)
            {
                e.printStackTrace();
                printf("Somethign went wrong with saving your entry.%n");
            } // end of catch
        } // end of if
    } // end of saveEntryToFile

} // end of DatabaseMain
