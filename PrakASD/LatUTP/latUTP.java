package PrakASD.LatUTP;

import java.util.LinkedList;
import java.util.Scanner;

class Gerbong {
    String kode;

    public Gerbong(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }
}

public class latUTP {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] inputKata = input.split(" ");
        LinkedList<Gerbong> rangkaian = new LinkedList<>();
        LinkedList<Gerbong> urutan = new LinkedList<>();

        loopUtama:
        while (true) {
            switch (inputKata[0]) {
                case "INSERT":
                    switch (inputKata[1]) {
                        case "G1":
                            rangkaian.add(new Gerbong("G1"));
                            break;
                        case "G2":
                            rangkaian.add(new Gerbong("G2"));
                            break;
                        case "G3":
                            rangkaian.add(new Gerbong("G3"));
                            break;
                        case "GM":
                            rangkaian.add(new Gerbong("GM"));
                            break;
                    }
                    break;

                case "SORT":
                    for (int i = 0; i < rangkaian.size(); i++) {
                        for (Gerbong gerbong : rangkaian) {
                            if (gerbong.getKode().equals(inputKata[i])) {
                                urutan.add(gerbong);
                            }
                        }
                    }
                    System.out.println(urutan.toString());
                    break loopUtama;
            }
        }
    }
}
