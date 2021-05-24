package ru.evant.learn_image_icon_2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyImageIcon2 extends JComponent implements KeyListener, ActionListener {

    private static String str = "ЯблоЕд";

    Image grass = new ImageIcon("src/ru/evant/learn_image_icon/grass.jpg").getImage();
    Image apple = new ImageIcon("src/ru/evant/learn_image_icon/apple.png").getImage();
    Image snake = new ImageIcon("src/ru/evant/learn_image_icon/apple.png").getImage();

    private static int screenW = 550, screenH = 550;
    private int W = 30, H = 30;
    private int snakeX = 0, snakeY = 0;
    private int appleX = (int) (Math.random() * (screenW - 15)), appleY = (int) (Math.random() * (screenH - 40));
    private int snakeSpeed = 5;
   // Rectangle user = new Rectangle(snakeX, snakeY, W, H);

    Timer t = new Timer(5, this);

    public static void main(String[] args) {
        MyImageIcon2 myImageIcon2 = new MyImageIcon2();
        JFrame frame = new JFrame(str);
        frame.setSize(screenW, screenH);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addKeyListener(myImageIcon2);
        frame.add(new MyImageIcon2());
        frame.add(myImageIcon2);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(grass, 0, 0, null);
        g2d.drawImage(apple, appleX, appleY, W, H, null);
        g2d.drawImage(snake, snakeX, snakeY, W, H, null);
        //g2d.fill(user);
        if (snakeX >= appleX - W / 4 && snakeY >= appleY - H / 4 && snakeX <= appleX + W / 4 && snakeY <= appleY + H / 4) {
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
            if (snakeX < screenW - (W + 15)) { // Ограничение, правый край окна
               // user.setLocation(user.x + snakeSpeed, user.y);
               // snakeX = user.x;

                snakeX += snakeSpeed;

            }
        }
        /*
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            if (snakeY < screenH - (H + 38)) { // Ограничение, нижний край окна
                user.setLocation(user.x, user.y + snakeSpeed);
                snakeY = user.y;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            if (snakeX > 0) { // Ограничение, левый край окна
                user.setLocation(user.x - snakeSpeed, user.y);
                snakeX = user.x;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            if (snakeY > 0) { // Ограничение, верхний край окна
                user.setLocation(user.x, user.y - snakeSpeed);
                snakeY = user.y;
            }
        }


        if ((e.getKeyCode() == KeyEvent.VK_RIGHT && e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_D && e.getKeyCode() == KeyEvent.VK_S)) {
            if (snakeX < 400 - (W + 15) && snakeY < 400 - (H + 38)) { // Ограничение, правый край окна
                user.setLocation(user.x + snakeSpeed, user.y + snakeSpeed);
                snakeX = user.x;
                snakeY = user.y;
            }
        }
        if ((e.getKeyCode() == KeyEvent.VK_RIGHT && e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_D && e.getKeyCode() == KeyEvent.VK_W)) {
            if (snakeX < screenW - (W + 15) && snakeY > 0) { // Ограничение, правый край окна
                user.setLocation(user.x + snakeSpeed, user.y - snakeSpeed);
                snakeX = user.x;
                snakeY = user.y;
            }
        }
        if ((e.getKeyCode() == KeyEvent.VK_LEFT && e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_A && e.getKeyCode() == KeyEvent.VK_S)) {
            if (snakeX > 0 && snakeY < screenH - (H + 38)) { // Ограничение, правый край окна
                user.setLocation(user.x - snakeSpeed, user.y + snakeSpeed);
                snakeX = user.x;
                snakeY = user.y;
            }
        }
        if ((e.getKeyCode() == KeyEvent.VK_LEFT && e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_A && e.getKeyCode() == KeyEvent.VK_W)) {
            if (snakeX > 0 && snakeY > 0) { // Ограничение, правый край окна
                user.setLocation(user.x - snakeSpeed, user.y - snakeSpeed);
                snakeX = user.x;
                snakeY = user.y;
            }
        }

         */
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
