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

    FileOutputStream fileOut;
    ObjectOutputStream out;
    
    public WriteObject() throws FileNotFoundException, IOException{
        fileOut =new FileOutputStream("file.txt");
        out = new ObjectOutputStream(fileOut);
    }
    
    public void serializePanel(JPanel panel) throws FileNotFoundException, IOException
    {
            out.writeObject(panel);
            
            Component[] c=panel.getComponents();
            int l=c.length;
            out.writeObject(l);
            
            for (int i = 0; i < l; i++) {
            if(c[i] instanceof JPanel)
            {
                out.writeObject("JPanel");
                this.serializePanel((JPanel)c[i]);
            }
            else
            {
                out.writeObject(c[i].getClass().getSimpleName());
                out.writeObject(c[i]);
            }
            
          }
            
            
            
            
            out.close();
            fileOut.close();
        
    }
}
