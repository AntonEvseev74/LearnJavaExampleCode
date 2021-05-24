package ru.evant.learn_key_listener;

/*
*   Нажимать клавиши: стрелка право, стрелка лево, стрелка верх, стрелка низ, Enter.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener; // Слушатель нажатия клавиш на клавиатуре

public class MyKeyListener extends JFrame implements KeyListener {

    private TextField exit = new TextField();
    private TextField output = new TextField();
    private String str = "Слушатель клавишь";

    public MyKeyListener(){
        setSize(350,200);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(MyKeyListener.EXIT_ON_CLOSE);
        addKeyListener(this);

        output.setSize(300,30);
        output.setLocation(20,70);
        output.setText(str);
        output.setVisible(true);
        output.setEditable(false);  // Редактирование поля пользователем отключено
        output.setFocusable(false); // Фокус в поле отключен
        add(output);

        exit.setSize(200,20);
        exit.setLocation(120,120);
        exit.setText("Для выхода нажмите Esc");
        exit.setVisible(true);
        exit.setEditable(false);  // Редактирование поля пользователем отключено
        exit.setFocusable(false); // Фокус в поле отключен
        add(exit);

    }

    public static void main(String[] args) {
        MyKeyListener frame = new MyKeyListener();
    }

    /* Клавиша нажата при вводе символов (используется при наборе текста например) */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /* Клавиша нажата (зажата) */
    @Override
    public void keyPressed(KeyEvent e) {
        // getKeyCode - код клавиши
        // KeyEvent.VK_RIGHT - код клавиши, стрелочка в право
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            str = "Нажата: Стрелка в право";
            printToOutput(str);
        }   // Если нажатая клавиша ( e.getKeyCode() ) - это стрелочка вправо ( == KeyEvent.VK_RIGHT ),
            // то печатаем в консоль "Нажата кнопка: Стрелка в право" ( System.out.println("Нажата кнопка: Стрелка в право"); )

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            str = "Нажата: Стрелка в лево";
            printToOutput(str);
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            str = "Нажата: Стрелка в верх";
            printToOutput(str);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            str = "Нажата: Стрелка в низ";
            printToOutput(str);
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            str = "Нажата: Enter";
            printToOutput(str);
        }
    }

    /* Клавиша отжата (отпущена) */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(11111);
        }
    }

    public void printToOutput (String str) {
        System.out.println(str);    // печатаем в консоль
        output.setText(str);        // Печатаем в Текствое поле - output
    }
}
