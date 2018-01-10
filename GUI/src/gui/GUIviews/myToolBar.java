/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;

import gui.GUIcontrollers.save_load;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import javafx.scene.control.ToolBar;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 *
 * @author Hussein Awala
 */
public class myToolBar extends JToolBar{
    JButton save;
    JButton load;
    MainFrame f;

    public myToolBar(MainFrame f) {
        super("toolbar",JToolBar.HORIZONTAL);
        this.f=f;
        this.setVisible(true);
        
        save=new JButton("save");
        
        
        load=new JButton("load");
        
        this.add(save);
        this.add(load);
        
        this.setFloatable(false);
        this.setRollover(true);
        this.addSeparator();
        
        this.setLayout(new GridLayout());
    }
    
    
    
}
