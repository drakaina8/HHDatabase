/* 

package HHDatabase;

import java.util.Scanner;

public class DatabaseMenu implements UserInterface
{
    private Scanner console;
    private final UserInterface ui;

    public DatabaseMenu(UserInterface ui)
    {
        console = new Scanner(System.in);
        this.ui = ui;
    } // end of DatabaseMenu constructor

    // mainMenu method, displays menu options to user
    public void printMenu()
    {
        ui.printf("~Database Menu~%n");
        ui.printf("|l| Load Database into Binary Search Tree%n");
        ui.printf("|a| Add an entry to the Binary Search Tree%n");
        ui.printf("|d| Delete an entry from the Binary Search Tree%n");
        ui.printf("|v| View Binary Search Tree%n");
        ui.printf("|q| Quit the program%n%n");
    } // end of mainMenu method

    // menuSelect method, processes user's menu selection
    public static void userSelect(BinarySearchTree bst)
    {
        boolean validSelection;
        char userSelection;
        do
        {
            ui.printf("Please enter the corresponding letter of your choice");
            userSelection = ui.userEnterChar();

            // validSelection only changes to false if one of the menu options is not selected
            validSelection = true;
            switch (userSelection)
            {
                case 'l':
                    bst.buildTreeFromFile("");
                    break;
                case 'a':
                    break;
                case 'd':
                    break;
                case 'v':
                    break;
                case 'q':
                    break;
                default:
                    validSelection = false;
                    break;
            } // end of switch case
        } while (!validSelection);
    } // end of menuSelect method

    // Evaluates the user's response to a yes/no question
    // returns a boolean value
    public boolean nextBoolean()
    {
        String answer = console.nextLine();
        return answer.trim().toLowerCase().startsWith("y");
    } // end of nextBoolean

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
} // end of DatabaseMenu

*/