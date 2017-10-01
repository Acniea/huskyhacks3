package huskyhacks3.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MyGUI {

    private Frame mainFrame;
    private JPanel controlPanel;

    public MyGUI(Controller controller, Controller.KeyboardListener keyboardListener){
        prepareGUI(controller, keyboardListener);
        showCanvas(controller, keyboardListener);
    }

    private void prepareGUI(Controller controller, Controller.KeyboardListener keyboardListener){
        mainFrame = new Frame("Procedural Generation");
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setLayout(new GridLayout(1, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.add(controlPanel);
        showCanvas(controller, keyboardListener);
        mainFrame.setVisible(true);
    }

    private void showCanvas(Controller controller, Controller.KeyboardListener keyboardListener){
        controlPanel.add(new MyCanvas(mainFrame.getSize(), controller, keyboardListener));
    }

    public void repaint() {
        mainFrame.repaint();
    }
}