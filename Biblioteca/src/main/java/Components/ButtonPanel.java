/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author steve
 */
public class ButtonPanel extends JPanel{
    public JButton btnEdit;
    public JButton btnReturned;
    
    public ButtonPanel(){
        setLayout(new GridLayout(1,2,10,0));
        
        btnEdit = new JButton("Editar");
        btnEdit.setBackground(Color.cyan);
        btnReturned =  new JButton("Entregar");
        btnReturned.setBackground(Color.GREEN);
        
        add(btnEdit);
        add(btnReturned);
    }
}
