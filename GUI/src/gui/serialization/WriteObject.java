/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.serialization;

import static gui.GUIcontrollers.deleteComponent.f;
import gui.GUIviews.PanelToDropComponent;
import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.JPanel;

/**
 *
 * @author Hussein Awala
 */
public class WriteObject {

   
    public void serializePanel(JPanel panel) throws FileNotFoundException, IOException
    {
        
    FileOutputStream fileOut=new FileOutputStream("file.txt");
    ObjectOutputStream out= new ObjectOutputStream(fileOut);
    out.writeObject((PanelToDropComponent)panel);
    out.close();
    fileOut.close(); 
    }
}
