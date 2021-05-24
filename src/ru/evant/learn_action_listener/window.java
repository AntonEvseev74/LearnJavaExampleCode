package ru.evant.learn_action_listener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; // Слушатель событий (нажатие кнопок, запись в текстовое поле...), метод actionPerformed(ActionEvent e){}
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener; // Слушатель оконных событий

public class window extends JFrame implements ActionListener, WindowListener {
    private TextField field = new TextField();                       // Создать объект Текстовое поле
    private JButton button = new JButton("Случайное число");    // Создать объект Кнопка

    /* Конструктор окна */
    public window(){
        /* настройка окна */
        setTitle("Моя программа"); // Установить подпись программы. Левый верхний угол окна
        setSize(300, 300); // Установить размер окна /(ширина, высота)/
        setLayout(null); // Установить менеджер размещения для данного контейнера (окна). Для того чтобы располагать компоненты в произвольных областях фрейма, следует установить для менеджера размещений значение null и воспользоваться методом setBounds().
        setVisible(true); // Установить видимость окна. true - видимое/ false - не видимое
        setLocation(100,100); // Установить место отрисовки окна на экране. x, y координаты. 0 координат - это верхний левый угол
        // setLocationRelativeTo(null); // Отрисовать окно по центру экрана
        setDefaultCloseOperation(window.EXIT_ON_CLOSE); // Установить кнопке - крестик в правом верхнем углу окна функцию - при нажатии закрыть окно.

        /* настройка текстового поля */
        field.setSize(60,25);
        field.setLocation(120,45);
        field.setEditable(false); // Установить редактируемость окна. true - разрешить (можно писать в окне), false - запретить.
        field.setVisible(true);

        /* настройка кнопки */
        button.setSize(120,25);
        button.setLocation(90,85);
        button.setVisible(true);

        /* Установка слушателей и добавление элементов на экран */
        addWindowListener(this); // Добавить к этому окну (this) Слушатель событий окна - WindowListener
        button.addActionListener(this); // Добавить кнопке (button) этого окна (this) Слушатель событий - ActionListener
        add(field); // Добавить текстовое поле (field) на окно. Без этой строки Текстовое поле не отобразится в окне
        add(button); // Добавить кнопку (button) на окно. Без этой строки Текстовое поле не отобразится в окне

    }

    /* Обработчик событий */
    public void actionPerformed(ActionEvent e) {
        // field.setText("Привет"); // Установить текст -Привет- в Текстовое поле (field)
        // double n = Math.random() * 10; // Случайное вещественное число от 0 до 10, с множеством знаков после запятой
        // double n = (int) + (Math.random() * 10); // Случайное вещественное число от 0 до 10, с одним знаком после запятой
        // int n = (int) (Math.random() * 10); // Случайное целое число от 0 до 10
        int n = (int) (10 + Math.random() * 10); // Случайное целое число от 10 до 20
        field.setText(String.valueOf(n)); // Привести число n к типу String и установить в текстовое поле field
    }

    public void windowOpened(WindowEvent e) {} // когда окно открыто (Например: "Добро пожаловать!" ...)
    public void windowClosing(WindowEvent e) {
        System.exit(1234); // В скобках код выхода.
    } // когда окно закрываем (Например: "Вы точно хотите закрыть? да/нет" ...)
    public void windowClosed(WindowEvent e) {} // когда окно закрыто (Например: Остановить все процессы; Что-то делать в фоновом режиме; ...)
    public void windowIconified(WindowEvent e) {} // когда окно свернуто
    public void windowDeiconified(WindowEvent e) {} // когда окно развернуто
    public void windowActivated(WindowEvent e) {} // когда окно активно
    public void windowDeactivated(WindowEvent e) {} // когда окно не активно
}
