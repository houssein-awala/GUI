/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;

import gui.GUIcontrollers.save_load;
import gui.GUImodels.convertToText;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Hussein Awala
 */
public class MyMenu extends JMenuBar{
    private JMenu file;
    private JMenu edit;
    private JMenu about;
    MainFrame f;
    public MyMenu(MainFrame f)
    {
        file=new JMenu("File");
        edit=new JMenu("Edit");
        about=new JMenu("About");
        this.f=f;
        
        JMenuItem save=new JMenuItem("Save");
        ActionListener save_action=new save_load(f, "save");
        save.addActionListener(save_action);
         KeyStroke keyStrokeToSave= KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
        save.setAccelerator(keyStrokeToSave);
        JMenuItem load=new JMenuItem("Load");
        ActionListener load_action=new save_load(f, "load");
        load.addActionListener(load_action);
         KeyStroke keyStrokeToLoad= KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
        load.setAccelerator(keyStrokeToLoad);
        JMenuItem text=new JMenuItem("Text");
         KeyStroke keyStrokeToText= KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_DOWN_MASK);
        text.setAccelerator(keyStrokeToText);
        file.add(save);
        file.add(load);
        file.add(text);
        
        text.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    convertToText.toText(f.getDropPanel());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(MyMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        JMenuItem undo=new JMenuItem("Undo");
        JMenuItem redo=new JMenuItem("Redo");
        edit.add(redo);
        edit.add(undo);
        
        KeyStroke keyStrokeToUndo= KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK);
        undo.setAccelerator(keyStrokeToUndo);
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.getO().undo();
                f.getDropPanel().updateUI();
            }
        });
        
        KeyStroke keyStrokeToRedo= KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK);
        redo.setAccelerator(keyStrokeToRedo);
        redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.getO().redo();
                f.getDropPanel().updateUI();
            }
        });
        
        this.add(file);
        this.add(edit);
        this.add(about);

        
    }
}
