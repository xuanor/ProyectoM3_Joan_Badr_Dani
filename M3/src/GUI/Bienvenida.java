

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
    private JLayeredPane panelFondo;
    private  JPanel panelLogo, panelInfo;
    private JLabel label1,label2, fondoLabel, logoLabel;
    private JButton join;
    private JTextField textfield1;
    public static String texto ="";

    Ventana(){
		// con margenes en el layout (10,10)
		setLayout(new BorderLayout(10,10));
    	setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    	 // Titulo de la ventana
        setTitle("Bienvenido");
        // Icono de la vantana
        setIconImage(new ImageIcon(getClass().getResource("OGamelogopng.png")).getImage());
        initComponents();
        setVisible(true);
    }
    public void initComponents() {
        panelFondo = new JLayeredPane();
        panelLogo = new JPanel();
		panelInfo = new JPanel();
		
		panelFondo.setBackground(Color.red);
		panelLogo.setBackground(Color.black);
		panelInfo.setBackground(Color.gray);
		
//		panelLogo.setOpaque(false);
//		panelInfo.setOpaque(false);
		
		
		panelFondo.setPreferredSize(new Dimension(100,100));
		panelLogo.setPreferredSize(new Dimension(100,100));
		panelInfo.setPreferredSize(new Dimension(30,300));
		
		panelFondo.setLayout(new BorderLayout());
		panelLogo.setLayout(new FlowLayout());
		panelInfo.setLayout(new GridLayout(3,2,10,30));
		
        ImageIcon fondoIcono = new ImageIcon(getClass().getResource("EspacioGif.gif"));
        fondoLabel = new JLabel(fondoIcono);
        fondoLabel.setLayout(new BorderLayout());
        fondoLabel.setOpaque(true);
        
        ImageIcon fotoLogo = new ImageIcon(getClass().getResource("OGamelogopng.png"));
        logoLabel = new JLabel();
        logoLabel.setBounds(50,100,400,300);
        logoLabel.setIcon(fotoLogo);
       
        label1 = new JLabel("Ingrese su nombre");
        label1.setBounds(45,50,50,30);
        label1.setFont(new Font("Andale Mono", 1, 12));
        label1.setForeground(Color.black);
        
//        label2 = new JLabel("Hola mundo");
//        label2.setBounds(45,50,60,50);
//        label2.setFont(new Font("Andale Mono", 1, 12));
//        label2.setForeground(Color.black);
        
        textfield1 = new JTextField ();
        textfield1.setBounds(45,40,55,25);
        textfield1.setBackground(new Color(224,224,224));
        textfield1.setFont(new Font("Andale Mono", 1, 14));
        textfield1.setForeground(new Color(100,100,100));
       
        join = new JButton("Ingresar");
        join.setBounds(25,80,10,30);
        join.setBackground(new Color(255,255,255));
        join.setFont(new Font("Andale Mono", 1, 14));
        join.setForeground(new Color(100,100,100));
        
//        logoLabel.add(label2);
        
        panelInfo.add(label1);
        panelInfo.add(textfield1);
        panelInfo.add(join);
        
        panelLogo.add(logoLabel, BorderLayout.CENTER);
        
        panelFondo.add(fondoLabel, BorderLayout.CENTER);
		panelFondo.add(panelLogo, BorderLayout.NORTH);
		panelFondo.add(panelInfo, BorderLayout.SOUTH);
		
		add(panelFondo);
    
        // Por si quiero que se adapte
//        addComponentListener(new ComponentAdapter() {
//            public void componentResized(ComponentEvent ev) {
//                Image imgFondo = fondoIcono.getImage();
//                fondoLabel.setIcon(new ImageIcon(imgFondo.getScaledInstance(
//                    ev.getComponent().getWidth(),
//                    ev.getComponent().getHeight(),
//                    Image.SCALE_DEFAULT
//                )));
//            }
//        });

       
         
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
