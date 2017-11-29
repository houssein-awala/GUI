/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUImodels;

import gui.GUIviews.dragedComponent;
import gui.GUIviews.newButton;
import gui.GUIviews.newComponent;
/**
 *
 * @author Hussein Awala
 */
public class newComponentFactory {
    public newComponentFactory()
    {
        
    }
    public newComponent createNew(dragedComponent c)
    {
        String type=c.getClass().getSimpleName();
        switch(type)
        {
            case "draggedButton":
                return new newButton();
            default:
                return null;
        }
        
    }
}
