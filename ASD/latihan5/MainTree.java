package ASD.latihan5;

import java.util.LinkedList;
import java.util.List;

class Node<T>{
    T data;
    List<Node> child;

    public Node(T data){
        this.data = data;
        child = new LinkedList<Node>();
    }
}

class Tree<T> {
    Node<T> root;
    public Tree(Node<T>root){

        this.root=root;
    }

    public Tree (T data){

        root=new Node<T>(data);
    }

    public boolean isEmpty(){

        return root==null;
    }

    public Node getNode(Node<T>node,T data){
        if (node.data==data){
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
        Node<T>node = getNode(root,dataParent);
        if (node!=null){
            node.child.add(new Node<>(data));
        }
        else {
            System.out.println("Node parent tidak ditemukan");
        }
    }

    public void access(){
        System.out.println(root.data);
        access(root, " ");
    }

    private void access(Node<T> node, String space){
        System.out.println("");
        for (Object currNode : node.child){
            System.out.print(space+"->"+((Node)currNode).data);
            access((Node)currNode, space+" " );
        }
        return;
    }
}

public class MainTree{
    public static void main(String[] args) {

    }
}


