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
public class PanelToDropComponent extends JPanel{
    
    public PanelToDropComponent(){
        super();
        this.setLayout(null);
        this.setBounds(320,10,850,700);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
    
}
