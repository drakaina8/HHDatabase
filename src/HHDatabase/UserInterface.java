// Programmer: Hannah Hendrickson
// Assignment 3 Database
// Class: CS145 Hybrid01
// Date: 6/14/2022
// Purpose: Create a binary search tree for a database

// Notes: This interface was inspired and modeled after 
// the UserInterface in the 20 questions lab.

package HHDatabase;

public interface UserInterface 
{
    // Evaluates the user's response to a yes/no question
    // returns a boolean value
    boolean nextBoolean();

    // Intakes and returns an integer entered by the user
    int nextInt();

    // Intakes a line of user input and returns it as a String value
    String nextLine();

    // Prints a formatted String to the console
    void printf(String message);

    // returns a char entered by the user
    // char will be lowercase
    char userEnterChar();

    // Processes user's menu selections
    void userSelect(BinarySearchTree bst);

} // end of interface UserInterface
