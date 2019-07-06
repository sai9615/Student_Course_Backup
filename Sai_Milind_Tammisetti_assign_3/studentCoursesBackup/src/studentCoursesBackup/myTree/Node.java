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


    public void newNode(int bno, String course) {
        this.bno = bno;
        this.course = course;
        this.courses.add(course);
        this.left = null;
        this.right = null;
        this.bkup = 0;
    }

    public void bkpNode(int bno, String course){
        this.bno = bno;
        this.course = course;
        this.courses.add(course);
        this.left = null;
        this.right = null;
        this.bkup = 1;
    }

    public void notif(Node node, String course){
        for(Node nodes : listeners){
            nodes.update(node, course);
        }
    }

    public  void registerObs(Node obs){
        this.listeners.add(obs);
    }

    public void update(Node node, String course){
       String crs= course;
       // System.out.println(node.getbno()+ " " +crs);
        if(!courses.contains(crs)){
            this.courses.add(crs);
        }
        if(this.bkup == 0){
            this.notifyAll(node, course);
        }
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
