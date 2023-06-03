/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import com_decomp.Compressor;
import com_decomp.Decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author likhi
 */
public class AppFrame extends JFrame implements ActionListener{
    
    JButton compressor;
    JButton decompressor;
    JButton button;
    JFrame frame;
    
    public AppFrame(){
        frame = new JFrame("Compressor & Decompressor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        compressor = new JButton("Select file to compress");
        compressor.setBounds(200,280,200,50);
        compressor.addActionListener(this);
        decompressor = new JButton("Select file to decompress");
        decompressor.setBounds(450,280,200,50);
        decompressor.addActionListener(this);

        frame.add(compressor);
        frame.add(decompressor);
        frame.setLayout(null);
//        button = new JButton("Click me!");
//        button.setBounds(20,20,100,30);
//        frame.add(button);
        frame.setSize(900,700);
        frame.setBackground(Color.red);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setVisible(true);  
         
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == compressor){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,e.toString());
                }
            }
        }
        if(e.getSource() == decompressor){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,e.toString());
                }
            }
        }
    }
    
}
