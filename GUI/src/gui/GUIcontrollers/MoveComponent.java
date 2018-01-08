/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import static gui.GUIcontrollers.DragAndDropListener.p;
import gui.GUImodels.parametre_move;
import gui.GUIviews.MainFrame;
import gui.GUIviews.PanelToDropComponent;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Hussein Awala
 */
public class MoveComponent extends MouseAdapter{

    static JPanel c1;
    static JComponent c2;
    static boolean flag;
    static MainFrame f;
    static Point p;
    static boolean dragged;
    static boolean resize;
    static boolean L,R,U,D;
    static boolean drag_panel;
    static JPanel panel;
    static Point old_p;
    JComponent ccc;
    public MoveComponent(MainFrame f,JComponent ccc) {
        super();
        flag=false;
        this.f=f;
        dragged=false;
        resize=false;
        L=R=U=D=false;
        drag_panel=false;
        panel=null;
        this.ccc=ccc;
    }
    
    @Override
    public void mouseMoved(MouseEvent e)
    {
        if(dragged||c2!=null)
            return;
         int x=e.getX();
        int y=e.getY();
        boolean L=R=U=D=false;
        if(x<5)
            L=true;
        if(y<5)
            U=true;
        if(Math.abs(x-e.getComponent().getWidth())<5)
            R=true;
        if(Math.abs(y-e.getComponent().getHeight())<5)
            D=true;
        
        if((L&&U)||(U&&R)||(R&&D)||(D&&L))
        {
            if(L&&U)
            {
                e.getComponent().setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
            }
            if(U&&R)
            {
                e.getComponent().setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
            }
            if(R&&D)
            {
                e.getComponent().setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
            }
            if(D&&L)
            {
                e.getComponent().setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
            }
        }
        else
        {
            if(R||L)
            {
                e.getComponent().setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
            }
            else
            {
                if(U||D)
                {
                    e.getComponent().setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
                }
                else
                {
                   e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
                  /* if(e.getComponent().getClass().getSimpleName().equals("JPanel"))
                   {
                       drag_panel=true;
                       panel=(JPanel)e.getComponent();
                       System.out.println("paneeeeeeeeeeeeeeeeeeeeeeeeeel");
                   }*/
                }
            }
        }
    }
    public boolean contient_screen(Component c,Point a)
    {
        double x=a.getX()-c.getLocationOnScreen().getX();
        double y=a.getY()-c.getLocationOnScreen().getY();
        if(x<=c.getWidth()&&y<=c.getHeight()&&x>=0&&y>=0)
        {
            return true;
        }
        return false;
    }
    
