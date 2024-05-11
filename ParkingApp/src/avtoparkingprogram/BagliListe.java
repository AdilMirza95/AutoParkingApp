package avtoparkingprogram;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BagliListe {

    Scanner sc = new Scanner(System.in);

    OtoNode head;
    OtoNode tail;
    OtoNode temp = head;
    OtoNode temp2 = temp;

    String avtNomre;
    String giris;
    String cixis;
    long deq;
    long qiymet;
    long cemQiymet = 0;

    void ekle() {
        System.out.print("Avtonomre : ");
        avtNomre = sc.nextLine();
        System.out.print("giris (ss:dd): ");
        giris = sc.nextLine();

        OtoNode masin = new OtoNode(avtNomre, giris);

        if (head == null) {
            head = masin;
            tail = masin;
            head.next = tail;
            tail.prev = head;
            head.prev = tail;
            tail.next = head;
            System.out.println("Masin avtoparka girdi..");
        } else {
            masin.next = head;
            head.prev = masin;
            head = masin;
            head.prev = tail;
            tail.next = head;
            System.out.println("Masin avtoparka girdi..");
        }
    }

    void sil() throws ParseException {
        if (head == null) {
            System.out.println("Avtoparking bosdur !");
        } else {
            System.out.print("Avtonomre : ");
            avtNomre = sc.nextLine();
            System.out.print("Cixis (ss:dd): ");
            cixis = sc.nextLine();
            if (head == tail && head.avtNomre.equals(avtNomre)) {
                qiymetHesabla(head, cixis);
                head = null;
                tail = null;
                System.out.println("Masin avtoparkdan cixis etdi..");
                
            } else if (head != tail && head.avtNomre.equals(avtNomre)) {
                qiymetHesabla(head, cixis);
                head = head.next;
                head.prev = tail;
                tail.next = head;
                System.out.println("Masin avtoparkdan cixis etdi..");
            } else {
                temp = head;
                while (temp != tail) {
                    if (temp.avtNomre.equals(avtNomre)) {
                        qiymetHesabla(temp, cixis);
                        temp2.next = temp.next;
                        temp.next.prev = temp2;
                        System.out.println("Masin avtoparkdan cixdi.");
                    }
                    temp2 = temp;
                    temp = temp.next;
                }
                if (temp.avtNomre.equals(avtNomre)) {
                    qiymetHesabla(temp, cixis);
                    tail = temp2;
                    tail.next = head;
                    head.prev = tail;
                    System.out.println("Masin avtoparkdan cixdi.");
                }

            }
        }

    }

    void qiymetHesabla(OtoNode temp3, String cixis) throws ParseException {
        giris = temp3.giris;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date d1, d2;
        d1 = sdf.parse(giris);
        d2 = sdf.parse(cixis);
        deq = d2.getTime() - d1.getTime();
        deq = deq / 60000;
        qiymet = deq / 30;
        System.out.println("Vaxt: " + deq + " dq");
        System.out.println("Mebleg: " + qiymet + " AZN");
        cemQiymet += qiymet;
    }

    void yazdir() {
        if (head == null) {
            System.out.println("Avtopark bosdur.");
        } else {
            System.out.println("NOMRE\t\tGIRIS  SAAT");
            temp = head;
            while (temp != tail) {
                System.out.println(temp.avtNomre + "\t\t" + temp.giris);
                temp = temp.next;
            }
            System.out.println(temp.avtNomre + "\t\t" + temp.giris + "\n");
        }
    }
}
