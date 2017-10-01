package huskyhacks3.gui;

import huskyhacks3.world.data.World;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Runnable{

    public Screen screen;
    public World world = new World();
    public TileDrawer tileDrawer = new VerticalTileDrawer();
    public ChunkRecorder chunkRecorder = new ChunkRecorder(this);
    int xPos = 0, yPos  = 0;
    
    private boolean running = false;
    private Thread thread;
    
    public void init(){
        screen = new Screen(1920,1280);
    }
    
    
    private synchronized void start(){
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    private synchronized void stop(){
        if (!running)
            return;
    
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.exit(1);
    
    }
    
    @Override
    public void run(){
        init();
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta=0;
        int updates=0;
        int frames=0;
        long timer = System.currentTimeMillis();
        
        while (running){
            long now = System.nanoTime();
            delta += (now-lastTime)/ns;
            lastTime = now;
            if (delta>=1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
            
            if (System.currentTimeMillis()-timer>1000){
                timer+=1000;
                System.out.println(updates + " Ticks, FPS "+frames);
                updates=0;
                frames=0;
            }
        }
        stop();
    }
    
    private void tick(){
        screen.tick();
        if(screen.keyboard.up){
            yPos -= 50;
        }
        if(screen.keyboard.down){
            yPos += 50;
        }
        if(screen.keyboard.left){
            xPos -= 50;
        }
        if(screen.keyboard.right){
            xPos += 50;
        }
    }
    
    private void render(){
        drawChunks(screen);
        
        screen.render();
    }
    
    public void main(){
        start();
    }
    
    public void drawChunks(Screen s){
        int xMin, xMax, yMin, yMax, xOffset, yOffset;
        int chunkSize = chunkRecorder.getChunkSize();

        xMin = xPos / chunkSize;
        xMax = (xPos + s.WIDTH) / chunkSize;
        yMin = yPos  / chunkSize;
        yMax = (yPos + s.HEIGHT)/ chunkSize;

        xOffset = xPos % chunkSize;
        yOffset = yPos % chunkSize;

        for (int x = xMin; x <= xMax; x++) {
            for (int y = yMin; y <= yMax; y++) {
                s.drawImage(chunkRecorder.getChunkImage(x, y),
                        (x - xMin)*chunkSize - xOffset,
                        (y - yMin)*chunkSize - yOffset);
            }
        }
    }
}

