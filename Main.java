import javax.swing.*;
import java.awt.event.*;

public class Main {
    public static double bakiye = 1000; // Başlangıç bakiyesi
    private static JFrame frame;
    private static JPanel panel;
    private static JPasswordField passwordField;
    private static JButton exitButton;
    private static JButton paraYatirButton;
    private static JButton paraCekButton;
    private static JButton bakiyeGoruntuleButton;

    public static void main(String[] args) {
        frame = new JFrame("ATM İşlemi");
        frame.setSize(300, 200);
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
        exitButton.setEnabled(false);

        paraYatirButton = new JButton("Para Yatır");
        paraYatirButton.setBounds(10, 100, 120, 25);
        panel.add(paraYatirButton);
        paraYatirButton.setEnabled(false);

        paraCekButton = new JButton("Para Çek");
        paraCekButton.setBounds(140, 100, 120, 25);
        panel.add(paraCekButton);
        paraCekButton.setEnabled(false);

        bakiyeGoruntuleButton = new JButton("Bakiyeyi Görüntüle");
        bakiyeGoruntuleButton.setBounds(10, 130, 250, 25);
        panel.add(bakiyeGoruntuleButton);
        bakiyeGoruntuleButton.setEnabled(false);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[] input = passwordField.getPassword();
                String password = new String(input);

                // Burada şifre kontrolü yapılır, örneğin "1234" şifresi doğru kabul edilir
                if (password.equals("1234")) {
                    // Şifre doğruysa ana işlem ekranını aç
                    loginButton.setEnabled(false);
                    exitButton.setEnabled(true);
                    paraYatirButton.setEnabled(true);
                    paraCekButton.setEnabled(true);
                    bakiyeGoruntuleButton.setEnabled(true);
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

        paraYatirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String miktarString = JOptionPane.showInputDialog(frame, "Yatırmak istediğiniz tutarı giriniz:");
                if (miktarString != null) {
                    try {
                        double miktar = Double.parseDouble(miktarString);
                        paraYatir(miktar);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Geçersiz miktar!", "Hata", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        paraCekButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String miktarString = JOptionPane.showInputDialog(frame, "Çekmek istediğiniz tutarı giriniz:");
                if (miktarString != null) {
                    try {
                        double miktar = Double.parseDouble(miktarString);
                        paraCek(miktar);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame, "Geçersiz miktar!", "Hata", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        bakiyeGoruntuleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Mevcut bakiyeniz: " + bakiye, "Bilgi", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void paraYatir(double miktar) {
        bakiye += miktar;
        JOptionPane.showMessageDialog(frame, "Bakiyeniz: " + bakiye, "Bilgi", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void paraCek(double miktar) {
        if (miktar > bakiye) {
            JOptionPane.showMessageDialog(frame, "Yetersiz bakiye! Çekilecek tutar bakiyeden fazla.", "Hata", JOptionPane.ERROR_MESSAGE);
        } else {
            bakiye -= miktar;
            JOptionPane.showMessageDialog(frame, "Bakiyeniz: " + bakiye, "Bilgi", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
