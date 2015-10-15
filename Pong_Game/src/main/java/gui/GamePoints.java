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

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Panel points counter
 * @author <a href="mailto:jgm1986@hotmail.com">Javier Gusano Martinez</a>
 */
public final class GamePoints extends JPanel{
    private int leftPoints;
    private int rightPoints;
    private final JLabel leftLabel;
    private final JLabel rightLabel;
    private JButton rstPoints;
    
    /**
     * Default class constructor.
     */
    public GamePoints(){
        leftLabel = new JLabel(String.valueOf(leftPoints));
        rightLabel = new JLabel(String.valueOf(rightPoints));
        setLayout(new FlowLayout());
        resetPoints();

        // New Game Button
        rstPoints = new JButton("Reset Marker");
        rstPoints.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                resetPoints();
            }
        });
        
        // Add elements to the panel
        add(new JLabel("Current points: "));
        add(leftLabel);
        add(new JLabel("  |  "));
        add(rightLabel);
        add(new JLabel("               "));
        add(rstPoints);
    }
    
    /**
     * Set the marker points to zero.
     */
    public void resetPoints(){
        leftPoints = 0;
        rightPoints = 0;
        updateLabels();
    }
    
    /**
     * Increase in one unit the points of left player.
     */
    public void leftPoint(){
        leftPoints++;
        updateLabels();
    }
    
    /**
     * Increase in one unit the points of left player.
     */
    public void rightPoint(){
        rightPoints++;
        updateLabels();
    }
    
    public void setFocusableButton(boolean status){
        rstPoints.setFocusable(status);
    }
    /**
     * Method used to update text labels on screen
     */
    private void updateLabels(){
        leftLabel.setText(String.valueOf(leftPoints));
        rightLabel.setText(String.valueOf(rightPoints)); 
    }
}
