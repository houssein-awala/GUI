/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;

import gui.GUIcontrollers.DragAndDropListener;
import javax.swing.JLabel;

/**
 *
 * @author Hussein Awala
 */
public class draggedLabel extends JLabel implements dragedComponent{
 
    public draggedLabel()
    {
        super("Label");
        this.setLayout(null);
        this.setBounds(10, 60,90 ,40 );
        this.addMouseListener(new DragAndDropListener());
        this.addMouseMotionListener(new DragAndDropListener());
    }
}
