/**
 * Copyright 2015 Javier Gusano Martinez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;
import objects.BallObject;
import objects.BarObject;

/**
 * Game panel
 * @author <a href="mailto:jgm1986@hotmail.com">Javier Gusano Martinez</a>
 */
public class GamePanel extends JPanel{
    // Game objects
    private BarObject leftPlayer;
    private BarObject rightPlayer;
    private BallObject ball;
    // Keys flags
    private boolean key_w;
    private boolean key_s;
    private boolean key_up;
    private boolean key_down;
    // Timer for game refresh
    private Timer timer;
    
    public GamePanel(){
         setBackground(new Color(97, 218, 146));
         // Players bars
         leftPlayer = new BarObject(0, 190, Color.BLUE);
         rightPlayer = new BarObject(720, 190, Color.RED);
         ball = new BallObject(360, 240, Color.DARK_GRAY);
         
         // Timer object
         timer = new Timer(10, new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent ae) {
                 updatePositions();
             }
         });
         timer.start();
    }
    
    /**
     * Pain components method override
     * @param g Graphics object.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        // Draw play area lines 
        g.drawLine(20, 0, 20, 480);
        g.drawLine(370, 0, 370, 480);
        g.drawLine(720, 0, 720, 480);
        // Draw players bars
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(leftPlayer.getColor());
        g2.fill(leftPlayer.getBarGraph());
        g2.setColor(rightPlayer.getColor());
        g2.fill(rightPlayer.getBarGraph());
        // Draw ball
        g2.setColor(ball.getColor());
        g2.fill(ball.getBallGraph());
    }
    
    /**
     * Used to change the flags 
     * @param keyCode Code of the key pressed.
     * @param value Value of the key (true if is pressed, false if not).
     */
    public void setFlag(int keyCode, boolean value){
        switch( keyCode ) { 
            case KeyEvent.VK_UP:
                if(key_down == false){
                    key_up = value;
                }
                break;
            case KeyEvent.VK_DOWN:
                if(key_up == false){
                    key_down = value;
                }
                break;
            case KeyEvent.VK_W:
                if(key_s == false){
                    key_w = value;
                }
                break;
            case KeyEvent.VK_S:
                if(key_w == false){
                    key_s = value;
                }
            break;
        }
    }
    
    /**
     * Method for keyboard flags debug.
     * Returns a string with the keyboard game keys flags.
     * @return String with the flags status.
     */
    public String debugKeys(){
        return "Key status Up = " + key_up + " Down = " + key_down + " | W = " + key_w + " S = " + key_s;
    }
    
    private void updatePositions(){
        // Left player
        if(key_w){
            leftPlayer.moveUp();
        }else if(key_s){
            leftPlayer.moveDown();
        }
        // Right player
        if(key_up){
            rightPlayer.moveUp();
        } else if(key_down){
            rightPlayer.moveDown();
        }
        repaint();
    }
    
}
