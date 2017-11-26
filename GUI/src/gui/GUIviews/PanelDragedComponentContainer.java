/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Hussein Awala
 */
public class PanelDragedComponentContainer extends JPanel{
    draggedButton button;
    
    public PanelDragedComponentContainer(){
        super();
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setLayout(null);
        this.setBounds(10, 10, 300, 700);
        
        button=new draggedButton();
        this.add(button);
    }
}
