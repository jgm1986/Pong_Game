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
    
    /**
     * Default class constructor.
     * @param x X coordinate for the bar start point.
     * @param y Y coordinate for the bar start point.
     * @param color Bar color.
     */
    public BarObject(int x, int y, Color color){
        pos_x = x;
        pos_y = y;
        rectangle = new Rectangle2D.Double(pos_x, pos_y, with, height);
        this.color = color;
    }
    
    /**
     * Move the bar up in one unit.
     */
    public void moveUp(){
        if(pos_y > 0){
            pos_y-=2;
            rectangle.setRect(pos_x, pos_y, with, height);
        }
    }
    
    /**
     * Move the bar down in one unit.
     */
    public void moveDown(){
        if(pos_y < (480 - (height))){
            pos_y+=2;
            rectangle.setRect(pos_x, pos_y, with, height);
        }
    }
    
    /**
     * Method used to get the graphical element of this ball.
     * @return Graphical element of the bar.
     */
    public Rectangle2D getBarGraph(){
        return rectangle;
    }
    
    /**
     * Get with dimension of this bar.
     * @return With size.
     */
    public int getWith(){
        return with;
    }
    
    /**
     * Get height dimension of this bar.
     * @return Height size.
     */
    public int getHeight(){
        return height;
    }
    
    /**
     * Get the color of this bar.
     * @return Color.
     */
    public Color getColor(){
        return color;
    }
    
    /**
     * Get current X position of this bar.
     * @return X coordinate.
     */
    public int getX(){
        return pos_x;
    }
    
    /**
     * Get current Y position of this bar.
     * @return Y coordinate.
     */
    public int getY(){
        return pos_y;
    }
}
