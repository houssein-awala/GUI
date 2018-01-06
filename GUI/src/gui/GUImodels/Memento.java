/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUImodels;

import gui.GUIviews.PanelToDropComponent;
import javax.swing.JComponent;

/**
 *
 * @author Hussein Awala
 */
public class Memento {
    private JComponent component;
    private Object parametre;
    private String action;

    public Memento(JComponent component,String action,Object parametre) {
        this.component=component;
        this.parametre=parametre;
        this.action=action;
    }

    public JComponent getComponent() {
        return component;
    }

    public Object getParametre() {
        return parametre;
    }

    public String getAction() {
        return action;
    }
    
    
}
