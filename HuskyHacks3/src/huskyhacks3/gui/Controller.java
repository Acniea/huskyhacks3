package huskyhacks3.gui;

import huskyhacks3.world.data.Chunk;
import huskyhacks3.world.data.World;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by david on 9/30/2017.
 */
public class Controller {

    World world;
    GUI gui;
    TileDrawer tileDrawer;
    private int xPos, yPos;

    public Controller(){
        this.tileDrawer = new VerticalTileDrawer();
        this.world = new World();
        this.gui = new MyGUI(this, new KeyboardListener());
    }

    public Chunk getChunk(int x, int y) {
        return world.get(x, y);
    }

    public TileDrawer getTileDrawer(){
        return tileDrawer;
    }

    public int getX(){
        return xPos;
    }

    public int getY(){
        return yPos;
    }

    private void translate(int deltaX, int deltaY) {
        xPos += deltaX;
        yPos += deltaY;
        gui.repaint();
    }


    class KeyboardListener implements KeyListener {

        private final int WALKING_SPEED = 10;

        @Override
        public void keyTyped(java.awt.event.KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println();
            switch (e.getExtendedKeyCode()) {
                case KeyEvent.VK_KP_UP:
                    translate(0, - WALKING_SPEED);
                    break;
                case KeyEvent.VK_DOWN:
                    translate(0, WALKING_SPEED);
                    break;
                case KeyEvent.VK_LEFT:
                    translate(-WALKING_SPEED, 0);
                    break;
                case KeyEvent.VK_RIGHT:
                    translate(WALKING_SPEED, 0);
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }


    }


}
