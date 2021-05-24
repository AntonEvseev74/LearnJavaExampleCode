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
    private int bitSpeed = 5; // скорость биты

    private int ballX = screenHalfW, ballY = screenHalfH; // координаты "x" и "y" шара
    private int ballSize = 15; // размер шара
    private int ballSpeedX = 3, ballSpeedY = 3; // скорость шарика

    private int scorePlayer1 = 0, scorePlayer2 = 0;

    private String start = "Press ENTER to start";
    private boolean isStart = false;

    Timer timer;

    Logic() {
        addKeyListener(this);
        timer = new Timer(10, this);
        setFocusable(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, screenW, screenH); // задний фон
        g.setColor(Color.white);
        g.drawLine(screenHalfW, 0, screenHalfW, screenH); // центр поля
        g.fillRect(0, bit1Y, bitW, bitH); // 1я бита
        g.fillRect(screenW - bitW - 15, bit2Y, bitW, bitH); // 2я бита
        g.fillOval(ballX - ballSize / 2, ballY, ballSize, ballSize); // шар

        /* очки */
        Font font20 = new Font("Arial", Font.BOLD, 20);
        g.setFont(font20);
        g.drawString(String.valueOf(scorePlayer1), screenHalfW - 45, 20); // очки левого игрока
        g.drawString(String.valueOf(scorePlayer2), screenHalfW + 30, 20); // очки правого игрока

        Font font40 = new Font("Arial", Font.BOLD, 40);
        if(!isStart) {
            g.setFont(font40);
            g.drawString(start, screenHalfW - 200, screenH - 60);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();

        /* движение шарика */
        ballX += ballSpeedX;
        ballY += ballSpeedY;
        if (ballY <= 0){
            ballSpeedY = -ballSpeedY;
        }
        if (ballY > screenH - 60){
            ballSpeedY = -ballSpeedY;
        }

        /* движение правой биты */
        if (ballY - 50 <= bit2Y && ballX >= screenHalfW && ballSpeedX > 0){
            bit2Y -= bitSpeed;
        }
        if (ballY - 50 >= bit2Y && ballX >= screenHalfW && ballSpeedX > 0){
            bit2Y += bitSpeed;
        }

        /* пересечение шара и правой биты */
        if (new Rectangle(ballX - ballSize / 2, ballY, ballSize, ballSize).intersects(new Rectangle(screenW - bitW - 15, bit2Y, bitW, bitH))){
            ballSpeedX = -Math.abs(ballSpeedX+1); // -ballSpeedX;
        }
        /* пересечение шара и левой биты */
        if (new Rectangle(ballX - ballSize / 2, ballY, ballSize, ballSize).intersects(new Rectangle(0, bit1Y, bitW, bitH))){
            ballSpeedX =-(ballSpeedX-1); // -ballSpeedX;
        }

        /* пересечение шаром левой стороны окна */
        if (ballX < -20){
            scorePlayer2++;
            timer.stop();
            setToStart();
            setBallSpeed(ballSpeedX, ballSpeedY);
        }

        /* пересечение шаром правой стороны окна */
        if (ballX > screenW+20){
            scorePlayer1++;
            timer.stop();
            setToStart();
            setBallSpeed(-ballSpeedX, -ballSpeedY);
        }
    }

    /* установить все элементы в стартовое положение */
    public void setToStart(){
        ballX = screenHalfW;
        ballY = screenHalfH;
        bit1Y = 120;
        bit2Y = 120;
        ballSpeedX = 3;
        ballSpeedY = 3;
        isStart = false;
    }

    /* Установить скорости шара (направление движения шара при старте) */
    public void setBallSpeed(int ballSpeedX, int ballSpeedY){
        this.ballSpeedX = ballSpeedX;
        this.ballSpeedY = ballSpeedY;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S) {
            bit1Y += bitSpeed;
            if (bit1Y > screenH - bitH) {
                bit1Y = screenH - bitH;
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            bit1Y -= bitSpeed;
            if (bit1Y <= -30) {
                bit1Y = -30;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            isStart = true;
            timer.start();
        }
    }
}
