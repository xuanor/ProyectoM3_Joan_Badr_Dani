package GUI;

import javax.swing.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;

public class Bienvenida {


    public static void main(String[] args) {
        new Ventana();
    }

}
class Ventana extends JFrame{
    private JPanel panelPrincipal;
    private JLabel etiqueta;
    private JButton join;
    private JTextField textfield1;
    public static String texto ="";

    Ventana(){
    	setBounds(100, 100, 400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    	 // Titulo de la ventana
        setTitle("Bienvenido");
        // Color de fondo
        getContentPane().setBackground(new Color(255,0,0));
        // Icono de la vantana
        setIconImage(new ImageIcon(getClass().getResource("OGamelogopng.png")).getImage());
        //initComponents();
        setVisible(true);
    }
    public void initComponents() {
        panelPrincipal = new JPanel();
        add(panelPrincipal);
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.add(etiqueta,BorderLayout.SOUTH);
        etiqueta.setText("Introduce tu nombre:");
        
        
        
       
         
//         pause.addActionListener(new ActionListener() {
//            
//            public void actionPerformed(ActionEvent arg0) {
//                pauseGame  = true;
//                
//            }
//        });
//         resume.addActionListener(new ActionListener() {
//            
//             
//            public void actionPerformed(ActionEvent arg0) {
//                pauseGame  = false;
//                
//            }
//        });
         
    }
}
