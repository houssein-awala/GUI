/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUImodels;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JComponent;
import javax.swing.JPanel;

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
                    m_redo=new Memento(m.getComponent(), "remove", m.getComponent().getParent());
                    break;
                }
                case "bounds":
                {
                    m_redo=new Memento(m.getComponent(), "bounds", new Rectangle(m.getComponent().getBounds()));
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
                    m_undo=new Memento(m.getComponent(), "bounds", new Rectangle(m.getComponent().getBounds()));
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
