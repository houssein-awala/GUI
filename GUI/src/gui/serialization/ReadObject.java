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

    public PanelToDropComponent deserialize() throws IOException, ClassNotFoundException
    {
     
        FileInputStream fileIn = null;
        try {
            fileIn = new FileInputStream("file.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            PanelToDropComponent p=(PanelToDropComponent)(in.readObject());
            
            return p;
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
        return null;
    }
}
