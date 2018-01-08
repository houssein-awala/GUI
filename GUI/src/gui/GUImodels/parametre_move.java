/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUImodels;

import java.awt.Component;
import java.awt.Container;
import java.awt.Rectangle;
import javax.swing.JComponent;

/**
 *
 * @author Hussein Awala
 */
public class parametre_move {
    Rectangle r;
    Container c;

    public parametre_move(Rectangle r, Container c) {
        this.r = r;
        this.c = c;
    }

    public Rectangle getR() {
        return r;
    }

    public Container getC() {
        return c;
    }

    public void setR(Rectangle r) {
        this.r = r;
    }

    public void setC(Container c) {
        this.c = c;
    }
    
}
