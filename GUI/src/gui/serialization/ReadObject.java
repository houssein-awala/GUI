/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.serialization;

import gui.GUIcontrollers.MoveComponent;
import gui.GUIviews.MainFrame;
import gui.GUIviews.PanelToDropComponent;
import java.awt.Panel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Hussein Awala
 */
public class ReadObject {
    FileInputStream fileIn;
    ObjectInputStream in;
    MainFrame f;
    public ReadObject(MainFrame f) {
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream("file.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            this.f=f;
            System.out.println("ssssssssssssssssssssss");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadObject.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadObject.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileIn.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadObject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public JPanel deserializePanel() throws IOException, ClassNotFoundException
    {
        JPanel p=(JPanel)in.readObject();
        int l=(Integer)in.readObject();
        for (int i = 0; i < l; i++) {
            String c=(String)in.readObject();
            JComponent component=null;
            switch(c)
            {
                case "JButton":
                {
                    component=(JButton)in.readObject();
                    component.addMouseListener(new MoveComponent(f,component));
                    component.addMouseMotionListener(new MoveComponent(f,component));
                    p.add(component);
                    break;
                }
                case "JLabel":
                {
                    component=(JLabel)in.readObject();
                    component.addMouseListener(new MoveComponent(f,component));
                    component.addMouseMotionListener(new MoveComponent(f,component));
                    p.add(component);
                    break;
                }
                case "JTextField":
                {
                    component=(JTextField)in.readObject();
                    component.addMouseListener(new MoveComponent(f,component));
                    component.addMouseMotionListener(new MoveComponent(f,component));
                    p.add(component);
                    break;
                }
                case "JPanel":
                {
                    component=this.deserializePanel();
                    component.addMouseListener(new MoveComponent(f,component));
                    component.addMouseMotionListener(new MoveComponent(f,component));
                    p.add(component);
                    break;
                }
            }
            
        }
        
        return p;
    }
    public PanelToDropComponent deserialize() throws IOException, ClassNotFoundException
    {
        PanelToDropComponent p=(PanelToDropComponent)in.readObject();
        int l=(Integer)in.readObject();
        for (int i = 0; i < l; i++) {
            String c=(String)in.readObject();
            JComponent component=null;
            switch(c)
            {
                case "JButton":
                {
                    component=(JButton)in.readObject();
                    component.addMouseListener(new MoveComponent(f,component));
                    component.addMouseMotionListener(new MoveComponent(f,component));
                    p.add(component);
                    break;
                }
                case "JLabel":
                {
                    component=(JLabel)in.readObject();
                    component.addMouseListener(new MoveComponent(f,component));
                    component.addMouseMotionListener(new MoveComponent(f,component));
                    p.add(component);
                    break;
                }
                case "JTextField":
                {
                    component=(JTextField)in.readObject();
                    component.addMouseListener(new MoveComponent(f,component));
                    component.addMouseMotionListener(new MoveComponent(f,component));
                    p.add(component);
                    break;
                }
                case "JPanel":
                {
                    component=this.deserializePanel();
                    component.addMouseListener(new MoveComponent(f,component));
                    component.addMouseMotionListener(new MoveComponent(f,component));
                    p.add(component);
                    break;
                }
            }
            
        }
        
        return p;
    }
}
