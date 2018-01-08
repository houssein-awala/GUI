/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;

import gui.GUIcontrollers.save_load;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
        
        JMenuItem load=new JMenuItem("Load");
        ActionListener load_action=new save_load(f, "load");
        load.addActionListener(load_action);
        
        file.add(save);
        file.add(load);
        
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
