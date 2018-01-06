/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUImodels;

import java.awt.Rectangle;
import javax.swing.JComponent;
import javax.swing.JPanel;

/**
 *
 * @author Hussein Awala
 */
public class Originator {
    private CareTaker c;
    
    public Originator() {
        this.c = new CareTaker();
    }
    
    public void add(JComponent component,String action,Object parametre)
    {
        Memento m=new Memento(component, action, parametre);
        c.add(m);
    }
    
    public boolean can_undo()
    {
        return c.can_undo();
    }
    
    public boolean can_redo()
    {
        return c.can_redo();
    }
    
    public void undo()
    {
        if(can_undo())
        {
            Memento m=c.UndoMemento();
            switch(m.getAction())
            {
                case "add":
                {
                    ((JPanel)m.getParametre()).remove(m.getComponent());
                    break;
                }
                case "remove":
                {
                    ((JPanel)m.getParametre()).add(m.getComponent());
                    
                    break;
                }
                case "bounds":
                {
                    m.getComponent().setBounds((Rectangle)m.getParametre());
                    break;
                }
            }
        }
    }
    
    public void redo()
    {
        if(can_redo())
        {
            Memento m=c.RedoMemento();
            switch(m.getAction())
            {
                case "add":
                {
                    ((JPanel)m.getParametre()).remove(m.getComponent());
                    break;
                }
                case "remove":
                {
                    ((JPanel)m.getParametre()).add(m.getComponent());
                    break;
                }
                case "bounds":
                {
                    m.getComponent().setBounds((Rectangle)m.getParametre());
                    break;
                }
            }
        }
    }
}
