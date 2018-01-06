/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.GUIviews.MainFrame;
import javax.swing.JComponent;
import javax.swing.undo.UndoManager;

/**
 *
 * @author USER
 */
public class GUI {

    /**
     * @param args the command line arguments
     */
    static UndoManager u;
    public static void main(String[] args) {
        // TODO code application logic here
        u=new UndoManager();
        MainFrame frame=new MainFrame();
        frame.show();
       // gui.GUIcontrollers.covertToText.toText(new JComponent() {});
    }
    
}
