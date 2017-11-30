/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import gui.GUImodels.newComponentFactory;
import gui.GUIviews.MainFrame;
import gui.GUIviews.dragedComponent;
import java.awt.Component;
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
        Component[] cc =f.getDropPanel().getComponents();
        for (int i = 0; i < cc.length; i++) {
              //  System.out.println(cc[i].getY()+" "+f.getDropPanel().getY()+" "+designC.getY());
                if(Math.abs(cc[i].getY()+f.getDropPanel().getY()-designC.getY())<30)
                {
                    f.getDropPanel().drawH((JComponent)cc[i], designC);
                    break;
                }
            }
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
             JComponent newc=factory.createNew((dragedComponent)c);
             ((JButton)newc).setLayout(null);
             ((JButton)newc).setSize(90, 40);
             ((JButton)newc).setText(name);
             ((JButton)newc).setName(name);
             ((JButton)newc).setLocation(((int)p.getX()-f.getDropPanel().getX()),((int)p.getY()-f.getDropPanel().getY()));
             JComponent dropedIn=null;
             Component[] components=f.getDropPanel().getComponents();
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
