/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import gui.GUIviews.MainFrame;
import gui.GUIviews.PanelToDropComponent;
import java.awt.Component;
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
    static boolean dragged;
    static boolean resize;
    static boolean L,R,U,D;
    public MoveComponent(MainFrame f) {
        super();
        flag=false;
        this.f=f;
        dragged=false;
        resize=false;
        L=R=U=D=false;
    }
    
    @Override
    public void mousePressed(MouseEvent e)
    {
         if(SwingUtilities.isRightMouseButton(e))
            return;
        if(e.getComponent().getClass().getSimpleName().equals("PanelToDropComponent"))
            return;
        
        int x=e.getX();
        int y=e.getY();
        System.out.println(x+" "+y);
        System.out.println(e.getComponent().getWidth());
        if(x<5)
            L=true;
        if(y<5)
            U=true;
        if(Math.abs(x-e.getComponent().getWidth())<5)
            R=true;
        if(Math.abs(y-e.getComponent().getHeight())<5)
            D=true;
        if(L||R||U||D)
        {
            dragged=false;
            resize=true;
            return;
        }
            c1=(JComponent)e.getComponent().getParent();
            c1.remove(e.getComponent());
            c2=(JComponent)e.getComponent();
            p=c2.getLocation();
            dragged=true;
            f.getDropPanel().add(c2,2,0);
    }
    
    @Override
    public void mouseDragged(MouseEvent e){
        if(SwingUtilities.isRightMouseButton(e))
            return;
        if(e.getComponent().getClass().getSimpleName().equals("PanelToDropComponent"))
            return;
        if(dragged==true)
        {
        int x=e.getXOnScreen()-f.getDropPanel().getX()-(int)((double)e.getComponent().getWidth()/2);
        int y=e.getYOnScreen()-f.getDropPanel().getY()-(int)((double)e.getComponent().getHeight()/2);
        if(!f.getDropPanel().contient(new Point(x+f.getDropPanel().getX(), y+f.getDropPanel().getY())))
        {
            c2.setLocation(p);
            return;
        }
            c2.setLocation(x,y);
        }
        else
        {
            if(resize==true)
            {
                Component resizeC=e.getComponent();
                int x=e.getX();
                int y=e.getY();
                Point location=resizeC.getLocation();
                if(R)
                {
                    resizeC.setSize(x, resizeC.getHeight());
                }
                if(D)
                {
                    resizeC.setSize(resizeC.getWidth(),y);
                }
                if(U&&L)
                {
                    resizeC.setBounds(location.x+x, location.y+y, resizeC.getWidth()-x, resizeC.getHeight()-y);
                }
                else
                {
                if(U)
                {
                    resizeC.setBounds(location.x, location.y+y, resizeC.getWidth(), resizeC.getHeight()-y);
                }
                if(L)
                {
                    resizeC.setBounds(location.x+x, location.y, resizeC.getWidth()-x, resizeC.getHeight());
                }
                }
            }
        }
            f.getDropPanel().updateUI();

    }
    
    
    
    @Override
    public void mouseReleased(MouseEvent e){
        if(L||R||U||D)
        {
            L=R=U=D=resize=false;
            return;
        }
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
