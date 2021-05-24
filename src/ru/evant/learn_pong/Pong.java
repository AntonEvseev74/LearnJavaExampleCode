package ru.evant.learn_pong;

import javax.swing.*;

public class Pong {
    public static void main(String[] args) {

        JFrame window = new JFrame("Pong");
        Logic game = new Logic();
        window.setSize(600,400);
        window.setResizable(false);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.add(game);
    }
}
