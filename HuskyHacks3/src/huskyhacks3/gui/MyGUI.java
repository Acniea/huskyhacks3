package huskyhacks3.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class MyGUI {

    private Frame mainFrame;
    private Panel controlPanel;
    private TileDrawer tileDrawer;

    public MyGUI(){
        prepareGUI();
    }

    public static void main(String[] args){
        MyGUI gui = new MyGUI();
        gui.showCanvas();
    }

    private void prepareGUI(){
        mainFrame = new Frame("Java AWT Examples");
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
        mainFrame.setVisible(true);
    }

    private void showCanvas(){
        controlPanel.add(new MyCanvas(mainFrame.getSize(), tileDrawer));
        mainFrame.setVisible(true);
    }


}