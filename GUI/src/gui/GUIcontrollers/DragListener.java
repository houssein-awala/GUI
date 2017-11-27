/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import com.sun.org.apache.bcel.internal.Repository;
import gui.GUIviews.MainFrame;
import gui.GUIviews.dragedComponent;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComponent;

/**
 *
 * @author Hussein Awala
 */
public class DragListener extends MouseAdapter{
    
    static MainFrame f;
    static JComponent c;
    static Point p;
    static boolean draged;
    public DragListener(){
        super();
    }
    public DragListener(MainFrame f){
        super();
        this.f=f;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        if(!(e.getComponent() instanceof dragedComponent))
            return;
        p=e.getPoint();
        c=(JComponent)e.getComponent();
        draged=false;
        System.out.println(c.getClass());
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if(c==null)
            return;
        draged=true;
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println(draged);
        if(!draged)
            return;
        System.out.println("wow");
        p=e.getPoint();
        JComponent c=new JButton("add");
        c.setLayout(null);
        c.setSize(90, 40);
        c.setLocation(p);
        f.add(c);
    }
    
    @Override
     public void mouseEntered(MouseEvent e) {
    }

    @Override
     public void mouseReleased(MouseEvent e) {
         if(!draged)
             return;
         p=e.getPoint();
         if(f.getDropPanel().contains(p))
         {
             //System.out.println("ghina");
         }

       draged=false;
       c=null;
       p=null;
    }
}
