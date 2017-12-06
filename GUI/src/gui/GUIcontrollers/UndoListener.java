/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import gui.GUIviews.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Hussein Awala
 */
public class UndoListener implements ActionListener{

    private MainFrame f;
    public UndoListener(MainFrame f)
    {
        super();
        this.f=f;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
