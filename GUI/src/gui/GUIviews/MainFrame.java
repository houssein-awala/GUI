/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;

import gui.GUIcontrollers.DragAndDropListener;
import gui.GUImodels.Memento;
import gui.GUImodels.Originator;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Hussein Awala
 */
public class MainFrame extends JFrame{
    PanelDragedComponentContainer DragedPanel;
    PanelToDropComponent DropPanel;
    MyMenu menu;
    Memento m;
    Originator o;
    myToolBar toolbar;
    public MainFrame(){
        this.setSize(1200, 900);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.addMouseListener(new DragAndDropListener(this));
        this.addMouseMotionListener(new DragAndDropListener(this));
        
        DragedPanel=new PanelDragedComponentContainer();
        this.add(DragedPanel);
        
        DropPanel=new PanelToDropComponent();
        this.add(DropPanel);
        
        menu=new MyMenu(this);
        this.setJMenuBar(menu);
        
        o=new Originator();
        
        toolbar=new myToolBar(this);
        this.add(toolbar,BorderLayout.NORTH);
    }

    public Originator getO() {
        return o;
    }

    public PanelDragedComponentContainer getDragedPanel() {
        return DragedPanel;
    }

    public PanelToDropComponent getDropPanel() {
        return DropPanel;
    }

    public void setDragedPanel(PanelDragedComponentContainer DragedPanel) {
        this.DragedPanel = DragedPanel;
    }

    public void setDropPanel(PanelToDropComponent DropPanel) {
        this.DropPanel = DropPanel;
    }
    
}
