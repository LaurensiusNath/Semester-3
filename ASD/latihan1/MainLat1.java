package ASD.latihan1;
import java.util.LinkedList;
public class MainLat1 {
    public static void main(String[] args) {
        LinkedList<Layanan> macamLayanan=new LinkedList<>();
        macamLayanan.add(new Layanan("VIP",10000000));
        macamLayanan.add(new Layanan("Reguler",5000000));
        for (Layanan data: macamLayanan){
            System.out.println(data);
        }

        LinkedList<Pasien> daftarPasien = new LinkedList<>();
        daftarPasien.add(new Pasien("Budi",macamLayanan.get(0)));
        daftarPasien.add(new Pasien("Lala",macamLayanan.get(1)));
        System.out.println(daftarPasien);
    }

}
