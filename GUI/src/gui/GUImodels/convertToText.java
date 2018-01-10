/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUImodels;

import gui.GUIviews.PanelToDropComponent;
import java.awt.Component;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Hussein Awala
 */
public class convertToText {
    public static String s="";
    
    public static void PanelToText(JPanel p)
    {
        Component[] c=p.getComponents();
        for (int i = 0; i < c.length; i++) {
            
            switch(c[i].getClass().getSimpleName())
            {
                case "JButton":
                {
                    JButton x=(JButton)c[i];
                    s+="JButton "+x.getName()+"= new JButton("+x.getText()+");\n";
                    s+=x.getName()+".setBounds("+x.getX()+","+x.getY()+","+x.getWidth()+","+x.getHeight()+");\n";
                    s+=p.getName()+".add("+x.getName()+");\n";
                    break;
                }
                case "JLabel":
                {
                    JLabel x=(JLabel)c[i];
                    s+="JLabel "+x.getName()+"= new JLabel("+x.getText()+");\n";
                    s+=x.getName()+".setBounds("+x.getX()+","+x.getY()+","+x.getWidth()+","+x.getHeight()+");\n";
                    s+=p.getName()+".add("+x.getName()+");\n";
                    break;
                }
                case "JTextField":
                {
                    JTextField x=(JTextField)c[i];
                    s+="JTextField "+x.getName()+"= new JTextField("+x.getText()+");\n";
                    s+=x.getName()+".setBounds("+x.getX()+","+x.getY()+","+x.getWidth()+","+x.getHeight()+");\n";
                    s+=p.getName()+".add("+x.getName()+");\n";
                    break;
                }
                case "JPanel":
                {
                    JPanel x=(JPanel)c[i];
                    s+="JPanel "+x.getName()+"= new JPanel();\n";
                    s+=x.getName()+".setBounds("+x.getX()+","+x.getY()+","+x.getWidth()+","+x.getHeight()+");\n";
                    s+=p.getName()+".add("+x.getName()+");\n";
                    PanelToText(x);
                    break;
                }
            }
        }
    }
    public static void toText(PanelToDropComponent p) throws FileNotFoundException
    {
        s="import javax.swing.* \n"+"import javax.util.* \n"+" public class PROJECT {\n"+" public static void main(String[] args) { \n"+"  Jframe frame=new Jframe();\n"+" frame.setSize(1200, 800);\n" +
"frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); \n"+"frame.show(); \n";
        Component[] c=p.getComponents();
        for (int i = 0; i < c.length; i++) {
            
            switch(c[i].getClass().getSimpleName())
            {
                case "JButton":
                {
                    JButton x=(JButton)c[i];
                    s+="JButton "+x.getName()+"= new JButton("+x.getText()+");\n";
                    s+=x.getName()+".setBounds("+x.getX()+","+x.getY()+","+x.getWidth()+","+x.getHeight()+");\n";
                    s+="frame.add("+x.getName()+");\n";
                    break;
                }
                case "JLabel":
                {
                    JLabel x=(JLabel)c[i];
                    s+="JLabel "+x.getName()+"= new JLabel("+x.getText()+");\n";
                    s+=x.getName()+".setBounds("+x.getX()+","+x.getY()+","+x.getWidth()+","+x.getHeight()+");\n";
                    s+="frame.add("+x.getName()+");\n";
                    break;
                }
                case "JTextField":
                {
                    JTextField x=(JTextField)c[i];
                    s+="JTextField "+x.getName()+"= new JTextField("+x.getText()+");\n";
                    s+=x.getName()+".setBounds("+x.getX()+","+x.getY()+","+x.getWidth()+","+x.getHeight()+");\n";
                    s+="frame.add("+x.getName()+");\n";
                    break;
                }
                case "JPanel":
                {
                    JPanel x=(JPanel)c[i];
                    s+="JPanel "+x.getName()+"= new JPanel();\n";
                    s+=x.getName()+".setBounds("+x.getX()+","+x.getY()+","+x.getWidth()+","+x.getHeight()+");\n";
                    s+="frame.add("+x.getName()+");\n";
                    PanelToText(x);
                    break;
                }
            }
            
        }
   
        
        
        s+="}}";
    BufferedWriter writer = null;
try
{
    writer = new BufferedWriter( new FileWriter( "file.java"));
    writer.write( s);

}
catch ( IOException e)
{
}
finally
{
    try
    {
        if ( writer != null)
        writer.close( );
    }
    catch ( IOException e)
    {
    }
}
    }
}
