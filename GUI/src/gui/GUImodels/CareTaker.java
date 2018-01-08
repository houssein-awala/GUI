/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUImodels;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Hussein Awala
 */
public class CareTaker {
    Stack<Memento> undo;
    Stack<Memento> redo;

    public CareTaker() {
        this.undo = new Stack<>();
    }
    
    public void add(Memento m)
    {
        undo.push(m);
        redo=null;
    }
    public Memento UndoMemento()
    {
        if(redo==null)
            redo=new Stack<>();
        Memento m=undo.pop();
        Memento m_redo=null;
        switch(m.getAction())
            {
                case "add":
                {
                    m_redo=new Memento(m.getComponent(), "remove", m.getComponent().getParent());
                    break;
                }
                case "remove":
                {
                    m_redo=new Memento(m.getComponent(), "add", m.getComponent().getParent());
                    break;
                }
                case "bounds":
                {
                    m_redo=new Memento(m.getComponent(), "bounds", new parametre_move(m.getComponent().getBounds(),m.getComponent().getParent()));
                    break;
                }
                case "text":
                {
                    switch(m.getComponent().getClass().getSimpleName())
                    {
                        case "JLabel":
                        {
                            m_redo=new Memento(m.getComponent(), "text", ((JLabel)m.getComponent()).getText());
                            break;
                        }
                        case "JButton":
                        {
                            m_redo=new Memento(m.getComponent(), "text", ((JButton)m.getComponent()).getText());
                            break;
                        }
                        case "JTextField":
                        {
                        
                            m_redo=new Memento(m.getComponent(), "text", ((JTextField)m.getComponent()).getText());
                            break;
                        }
                    }
                    break;
                }
               
            }
        redo.push(m_redo);
        return m;
        
    }
    public Memento RedoMemento()
    {
        if(redo==null||redo.isEmpty())
            return null;
        Memento m=redo.pop();
        Memento m_undo=null;
        switch(m.getAction())
            {
                case "add":
                {
                    m_undo=new Memento(m.getComponent(), "remove", m.getComponent().getParent());
                    break;
                }
                case "remove":
                {
                    m_undo=new Memento(m.getComponent(), "remove", m.getComponent().getParent());
                    break;
                }
                case "bounds":
                {
                    m_undo=new Memento(m.getComponent(), "bounds", new parametre_move(m.getComponent().getBounds(),m.getComponent().getParent()));
                    break;
                }
                case "text":
                {
                    switch(m.getComponent().getClass().getSimpleName())
                    {
                        case "JLabel":
                        {
                            m_undo=new Memento(m.getComponent(), "text", ((JLabel)m.getComponent()).getText());
                            break;
                        }
                        case "JButton":
                        {
                            m_undo=new Memento(m.getComponent(), "text", ((JButton)m.getComponent()).getText());
                            break;
                        }
                        case "JTextField":
                        {
                        
                            m_undo=new Memento(m.getComponent(), "text", ((JTextField)m.getComponent()).getText());
                            break;
                        }
                    }
                    break;
                }
                case "move":
                {
                    m_undo=new Memento(m.getComponent(), "move", m.getComponent().getParent());
                    break;
                }
            }
        undo.push(m);
        return m;
    }
    
    public boolean can_undo()
    {
        return !undo.isEmpty();
    }
    public boolean can_redo()
    {
        if(redo==null)
            return false;
        return !redo.isEmpty();
    }
}
