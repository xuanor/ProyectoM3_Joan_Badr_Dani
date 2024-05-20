//package GUI;
//import java.awt.BorderLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.Timer;
//import java.util.TimerTask;
//import javax.swing.*;
//
//
//public class TestTimer {
//    private boolean pause = false;
//
//    public static void main(String[] args) {
//        new Ventana();
//    }
//
//}
//
//class Ventana extends JFrame{
//    JPanel panelPrincipal;
//    JLabel etiqueta;
//    JButton pause,resume;
//    Timer timer;
//    TimerTask task;
//    private boolean pauseGame = false;
//
//    Ventana(){
//        setBounds(100, 100, 400, 400);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        initComponents();
//        setVisible(true);
//    }
//    public void initComponents() {
//        panelPrincipal = new JPanel();
//        add(panelPrincipal);
//        panelPrincipal.setLayout(new BorderLayout());
//        etiqueta = new JLabel("", SwingConstants.CENTER);
//        pause = new JButton("Pause");
//        resume = new JButton("Resume");
//        panelPrincipal.add(etiqueta,BorderLayout.SOUTH);
//        panelPrincipal.add(pause,BorderLayout.WEST);
//        panelPrincipal.add(resume,BorderLayout.EAST);
//        etiqueta.setText("1");
//        
//        
//        timer = new Timer();   
//        task = new TimerTask() {
//                
//                public void run() {
//                    if (!pauseGame) {
//                        etiqueta.setText(String.valueOf(Integer.valueOf(etiqueta.getText())+1)  );
//                    }
//                    
//                }
//            };
//         timer.schedule(task,  50, 600);
//         
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
//         
//    }
//    
//}