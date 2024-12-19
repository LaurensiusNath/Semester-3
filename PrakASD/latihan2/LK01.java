package PrakASD.latihan2;

import java.util.LinkedList;
import java.util.Scanner;

class Gerbong{
    private String nama;
    public Gerbong(String nama){
        this.nama=nama;
    }

    public String getNama() {
        return nama;
    }
}
public class LK01 {
    public static void main(String[] args) {
        LinkedList<Gerbong>jenisGerbong = new LinkedList<>();
        jenisGerbong.add(new Gerbong("Eksekutif"));
        jenisGerbong.add(new Gerbong("Bisnis"));
        jenisGerbong.add(new Gerbong("Ekonomi"));
        jenisGerbong.add(new Gerbong("Makanan"));

        LinkedList<Gerbong>rangkaian = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        int loop = 0;
        while (loop==0){
            String input = scan.nextLine();
            String[]kata=input.split(" ");
            if (kata[0].equals("INSERT")){
                switch (kata[1]) {
                    case "G1":
                        rangkaian.add(jenisGerbong.get(0));
                        System.out.println("Gerbong "+jenisGerbong.get(0).getNama()+" berhasil ditambahkan");
                        break;

                    case "G2":
                        rangkaian.add(jenisGerbong.get(1));
                        System.out.println("Gerbong "+jenisGerbong.get(1).getNama()+" berhasil ditambahkan");
                        break;

                    case "G3":
                        rangkaian.add(jenisGerbong.get(2));
                        System.out.println("Gerbong "+jenisGerbong.get(2).getNama()+" berhasil ditambahkan");
                        break;

                    case "GM":
                        rangkaian.add(jenisGerbong.get(3));
                        System.out.println("Gerbong "+jenisGerbong.get(3).getNama()+" berhasil ditambahkan");
                        break;
                }
            } else if (kata[0].equals("SISIP")) {
                int index = Integer.parseInt(kata[1]);
                if (index >= 0 && index<= rangkaian.size()) {
                    switch (kata[2]){
                        case "G1":
                            rangkaian.add(Integer.parseInt(kata[1]), jenisGerbong.get(0));
                            System.out.println("Gerbong "+ jenisGerbong.get(0).getNama()+" berhasil ditambahkan pada index ke-"+Integer.parseInt(kata[1]));
                            break;

                        case "G2":
                            rangkaian.add(Integer.parseInt(kata[1]),jenisGerbong.get(1));
                            System.out.println("Gerbong "+ jenisGerbong.get(1).getNama()+" berhasil ditambahkan pada index ke-"+Integer.parseInt(kata[1]));
                            break;

                        case "G3":
                            rangkaian.add(Integer.parseInt(kata[1]),jenisGerbong.get(2));
                            System.out.println("Gerbong "+ jenisGerbong.get(2).getNama()+" berhasil ditambahkan pada index ke-"+Integer.parseInt(kata[1]));
                            break;

                        case "GM":
                            rangkaian.add(Integer.parseInt(kata[1]), jenisGerbong.get(3));
                            System.out.println("Gerbong "+ jenisGerbong.get(3).getNama()+" berhasil ditambahkan pada index ke-"+Integer.parseInt(kata[1]));
                            break;
                    }
                }
                else {
                    System.out.println("Index melebihi batas");
                }
            }
            else if (kata[0].equals("LEPAS")) {
                if (rangkaian.size()!=0){
                System.out.println("Gerbong "+rangkaian.getLast().getNama()+" berhasil dilepas");
                rangkaian.removeLast();
            }
                else {
                    System.out.println("Jumlah gerbong kosong");
                }
            }
            else if (kata[0].equals("CETAK")) {
                if (rangkaian.size()!=0){
                    System.out.print("Start -");
                    int i=0;
                    while (i< rangkaian.size()){
                        System.out.print(" Gerbong "+rangkaian.get(i).getNama()+" -");
                        if(i== (rangkaian.size()-1)){
                            System.out.println(" End");
                        }
                        i++;
                    }
                }
                else {
                    System.out.println("Kereta tidak memiliki gerbong");
                }
            }
            else if (kata[0].equals("SELESAI")) {
                loop=1;
            }
        }
        }
}
