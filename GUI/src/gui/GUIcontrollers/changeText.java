/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
        switch(c.getClass().getSimpleName())
        {
            case "JButton":
            {
                ((JButton)c).setText(s);
                ((JButton)c).setName(s);
            }
            case "JLabel":
            {
                ((JLabel)c).setText(s);
                ((JLabel)c).setName(s);
            }
            case "JTextField":
            {
                ((JTextField)c).setText(s);
                ((JTextField)c).setName(s);
            }
            case "JPanel":
            {
                ((JPanel)c).setName(s);
            }
        }
    }
    
}
