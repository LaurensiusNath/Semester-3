package PrakASD.LK07;

import java.util.Stack;
import java.util.Scanner;

class Node {
    char value;
    Node left, right;

    Node(char value) {
        this.value = value;
        left = right = null;
    }
}

class Tree {
    Node root;

    boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    void inorder(Node node, boolean isRoot) {
        if (node != null) {
            boolean tandaKurung = !isRoot && isOperator(node.value);
            if (tandaKurung) {
                System.out.print("(");
            }
            inorder(node.left, false);
            System.out.print(node.value);
            inorder(node.right, false);
            if (tandaKurung) {
                System.out.print(")");
            }
        }
    }

    int evaluate(Node root) {
        if (root == null) {
            return 0;
        }

        if (!isOperator(root.value)) {
            return Character.getNumericValue(root.value);
        }

        int leftVal = evaluate(root.left);
        int rightVal = evaluate(root.right);

        if (root.value == '/' && rightVal == 0) {
            return leftVal;
        }

        switch (root.value) {
            case '+':
                return leftVal + rightVal;
            case '-':
                return leftVal - rightVal;
            case '*':
                return leftVal * rightVal;
            case '/':
                return leftVal / rightVal;
            default:
                return 0;
        }
    }



    Node constructTree(String postfix) {
        Stack<Node> st = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);
            if (!isOperator(ch)) {
                Node node = new Node(ch);
                st.push(node);
            } else {
                Node newNode = new Node(ch);
                newNode.right = st.pop();
                newNode.left = st.pop();
                st.push(newNode);
            }
        }

        return st.pop();
    }
}

public class LK07 {
    public static void main(String args[]) {
        Tree et = new Tree();
        Scanner scanner = new Scanner(System.in);

        String postfix = scanner.nextLine();

        Node root = et.constructTree(postfix);

        System.out.println("Infix expression :");
        et.inorder(root, true);

        int result = et.evaluate(root);
        System.out.println("\nHasil: " + result);
    }
}
