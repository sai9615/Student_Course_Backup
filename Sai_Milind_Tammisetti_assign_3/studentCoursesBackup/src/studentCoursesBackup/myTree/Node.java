package studentCoursesBackup.myTree;

import java.util.ArrayList;

public class Node implements observer, subject {

    int bno;
    String course;
    Node left;
    Node right;
    int bkup=0; //0 for original node and 1 for backup node

    ArrayList<Node> listeners = new ArrayList<>();


    public void newNode(int bno, String course) {
        this.bno = bno;
        this.course = course;
        this.left = null;
        this.right = null;
        this.bkup = 0;
    }

    public void bkpNode(int bno, String course){
        this.bno = bno;
        this.course = course;
        this.left = null;
        this.right = null;
        this.bkup = 1;
    }

    public void notif(Node node){
        for(Node nodes : listeners){
            nodes.update(node);
        }
    }

    public  void registerObs(Node obs){
        this.listeners.add(obs);
    }

    public void update(Node node){
        System.out.println();
    }

    public int getbno(){
        return this.bno;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }

    public Node clone(int bno, String course){
        Node node = new Node();
        node.bkpNode(bno, course);
        return node;
    }

}
