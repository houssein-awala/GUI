/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import gui.GUImodels.newComponentFactory;
import gui.GUIviews.MainFrame;
import gui.GUIviews.dragedComponent;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

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

         if(f.getDropPanel().contient(p))
         {
             String name=JOptionPane.showInputDialog("Enter the name");
             if(name!=null)
             {
             gui.GUIviews.newComponent newc=factory.createNew((dragedComponent)c);
             ((JButton)newc).setLayout(null);
             ((JButton)newc).setSize(90, 40);
             ((JButton)newc).setText(name);
             ((JButton)newc).setLocation(((int)p.getX()-f.getDropPanel().getX()),((int)p.getY()-f.getDropPanel().getY()));
             f.getDropPanel().add((JButton)newc);
             f.getDropPanel().updateUI();
             }
         }
       draged=false;
       designC.setLocation(10000, 10000);
       f.remove(designC);
       designC=null;
       c=null;
       p=null;
       pressed=false;
        System.out.println(f.getDropPanel().getComponents());
    }
}
