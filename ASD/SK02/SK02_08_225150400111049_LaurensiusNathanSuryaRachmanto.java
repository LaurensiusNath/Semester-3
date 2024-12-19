package ASD.SK02;

import java.util.Scanner;
import java.util.Stack;

public class SK02_08_225150400111049_LaurensiusNathanSuryaRachmanto {
    public static void main(String[] args) {
        Stack riwayat = new Stack<>();
        Stack redo = new Stack<>();
        Scanner scn = new Scanner(System.in);

        System.out.print("Masukkan riwayat penyakit pasien: ");
        String inputRiwayat = scn.nextLine();
        String[] inputKata = inputRiwayat.split(" ");

        System.out.println("==========================================");
        for(int i = 0; i < inputKata.length; i++){
            riwayat.push(inputKata[i]);
            System.out.print(riwayat.peek() + " ");
        }
        System.out.println("\n==========================================\n");

        System.out.println("\n1. Ketik satu kata atau kalimat untuk menambahkan riwayat, kemudian enter untuk memasukkan data riwayat\n" +
                "2. Ketik huruf 'z' untuk membatalkan kata terakhir (undo)\n" +
                "3. Ketik huruf 'y' untuk mengembalikan kata (redo)\n" +
                "4. Ketik huruf 'n' untuk keluar dari program");

        loopUtama: while (true) {
            String input = scn.nextLine();
            switch (input){
                case "z":
                    if (riwayat.size()!=0){
                        redo.push(riwayat.pop());
                        System.out.println(riwayat.toString());
                        System.out.println();}
                    else {
                        System.out.println(riwayat.toString());
                    }
                    break;

                case "y":
                    if (redo.size()==0){
                        System.out.println(riwayat.toString());
                        System.out.println();
                    }
                    else {
                        riwayat.push(redo.pop());
                        System.out.println(riwayat.toString());
                        System.out.println();
                    }
                    break;

                case "n":
                    System.out.println("TERIMA KASIH DAN SEMOGA LEKAS SEMBUH");
                    break loopUtama;

                default:
                    inputKata = input.split(" ");
                    for(int i = 0; i < inputKata.length; i++){
                        riwayat.push(inputKata[i]);;
                    }
                    redo.clear();
                    System.out.println(riwayat.toString());
                    System.out.println();
            }
        }
    }
}
