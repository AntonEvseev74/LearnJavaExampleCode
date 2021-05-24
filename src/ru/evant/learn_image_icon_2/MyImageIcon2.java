package ru.evant.learn_image_icon_2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// !!! довести до ума. Чтобы у змеи была возможность есть яблоки до тех пор пока. размер змеи не будет равен размеру окна
// В текущей реслизации змея ест 5 яблок и становится сново маленькой, и возвращается в центр окна

public class MyImageIcon2 extends JComponent implements KeyListener, ActionListener {

    private static String str = "ЯблоЕд";

    Image grass = new ImageIcon("src/ru/evant/learn_image_icon_2/grass2.jpg").getImage();
    Image apple = new ImageIcon("src/ru/evant/learn_image_icon_2/apple2.png").getImage();
    Image snake = new ImageIcon("src/ru/evant/learn_image_icon_2/snake2.png").getImage();

    private static int screenW = 550, screenH = 550;
    private int W = 30, H = 30;
    private int centerScreenX = (screenW - 30) / 2, centerScreenY = (screenH - 70) / 2;
    private int appleX = (int) (Math.random() * (screenW - 15)), appleY = (int) (Math.random() * (screenH - 40));
    private int snakeX = centerScreenX, snakeY = centerScreenY, snakeW = W, snakeH = H;
    private int snakeSpeed = 5; // скорость змеи
    private int countApple = 0;

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
        g2d.drawImage(snake, snakeX, snakeY, snakeW, snakeH, null);

        /* если змея съедает яблоко */
        // если середина +- 10 = середине +-10
        // !!! довести до ума. Чтобы у змеи была возможность есть яблоки до тех пор пока. размер змеи не будет равен размеру окна
        int centerSnakeX = snakeX + snakeW / 2 , centerSnakeY = snakeY + snakeH / 2;
        int centerAppleX = appleX + W / 2, centerAppleY = appleY + H / 2;
        if (centerSnakeX >= centerAppleX - W / 4 && centerSnakeY >= centerAppleY - H / 4 && centerSnakeX <= centerAppleX + W / 4 && centerSnakeY <= centerAppleY + H / 4){
            createCoordApple(); // задаем новые координаты яблока
            upSizeSnake();
            countApple++;
        }

        /* если змея съела 5 яблок (временно), пока не доведется до ума предыдущий блок */
        // нет ничего более постоянного, чем временное
        if (countApple == 5){
            createCoordApple();
            unSizeSnake();
            snakeX = centerSnakeX;
            snakeY = centerSnakeY;
            countApple = 0;
        }

        t.start();
    }

    private void upSizeSnake() {
        snakeW += 10;
        snakeH += 10;
    }

    private void unSizeSnake() {
        snakeW = W;
        snakeH = H;
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
                snakeX += snakeSpeed;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            if (snakeY < screenH - (H + 38)) { // Ограничение, нижний край окна
                snakeY += snakeSpeed;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A) {
            if (snakeX > 0) { // Ограничение, левый край окна
                snakeX -= snakeSpeed;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            if (snakeY > 0) { // Ограничение, верхний край окна
                snakeY -= snakeSpeed;
            }
        }

        if ((e.getKeyCode() == KeyEvent.VK_RIGHT && e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_D && e.getKeyCode() == KeyEvent.VK_S)) {
            if (snakeX < 400 - (W + 15) && snakeY < 400 - (H + 38)) { // Ограничение, правый край окна
                snakeX += snakeSpeed;
                snakeY += snakeSpeed;
            }
        }
        if ((e.getKeyCode() == KeyEvent.VK_RIGHT && e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_D && e.getKeyCode() == KeyEvent.VK_W)) {
            if (snakeX < screenW - (W + 15) && snakeY > 0) { // Ограничение, правый край окна
                snakeX += snakeSpeed;
                snakeY -= snakeSpeed;
            }
        }
        if ((e.getKeyCode() == KeyEvent.VK_LEFT && e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_A && e.getKeyCode() == KeyEvent.VK_S)) {
            if (snakeX > 0 && snakeY < screenH - (H + 38)) { // Ограничение, правый край окна
                snakeX -= snakeSpeed;
                snakeY += snakeSpeed;
            }
        }
        if ((e.getKeyCode() == KeyEvent.VK_LEFT && e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_A && e.getKeyCode() == KeyEvent.VK_W)) {
            if (snakeX > 0 && snakeY > 0) { // Ограничение, правый край окна
                snakeX -= snakeSpeed;
                snakeY -= snakeSpeed;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
