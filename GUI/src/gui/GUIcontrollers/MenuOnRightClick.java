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
import javax.swing.JComponent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
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
             if(SwingUtilities.isRightMouseButton(e)&&!e.getComponent().getClass().getSimpleName().equals("PanelToDropComponent"))
             {
                 JPopupMenu menu=new JPopupMenu();
                 
                 JMenuItem delete=new JMenuItem("delete");
                 menu.add(delete);
                 deleteComponent deleltecomponent=new deleteComponent(f,(JComponent)e.getComponent().getParent(),(JComponent)e.getComponent());
                 delete.addActionListener(deleltecomponent);
                 
                 JMenuItem set_text=new JMenuItem("Change text");
                 menu.add(set_text);
                 
                 JMenuItem add_listener=new JMenuItem("Add Listener");
                 menu.add(add_listener);
                 
                 menu.show(e.getComponent(), e.getX(), e.getY());
                 
             }
             else
             {
                 
             }
         }
     }
}
