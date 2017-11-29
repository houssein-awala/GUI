/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;

import java.awt.Component;
import java.awt.PopupMenu;
import javax.swing.JButton;


/**
 *
 * @author Hussein Awala
 */
public class newButton extends JButton implements newComponent{
    newComponent parent;
    newComponent child;
    

    @Override
    public void add(Component comp, Object constraints) {
        super.add(comp, constraints); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(PopupMenu popup) {
        super.add(popup); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Component add(Component comp) {
        return super.add(comp); //To change body of generated methods, choose Tools | Templates.
    }
    public newButton(){
        super();
        
    }

    @Override
    public newComponent get_Parent() {
        return parent;
    }

    @Override
    public newComponent getChild() {
        return child;
    }

    @Override
    public void deleteChild() {
        child=null;
    }

    @Override
    public void addChild(newComponent child) {
        this.child=child;
    }

    @Override
    public void addParent(newComponent parent) {
        this.parent=parent;
    }
}
