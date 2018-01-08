/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Hussein Awala
 */
public class draggedPanel extends JPanel implements dragedComponent{

    public draggedPanel() {
        super(new GridLayout(0, 4, 6, 6), true);
        this.setLayout(null);
        this.setBounds(10, 170, 100, 100);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setOpaque(false);
    }
    
}
