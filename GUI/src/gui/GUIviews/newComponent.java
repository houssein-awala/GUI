/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;


/**
 *
 * @author Hussein Awala
 */
public interface newComponent{

    public newComponent get_Parent();   
    public newComponent getChild();
    public void addChild(newComponent child);
    public void addParent(newComponent parent);
    public void deleteChild();
    
}
