/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import gui.GUImodels.newComponentFactory;
import gui.GUIviews.MainFrame;
import gui.GUIviews.dragedComponent;
import gui.GUIviews.draggedLabel;
import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Event;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Hussein Awala
 */
public class DragAndDropListener extends MouseAdapter{
    
    static MainFrame f;
    static JComponent c;
    static Point p;
    static boolean draged;
    static boolean pressed;
    static JComponent designC;
    static newComponentFactory factory;
    public DragAndDropListener(){
        super();
    }
    public DragAndDropListener(MainFrame f){
        super();
        DragAndDropListener.f=f;
        pressed=false;
        factory=new newComponentFactory();
    }
    
    public boolean contient(Component c,Point a)
    {
        int x=(int)a.getX()-f.getDropPanel().getX();
        int y=(int)a.getY()-f.getDropPanel().getY();
        Point p=new Point(x,y);
        if(p.getX()<c.getX()||p.getX()>(c.getX()+c.size().width)||p.getY()<c.getY()||p.getY()>(c.getY()+c.size().height))
        {
            return false;
        }
        return true;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        if(!(e.getComponent() instanceof dragedComponent))
            return;
        p=new Point((int)(e.getXOnScreen()-f.getDragedPanel().getLocationOnScreen().getX()),(int)( e.getYOnScreen()-f.getDragedPanel().getLocationOnScreen().getY()));
        c=(JComponent)e.getComponent();
        draged=false;
        pressed=true;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if(pressed&&!draged)
        {
            switch(e.getComponent().getClass().getSimpleName())
            {
                case "draggedButton":
                    designC=new JButton("add");
                    break;
                case "draggedLabel":
                    designC=new JLabel("add");
                    break;
                case "draggedTextField":
                    designC=new JTextField("add");
                    break;
            }
           
            designC.setLayout(null);
            f.add(designC,2,0);
            designC.setSize(90, 40);
            designC.setLocation(p.x+f.getDragedPanel().getX(),p.y+f.getDragedPanel().getY());
            
            
        }
        if(c==null)
            return;
        Component[] cc =f.getDropPanel().getComponents();
        int i;
        for (i = 0; i < cc.length; i++) {
              //  System.out.println(cc[i].getY()+" "+f.getDropPanel().getY()+" "+designC.getY());
                if(Math.abs(cc[i].getY()+f.getDropPanel().getY()-designC.getY())<10)
                {
                    f.getDropPanel().drawH((JComponent)cc[i], designC);
                    break;
                }
            }
        if(i==cc.length)
            f.getDropPanel().drawH(null,null);
        for (i = 0; i < cc.length; i++) {
              //  System.out.println(cc[i].getY()+" "+f.getDropPanel().getY()+" "+designC.getY());
                if(Math.abs(cc[i].getX()+f.getDropPanel().getX()-designC.getX())<10)
                {
                    f.getDropPanel().drawW((JComponent)cc[i], designC);
                    break;
                }
            }
        if(i==cc.length)
            f.getDropPanel().drawW(null,null);
        draged=true;
        p=new Point((int)(e.getXOnScreen()-f.getLocationOnScreen().getX()-9),(int)( e.getYOnScreen()-f.getLocationOnScreen().getY()-61));
        designC.setLocation(p);
        
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
       
    }
    
    @Override
     public void mouseEntered(MouseEvent e) {
    }

    @Override
     public void mouseReleased(MouseEvent e) {
         
         if(!draged)
             return;
         p=new Point((int)(e.getXOnScreen()-f.getDropPanel().getLocationOnScreen().getX()),(int)( e.getYOnScreen()-f.getDropPanel().getLocationOnScreen().getY()));
         System.out.println(p);
            JComponent newc=null;
         if(f.getDropPanel()._contient(p))
         {
             String name=JOptionPane.showInputDialog("Enter the name");
             
             if(name!=null)
             {
             JComponent dropedIn=null;
             Component[] components=f.getDropPanel().getComponents();
             switch(c.getClass().getSimpleName())
            {
                case "draggedButton":
                    newc=new JButton("add");
                    ((JButton)newc).setLayout(null);
                    ((JButton)newc).setSize(90, 40);
                    ((JButton)newc).setText(name);
                    ((JButton)newc).setName(name);
                    ((JButton)newc).setLocation(p);
                    //((JButton)newc).setLocation(p);
                      for (int i = 0; i < components.length; i++) {
                          if(contient(components[i],p))
                             {
                               dropedIn=(JComponent)components[i];
                                 break;
                          }
                      }
             
                    if(dropedIn==null)
                    {
                        f.getDropPanel().add((JButton)newc);
                    }
                   else{
                        dropedIn.add((JButton)newc);
                      }
                     f.getDropPanel().updateUI();
                    break;
                case "draggedLabel":
                    newc=new JLabel("add");
                    ((JLabel)newc).setLayout(null);
                    ((JLabel)newc).setSize(90, 40);
                    ((JLabel)newc).setText(name);
                    ((JLabel)newc).setName(name);
                    ((JLabel)newc).setLocation(p);
                    ((JLabel)newc).setBorder(BorderFactory.createDashedBorder(null));
                      for (int i = 0; i < components.length; i++) {
                          if(contient(components[i],p))
                             {
                               dropedIn=(JComponent)components[i];
                                 break;
                          }
                      }
             
                    if(dropedIn==null)
                    {
                        f.getDropPanel().add((JLabel)newc);
                    }
                   else{
                        dropedIn.add((JLabel)newc);
                      }
                     f.getDropPanel().updateUI();
                    break;
                    case "draggedTextField":
                    newc=new JTextField("add");
                    ((JTextField)newc).setLayout(null);
                    ((JTextField)newc).setSize(90, 40);
                    ((JTextField)newc).setText(name);
                    ((JTextField)newc).setName(name);
                    ((JTextField)newc).setLocation(p);
                      for (int i = 0; i < components.length; i++) {
                          if(contient(components[i],p))
                             {
                               dropedIn=(JTextField)components[i];
                                 break;
                          }
                      }
             
                    if(dropedIn==null)
                    {
                        f.getDropPanel().add((JComponent)newc);
                    }
                   else{
                        dropedIn.add((JComponent)newc);
                      }
                     f.getDropPanel().updateUI();
                    break;
            }    
             f.getDropPanel().drawH(null,null);
             f.getDropPanel().drawW(null,null);
             newc.addMouseListener(new MenuOnRightClick());
             MoveComponent mc=new MoveComponent(f);
             newc.addMouseListener(mc);
             newc.addMouseMotionListener(mc);
             
         }
         }
       draged=false;
       designC.setLocation(10000, 10000);
       f.remove(designC);
       designC=null;
       c=null;
       p=null;
       pressed=false;
        
    }
    
}
