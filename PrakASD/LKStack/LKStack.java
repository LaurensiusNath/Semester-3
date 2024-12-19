package PrakASD.LKStack;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Penumpang{
    String nama,tujuan;

    public Penumpang(String nama, int kode){
        this.nama=nama;
        switch (kode){
            case 1:
                this.tujuan="Surabaya";
                break;
            case 2:
                this.tujuan="Jogjakarta";
                break;
            case 3:
                this.tujuan="Jakarta";
                break;
        }
    }

    public String getTujuan() {
        return tujuan;
    }

    public String getNama() {
        return nama;
    }
}

public class LKStack {

    public static void main(String[] args) {
        Stack<Penumpang> rangkaian = new Stack<>();
        Stack<Penumpang> kembali = new Stack<>();
        List<Penumpang> turun = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        loop1: while (true){
            String input = scan.nextLine();
            String[]kata =input.split(" ");
            if (input.equals("EXIT")){
                break loop1;
            }
            rangkaian.push(new Penumpang(kata[0],Integer.parseInt(kata[1])));
        }

            turunkanPenumpang("Surabaya", rangkaian, kembali, turun);
            turunkanPenumpang("Jogjakarta", rangkaian, kembali, turun);
            turunkanPenumpang("Jakarta", rangkaian, kembali, turun);
    }

    public static void turunkanPenumpang(String tujuan, Stack<Penumpang> rangkaian, Stack<Penumpang>kembali, List<Penumpang>turun) {
        int iteration;
        int lastIndex = -1;
        //mendapatkan index dari penumpang terakhir yg turun pada stasiun tertentu
        iteration=rangkaian.size();
        for (int i = iteration-1; i > -1; i--) {
            if (rangkaian.get(i).getTujuan().equals(tujuan)) {
                lastIndex = i;
            }
        }
        System.out.println("Stasiun "+tujuan);
        if (lastIndex>-1){
        iteration=rangkaian.size();
        for (int i=iteration-1;i>(lastIndex-1);i--) {
            if (rangkaian.peek().getTujuan().equals(tujuan)) {
                turun.add(rangkaian.pop());
            } else {
                kembali.push(rangkaian.pop());
            }
        }

        System.out.println("Penumpang yang bertujuan di stasiun ini :");
        for (Penumpang penumpang : turun){
            System.out.print(penumpang.getNama() + " ");
        }
            System.out.println();

        if (tujuan.equals("Jakarta")){
            System.out.println("Sampai di stasiun terakhir");
        }
        else if (!kembali.isEmpty()) {
            System.out.println("Penumpang yang kembali ke kereta :");
            iteration= kembali.size();
            for (int i =0;i<iteration;i++){
                System.out.print(kembali.peek().getNama()+" ");
                rangkaian.push(kembali.pop());
            }
        }
        else {
            System.out.print("Tidak ada penumpang yang keluar kereta di stasiun "+tujuan);
        }
        }
        else {
                System.out.print("Tidak ada penumpang yang bertujuan di stasiun "+tujuan);
            }
        kembali.clear();
        turun.clear();
        System.out.println();
        System.out.println();
        }
    }
