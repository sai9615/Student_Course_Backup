package studentCoursesBackup.myTree;

import java.util.ArrayList;

//code borrowed from https://www.geeksforgeeks.org/iterative-searching-binary-search-tree/

public class tree {

        /* Class containing left and right child of current node and key value*/

        // Root of BST
        Node root;
        ArrayList<tree> mytrees = new ArrayList<>();

        // Constructor
       public tree(int parent) {
           if(parent == 0){
            root = null;
            mytrees.add(this);
            mytrees.add(new tree(1));
            mytrees.add(new tree(1));
        } else {
            root = null;
           }
       }

        public ArrayList<tree> returnTreeList(){
           return mytrees;
        }
        // This method mainly calls insertRec()
       public void insert(Node node) {
            root = insertRec(root, node);
        }

        /* A recursive function to insert a new key in BST */
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

        // This method mainly calls InorderRec()
       public void inorderRec(Results results) {
            this.display(root, results);
        }

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

  /*  void deleteKey(int key)
    {
        root = deleteRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
  /*  Node deleteRec(Node root, int key)
    {

        if (root == null)  return root;


        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);


        else
        {

            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;


            root.key = minValue(root.right);

            root.right = deleteRec(root.right, root.key);
        }
        return root;
    } */

    // A utility function to do inorder traversal of BST
        public void display(Node root, Results results) {
            if (root != null) {
                display(root.getLeft(), results);
                results.storeNewResult(Integer.toString(root.bno)+ " " +root.courses + "\n");
                System.out.println(root.bno);
                display(root.getRight(),results);
            }
        }
}

