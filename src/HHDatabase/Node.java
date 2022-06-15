// Programmer: Hannah Hendrickson
// Assignment 3 Database
// Class: CS145 Hybrid01
// Date: 6/14/2022
// Purpose: Create a binary search tree that populates from a csv file.

// Pokemon have Pokedex numbers which are unique and function as primary keys.


package HHDatabase;

public class Node 
{
    // Node fields
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
    public int getNum()
    {
        return this.pokedexNum;
    } // end of getKey method

    // getName getter, returns name as String
    public String getName()
    {
        return this.name;
    } // end of getName

    //getType1 getter, returns type1 as String
    public String getType1()
    {
        return this.type1;
    } // end of getType1 method

    //getType2 getter, returns type1 as String
    public String getType2()
    {
        return this.type2;
    } // end of getType2 method

    // getStringLegendary, returns String representation of boolean value
    public String getStringLegendary()
    {
        String legendaryString = "";
        if (this.legendary)
        {
            legendaryString = "True";
        } // end of if
        else
        {
            legendaryString = "False";
        } // end of else
        return legendaryString;
    } // end of getStringLegendary method

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