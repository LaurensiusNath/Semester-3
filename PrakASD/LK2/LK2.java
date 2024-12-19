package PrakASD.LK2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class Gerbong{
String nama;
int kapasitas;
int terisi;

public Gerbong(int kapasitas, String nama){
    this.kapasitas=kapasitas;
    this.nama=nama;
    this.terisi=0;
}

    public String getNama() {
        return nama;
    }

    public int getKapasitas() {
        return kapasitas;
    }

    public void tambahPenumpang (int terisi) {
        this.terisi = terisi;
    }

    public int getTerisi() {
        return terisi;
    }
}

class ListRangkaian {
    LinkedList<Gerbong> rangkaianEksekutif = new LinkedList<>();
    LinkedList<Gerbong> rangkaianBisnis = new LinkedList<>();
    LinkedList<Gerbong> rangkaianEkonomi = new LinkedList<>();

    public void tambahGerbong(int kode) {
        switch (kode) {
            case 1:
                rangkaianEksekutif.add(new Gerbong( 10,"Eksekutif"));
                break;
            case 2:
                rangkaianBisnis.add(new Gerbong( 15,"Bisnis"));
                break;
            case 3:
                rangkaianEkonomi.add(new Gerbong(20,"Ekonomi"));
                break;
        }
    }

    @Override
    public String toString() {
        String hasil="";
        if(rangkaianEksekutif.size()==0&&rangkaianBisnis.size()==0&&rangkaianEkonomi.size()==0) {
            hasil += "Kereta tidak memiliki gerbong";
        }
        else {
            LinkedList<Gerbong> rangkaianAkhir = new LinkedList<>();
            rangkaianAkhir.add(new Gerbong(0,"Makanan"));
            rangkaianAkhir.addAll(rangkaianEksekutif);
            rangkaianAkhir.addAll(rangkaianBisnis);
            rangkaianAkhir.addAll(rangkaianEkonomi);
            rangkaianAkhir.add(new Gerbong(0,"Makanan"));
            hasil += "Start\n";
            for (int i = 0; i < rangkaianAkhir.size(); i++) {
                hasil += "Gerbong " + rangkaianAkhir.get(i).getNama() + "\n";
            }
            ;

            hasil +="End";
        }
        return hasil;
    }
}

