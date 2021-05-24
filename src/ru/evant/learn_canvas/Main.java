package ru.evant.learn_canvas;

import javax.swing.*;
import java.awt.*;

public class Main extends JComponent {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Рисование"); // имя окна
        frame.setSize(500, 500);        // размер окна
        frame.setLocationRelativeTo(null);           // открыть окно по центру экрана
        frame.getContentPane().add(new Main());      // Добавляем весь код класса Main который относится к фрейму
        frame.setVisible(true);                      // Видимость окна
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); // закрыть окно нажав на крестик в правом верхнем углу
    }

    public void paint(Graphics g) {

        g.setColor(Color.black); // цвет

        g.fillOval(10, 10, 60, 60); //овал, круг
        g.drawOval(80, 10, 60, 60); //овал, круг
        g.fillRect(150, 10, 60, 60);//квадрат прямоугольник
        g.drawRect(220, 10, 60, 60);
        g.fillRoundRect(290, 10, 60, 60, 20, 20); //прямоугольник с закругленными углами
        g.drawRoundRect(360, 10, 60, 60, 20, 20);

        g.fillArc(10, 80, 60, 60, 0, 90);  // сектор
        g.fillArc(80, 80, 60, 60, 0, 180);
        g.fillArc(150, 80, 60, 60, 0, -180);
        g.fillArc(220, 80, 60, 60, 30, -180);
        g.drawArc(290, 80, 60, 60, 0, 90);
        g.drawArc(360, 80, 60, 60, 30, 180);

        g.drawLine(10, 150, 70, 160); // линия
        g.drawLine(80, 160, 140, 150);

        Graphics2D g2d = (Graphics2D) g;
        BasicStroke pen10 = new BasicStroke(10); // толщина линии
        BasicStroke pen2 = new BasicStroke(2); // толщина линии
        BasicStroke pen5 = new BasicStroke(5); // толщина линии
        g2d.setStroke(pen10);
        g2d.drawLine(150, 150, 210, 160);
        g2d.drawLine(220, 160, 280, 150);
        g2d.setStroke(pen2);
        g2d.drawLine(10, 170, 70, 200);
        g2d.drawLine(80, 200, 140, 170);
        g2d.setStroke(pen5);
        g2d.drawLine(150, 170, 210, 200);
        g2d.drawLine(220, 200, 280, 170);

        // мордочка
        g2d.setStroke(pen10);
        g2d.drawLine(10, 210, 70, 240);
        g2d.drawLine(80, 240, 140, 210);
        g2d.setStroke(pen5);
        g2d.setColor(Color.RED);
        g.fillArc(10, 210, 60, 60, -30, -180);
        g2d.fillArc(80, 210, 60, 60, 30, -180);
        g2d.setColor(Color.black);
        g2d.fillOval(70, 270, 20, 20);
        g2d.drawArc(40, 270, 60, 30, 0, -180);
        g2d.drawArc(40, 250, 60, 70, 0, -180);
    }
}
