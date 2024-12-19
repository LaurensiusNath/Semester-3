package PrakASD.UTP;

import java.util.Scanner;

public class UTP {

    public static <T> boolean isPalindrome(T data) {
        // Mengkonversi data menjadi string untuk memudahkan pemrosesan
        String input = String.valueOf(data);
        // Menghapus semua spasi dan mengubah huruf menjadi huruf kecil (case-insensitive)
        input = input.replaceAll("\\s+", "").toLowerCase();

        // Mengecek apakah string adalah palindrome
        int left = 0;
        int right = input.length() - 1;
        while (left < right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Jangan ubah main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Integer number = sc.nextInt();
        Double dbl = sc.nextDouble();

        System.out.println("Is '" + str + "' a palindrome? " + isPalindrome(str));
        System.out.println("Is " + number + " a palindrome? " + isPalindrome(number));
        System.out.println("Is " + dbl + " a palindrome? " + isPalindrome(dbl));
    }
}