public class LK2 {
    public static void main(String[] args) {
        ListRangkaian rangkaianKereta = new ListRangkaian();
        Scanner scan = new Scanner(System.in);
        loopUtama: while (true) {
            String input=scan.nextLine();
            String[] kata = input.split(" ");
            if (kata[0].equals("INSERT")) {
                switch (kata[1]) {
                    case "G1":
                        rangkaianKereta.tambahGerbong(1);
                        break;

                    case "G2":
                        rangkaianKereta.tambahGerbong(2);
                        break;

                    case "G3":
                        rangkaianKereta.tambahGerbong(3);
                        break;
                }
            }
            else if (kata[0].equals("TIKET")) {
                int tiketEksekutif = scan.nextInt();
                scan.nextLine();
                int tiketBisnis = scan.nextInt();
                scan.nextLine();
                int tiketEkonomi = scan.nextInt();
                scan.nextLine();

                for (Gerbong gerbong : rangkaianKereta.rangkaianEksekutif) {
                    if (tiketEksekutif >= gerbong.getKapasitas()) {
                        tiketEksekutif -= gerbong.getKapasitas();
                        gerbong.tambahPenumpang(gerbong.getKapasitas());
                    } else {
                        gerbong.tambahPenumpang(tiketEksekutif);
                        tiketEksekutif = 0;
                    }
                }

                for (Gerbong gerbong : rangkaianKereta.rangkaianBisnis) {
                    if (tiketBisnis >= gerbong.getKapasitas()) {
                        tiketBisnis -= gerbong.getKapasitas();
                        gerbong.tambahPenumpang(gerbong.getKapasitas());
                    } else {
                        gerbong.tambahPenumpang(tiketBisnis);
                        tiketBisnis = 0;
                    }
                }

                for (Gerbong gerbong : rangkaianKereta.rangkaianEkonomi) {
                    if (tiketEkonomi >= gerbong.getKapasitas()) {
                        tiketEkonomi -= gerbong.getKapasitas();
                        gerbong.tambahPenumpang(gerbong.getKapasitas());
                    } else {
                        gerbong.tambahPenumpang(tiketEkonomi);
                        tiketEkonomi = 0;
                    }
                }
                int sisaTiketEksekutif = tiketEksekutif;
                int sisaTiketBisnis = tiketBisnis;
                int sisaTiketEkonomi = tiketEkonomi;

                ArrayList<Gerbong> gerbongHapus = new ArrayList<>();
                if (rangkaianKereta.rangkaianEksekutif.size()!=0){
                    int countEksekutif = 0;
                    for (Gerbong gerbong : rangkaianKereta.rangkaianEksekutif) {
                        if (gerbong.getTerisi()==0) {
                            gerbongHapus.add(gerbong);
                            countEksekutif++;
                        }
                    }
                    rangkaianKereta.rangkaianEksekutif.removeAll(gerbongHapus);
                    gerbongHapus.clear();

                    int loop = 0;
                    for (Gerbong gerbong : rangkaianKereta.rangkaianEksekutif) {
                        loop++;
                        System.out.println("Gerbong Eksekutif ke-" + loop + " terisi " + gerbong.getTerisi() + " penumpang");
                    }
                    if (countEksekutif != 0) {
                        System.out.println("Mengurangi " + countEksekutif + " gerbong Eksekutif");
                    }
                    if (sisaTiketEksekutif != 0) {
                        System.out.println("Sisa penumpang Eksekutif berjumlah " + sisaTiketEksekutif);
                    }
                }
                else {
                    System.out.println("Kereta tidak memiliki gerbong Eksekutif");
                }

                if (rangkaianKereta.rangkaianBisnis.size()!=0){
                    int countBisnis = 0;
                    for (Gerbong gerbong : rangkaianKereta.rangkaianBisnis) {
                        if (gerbong.getTerisi() == 0) {
                            gerbongHapus.add(gerbong);
                            countBisnis++;
                        }
                    }
                    rangkaianKereta.rangkaianBisnis.removeAll(gerbongHapus);
                    gerbongHapus.clear();

                    int loop = 0;
                    for (Gerbong gerbong : rangkaianKereta.rangkaianBisnis) {
                        loop++;
                        System.out.println("Gerbong Bisnis ke-" + loop + " terisi " + gerbong.getTerisi() + " penumpang");
                    }
                    if (countBisnis != 0) {
                        System.out.println("Mengurangi " + countBisnis + " gerbong Bisnis");
                    }
                    if (sisaTiketBisnis != 0) {
                        System.out.println("Sisa penumpang Bisnis berjumlah " + sisaTiketBisnis);
                    }
                }
                else {
                    System.out.println("Kereta tidak memiliki gerbong Bisnis");
                }

                if (rangkaianKereta.rangkaianEkonomi.size()!=0) {
                    int countEkonomi = 0;
                    for (Gerbong gerbong : rangkaianKereta.rangkaianEkonomi) {
                        if (gerbong.getTerisi() == 0) {
                            gerbongHapus.add(gerbong);
                            countEkonomi++;
                        }
                    }
                    rangkaianKereta.rangkaianEkonomi.removeAll(gerbongHapus);
                    gerbongHapus.clear();

                    int loop = 0;
                    for (Gerbong gerbong : rangkaianKereta.rangkaianEkonomi) {
                        loop++;
                        System.out.println("Gerbong Ekonomi ke-" + loop + " terisi " + gerbong.getTerisi() + " penumpang");
                    }
                    if (countEkonomi != 0) {
                        System.out.println("Mengurangi " + countEkonomi + " gerbong Ekonomi");
                    }
                    if (sisaTiketEkonomi != 0) {
                        System.out.println("Sisa penumpang Ekonomi berjumlah " + sisaTiketEkonomi);
                    }
                }
                else {
                    System.out.println("Kereta tidak memiliki gerbong Ekonomi");
                }
                System.out.println(rangkaianKereta);
                break loopUtama;
            }
        }
    }
}

