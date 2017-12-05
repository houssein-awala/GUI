/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import gui.GUIviews.MainFrame;
import gui.GUIviews.PanelToDropComponent;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Hussein Awala
 */
public class MoveComponent extends MouseAdapter{

    static JComponent c1;
    static JComponent c2;
    static boolean flag;
    static MainFrame f;
    static Point p;
    
    public MoveComponent(MainFrame f) {
        super();
        flag=false;
        this.f=f;
    }
    
    @Override
    public void mousePressed(MouseEvent e)
    {
         if(SwingUtilities.isRightMouseButton(e))
            return;
        if(e.getComponent().getClass().getSimpleName().equals("PanelToDropComponent"))
            return;
            c1=(JComponent)e.getComponent().getParent();
            c1.remove(e.getComponent());
            c2=(JComponent)e.getComponent();
            p=c2.getLocation();
              System.out.println(e.getPoint());
            f.getDropPanel().add(c2,2,0);
    }
    
    @Override
    public void mouseDragged(MouseEvent e){
        if(SwingUtilities.isRightMouseButton(e))
            return;
        if(e.getComponent().getClass().getSimpleName().equals("PanelToDropComponent"))
            return;
        int x=e.getXOnScreen()-(int)((double)e.getComponent().getWidth()/2);
        int y=e.getYOnScreen()-(int)((double)e.getComponent().getHeight()/2);
            c2.setLocation(x-f.getDropPanel().getX(),y-f.getDropPanel().getY());
            f.getDropPanel().updateUI();

       // System.out.println(p);
    }
    
    
    
    @Override
    public void mouseReleased(MouseEvent e){
        
        if(!flag)
            return;
        if(!f.getDropPanel().contient(new Point(e.getX(), e.getY())))
        {
            c1.add(c2);
            c2.setLocation(p);
            f.getDropPanel().updateUI();
            return;
        }
       // f.getDropPanel().remove(c2);
        System.out.println(e.getPoint());
        JComponent c=(JComponent)e.getComponent();
        System.out.println(c);
        c2.setLocation(c2.getX(), c2.getY());
        c1.add(c2);
       // System.out.println(c+" "+c2);
       // c2.setLocation(, 0);
       flag=false;
       c1=null;
       c2=null;
    }
}
