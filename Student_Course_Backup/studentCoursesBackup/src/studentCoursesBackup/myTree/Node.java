package studentCoursesBackup.myTree;

import java.util.ArrayList;

public class Node implements observer, subject {

    public int bno;
    public String course;
    public Node left;
    public Node right;
    public int bkup=0; //0 for original node and 1 for backup node

    ArrayList<Node> listeners = new ArrayList<>();
    public ArrayList<String> courses = new ArrayList<>();
    public enum keys {INSERT , DELETE }
    public keys operation;

    /**
    * Used to create a new node.
    * @param bno
    * @param course
    * @param ops
    */
    public void newNode(int bno, String course, keys ops) {
        this.bno = bno;
        this.course = course;
        this.courses.add(course);
        this.left = null;
        this.right = null;
        this.bkup = 0;
        this.operation = ops;
    }

    /**
    * Used for creating backup nodes.
    * @param bno
    * @param course
    * @param ops
    */
    public void bkpNode(int bno, String course, keys ops){
        this.bno = bno;
        this.course = course;
        this.courses.add(course);
        this.left = null;
        this.right = null;
        this.bkup = 1;
        this.operation = ops;
    }

    /**
    * Used to notify all the backup nodes about the update.
    * @param node
    * @param course
    */
    public void notifyAll(Node node, String course){
        for(Node nodes : listeners){
            nodes.update(node, course);
        }
    }

    /**
    * Used to register the observer.
    * @param obs
    */
    public  void registerObs(Node obs){
        this.listeners.add(obs);
    }

    /**
    * Used to update the original node as well as the backup nodes.
    * @param node
    * @param course
    */
    public void update(Node node, String course){
       String crs= course;
       // System.out.println(node.getbno()+ " " +crs);
        if(!courses.contains(crs) && node.getOperation() ==  node.operation.INSERT){
            this.courses.add(crs);
        } else if(courses.contains(crs) && node.getOperation() ==  node.operation.DELETE){
            this.courses.remove(crs);
        }
        if(this.bkup == 0){
            this.notifyAll(node, course);
        }
    }

    /**
    * Used to get the bnumber of the node.
    * @return the bnumber of the node
    */
    public int getbno(){
        return this.bno;
    }

    /**
    * Used to get the left node of the particular node.
    * @return the left node.
    */
    public Node getLeft(){
        return this.left;
    }

    /**
    * Used to get the right node of the particular node.
    * @return the right node.
    */
    public Node getRight(){
        return this.right;
    }

    /**
    * Used to get the enum value of the node.
    * @return the enum value.
    */
    public keys getOperation() {
        return this.operation;
    }

    /**
    * Used for creating clone of the node calling this method.
    * @param bno
    * @param course
    * @return the cloned node.
    */
    public Node clone(int bno, String course){
        Node node = new Node();
        node.bkpNode(bno, course, node.operation.INSERT);
        return node;
    }

}
