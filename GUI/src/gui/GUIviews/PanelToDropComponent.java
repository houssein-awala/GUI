/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;

import gui.GUIcontrollers.MenuOnRightClick;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Hussein Awala
 */
public class PanelToDropComponent extends JPanel{
    
    static JComponent c1;
    static JComponent c2;
    static boolean flag;
    static boolean flag1;
    
    public PanelToDropComponent(){
        super();
        flag=false;
        this.setLayout(null);
        this.setBounds(320,10,850,700);
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
}
