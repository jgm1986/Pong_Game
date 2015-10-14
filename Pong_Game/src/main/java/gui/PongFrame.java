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

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Main Frame for Pong Game
 * @author <a href="mailto:jgm1986@hotmail.com">Javier Gusano Martinez</a>
 */
public class PongFrame extends JFrame{
    public PongFrame(){
        setTitle("Pong Game - Java SE Example");
        setSize(640, 480);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.addKeyListener(null);
        
        // Auxiliar panels
        GamePanel game = new GamePanel();
        game.setBackground(new Color(97, 218, 146));
        mainPanel.add(game, BorderLayout.CENTER);
        
        GamePoints points = new GamePoints();
        points.setBackground(Color.yellow);
        mainPanel.add(points, BorderLayout.SOUTH);
        
        // Add main panel to JFrame
        add(mainPanel);
        
        // Set visible
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
