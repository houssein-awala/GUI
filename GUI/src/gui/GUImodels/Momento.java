/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUImodels;

import gui.GUIviews.PanelToDropComponent;

/**
 *
 * @author Hussein Awala
 */
public class Momento {
    private PanelToDropComponent panelToDropComponent;

    public Momento(PanelToDropComponent panelToDropComponent) {
        this.panelToDropComponent = panelToDropComponent;
    }
    
    public PanelToDropComponent getPanel()
    {
        return panelToDropComponent;
    }
}
