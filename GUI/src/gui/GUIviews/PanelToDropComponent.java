/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;

import gui.GUIcontrollers.MenuOnRightClick;
import gui.GUIcontrollers.MoveComponent;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import java.util.Stack;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Hussein Awala
 */
public class PanelToDropComponent extends JPanel implements Cloneable{
    
    static JComponent c1;
    static JComponent c2;
    static boolean flag;
    static boolean flag1;
    
    public PanelToDropComponent(){
        super();
        flag=false;
        this.setLayout(null);
        this.setBounds(320,100,850,700);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.addMouseListener(new MenuOnRightClick());
        
    }
    public boolean contient(Point p)
    {
        if(p.getX()<this.getX()||p.getX()>(this.getX()+this.size().width)||p.getY()<this.getY()||p.getY()>(this.getY()+this.size().height))
        {
            return false;
        }
        return true;
    }
    
    public boolean _contient(Point p)
    {
        if(p.getX()<0||p.getX()>(this.size().width)||p.getY()<0||p.getY()>(this.size().height))
        {
            return false;
        }
        return true;
    }
    
    public void drawH(JComponent c1,JComponent c2)
    {
        if(c1==null||c2==null)
        {
            flag=false;
            repaint();
            return;
        }
        flag=true;
        this.c1=c1;
        this.c2=c2;
        repaint();
    }
    public void drawW(JComponent c1,JComponent c2)
    {

        if(c1==null||c2==null)
        {
            flag1=false;
            repaint();
            return;
        }
        flag1=true;
        this.c1=c1;
        this.c2=c2;
        repaint();
    }
    
    
    @Override
    public void paint(Graphics g)
    {
        
        super.paint(g);
        if(flag)
        {
        int x1;
        int x2;
        if(c1.getX()<c2.getX()-this.getX())
        {
            x1=c1.getX();
            x2=c2.getX()-this.getX()+ c2.size().width;
        }
        else
        {
            x1=c2.getX()-this.getX();
            x2=c1.getX()+ c1.size().width;
        }
        g.setColor(Color.black);
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        ((Graphics2D)g).setStroke(dashed);
        g.drawLine(x1, c1.getY(), x2, c1.getY());
        }
        if(flag1)
        {
        int y1;
        int y2;
        if(c1.getY()<c2.getY()-this.getY())
        {
            y1=c1.getY();
            y2=c2.getY()-this.getY()+ c2.size().height;
        }
        else
        {
            y1=c2.getY()-this.getY();
            y2=c1.getY()+ c1.size().height;
        }
        Stroke dashed = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[]{9}, 0);
        ((Graphics2D)g).setStroke(dashed);
        g.setColor(Color.black);
        g.drawLine(c1.getX(), y1, c1.getX(), y2);
        }
    }

    
    public void cloneCom(JComponent c1,JComponent[] c2)
    {
        if(c1.getClass().getSimpleName().equals("PanelToDropComponent"))
        {
           /* ActionListener[] l1=c1.getListeners(ActionListener.class);
            for (int j = 0; j < l1.length; j++) {
                c2[0].addAncestorListener((AncestorListener) l1[j]);
            }
            
            MouseListener[] l2=c1.getListeners(MouseListener.class);
            for (int j = 0; j < l2.length; j++) {
                c2[0].addMouseListener(l2[j]);
            }
            
            MouseMotionListener[] l3=c1.getListeners(MouseMotionListener.class);
            for (int j = 0; j < l3.length; j++) {
                c2[0].addMouseMotionListener(l3[j]);
            }
            */
            c2[0]=new PanelToDropComponent();
            
        }
        Component[] com=c1.getComponents();
        if(com.length==0)
            return;
        for (int i = 0; i < com.length ; i++) {
            JComponent[] temp=new JComponent[1];
            switch(com[i].getClass().getSimpleName())
            {
                case "JButton":
                    temp[0]=new JButton(((JButton)com[i]).getText());
                    break;
            }
            temp[0].setName(com[i].getName());
            temp[0].setBounds(com[i].getX(), com[i].getY(),com[i].getWidth() , com[i].getHeight());
            
            ActionListener[] l1=com[i].getListeners(ActionListener.class);
            for (int j = 0; j < l1.length; j++) {
                temp[0].addAncestorListener((AncestorListener) l1[j]);
            }
            
            MouseListener[] l2=com[i].getListeners(MouseListener.class);
            for (int j = 0; j < l2.length; j++) {
                temp[0].addMouseListener(l2[j]);
            }
            
            MouseMotionListener[] l3=com[i].getListeners(MouseMotionListener.class);
            for (int j = 0; j < l3.length; j++) {
                temp[0].addMouseMotionListener(l3[j]);
            }
            
            
            
            cloneCom((JComponent)com[i], temp);
            
            c2[0].add(temp[0]);
            
        }
    }
    
}
