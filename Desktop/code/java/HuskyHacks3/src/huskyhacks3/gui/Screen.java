
package huskyhacks3.gui;

import huskyhacks3.input.KeyboardInputListener;
import huskyhacks3.input.MouseInputListener;
import huskyhacks3.input.MouseMotionInputListener;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

public class Screen extends Canvas {
    public int WIDTH = 2048;
    public int HEIGHT = 1024;
    public final String TITLE = "Test";
    //what's drawn to the screen
    private BufferedImage draw;
    
    //offsets
    private int pxoff=-1,pyoff=-1,xoff=0,yoff=0;
    
    //inputs
    public MouseInputListener mouse = new MouseInputListener();
    public MouseMotionInputListener mouseMovement = new MouseMotionInputListener();
    public KeyboardInputListener keyboard = new KeyboardInputListener();
    
    
    
    public Screen(int width, int height){
        WIDTH=width;
        HEIGHT=height;
        draw = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        
        
        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setMaximumSize(new Dimension(WIDTH,HEIGHT));
        setMinimumSize(new Dimension(WIDTH,HEIGHT));
        
        JFrame frame = new JFrame(TITLE);
        frame.add(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        init();
    }
    
    public void init(){
        requestFocus();
        
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouseMovement);
        this.addKeyListener(keyboard);
    }
    
    public void drawPixel(int x, int y, int rgb){
	if(x<draw.getWidth() && y<draw.getHeight() && x>=0 && y>=0)
	    draw.setRGB(x,y,rgb);
    }
    
    public void drawRect(int x, int y, int rgb, int width, int height){
        if(width == 1 && height == 1){
            drawPixel(x,y,rgb);
        } else {
            for(int xx=x; xx<x+width; xx++){
                for(int yy=y; yy<y+height; yy++){
                    if(xx<draw.getWidth() && yy<draw.getHeight() && xx>=0 && yy>=0)
                        draw.setRGB(xx,yy,rgb); 
                    else break;
                }
            }
        }
    }
    
    public void drawImage(BufferedImage bi, int x, int y){
        draw.getGraphics().drawImage(bi, x, y, this);
    }
    
    
    public void setXOff(int i){
	pxoff=xoff;
        xoff+=i;
    }
    
    public void setYOff(int i){
	pyoff=yoff;
        yoff+=i;
    }
    
    public void render(){
        //WorldHandler.render(this);
        BufferStrategy bs = this.getBufferStrategy();
        
        if (bs==null){
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(new Color(0,0,0));
        g.fillRect(0,0,getWidth(),getHeight());
        g.drawImage(draw, 0, 0, null);
        
        g.dispose();
        bs.show();
        
	pxoff=xoff;
	pyoff=yoff;
        //draw = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
    }
    
    public void tick(){
        int movementSpeed = 8;
//	setXOff(-movementSpeed*16);
//        setYOff(-movementSpeed*16);
	
        if(keyboard.right){
            setXOff(movementSpeed);
        }
        if(keyboard.left){
            setXOff(-movementSpeed);
        }
        if(keyboard.up){
            setYOff(-movementSpeed);
        }
        if(keyboard.down){
            setYOff(movementSpeed);
        }
	
        
    }
    
    public int pxoff(){
	return pxoff;
    }
    public int xoff(){
	return xoff;
    }
    public int pyoff(){
	return pyoff;
    }
    public int yoff(){
	return yoff;
    }
}
