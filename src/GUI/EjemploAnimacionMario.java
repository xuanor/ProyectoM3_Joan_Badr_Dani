package graphicGames.AnimacionMario;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class EjemploAnimacionMario extends JFrame implements ActionListener{

	
	private JPanel panel1;

	public EjemploAnimacionMario() {
		initJFrame();
		//initPanel();
	}

	private void initJFrame() {
		setTitle("Ejemplo Gráficos 1");
		setSize(800, 600);
		//setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		initPanel();
		setVisible(true);
	}

	private void initPanel() {
		
		//panel = (JPanel) getContentPane();
		panel1 = new JPanel(); // Inicializo panel
		
		JButton boton1 = new JButton("Start");
		JButton boton2 = new JButton("Stop");
		JButton boton3 = new JButton("Pause");
		JButton boton4 = new JButton("Resume");
		
		panel1.add(boton1);
		panel1.add(boton2);
		panel1.add(boton3);
		panel1.add(boton4);
		
		//add(panel1,BorderLayout.NORTH); // Lo añado al JFrame
		add(panel1,BorderLayout.SOUTH);
		//add(panel3,BorderLayout.CENTER);

		System.out.println("Iniciamos panel");
		
		Border bordePaneles = BorderFactory.createLineBorder(Color.black);
		panel1.setBorder(bordePaneles);

		Animacion an = new Animacion();
		
		add(an,BorderLayout.CENTER);
		
		boton1.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) {
		        an.start();
		        System.out.println("boton start clicado");
		    }
		});
		boton2.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) {
		        an.stop();
		        System.out.println("boton stop clicado");
		    }
		});
		boton3.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) {
		        an.pause();
		        System.out.println("boton pause clicado");
		    }
		});
		boton4.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) {
		        an.resume();
		        System.out.println("boton resume clicado");
		    }
		});
		
		
	}
	
	
	public static void main(String[] args) {
		new EjemploAnimacionMario();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}



class Animacion extends JPanel{
	
    int despHorizontal;
    int indiceImagen;    
    private ArrayList<BufferedImage> frames ;
    private volatile boolean running = false;
    private int frameAtPause, currentframe;
	
    Animacion(){

    	frames = new ArrayList<BufferedImage>();
		setSize(150,100);
		setVisible(true);
		
		// cargamos cada una de las imagenes en nuestro arrayList
		for (int i = 1; i < 6; i++) {
			try {
				frames.add(ImageIO.read(new File("img"+i+".png")));
			} catch (IOException e) {
				System.out.println("problemas cargando"+"img"+i+".png");
				e.printStackTrace();
			}
		}
		
		// Creamos un objeto de la clase Timer para programar una tarea
		Timer tt = new Timer();
		
		// Creamos un objeto de la clase TimerTask para definir la tarea en el método run
		TimerTask deplazamiento = new TimerTask() {

			public void run() {
				if (running) {
					//System.out.println("run del timertask, despHorizontal ="+despHorizontal);
					// Desplazamos la imagen 20 pixeles
					despHorizontal = despHorizontal+20;
					// escogemos la imagen (indiceImagen+1)%5
					currentframe = (currentframe+1)%5;
					// forzamos llamada al método paint				
					repaint();
				}
			}
		};
		// programamos la tarea
		tt.schedule(deplazamiento, 10, 100);
	}
    public void start() {
		running = true;
		//previousTime = 0;
		frameAtPause = 0;
		currentframe = 0;
	}

	public void stop() {
		running = false;
		//previousTime = 0;
		frameAtPause = 0;
		currentframe = 0;
		despHorizontal = 0;
	}

	public void pause() {
		frameAtPause = currentframe;
		running = false;

	}

	public void resume() {
		currentframe = frameAtPause;
		running = true;

	}
	// Como nuestra clase extiende de JPanel, podemos redefinir el método paint 
	public void paint(Graphics g) {
		// llamamos al método paint de la clase super para refrescar pantalla
		super.paint(g);
		// Creamos un objeto de la clase Graphics2D para poder pintar la imagen
		Graphics2D g2d = (Graphics2D) g;
		// pintamos la imagen en la posición desplazamiento horizontal ( x ) , posicion vertical y decimos quien es el objeto Observer

		if (despHorizontal >= this.getWidth()) {
			despHorizontal = 0-frames.get(0).getWidth(this);
		}
		
		//System.out.println("anchoImagen = "+anchoImagen);
		g2d.drawImage(frames.get(currentframe), despHorizontal, 100, this);

	}
}
