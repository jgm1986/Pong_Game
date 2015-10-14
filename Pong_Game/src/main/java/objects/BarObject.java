/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.awt.Color;
import java.awt.geom.Rectangle2D;

/**
 * Class for pong bars
 * @author <a href="mailto:jgm1986@hotmail.com">Javier Gusano Martinez</a>
 */
public class BarObject {
    private static final int with = 20;
    private static final int height = 120;
    private final int pos_x;
    private int pos_y;
    private Rectangle2D rectangle;
    private Color color;
    
    public BarObject(int x, int y, Color color){
        pos_x = x;
        pos_y = y;
        rectangle = new Rectangle2D.Double(pos_x, pos_y, with, height);
        this.color = color;
    }
    
    public void moveUp(){
        if(pos_y > 0){
            pos_y--;
            rectangle.setRect(pos_x, pos_y, with, height);
        }
    }
    
    public void moveDown(){
        if(pos_y < (480 - (height))){
            pos_y++;
            rectangle.setRect(pos_x, pos_y, with, height);
        }
    }
    
    public Rectangle2D getBarGraph(){
        return rectangle;
    }
    
    public int getWith(){
        return with;
    }
    
    public int getHeight(){
        return height;
    }
    
    public Color getColor(){
        return color;
    }
}
