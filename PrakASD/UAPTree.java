package PrakASD;

import java.util.*;

class Node {
    String data;
    Node left, right;

    public Node(String item) {
        data = item;
        left = right = null;
    }
}

public class UAPTree {
    public UAPTree() {
    }

    public int count(String expression) {
        Stack<Node> stack = new Stack<>();
        String[] tokens = expression.split(" ");

        // Proses ekspresi dari belakang ke depan
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];

            if (isOperand(token)) {
                // Jika token adalah operand, masukkan ke dalam stack
                stack.push(new Node(token));
            } else if (isOperator(token)) {
                // Jika token adalah operator, ambil dua operand dari stack
                Node node = new Node(token);
                node.left = stack.pop();
                node.right = stack.pop();

                // Hitung dan masukkan hasilnya ke dalam stack
                int result = visit(node);
                stack.push(new Node(String.valueOf(result)));
            }
        }

        // Hasil akhir akan berada di stack
        return Integer.parseInt(stack.pop().data);
    }

    private int visit(Node root) {
        int rightValue = Integer.parseInt(root.right.data);
        int leftValue = Integer.parseInt(root.left.data);

        String operator = root.data;

        // Lakukan operasi yang sesuai
        switch (operator) {
            case "+":
                return leftValue + rightValue;
            case "/":
                if (rightValue != 0) {
                    return leftValue / rightValue;
                } else {
                    throw new ArithmeticException("Error: Division by zero");
                }
            case "-":
                return leftValue - rightValue;
            case "*":
                return leftValue * rightValue;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private boolean isOperand(String token) {
        // Cek apakah token adalah operand (angka)
        return token.matches("[0-9]+");
    }

    private boolean isOperator(String token) {
        // Cek apakah token adalah operator yang diizinkan
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UAPTree kalkulator = new UAPTree();
        String operasi = sc.nextLine();

        // Logika pengecekan jenis operasi matematika
        if (kalkulator.isOperator(operasi.split("\\s+")[0])) {
            System.out.println(kalkulator.count(operasi));
        } else if (kalkulator.isOperator(operasi.split("\\s+")[operasi.split("\\s+").length - 1])) {
            System.out.println("Operasi ditolak (postfix)");
        } else {
            System.out.println("Operasi ditolak (infix)");
        }
    }
}