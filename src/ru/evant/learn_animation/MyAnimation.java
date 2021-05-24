package ru.evant.learn_animation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyAnimation extends JComponent implements KeyListener, ActionListener {

    private int x = 0, y = 0, W = 20, H = 20;
    Rectangle rectangle = new Rectangle(x,y,W,H);
    Timer t = new Timer(5,this); // Таймер обновления экрана

    public static void main(String[] args) {
        MyAnimation myAnimation = new MyAnimation();
        JFrame frame = new JFrame("Анимация");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.add(myAnimation);
        frame.addKeyListener(myAnimation);
    }

    public void paint(Graphics g1d){
        Graphics2D g2d = (Graphics2D) g1d;
        g2d.fill(rectangle);
        t.start(); // запустить таймер
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint(); // перерисовать окно
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(x < 400 - (W + 15)) { // Ограничение, правый край окна
                rectangle.setLocation(rectangle.x + 5, rectangle.y);
                x = rectangle.x;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN){
            if (y < 400 - (H + 38)) { // Ограничение, нижний край окна
                rectangle.setLocation(rectangle.x, rectangle.y + 5);
                y = rectangle.y;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            if (x > 0) { // Ограничение, левый край окна
                rectangle.setLocation(rectangle.x - 5, rectangle.y);
                x = rectangle.x;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP){
            if(y > 0) { // Ограничение, верхний край окна
                rectangle.setLocation(rectangle.x, rectangle.y - 5);
                y =  rectangle.y;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT && e.getKeyCode() == KeyEvent.VK_DOWN){
            if(x < 400 - (W + 15) && y < 400 - (H + 38)) { // Ограничение, правый край окна
                rectangle.setLocation(rectangle.x + 5, rectangle.y + 5);
                x = rectangle.x;
                y = rectangle.y;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && e.getKeyCode() == KeyEvent.VK_UP){
            if(x < 400 - (W + 15) && y > 0) { // Ограничение, правый край окна
                rectangle.setLocation(rectangle.x + 5, rectangle.y -5);
                x = rectangle.x;
                y = rectangle.y;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && e.getKeyCode() == KeyEvent.VK_DOWN){
            if(x >0 && y < 400 - (H + 38)) { // Ограничение, правый край окна
                rectangle.setLocation(rectangle.x - 5, rectangle.y + 5);
                x = rectangle.x;
                y = rectangle.y;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && e.getKeyCode() == KeyEvent.VK_UP){
            if(x > 0 && y > 0 ) { // Ограничение, правый край окна
                rectangle.setLocation(rectangle.x - 5, rectangle.y - 5);
                x = rectangle.x;
                y = rectangle.y;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
