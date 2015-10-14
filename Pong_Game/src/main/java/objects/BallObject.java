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
    private int pos_x;
    private int pos_y;
    private Ellipse2D ball;
    private Color color;
    
    public BallObject(int x, int y, Color color){
        ball = new Ellipse2D.Double(x, y, 20, 20);
        this.color = color;
    }
    
    public Ellipse2D getBallGraph(){
        return ball;
    }
    
    public Color getColor(){
        return color;
    }
    
}
