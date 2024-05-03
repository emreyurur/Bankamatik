import java.util.Scanner;

public class Main {
    public static double bakiye = 1000; // Başlangıç bakiyesi

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int secim = 0;

        System.out.println("ATM Islemi:");
        System.out.println("1- Para Yatir");
        System.out.println("2- Para Cek");
        System.out.println("3- Bakiyeyi Goruntule");
        System.out.println("4- Cikis");

        while (secim != 4) {
            System.out.print("Lutfen yapmak istediginiz islemi seciniz: ");
            secim = input.nextInt();

            switch (secim) {
                case 1:
                    paraYatir(input);
                    break;
                case 2:
                    paraCek(input);
                    break;
                case 3:
                    bakiyeyiGoruntule();
                    break;
                case 4:
                    System.out.println("ATM'den cikiliyor...");
                    break;
                default:
                    System.out.println("Gecersiz bir secim yaptiniz. Lutfen tekrar deneyin.");
            }
        }
    }

    public static void paraYatir(Scanner input) {
        System.out.print("Yatirmak istediginiz tutari giriniz: ");
        double miktar = input.nextDouble();
        bakiye += miktar;
        System.out.println("Bakiyeniz: " + bakiye);
    }

    public static void paraCek(Scanner input) {
        System.out.print("Cekmek istediginiz tutari giriniz: ");
        double miktar = input.nextDouble();
        if (miktar > bakiye) {
            System.out.println("Yetersiz bakiye! Cekilecek tutar bakiyeden fazla.");
        } else {
            bakiye -= miktar;
            System.out.println("Bakiyeniz: " + bakiye);
        }
    }

    public static void bakiyeyiGoruntule() {
        System.out.println("Mevcut bakiyeniz: " + bakiye);
    }
}
