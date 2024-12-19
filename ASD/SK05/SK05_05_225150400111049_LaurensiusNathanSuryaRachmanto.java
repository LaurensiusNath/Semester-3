package ASD.SK05;

import java.util.LinkedList;
import java.util.Scanner;

class Akun implements Fesbuk {
    String nama;
    LinkedList<Akun> teman;

    public Akun(String nama){
        this.nama = nama;
        teman = new LinkedList<>();
    }
    @Override
    public void tambahTeman(Akun a) {
        teman.add(a);
    }

    @Override
    public void lihatDaftarTeman() {
        if (teman.isEmpty()){
            System.out.println("Data teman KOSONG");
        }
        else {
            int i = 1;
            for (Akun daftarTeman : teman) {
                System.out.println(i + ". " + daftarTeman.nama);
                i++;
            }
        }
    }

    @Override
    public void lihatTemanBersama(Akun akunLain) {
        LinkedList<Akun> dataTemanBersama = new LinkedList<>();
        for (Akun temanUtama : teman){
            for (Akun temanLain : akunLain.teman){
                if (temanUtama.equals(temanLain)){
                    dataTemanBersama.add(temanUtama);
                }
            }
        }
        if (dataTemanBersama.isEmpty()){
            System.out.println("Tidak ada teman bersama");
        }
        else {
            int i =1;
            for (Akun temanBersama : dataTemanBersama){
                System.out.println(i+". "+temanBersama.nama);
                i++;
            }
        }
    }
}

class ListAkun implements List {
    private LinkedList<Akun> listAkun = new LinkedList(); // digunakan untuk menyimpan data akun

    @Override
    public void tambahAkun(Akun a) {
        listAkun.add(a);
    }

    @Override
    public void lihatDaftarAkun() {
        if (listAkun.isEmpty()){
            System.out.println("Data akun KOSONG");
        }
        else {
            int i=1;
            for (Akun daftarAkun : listAkun) {
                System.out.println(i+". "+daftarAkun.nama);
                i++;
            }
        }
    }

    @Override
    public void lihatDaftarAkun(Akun akunSaya) {
        int i =1;
        for (Akun daftarAkun : listAkun){
            System.out.print(i+". "+daftarAkun.nama);
            if (daftarAkun.equals(akunSaya)){
                System.out.println(" [akun saya]");
                i++;
            }
            else {
                System.out.println();
                i++;
            }
        }
    }

    @Override
    public int jumlahAkun() {
        return listAkun.size();
    }

    @Override
    public Akun getAkunByIndex(int i) {
        return listAkun.get(i);
    }

    @Override
    public boolean isEmpty() {
        return listAkun.isEmpty();
    }
}

interface List {
    void tambahAkun(Akun a);
    void lihatDaftarAkun(); // melihat semua akun yang telah terdaftar
    void lihatDaftarAkun(Akun akunSaya); // melihat semua akun dan menandai akun yang sedang login
    int jumlahAkun();
    Akun getAkunByIndex(int i); // mendapatkan akun berdasarkan indeks
    boolean isEmpty();
}

interface Fesbuk {
    void tambahTeman(Akun a);
    void lihatDaftarTeman(); // melihat semua daftar teman dari suatu akun
    void lihatTemanBersama(Akun akunLain); // melihat semua mutual friend antara akun yang sedang login dengan akun lain
}
public class SK05_05_225150400111049_LaurensiusNathanSuryaRachmanto {
    public static void main(String[] args) {
        ListAkun Akun = new ListAkun();
        Scanner scan = new Scanner(System.in);
        System.out.println("SELAMAT DATANG DI FESBUK\n" +
                "    MEDSOS GRATISTIS\n" +
                "========================");
        loop1: while (true){
            System.out.println("\nData akun:");
            Akun.lihatDaftarAkun();
            System.out.print("Apakah ada penambahan akun (Y/T)? ");
            String out1 = scan.nextLine();
            if (out1.equalsIgnoreCase("t")){
                if (Akun.isEmpty()){
                    break loop1;
                }
                else {
                    System.out.print("Pilih akun untuk login (1-" + Akun.jumlahAkun() + "): ");
                    int ask2 = scan.nextInt();
                    scan.nextLine();
                    if (ask2 > Akun.jumlahAkun()) {
                        break loop1;
                    }
                    System.out.println();
                    System.out.println("\nSELAMAT DATANG DI FESBUK\n" +
                            "Anda login sebagai "+Akun.getAkunByIndex((ask2-1)).nama+"\n" +
                            "========================");
                    loop2: while (true) {
                        System.out.print("\nLayanan yang tersedia:\n" +
                                "1. Tambah teman\n" +
                                "2. Lihat daftar teman\n" +
                                "3. Lihat teman bersama\n" +
                                "Masukkan kode layanan (1-3): ");
                        int ask3 = scan.nextInt();
                        scan.nextLine();
                        sc1: switch (ask3) {
                            case 1:
                                Akun.lihatDaftarAkun(Akun.getAkunByIndex((ask2 - 1)));
                                System.out.print("Masukkan nomor akun sebagai teman (1-"+Akun.jumlahAkun()+"): ");
                                int ask4=scan.nextInt();
                                scan.nextLine();
                                if (ask4>Akun.jumlahAkun()){
                                    break loop1;
                                }
                                else {
                                    Akun.getAkunByIndex((ask2-1)).tambahTeman(Akun.getAkunByIndex((ask4-1)));
                                }
                                break;
                            case 2:
                                Akun.getAkunByIndex((ask2-1)).lihatDaftarTeman();
                                break;
                            case 3:
                                System.out.println("Data akun:");
                                Akun.lihatDaftarAkun(Akun.getAkunByIndex((ask2-1)));
                                System.out.print("Masukkan nomor akun untuk melihat teman bersama (1-"+Akun.jumlahAkun()+"): ");
                                int ask5 = scan.nextInt();
                                scan.nextLine();
                                if (ask5>Akun.jumlahAkun()){
                                    break loop1;
                                }
                                System.out.println("Data teman bersama "+Akun.getAkunByIndex((ask2-1)).nama+" dengan "+Akun.getAkunByIndex((ask5-1)).nama);
                                Akun.getAkunByIndex((ask2-1)).lihatTemanBersama(Akun.getAkunByIndex((ask5-1)));
                                break;
                            default:
                                break sc1;
                        }
                        System.out.print("Apakah ingin logout (Y/T)? ");
                        String out2 = scan.nextLine();
                        if (out2.equalsIgnoreCase("y")){
                            System.out.print("Apakah ingin keluar dari sistem (Y/T)? ");
                            String out3 = scan.nextLine();
                            if (out3.equalsIgnoreCase("y")){
                                break loop1;
                            }
                            break loop2;
                        }

                    }
                }
            }
            else {
                System.out.print("\nBuat akun baru: ");
                String ask1 = scan.nextLine();
                Akun.tambahAkun(new Akun(ask1));
            }
        }
    }
}
