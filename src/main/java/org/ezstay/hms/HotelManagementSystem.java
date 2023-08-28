/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.ezstay.hms;

import javax.swing.JFrame;

/**
 *
 * @author shashisu
 */
public class HotelManagementSystem {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        SignUp signUp = new SignUp();
        frame.setSize(1000, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(signUp, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
