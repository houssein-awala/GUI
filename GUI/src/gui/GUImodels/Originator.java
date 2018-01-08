/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUImodels;

import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
                    m.getComponent().setBounds(((parametre_move)m.getParametre()).getR());
                    JPanel a=((JPanel)(m.getComponent()).getParent());
                    (m.getComponent()).getParent().remove(m.getComponent());
                    a.updateUI();
                    ((JPanel)((parametre_move)m.getParametre()).getC()).add(m.getComponent());
                    ((JPanel)((parametre_move)m.getParametre()).getC()).updateUI();
                    break;
                }
                case "text":
                {
                    switch(m.getComponent().getClass().getSimpleName())
                    {
                        case "JLabel":
                        {
                            ((JLabel)m.getComponent()).setText((String)m.getParametre());
                            ((JLabel)m.getComponent()).setName((String)m.getParametre());
                            break;
                        }
                        case "JButton":
                        {
                            ((JButton)m.getComponent()).setText((String)m.getParametre());
                            ((JButton)m.getComponent()).setName((String)m.getParametre());
                            break;
                        }
                        case "JTextField":
                        {
                        
                            ((JTextField)m.getComponent()).setText((String)m.getParametre());
                            ((JTextField)m.getComponent()).setName((String)m.getParametre());
                            break;
                        }
                    }
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
                    m.getComponent().setBounds(((parametre_move)m.getParametre()).getR());
                    JPanel a=((JPanel)(m.getComponent()).getParent());
                    (m.getComponent()).getParent().remove(m.getComponent());
                    a.updateUI();
                    ((JPanel)((parametre_move)m.getParametre()).getC()).add(m.getComponent());
                    ((JPanel)((parametre_move)m.getParametre()).getC()).updateUI();
                    break;
                }
                case "text":
                {
                    switch(m.getComponent().getClass().getSimpleName())
                    {
                        case "JLabel":
                        {
                            ((JLabel)m.getComponent()).setText((String)m.getParametre());
                            ((JLabel)m.getComponent()).setName((String)m.getParametre());
                            break;
                        }
                        case "JButton":
                        {
                            ((JButton)m.getComponent()).setText((String)m.getParametre());
                            ((JButton)m.getComponent()).setName((String)m.getParametre());
                            break;
                        }
                        case "JTextField":
                        {
                        
                            ((JTextField)m.getComponent()).setText((String)m.getParametre());
                            ((JTextField)m.getComponent()).setName((String)m.getParametre());
                            break;
                        }
                    }
                    break;
                }
                
            }
        }
    }
}
