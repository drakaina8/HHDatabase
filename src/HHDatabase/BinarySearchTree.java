// Programmer: Hannah Hendrickson
// Assignment 3 Database
// Class: CS145 Hybrid01
// Date:
// Purpose: Create a binary search tree for a database

// Notes:


package HHDatabase;

public class BinarySearchTree 
{
    protected Node root;
    public BinarySearchTree()
    {
        this.root = null;
    } // end of BinarySearchTree constructor

    // getRoot getter method, returns root Node
    public Node getRoot()
    {
        return this.root;
    } // end of getRoot method

    public Node add(Node root, Node node)
    {
        if (root == null)
        {
            root = node;
        } // end of if
        else if (node.getKey() < root.getKey())
        {
            root.left = add(root.left, node);
        } // end of if
        else if (node.getKey() > root.getKey())
        {
            root.right = add(root.right, node);
        } // end of else if

        return node;
    } // end of addNode method

} // end of BinarySearchTree class
