/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

/**
 *
 * @author Hussein Awala
 */
public class MainFrame extends JFrame{
    PanelDragedComponentContainer DragedPanel;
    PanelToDropComponent DropPanel;
    
    public MainFrame(){
        this.setSize(1200, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        
        DragedPanel=new PanelDragedComponentContainer();
        this.add(DragedPanel);
        
        DropPanel=new PanelToDropComponent();
        this.add(DropPanel);
        
    }
}
