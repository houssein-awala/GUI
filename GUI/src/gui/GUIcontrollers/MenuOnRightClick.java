/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import static gui.GUIcontrollers.DragAndDropListener.f;
import gui.GUIviews.PanelToDropComponent;
import java.awt.Component;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
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
                 set_text.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent h) {
                         String name=JOptionPane.showInputDialog("Enter the Text");
             
                      if(name!=null)
                      {
                          switch(e.getComponent().getClass().getSimpleName())
                          {
                              case "JLabel":
                              {
                                  f.getO().add((JComponent)(e.getComponent()), "text", ((JLabel)e.getComponent()).getText());
                                  ((JLabel)e.getComponent()).setName(name);
                                    ((JLabel)e.getComponent()).setText(name);
                                    break;
                              }
                              case "JButton":
                              {
                                  f.getO().add((JComponent)(e.getComponent()), "text", ((JButton)e.getComponent()).getText());
                                  ((JButton)e.getComponent()).setName(name);
                                    ((JButton)e.getComponent()).setText(name);
                                    break;
                              }
                              case "JTextField":
                              {
                                  f.getO().add((JComponent)(e.getComponent()), "text", ((JTextField)e.getComponent()).getText());
                                  ((JTextField)e.getComponent()).setName(name);
                                    ((JTextField)e.getComponent()).setText(name);
                                    break;
                              }
                          }
                          
                       }
                      
                     }
                          });
                     
                JMenuItem add_listener=new JMenuItem("Add Listener");
                 menu.add(add_listener);
                 add_listener.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent e) {
                         JComponent[] c1=new JComponent[]{new PanelToDropComponent()};
                         f.getDropPanel().cloneCom(f.getDropPanel(), c1);
                         f.setDropPanel((PanelToDropComponent)c1[0]);
                     }
                 });
                 
                 menu.show(e.getComponent(), e.getX(), e.getY());
                 
             }
             else
             {
                 
             }
         }
     }
}
