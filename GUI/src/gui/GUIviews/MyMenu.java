/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIviews;

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
    public MyMenu()
    {
        file=new JMenu("File");
        edit=new JMenu("Edit");
        about=new JMenu("About");
        
        JMenuItem undo=new JMenuItem("Undo");
        JMenuItem redo=new JMenuItem("Redo");
        edit.add(redo);
        edit.add(undo);
        
        KeyStroke keyStrokeToUndo= KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK);
        undo.setAccelerator(keyStrokeToUndo);
        undo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("undo");
            }
        });
        
        KeyStroke keyStrokeToRedo= KeyStroke.getKeyStroke(KeyEvent.VK_Y, KeyEvent.CTRL_DOWN_MASK);
        redo.setAccelerator(keyStrokeToRedo);
        redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("redo");
            }
        });
        
        this.add(file);
        this.add(edit);
        this.add(about);

        
    }
}
