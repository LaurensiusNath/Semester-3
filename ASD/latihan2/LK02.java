package ASD.latihan2;

import java.util.Arrays;
import java.util.LinkedList;

public class LK02 {
    public static void main(String[] args) {
        LinkedList<Mahasiswa> list = new LinkedList<>();
        list.add(new Mahasiswa("Robert"));
        list.add(new Mahasiswa("Qiana"));
        list.addFirst(new Mahasiswa("Ahmad"));
        list.addLast(new Mahasiswa("Zahra"));
        list.add(2, new Mahasiswa("Badrun"));

// tambah Budi di akhir
// Menambah node baru pada indeks terakhir, yaitu ke 5 dengan objek Budi
        list.addLast(new Mahasiswa("Budi"));
// tambah Ahmad di indeks 4
// pada indeks ke 4, ditambahkan node dengan objek Ahmad. Sehingga node di belakangnya harus bergeser.
        list.add(4, new Mahasiswa("Ahmad"));
// cari apakah ada Risma
// Menampilkan boolean yang mengecek apakah pada list ada node dengan objek yang bernama Risma. Karena tidak ada maka returnnya false.
        System.out.println(list.contains(new Mahasiswa("Risma")));
// hapus indeks 2
// Menghapus indeks ke-2 yaitu objek dengan nama badrun
        list.remove(2);
// hapus objek Ahmad
// Menghapus node dengan objek yang bernama Ahmad, sehigga node head diberikan kepada node dengan objek bernama robert
        list.remove(new Mahasiswa("Ahmad"));
// tambah Ahmad di awal
// menambah node pada indeks 0 dengan objek bernama ahmad. Node tersebut juga menjadi node head.
        list.addFirst(new Mahasiswa("Ahmad"));
// tambah Ahmad di indeks 3
// Menyisipkan node dengan objek bernama Ahmad pada indeks ke-3
        list.add(3, new Mahasiswa("Ahmad"));
// tambah Ahmad di akhir
// Menambah node tail dengan objek bernama Ahmad
        list.addLast(new Mahasiswa("Ahmad"));
// tampilkan indeks Ahmad yang pertama (gunakan indexOf)
// Melakukan print pada layar untuk menampilkan indeks dari node Ahmad yang pertama ditemukan dari depan
        System.out.println(list.indexOf(new Mahasiswa("Ahmad")));
// tampilkan indeks Ahmad yang terakhir (gunakan lastIndexOf)
// Melakukan print pada layar untuk menampilkan indeks dari node Ahmad yang terakhir ditemukan dari depan
        System.out.println(list.lastIndexOf(new Mahasiswa("Ahmad")));
// hapus Ahmad yang pertama dari depan
// Menghapus node Ahmad yang pertama ditemukan dari depan
        list.removeFirstOccurrence(new Mahasiswa("Ahmad"));
// hapus Ahmad yang terakhir dari belakang
// Menghapus node Ahmad yang pertama ditemukan dari depan
        list.removeLastOccurrence(new Mahasiswa("Ahmad"));
// cek apakah list kosong
// Karena list tidak kosong, maka returnnya adalah false
        System.out.println(list.isEmpty());
// tampilkan ukuran list
// Melakukan print jumlah node pada list
        System.out.println(list.size());
// ubah node ke 2 menjadi Zidane
// mengubah node ke 2 dengan indeks 1 menjadi object bernama Zidane
        list.set(1, new Mahasiswa("Zidane"));
// tampilkan node ke 2
// Melakukan print nama dari object pada node ke 2 dengan indeks 1
        System.out.println(list.get(1));
// ubah list menjadi array
// Membuat array baru dengan nama array dan tipe data Mahasiswa untuk menyimpan node pada list
// Selanjutnya array di print dengan method Arrays.toString
        Mahasiswa[]array=list.toArray(new Mahasiswa[0]);
        System.out.println(Arrays.toString(array));
    }
}

class Mahasiswa{
    String nama;

    public Mahasiswa (String nama){
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Mahasiswa)) {
            return false;
        }

        Mahasiswa mahasiswa = (Mahasiswa) obj;
        return nama.equals(mahasiswa.nama);
    }

    public String toString() {
        return nama;
    }

}
