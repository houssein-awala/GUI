/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.GUIcontrollers;

import javax.swing.JComponent;

/**
 *
 * @author Hussein Awala
 */
public class covertToText {
    public static String s="import javax.swing.* \n"+" public class PROJECT {\n"+" public static void main(String[] args) { \n"+"  Jframe frame=new Jframe();\n"+" frame.setSize(1200, 800);\n" +
"frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);";
    public static void toText(JComponent c)
    {
        System.out.println(s);
        if(c==null)
            return;
        s+="";
    }
}
