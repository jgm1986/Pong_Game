/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 * Class for the pong ball.
 * @author <a href="mailto:jgm1986@hotmail.com">Javier Gusano Martinez</a>
 */
public class BallObject {
    // Initial point
    private final int init_pos_x;
    private final int init_pos_y;
    // Current position
    private int pos_x;
    private int pos_y;
    private float dir_x;
    private float dir_y;
    // Graphics object
    private final Ellipse2D ball;
    private final Color color;
    
    /**
     * Default class constructor.
     * @param x X coordinate for the ball start point.
     * @param y Y coordinate for the ball start point.
     * @param color Ball color.
     */
    public BallObject(int x, int y, Color color){
        init_pos_x = x;
        init_pos_y = y;
        pos_x = init_pos_x;
        pos_y = init_pos_y;
        dir_x = getRandomDir();
        dir_y = getRandomDir();
        ball = new Ellipse2D.Double(pos_x, pos_y, 20, 20);
        this.color = color;
    }
    
    /**
     * Method used to get the graphical element of this ball.
     * @return Graphical ball object.
     */
    public Ellipse2D getBallGraph(){
        return ball;
    }
    
    /**
     * Returns the color of the ball.
     * @return Color of the ball.
     */
    public Color getColor(){
        return color;
    }
    
    /**
     * Set the current ball to the initial point.
     */
    public void resetBall(){
        pos_x = init_pos_x;
        pos_y = init_pos_y;
        dir_x = getRandomDir();
        dir_y = getRandomDir();
        ball.setFrame(pos_x, pos_y, 20, 20);
    }
    
    /**
     * Calculate the new ball position and check the collisions with the play 
     * area limits.
     */
    public void updatePosition(){
        pos_x = pos_x + (int) dir_x;
        pos_y = pos_y + (int) dir_y;
        if(pos_x < 20 || pos_x > 700){
            dir_x *= -1;
        }
        if(pos_y < 0 || pos_y > 460){
            dir_y *= -1;
        }
        ball.setFrame(pos_x, pos_y, 20, 20);
    }
    
    /**
     * Get current X coordinate position of this ball..
     * @return X coordinate value.
     */
    public int getX(){
        return pos_x;
    }
    
    /**
     * Get current Y coordinate position of this ball..
     * @return Y coordinate value.
     */
    public int getY(){
        return pos_y;
    }
    
    /**
     * Generate random direction 1 or -1.
     * @return Return 1 or -1 to get the direction of the ball.
     */
    private int getRandomDir() {
        Random rand = new Random();
        int tmp_dir = rand.nextInt(2);
        if(tmp_dir == 1){
            return 1;
        } else if(tmp_dir == 0){
            return -1;
        } else {
            System.err.println("Error, bad direction generated: " + tmp_dir);
            return -1;
        }
    }
    
    /**
     * Increase the ball velocity the specified percent value as input.
     * @param percent Percent value to increase the velocity.
     */
    public void increaseVelocity(int percent){
        dir_x = dir_x + ((dir_x * percent)/100);
        dir_y = dir_y + ((dir_y * percent)/100);
    }
}
