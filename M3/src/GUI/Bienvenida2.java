

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Bienvenida2 extends JFrame implements ActionListener{
	  private JPanel panel1;
	  private JTextField textfield1;
	  private JLabel label1, label2, label3, label4;
	  private JButton boton1;
	  // Var comaprtida por las diferentes interfaces
	  public static String texto ="";
	  
	  public Bienvenida2(){
	    setLayout(new BorderLayout());
	    // Cada vez que cierres la ventana el proceso se detendra para no quedan en 2do plano
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    // Titulo de la ventana
	    setTitle("Bienvenido");
	    // Color de fondo
	    getContentPane().setBackground(new Color(0,0,0));
	    // Icono de la vantana
	    setIconImage(new ImageIcon(getClass().getResource("OGamelogopng.png")).getImage());
	    
	    // Meto la otra imagen en un label
	    ImageIcon imagen = new ImageIcon(getClass().getResource("OGamelogopng.png"));
	    label1 = new JLabel();
	    label1.setBounds(125,115,400,150);
	    label1.setIcon(imagen);
	    add(label1);
	
	    label2 = new JLabel("THE SPACE ADVENTURE");
	    label2.setBounds(135,235,300,30);
	    label2.setFont(new Font("Andale Mono", 3, 13));
	    label2.setForeground(new Color(255,255,255));
	    add(label2);
	
	    label3 = new JLabel("Ingrese su nombre");
	    label3.setBounds(145,312,200,30);
	    label3.setFont(new Font("Andale Mono", 1, 12));
	    label3.setForeground(new Color(255,255,255));
	    add(label3);
	
	    label4 = new JLabel("©2024 BUGISOFT");
	    label4.setBounds(100,475,300,30);
	    label4.setFont(new Font("Andale Mono", 1, 12));
	    label4.setForeground(new Color(255,255,255));
	    add(label4, BorderLayout.SOUTH);
	
	    textfield1 = new JTextField ();
	    textfield1.setBounds(145,340,255,25);
	    textfield1.setBackground(new Color(224,224,224));
	    textfield1.setFont(new Font("Andale Mono", 1, 14));
	    textfield1.setForeground(new Color(0,0,0));
	    add(textfield1);
	
	    boton1 = new JButton("Ingresar");
	    boton1.setBounds(125,280,100,30);
	    boton1.setBackground(new Color(255,255,255));
	    boton1.setFont(new Font("Andale Mono", 1, 14));
	    boton1.setForeground(new Color(0,0,0));
	    boton1.addActionListener(this);
	    add(boton1, BorderLayout.LINE_END);
	    
	    
	    
	    setVisible(true);
	  }


	   public void actionPerformed(ActionEvent e){
	     if(e.getSource() == boton1){
	    	 // <.trim(>) es como un <replace(" ","")>
	       texto = textfield1.getText().trim();
	       // No ha escrito nada
	       if (texto.equals("")){
	    	   JOptionPane.showMessageDialog(null, "Debes ingresar tu nombre.");
	       }// Ha escrito su nombre
	       else {
	    	   JOptionPane.showMessageDialog(null, "Proximamente...");
	//    	   // Llamo a la otra interfaz
	//    	   Licencia ventanalicencia = new Licencia();
	//    	   ventanalicencia.setBounds(0,0,610,380);
	//    	   ventanalicencia.setVisible(true);
	//    	   ventanalicencia.setResizable(false);
	//    	   ventanalicencia.setLocationRelativeTo(null);
	//    	   //this.setVisible(false);
	//    	   dispose();
	       }
	     }
   }

	   public static void main(String args[]){
	     Bienvenida2 ventanabienvenida = new Bienvenida2();
	     ventanabienvenida.setBounds(0,0,400,550);
	     ventanabienvenida.setVisible(true);
	     ventanabienvenida.setResizable(false);
	     ventanabienvenida.setLocationRelativeTo(null);
	   }
}
