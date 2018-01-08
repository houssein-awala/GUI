/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import gui.GUIviews.MainFrame;
import gui.GUIviews.PanelToDropComponent;
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
              //  System.out.println("tst");
               // JFileChooser saveFile = new JFileChooser();
                //int result=saveFile.showSaveDialog(f);
                 //if (result == JFileChooser.APPROVE_OPTION) {
                     
                   //  File file = saveFile.getSelectedFile();
                     
                     try {
                          FileOutputStream fileOut =
                          new FileOutputStream("file.txt");
                            ObjectOutputStream out = new ObjectOutputStream(fileOut);
                            out.writeObject(f.getDropPanel());
                             out.close();
                            fileOut.close();
                           //  System.out.printf("Serialized data is saved in "+file.getPath());
                       } catch (IOException i) {
                          i.printStackTrace();
                       }
                     
                     
              //   }
                     
                
                break;
            }
            case "load":
            {
                System.out.println(action);
                try {
                          FileInputStream fileIn = new FileInputStream("file.txt");
                            ObjectInputStream in = new ObjectInputStream(fileIn);
                            PanelToDropComponent p=(PanelToDropComponent)in.readObject();
                            System.out.println(p);
                            System.out.println(f.getDropPanel());
                            f.setDropPanel(p);
                            
                            f.getDropPanel().updateUI();
                             in.close();
                            fileIn.close();
                             
                       } catch (IOException i) {
                           System.out.println("sss");
                          i.printStackTrace();
                       } catch (ClassNotFoundException ex) {
                           System.out.println("bbb");
                Logger.getLogger(save_load.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }
    }
    
}
