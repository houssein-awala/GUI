/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import static gui.GUIcontrollers.DragAndDropListener.f;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

/**
 *
 * @author Hussein Awala
 */
public class MenuOnRightClick extends MouseAdapter{
    @Override
     public void mouseClicked(MouseEvent e)
     {
         Point p=new Point(e.getX()+f.getDropPanel().getX(), e.getY()+f.getDropPanel().getY());
         if(f.getDropPanel().contient(p))
         {
             System.out.println("s");
             if(SwingUtilities.isRightMouseButton(e))
             {
                 
                 
             }
             else
             {
                 
             }
         }
     }
}
