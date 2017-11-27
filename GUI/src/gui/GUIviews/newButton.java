/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;

import javax.swing.JButton;


/**
 *
 * @author Hussein Awala
 */
public class newButton extends newComponentClass{
    newComponent parent;
    newComponent child;
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
