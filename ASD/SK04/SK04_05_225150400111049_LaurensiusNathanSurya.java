package ASD.SK04;

import java.util.*;

interface List {
    void tambahPasien(String nama, JenisAsuransi ja);
    Pasien lihatPasien(int i); // untuk mendapatkan data pasien berdasarkan indeks, dapat digunakan ketika menambah antrian
    int jumlahPasien();
    void tampil();
}

interface Antrian {
    void tambahAntrian(Pasien p);
    Pasien panggilAntrian();
    int sisaAntrian();
}
enum JenisAsuransi {
    Biasa,
    VIP,
    VVIP
}

class Pasien {
    String nama;
    JenisAsuransi jenisAsuransi;

    public Pasien(String nama, JenisAsuransi jenisAsuransi){
        this.nama=nama;
        this.jenisAsuransi=jenisAsuransi;
    }

    public String getNama() {
        return nama;
    }

    public JenisAsuransi getJenisAsuransi() {
        return jenisAsuransi;
    }
}


class ListPasien implements List {
    LinkedList<Pasien> listPasien = new LinkedList(); // digunakan untuk menyimpan data pasien

    @Override
    public void tambahPasien(String nama, JenisAsuransi ja) {
        listPasien.add(new Pasien(nama,ja));
    }

    @Override
    public Pasien lihatPasien(int i) {

        return listPasien.get(i);
    }

    @Override
    public int jumlahPasien() {
        return listPasien.size();
    }

    @Override
    public void tampil() {
        if (jumlahPasien()==0){
            System.out.println("Data pasien:");
            System.out.println("Data pasien KOSONG");
        }
        else {
            System.out.println("Data pasien:");
            for (int i=0;i<listPasien.size();i++){
                System.out.println((i+1)+". "+listPasien.get(i).getNama()+" "+listPasien.get(i).getJenisAsuransi());
            }
        }
    }
}

class AntrianPasien implements Antrian {
    PriorityQueue<Pasien> antrianPasien = new PriorityQueue(new PasienComparator());

    @Override
    public void tambahAntrian(Pasien p) {
        antrianPasien.offer(p);
    }

    @Override
    public Pasien panggilAntrian() {
        return antrianPasien.poll();
    }

    @Override
    public int sisaAntrian() {
        return antrianPasien.size();
    } // digunakan untuk menyimpan antrian berdasarkan prioritas. untuk dapat menyimpan antrian objek, pada bagian titik-titik perlu diisi dengan clue berikut (comparable atau comparator)
}


class PasienComparator implements Comparator<Pasien> {
    @Override
    public int compare(Pasien p1, Pasien p2) {
        JenisAsuransi jenis1 = p1.getJenisAsuransi();
        JenisAsuransi jenis2 = p2.getJenisAsuransi();

        if (jenis1.equals(jenis2)) {
            return 0;  // Same type of insurance, consider them equal
        } else if (jenis1.equals(JenisAsuransi.VVIP)) {
            return -1; // jenis1 is VVIP, give it the highest priority
        } else if (jenis1.equals(JenisAsuransi.VIP)) {
            if (jenis2.equals(JenisAsuransi.VVIP)) {
                return 1;  // jenis2 is VVIP, give it the highest priority
            } else {
                return -1; // jenis1 is VIP, give it higher priority than Biasa
            }
        } else {
            // jenis1 is Biasa, give it the lowest priority
            return 1;
        }
    }
}

public class SK04_05_225150400111049_LaurensiusNathanSurya {
    public static void main(String[] args) {
        ListPasien listPasien = new ListPasien();
        AntrianPasien queuePasien = new AntrianPasien();
        Scanner scan = new Scanner(System.in);
        System.out.println("SELAMAT DATANG DI RS HS");
        System.out.println("  (HIDUP SEJAHTERA)");
        System.out.println("-----------------------");
        System.out.println(" SEMOGA SEHAT SELALU");
        System.out.println();
        loop1: while (true){
            System.out.println("Layanan yang tersedia:\n" +
                    "1. Tambah data pasien\n" +
                    "2. Lihat daftar pasien\n" +
                    "3. Tambah antrian pasien\n" +
                    "4. Panggil antrian pasien\n" +
                    "5. Lihat sisa antrian pasien");
            System.out.print("Masukkan kode layanan (1-5): ");
            int input=scan.nextInt();
            scan.nextLine();
            sc1: switch (input){
                case 1:
                    System.out.print("Masukkan nama pasien: ");
                    String nama = scan.nextLine();
                    System.out.println("Jenis Asuransi:\n" +
                            "1. BIASA\n" +
                            "2. VIP\n" +
                            "3. VVIP");
                    System.out.print("Masukkan jenis asuransi (1-3): ");
                    int jenisAsuransi = scan.nextInt();
                    scan.nextLine();
                    switch (jenisAsuransi){
                        case 1:
                            listPasien.tambahPasien(nama,JenisAsuransi.Biasa);
                            break;
                        case 2:
                            listPasien.tambahPasien(nama,JenisAsuransi.VIP);
                            break;
                        case 3:
                            listPasien.tambahPasien(nama,JenisAsuransi.VVIP);
                            break;
                        default:
                            System.out.println("Jenis asuransi tidak tersedia.");
                            break sc1;
                    }
                    break;

                case 2:
                    listPasien.tampil();
                    break;

                case 3:
                    listPasien.tampil();
                    System.out.print("Pilih nomor pasien yang dimasukkan dalam antrian: ");
                    int noPasien = scan.nextInt();
                    scan.nextLine();
                    noPasien = noPasien-1;
                    if (noPasien<0||noPasien>(listPasien.jumlahPasien()-1)){
                        System.out.println("Nomor pasien yang dimasukkan di luar nomor pasien.");
                        break sc1;
                    }
                    else {
                        queuePasien.tambahAntrian(listPasien.lihatPasien(noPasien));
                    }
                    break;

                case 4:
                    if (queuePasien.sisaAntrian()==0){
                        System.out.println("Antrian pasien kosong.\n" +
                                "Sisa antrian 0");
                    }
                    else {
                        System.out.println("Pasien bernama "+queuePasien.antrianPasien.peek().getNama()+" dengan asuransi "+queuePasien.antrianPasien.peek().getJenisAsuransi()+" silakan masuk.");
                        queuePasien.panggilAntrian();
                        System.out.println("Sisa antrian "+queuePasien.sisaAntrian());
                    }
                    break;

                case 5:
                    System.out.println("Sisa antrian "+queuePasien.sisaAntrian());
                    break;
                default:
                    System.out.println("Kode layanan tidak ditemukan!");
            }
            System.out.print("Apakah masih ada layanan yang dilakukan (Y/T)?");
            String akhir=scan.nextLine();
            if (akhir.equalsIgnoreCase("t")){
                break loop1;
            }
        }

    }
}