    @Override
    public void mouseEntered(MouseEvent e)
    {
        if(dragged||c2!=null)
            return;
        int x=e.getX();
        int y=e.getY();
        boolean L=R=U=D=false;

        if(x<5)
            L=true;
        if(y<5)
            U=true;
        if(Math.abs(x-e.getComponent().getWidth())<5)
            R=true;
        if(Math.abs(y-e.getComponent().getHeight())<5)
            D=true;
        
        if((L&&U)||(U&&R)||(R&&D)||(D&&L))
        {
            if(L&&U)
            {
                e.getComponent().setCursor(new Cursor(Cursor.NW_RESIZE_CURSOR));
            }
            if(U&&R)
            {
                e.getComponent().setCursor(new Cursor(Cursor.NE_RESIZE_CURSOR));
            }
            if(R&&D)
            {
                e.getComponent().setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
            }
            if(D&&L)
            {
                e.getComponent().setCursor(new Cursor(Cursor.SW_RESIZE_CURSOR));
            }
        }
        else
        {
            if(R||L)
            {
                e.getComponent().setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
            }
            else
            {
                if(U||D)
                {
                    e.getComponent().setCursor(new Cursor(Cursor.N_RESIZE_CURSOR));
                }
                else
                {
                   e.getComponent().setCursor(new Cursor(Cursor.HAND_CURSOR));
                   if(e.getComponent().getClass().getSimpleName().equals("JPanel"))
                   {
                    /*   drag_panel=true;
                       panel=(JPanel)e.getComponent();
                       System.out.println("paneeeeeeeeeeeeeeeeeeeeeeeeeel");*/
                   }
                }
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e)
    {

        c2=(JComponent)e.getComponent();
        //System.out.println(e.getComponent().getParent());
         if(SwingUtilities.isRightMouseButton(e))
            return;
        if(e.getComponent().getClass().getSimpleName().equals("PanelToDropComponent"))
            return;
        f.getO().add((JComponent)e.getComponent(), "bounds",new parametre_move( new Rectangle(((JComponent)e.getComponent()).getBounds()),((JComponent)e.getComponent()).getParent()) );
        int x=e.getX();
        int y=e.getY();
        //System.out.println(x+" "+y);
        //System.out.println(e.getComponent().getWidth());
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
        flag=true;
            c1=(JPanel)e.getComponent().getParent();
            c1.remove(e.getComponent());
           // System.out.println(c1);
            c2=(JComponent)e.getComponent();
            p=c2.getLocation();
            old_p=new Point((int)(e.getLocationOnScreen().getX()-c1.getLocationOnScreen().getX()),(int)(e.getLocationOnScreen().getY()-c1.getLocationOnScreen().getY()));
            dragged=true;
            c2.setLocation((int)(e.getLocationOnScreen().getX()-f.getDropPanel().getLocationOnScreen().getX()),(int)(e.getLocationOnScreen().getY()-f.getDropPanel().getLocationOnScreen().getY()));
            f.getDropPanel().add(c2,2,0);

           
    }
    
    @Override
    public void mouseDragged(MouseEvent e){
        if(c2!=null&&c2!=ccc)
            return;
        if(SwingUtilities.isRightMouseButton(e))
            return;
        if(e.getComponent().getClass().getSimpleName().equals("PanelToDropComponent"))
            return;
        if(dragged==true)
        {
        int x=(int)e.getXOnScreen()-(int)f.getDropPanel().getLocationOnScreen().getX();
        int y=(int)e.getYOnScreen()-(int)f.getDropPanel().getLocationOnScreen().getY();
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
                ((JPanel)(resizeC.getParent())).updateUI();
            }
        }
        
            f.getDropPanel().updateUI();

    }
    
    
    
    @Override
    public void mouseReleased(MouseEvent e){
       // System.out.println(c1);
        dragged=false;
        if(L||R||U||D)
        {
            L=R=U=D=resize=dragged=flag=false;
            c2=null;
            return;
        }
        if(!flag)
        {
            c2=null;
            return;
        }
        if(!contient_screen(f.getDropPanel(),e.getLocationOnScreen()))
        {
            c1.add(c2);
            c2.setLocation(p);
            f.getDropPanel().updateUI();
            c2=null;
            return;
        }
       // f.getDropPanel().remove(c2);
       //f.getO().add((JComponent)e.getComponent(), "move", e.getComponent().getParent());
       Point point_screen=e.getLocationOnScreen();
       JPanel a=f.getDropPanel();
       Component[] components=f.getDropPanel().getComponents();
      for (int i = 0; i < components.length; i++) {
             if(components[i]!=c2&&components[i].getClass().getSimpleName().equals("JPanel")&&contient_screen(components[i],point_screen))
            {
                 a=(JPanel)components[i];
                  components=a.getComponents();
                  i=-1;
                 }
          }
       a.add(c2);
       a.updateUI();
       c2.setLocation(new Point((int)(e.getLocationOnScreen().getX()-a.getLocationOnScreen().getX()),(int)(e.getLocationOnScreen().getY()-a.getLocationOnScreen().getY())));
       // System.out.println(e.getPoint());
       // JComponent c=(JComponent)e.getComponent();
     //   System.out.println(c);
       // c2.setLocation(c2.getX(), c2.getY());
      //  a.add(c2);
       // System.out.println(c+" "+c2);
       // c2.setLocation(, 0);
     //  c1.add(c2);
       c1.updateUI();
       flag=false;
       c1=null;
       c2=null;
    }
}
