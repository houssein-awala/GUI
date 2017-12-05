/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;

/**
 *
 * @author Hussein Awala
 */
public class changeText implements ActionListener{

    protected JComponent c;
    protected String s;

    public changeText(JComponent c, String s) {
        this.c = c;
        this.s = s;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
