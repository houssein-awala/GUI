/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import gui.GUIviews.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

/**
 *
 * @author Hussein Awala
 */
public class deleteComponent implements ActionListener{

    public static MainFrame f;
    public static JComponent container;
    public static JComponent c;
    public deleteComponent(MainFrame f,JComponent container,JComponent c) {
        super();
        this.f=f;
        this.container=container;
        this.c=c;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(container==null||c==null)
            return;
        container.remove(c);
        f.getDropPanel().updateUI();
    }
}
