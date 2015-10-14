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
import javax.swing.JPanel;
import objects.BallObject;
import objects.BarObject;

/**
 * Game panel
 * @author <a href="mailto:jgm1986@hotmail.com">Javier Gusano Martinez</a>
 */
public class GamePanel extends JPanel{
    private BarObject leftPlayer;
    private BarObject rightPlayer;
    private BallObject ball;
    
    public GamePanel(){
         setBackground(new Color(97, 218, 146));
         // Players bars
         leftPlayer = new BarObject(0, 190, Color.BLUE);
         rightPlayer = new BarObject(620, 190, Color.RED);
         ball = new BallObject(310, 240, Color.DARK_GRAY);
    }
    
    /**
     * Pain components method override
     * @param g 
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  
        // Draw play area lines 
        g.drawLine(20, 0, 20, 480);
        g.drawLine(320, 0, 320, 480);
        g.drawLine(620, 0, 620, 480);
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
}
