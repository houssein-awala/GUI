/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;

import gui.GUIcontrollers.DragListener;
import javax.swing.JButton;

/**
 *
 * @author Hussein Awala
 */
public class draggedButton extends JButton implements dragedComponent{
    
    public draggedButton(){
        super("Button");
        this.setLayout(null);
        this.setBounds(10, 10, 90, 40);
        this.addMouseListener(new DragListener());
        this.addMouseMotionListener(new DragListener());
}
}
