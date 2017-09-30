package huskyhacks3.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MyGUI {

    private Frame mainFrame;
    private Panel controlPanel;

    public MyGUI(Controller controller){
        prepareGUI(controller);
        showCanvas(controller);
    }

//    public static void main(String[] args){
//        MyGUI gui = new MyGUI();
//        gui.showCanvas();
//    }

    private void prepareGUI(Controller controller){
        mainFrame = new Frame("Procedural Generation");
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setLayout(new GridLayout(1, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        controlPanel = new Panel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(controlPanel);
        showCanvas(controller);
        mainFrame.setVisible(true);
    }

    private void showCanvas(Controller controller){
        controlPanel.add(new MyCanvas(mainFrame.getSize(), controller));
        mainFrame.setVisible(true);
    }


}