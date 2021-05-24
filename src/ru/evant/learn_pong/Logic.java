package ru.evant.learn_pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Logic extends JPanel implements ActionListener, KeyListener {

    private int screenW = 600, screenH = 400; // ширина и высота окна
    private int screenHalfW = (screenW - 15) / 2, screenHalfH = (screenH - 60) / 2; // половина ширины окна, и половина высоты окна

    private int bitW = 10, bitH = 100; // ширина и высота биты
    private int bit1Y = 120, bit2Y = 120; // координаты "y" доски 1 и доски 2

    private int ballX = screenHalfW, ballY = screenHalfH; // координаты "x" и "y" шара
    private int ballSize = 15; // размер шара

    Logic() {
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, screenW, screenH); // задний фон
        g.setColor(Color.white);
        g.drawLine(screenHalfW, 0, screenHalfW, screenH); // центр поля
        g.fillRect(0, bit1Y, bitW, bitH); // 1я бита
        g.fillRect(screenW - 15, bit2Y, bitW * -1, bitH); // 2я бита
        g.fillOval(ballX - ballSize / 2, ballY, ballSize, ballSize); // шар
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
