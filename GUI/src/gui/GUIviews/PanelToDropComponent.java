/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
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
    
    public PanelToDropComponent(){
        super();
        flag=false;
        this.setLayout(null);
        this.setBounds(320,10,850,700);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
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
        flag=true;
        this.c1=c1;
        this.c2=c2;
       // repaint();
        flag=false;
    }
    
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        if(!flag)
            return;
        int x1;
        int x2;
        if(c1.getX()<c2.getX())
        {
            x1=c1.getX();
            x2=c2.getX()+ c2.size().width;
        }
        else
        {
            x1=c2.getX();
            x2=c1.getX()+ c1.size().width;
        }
        g.setColor(Color.black);
        g.drawLine(x1, c1.getY(), x2, c1.getY());
    }
}
