import java.util.LinkedList;
import java.util.Scanner;

public class linkedlist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<String> kereta = new LinkedList<>();

        int counterRestorasi = 0;
        int counterLoko = 0;
        int counterBagasi = 0;
        int jumlahKereta = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < jumlahKereta; i++) {
            String jenisKereta = scanner.nextLine();
            switch (jenisKereta.toLowerCase()) {
                case "lokomotif":
                    counterLoko++;
                    break;
                case "bagasi":
                    counterBagasi++;
                    break;
                case "restorasi":
                    counterRestorasi++;
                    break;
                default:
                    kereta.add(jenisKereta);
                    break;
            }
        }

        for (int i = 0; i < counterRestorasi; i++) {
            if (kereta.size() > 0) {
                kereta.add((kereta.size() / 2), "Restorasi");
            } else {
                kereta.add("Restorasi");
            }
        }

        for (int i = 0; i < counterLoko; i++) {
            kereta.addFirst("Lokomotif");
        }

        for (int i = 0; i < counterBagasi; i++) {
            kereta.addLast("Bagasi");
        }

        System.out.println(kereta);
    }
}