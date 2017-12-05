/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUImodels;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Hussein Awala
 */
public class CareTaker {
    Stack<Momento> undo;
    Stack<Momento> redo;

    public CareTaker() {
        this.undo = new Stack<>();
    }
    
    public void add(Momento m)
    {
        undo.push(m);
        redo=null;
    }
    public Momento UndoMomento(Momento m)
    {
        if(redo==null)
            redo=new Stack<>();
        redo.push(m);
        return undo.pop();
        
    }
    public Momento RedoMomento(Momento m)
    {
        if(redo==null||redo.isEmpty())
            return m;
        undo.push(m);
        return redo.pop();
    }
}
