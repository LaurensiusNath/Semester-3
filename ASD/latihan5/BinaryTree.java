package ASD.latihan5;

class BNode<T>{
    T data;
    BNode<T>leftChild;
    BNode<T>rightChild;

    public BNode(T data){
        this.data=data;
    }

    public BNode(T data, BNode<T>leftChild, BNode<T>rightChild){
        this.data=data;
        this.leftChild=leftChild;
        this.rightChild=rightChild;
    }
}

class BTree<T>{
    public BNode<T>root;

    public BTree(BNode<T>root){
        this.root=root;
    }

    public BTree(T data){
        root = new BNode<T>(data);
    }

    public boolean isEmpty(){
        return root==null;
    }

    public void access(BNode<T> node, String space, String childLR){
        if (node==null){
            return;
        }
        if (node!=root){
            System.out.println(space+"->"+childLR+node.data);
        }
        else {
            System.out.println(node.data);
            access(node.leftChild, space+ " ","(L)");
            access(node.rightChild, space+ " ","(R)");
        }
    }
}
public class BinaryTree {
    public static void main(String[] args) {
        BNode<Integer>n2=new BNode<Integer>(20,null,null);
        BNode<Integer>n3=new BNode<Integer>(40,null,null);
        BNode<Integer>n1=new BNode<Integer>(5,n2,n3);
    }
}
