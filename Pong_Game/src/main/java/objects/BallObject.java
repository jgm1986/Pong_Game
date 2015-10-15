/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

/**
 * Class for the pong ball.
 * @author <a href="mailto:jgm1986@hotmail.com">Javier Gusano Martinez</a>
 */
public class BallObject {
    // Initial point
    private int init_pos_x;
    private int init_pos_y;
    // Current position
    private int pos_x;
    private int pos_y;
    private int dir_x = 1;
    private int dir_y = 1;
    // Graphics object
    private Ellipse2D ball;
    private Color color;
    
    public BallObject(int x, int y, Color color){
        init_pos_x = x;
        init_pos_y = y;
        pos_x = init_pos_x;
        pos_y = init_pos_y;
        ball = new Ellipse2D.Double(pos_x, pos_y, 20, 20);
        this.color = color;
    }
    
    public Ellipse2D getBallGraph(){
        return ball;
    }
    
    public Color getColor(){
        return color;
    }
    
    public void resetBall(){
        pos_x = init_pos_x;
        pos_y = init_pos_y;
        ball.setFrame(pos_x, pos_y, 20, 20);
    }
    
    public void updatePosition(){
        pos_x = pos_x + dir_x;
        pos_y = pos_y + dir_y;
        if(pos_x < 20 || pos_x > 700){
            dir_x *= -1;
        }
        if(pos_y < 0 || pos_y > 460){
            dir_y *= -1;
        }
        ball.setFrame(pos_x, pos_y, 20, 20);
    }
    
    public int getX(){
        return pos_x;
    }
    
    public int getY(){
        return pos_y;
    }
}
