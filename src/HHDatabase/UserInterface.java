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

    // Displays menu options to console
    // TODO maybe delete from interface
    void printMainMenu();
} // end of interface UserInterface
