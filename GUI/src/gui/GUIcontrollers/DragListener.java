/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import gui.GUImodels.newComponentFactory;
import gui.GUIviews.MainFrame;
import gui.GUIviews.dragedComponent;
import gui.GUIviews.newComponent;
import gui.GUIviews.newComponentClass;
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
    static boolean pressed;
    static JComponent designC;
    static newComponentFactory factory;
    public DragListener(){
        super();
    }
    public DragListener(MainFrame f){
        super();
        DragListener.f=f;
        pressed=false;
        factory=new newComponentFactory();
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        if(!(e.getComponent() instanceof dragedComponent))
            return;
        p=e.getPoint();
        c=(JComponent)e.getComponent();
        draged=false;
        pressed=true;
        
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if(pressed&&!draged)
        {
           designC=new JButton("add");
            designC.setLayout(null);
            f.add(designC,2,0);
            designC.setSize(90, 40);
            designC.setLocation(p);
        }
        if(c==null)
            return;
        draged=true;
        p=e.getPoint();

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
         p=e.getPoint();
         if(f.getDropPanel().contains(p))
         {
             newComponentClass newc=factory.createNew((dragedComponent)c);
             newc.setLayout(null);
             newc.setLocation(p);
             f.getDropPanel().add(newc);
         }
         System.out.println("removed");
       draged=false;
       f.remove(designC);
       designC=null;
       c=null;
       p=null;
       pressed=false;
    }
}
