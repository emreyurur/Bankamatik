import javax.swing.*;
import java.awt.event.*;
import java.util.Scanner;

public class Main {
    public static double bakiye = 1000; // Başlangıç bakiyesi
    private static JFrame frame;
    private static JPanel panel;
    private static JPasswordField passwordField;
    private static JButton exitButton;

    public static void main(String[] args) {
        frame = new JFrame("ATM İşlemi");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel passwordLabel = new JLabel("Şifre:");
        passwordLabel.setBounds(10, 20, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(100, 20, 165, 25);
        panel.add(passwordField);

        JButton loginButton = new JButton("Giriş");
        loginButton.setBounds(100, 50, 80, 25);
        panel.add(loginButton);

        exitButton = new JButton("Çıkış");
        exitButton.setBounds(190, 50, 80, 25);
        panel.add(exitButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[] input = passwordField.getPassword();
                String password = new String(input);

                // Burada şifre kontrolü yapılır, örneğin "1234" şifresi doğru kabul edilir
                if (password.equals("1234")) {
                    // Şifre doğruysa ana işlem ekranını aç
                    openATMScreen();
                } else {
                    JOptionPane.showMessageDialog(frame, "Yanlış şifre!", "Hata", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Çıkış yapılıyor...", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
    }

    private static void openATMScreen() {
        frame.setVisible(false); // Giriş ekranını gizle
        Scanner input = new Scanner(System.in);
        int secim;

        do {
            System.out.println("ATM İşlemi:");
            System.out.println("1- Para Yatır");
            System.out.println("2- Para Çek");
            System.out.println("3- Bakiyeyi Görüntüle");
            System.out.println("4- Çıkış");
            System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz: ");
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
                    JOptionPane.showMessageDialog(frame, "Çıkış yapılıyor...", "Bilgi", JOptionPane.INFORMATION_MESSAGE);
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz bir seçim yaptınız. Lütfen tekrar deneyin.");
            }
        } while (secim != 5);

        input.close();
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
