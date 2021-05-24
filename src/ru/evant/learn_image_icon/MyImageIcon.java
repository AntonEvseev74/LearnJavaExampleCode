package ru.evant.learn_image_icon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyImageIcon extends JComponent implements KeyListener, ActionListener {

    private static String str = "ЯблоЕд";

    Image grass = new ImageIcon("src/ru/evant/learn_image_icon/grass.jpg").getImage();
    Image apple = new ImageIcon("src/ru/evant/learn_image_icon/apple.png").getImage();

    private static int screenW = 550, screenH = 550;
    private int x = 0, y = 0, W = 30, H = 30;
    private int appleX = (int) (Math.random() * (screenW - 15)), appleY = (int) (Math.random() * (screenH - 40));
    private int speedUser = 5;
    Rectangle user = new Rectangle(x, y, W, H);

    Timer t = new Timer(5, this);

    public static void main(String[] args) {
        MyImageIcon myImageIcon = new MyImageIcon();
        JFrame frame = new JFrame(str);
        frame.setSize(screenW, screenH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addKeyListener(myImageIcon);
        frame.add(new MyImageIcon());
        frame.add(myImageIcon);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(grass, 0, 0, null);
        g2d.drawImage(apple, appleX, appleY, W, H, null);
        g2d.fill(user);
        if (x >= appleX - W / 4 && y >= appleY - H / 4 && x <= appleX + W / 4 && y <= appleY + H / 4) {
            createCoordApple(); // задаем новые координаты яблока
        }

        t.start();
    }

    /* Создать новые координаты яблока */
    public void createCoordApple() {
        appleX = (int) (Math.random() * (screenW - 30));
        appleY = (int) (Math.random() * (screenH - 60));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D) {
            if (x < screenW - (W + 15)) { // Ограничение, правый край окна
                user.setLocation(user.x + speedUser, user.y);
                x = user.x;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            if (y < screenH - (H + 38)) { // Ограничение, нижний край окна
                user.setLocation(user.x, user.y + speedUser);
                y = user.y;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            if (x > 0) { // Ограничение, левый край окна
                user.setLocation(user.x - speedUser, user.y);
                x = user.x;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            if (y > 0) { // Ограничение, верхний край окна
                user.setLocation(user.x, user.y - speedUser);
                y = user.y;
            }
        }


        if ((e.getKeyCode() == KeyEvent.VK_RIGHT && e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_D && e.getKeyCode() == KeyEvent.VK_S)) {
            if (x < 400 - (W + 15) && y < 400 - (H + 38)) { // Ограничение, правый край окна
                user.setLocation(user.x + speedUser, user.y + speedUser);
                x = user.x;
                y = user.y;
            }
        }
        if ((e.getKeyCode() == KeyEvent.VK_RIGHT && e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_D && e.getKeyCode() == KeyEvent.VK_W)) {
            if (x < screenW - (W + 15) && y > 0) { // Ограничение, правый край окна
                user.setLocation(user.x + speedUser, user.y - speedUser);
                x = user.x;
                y = user.y;
            }
        }
        if ((e.getKeyCode() == KeyEvent.VK_LEFT && e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_A && e.getKeyCode() == KeyEvent.VK_S)) {
            if (x > 0 && y < screenH - (H + 38)) { // Ограничение, правый край окна
                user.setLocation(user.x - speedUser, user.y + speedUser);
                x = user.x;
                y = user.y;
            }
        }
        if ((e.getKeyCode() == KeyEvent.VK_LEFT && e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_A && e.getKeyCode() == KeyEvent.VK_W)) {
            if (x > 0 && y > 0) { // Ограничение, правый край окна
                user.setLocation(user.x - speedUser, user.y - speedUser);
                x = user.x;
                y = user.y;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
