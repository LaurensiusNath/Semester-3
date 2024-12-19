package PrakASD.UTP;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;
import java.util.Stack;

public class stack {
    public static boolean checker (String word1, String word2) {
        word1 = word1.replaceAll("\\s", "").toLowerCase();
        word2 = word2.replaceAll("\\s", "").toLowerCase();


        Stack<Character> stackWord1 = new Stack<>();
        Stack<Character> stackWord2 = new Stack<>();

        for (int i = 0; i < word1.length(); i++) {
            stackWord1.push(word1.charAt(i));
        }
        for (int i = 0; i < word2.length(); i++) {
            stackWord2.push(word2.charAt(i));
        }

        stackWord1 = sortStack(stackWord1);
        stackWord2 = sortStack(stackWord2);

        return stackWord1.equals(stackWord2);
    }


    // Gunakan method ini dan jangan diubah kodenya
    private static Stack<Character> sortStack(Stack<Character> stack) {
        Stack<Character> sortedStack = new Stack<>();
        while (!stack.isEmpty()) {
            char temp = stack.pop();
            while (!sortedStack.isEmpty() && temp > sortedStack.peek()) {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }
        return sortedStack;
    }

    // Jangan ubah main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();

        if (checker(word1, word2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}