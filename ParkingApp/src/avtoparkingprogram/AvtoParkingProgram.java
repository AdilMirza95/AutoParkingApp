package avtoparkingprogram;

import java.text.ParseException;
import java.util.Scanner;

public class AvtoParkingProgram {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        BagliListe liste = new BagliListe();
        int secim = -1;
        while (secim != 0) {

            System.out.println("1- Avto parka masin girisi ");
            System.out.println("2- Avto parkdan masin cixisi ");
            System.out.println("3- Avto parkdaki masinlarin siyahisi ");
            System.out.println("4- Toplam gelir (AZN) ");
            System.out.println("0- Cixis ");
            System.out.print("Seciminiz:  ");
            secim = sc.nextInt();

            switch (secim) {
                case 1:
                    liste.ekle();
                    break;
                case 2:
                    liste.sil();
                    break;
                case 3:
                    liste.yazdir();
                    break;
                case 4:
                    System.out.println(liste.cemQiymet);
                    ;
                    break;
                case 0:
                    System.out.println("Cixis etdiniz");
                    break;
                default:
                    System.out.println("Yalnis secim [0-4]");
            }

        }

    }

}
