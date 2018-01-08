/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import gui.GUIviews.MainFrame;
import gui.GUIviews.PanelToDropComponent;
import gui.serialization.ReadObject;
import gui.serialization.WriteObject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Hussein Awala
 */
public class save_load implements ActionListener{

    String action;
    MainFrame f;

    public save_load(MainFrame f,String action) {
        this.action = action;
        this.f=f;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(action);
        switch(action)
        {
            case "save":
            {
            try {
                WriteObject w=new WriteObject();
                w.serializePanel(f.getDropPanel());
            } catch (IOException ex) {
                Logger.getLogger(save_load.class.getName()).log(Level.SEVERE, null, ex);
            }
                
                break;
            }
            case "load":
            {
            try {
                ReadObject r=new ReadObject(f);
                f.setDropPanel((PanelToDropComponent)r.deserialize());
            } catch (IOException ex) {
                Logger.getLogger(save_load.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(save_load.class.getName()).log(Level.SEVERE, null, ex);
            }
                break;
            }
            }
        }
    }
    

