/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;

import gui.GUIcontrollers.DragAndDropListener;
import javax.swing.JTextField;

/**
 *
 * @author Hussein Awala
 */
public class draggedTextField extends JTextField implements dragedComponent{
    public draggedTextField(){
        super("Text Field");
        this.setLayout(null);
        this.setBounds(10, 110,90 ,40 );
        this.disable();
        this.addMouseListener(new DragAndDropListener());
        this.addMouseMotionListener(new DragAndDropListener());
    }
}
