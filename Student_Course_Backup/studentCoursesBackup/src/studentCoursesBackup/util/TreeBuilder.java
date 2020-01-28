package studentCoursesBackup.util;

import java.util.ArrayList;
import studentCoursesBackup.myTree.Node;

//code borrowed from https://www.geeksforgeeks.org/iterative-searching-binary-search-tree/

public class TreeBuilder {

        /* Class containing left and right child of current node and key value*/

        // Root of BST
        Node root;
        ArrayList<TreeBuilder> mytrees = new ArrayList<>();

        /**
        * Constructor, used to create the arraylist of trees for original node and two backup nodes.
        * @param node
        */
       public TreeBuilder(int parent) {
       MyLogger.writeMessage("In constructor "+ getClass().getName(), MyLogger.DebugLevel.CONSTRUCTOR);
           if(parent == 0){
            root = null;
            mytrees.add(this);
            mytrees.add(new TreeBuilder(1));
            mytrees.add(new TreeBuilder(1));
        } else {
            root = null;
           }
       }

        /**
        * Used to return the tree list
        * @param node
        * @return the arraylist of trees.
        */
        public ArrayList<TreeBuilder> returnTreeList(){
           return mytrees;
        }

        /**
        * This method mainly calls insertRec()
        * @param node
        */
       public void insert(Node node) {
            root = insertRec(root, node);
        }

        /**
        * A recursive function to insert a new key in BST.
        * @param root
        * @param node
        * @return return the (unchanged) node pointer.
        */
        Node insertRec(Node root, Node node) {

            /* If the tree is empty, return a new node */
            if (root == null) {
                root = node;
                return root;
            }

            /* Otherwise, recur down the tree */
            if (node.bno < root.bno)
                root.left = this.insertRec(root.left, node);
            else if (node.bno > root.bno)
                root.right = this.insertRec(root.right, node);

            /* return the (unchanged) node pointer */
            return root;
        }

        /**
        * This method mainly calls printNodes()
        * @param results
        */ 
       public void inorderRec(Results results) {
            this.printNodes(root, results);
        }

        /**
        * This method returns a node given it's bnumber.
        * @param bno
        * @return the node with the particular bnumber.
        */ 
        public Node SearchNode(int bno){
            Node tmp = root;
            while (tmp!= null){
                if(tmp.getbno() == bno){
                    return tmp;
                } else if(tmp.getbno() < bno){
                    tmp = tmp.getRight();
                } else {
                    tmp = tmp.getLeft();
                }
            }
            return null;
        }

        /**
        * A utility function to do inorder traversal of BST and store the results.
        * @param root
        * @param results
        */ 
        public void printNodes(Node root, Results results) {
            if (root != null) {
                printNodes(root.getLeft(), results);
                results.storeNewResult(root.bno + " " + root.courses + "\n");
                MyLogger.writeMessage(root.bno + " " + root.courses + "\n", MyLogger.DebugLevel.RESULT);
                printNodes(root.getRight(),results);
            }
        }
}

