// Programmer: Hannah Hendrickson
// Assignment 3 Database
// Class: CS145 Hybrid01
// Date:
// Purpose: Create a binary search tree for a database

// Notes:

package HHDatabase;

public class Node 
{
    private int pokedexNum;
    protected Node left;
    protected Node right;

    private String name;
    private String type1;
    private String type2;
    private boolean legendary;
    

    public Node(int pokedexNum, String name, String type1, String type2, boolean legendary)
    {
        this.pokedexNum = pokedexNum;
        this.left = null;
        this.right = null;

        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.legendary = legendary;
    } // end of Node constructor

    // toString method, prints all field of node
    public String toString()
    {
        String nodeString = "#" + this.pokedexNum + " " + this.name + ", " + this.type1 + ", " + type2 + ", " + this.legendary;

        return nodeString;
    } // end of toString method

    // getKey getter method, returns primaryKey value
    public int getKey()
    {
        return this.pokedexNum;
    } // end of getKey method

    // getLeft getter method, returns left node
    public Node getLeft()
    {
        return this.left;
    } // end of getLeft method

    // getRight getter method, returns right node
    public Node getRight()
    {
        return this.right;
    } // end of getRight method

} // end of Node class