/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

/**
 *
 * @author Hussein Awala
 */
public class DropListener extends MouseAdapter{
    JComponent c;
    Point p;
    boolean draged;
    boolean inPanel;
    
    public DropListener(JComponent c,boolean draged){
        super();
        this.c=c;
        this.draged=draged;
    }
    
   
    @Override
    public void mouseExited(MouseEvent e) {
       inPanel=false;
    }
    
    @Override
     public void mouseEntered(MouseEvent e) {
       inPanel=true;
    }

    @Override
     public void mouseReleased(MouseEvent e) {
         if(draged==false)
             return;
         p=e.getPoint();
         
    }
}
