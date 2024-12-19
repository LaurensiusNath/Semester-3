package PrakASD.LK06;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Node<T>{
    T data;
    List<Node<T>> child;

    public Node(T data){
        this.data = data;
        child = new LinkedList<>();
    }
}
class Tree<T> {
    Node<T> root;

    public Tree(Node<T> root) {

        this.root = root;
    }

    public Tree(T data) {

        root = new Node<T>(data);
    }

    public boolean isEmpty() {

        return root == null;
    }

    public Node getNode(Node<T> node, T data){
        if (node.data.equals(data)){
            return node;
        }
        for (Object currNode : node.child){
            Node<T> returnNode = getNode((Node)currNode,data);
            if (returnNode!=null){
                return returnNode;
            }
        }
        return null;
    }
    public void add(T dataParent, T data){
       // Node<T> nodeData = getNode(root,data);
        Node<T> nodeParent = getNode(root,dataParent);
       //if (nodeData==null) {
            if (nodeParent != null) {
                nodeParent.child.add(new Node<>(data));
            } else {
                System.out.println("TIDAK ADA " + dataParent + " DI KELUARGA AHMAD");
            }
       //}
    }
    public void access() {
        access(root, 0);
    }

    private void access(Node<T> node, int level) {
        StringBuilder prefix = new StringBuilder();
        if (level > 0) {
            for (int i = 0; i < (level - 1); i++) {
                prefix.append("  ");
            }
            System.out.println(prefix+"-- "+node.data);
        }
        else {
            System.out.println(node.data);
        }

        for (Node<T> childNode : node.child) {
            access(childNode, level + 1);
        }
    }

}

public class LK6 {
    public static void main(String[] args) {
        Node<String>root=new Node<>("AHMAD");
        Tree<String> kelAhmad = new Tree<>(root);
        Scanner scan = new Scanner(System.in);
        while (true){
            String input = scan.nextLine();
            String [] inputPerKata = input.toUpperCase().split(" ");
            if (inputPerKata[0].equals("END")){
                break;
            }
            else if (inputPerKata[1]!=null){
                kelAhmad.add(inputPerKata[0],inputPerKata[1]);
            }
            else {
                System.out.print("");
            }
        }
        System.out.println("KELUARGA AHMAD :");
        kelAhmad.access();
    }
}
