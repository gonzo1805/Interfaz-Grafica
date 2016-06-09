package cr.ac.ucr.ecci.ci1221.FatPusheen.ui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class UI extends JFrame implements ActionListener {

	private Container contenedor, contenedor2;
	JButton btn, btn2, btn3, boton1, boton2;

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("LOL");
	}

	public UI(int i) {
		if (i == 1) {
			contenedor = getContentPane();
			contenedor.setLayout(null);
			// Asigna un titulo a la barra de titulo
			setTitle("Contenedor 1");
			// tamaño de la ventana
			setSize(400, 300);
			// pone la ventana en el Centro de la pantalla
			setLocationRelativeTo(null);

			btn = new JButton("Boton 1");
			btn2 = new JButton("Escogencia");

			btn2.setSize(50, 50);
			btn.setSize(50, 50);
			btn.setBounds(0, 50, 100, 50);
			btn2.setBounds(0, 0, 100, 50);

			btn.setEnabled(true);
			btn2.setEnabled(true);

			add(btn);
			add(btn2);

			btn2.addActionListener(new Acciones());
			btn.addActionListener(new Acciones());
		}
		if (i == 2) {
			contenedor2 = getContentPane();
			contenedor2.setLayout(null);
			// Asigna un titulo a la barra de titulo
			setTitle("Contenedor 2");
			// tamaño de la ventana
			setSize(400, 300);
			// pone la ventana en el Centro de la pantalla
			setLocationRelativeTo(null);

			boton1 = new JButton("Nueva");
			boton2 = new JButton("Regresar");

			boton2.setSize(50, 50);
			boton1.setSize(50, 50);
			boton1.setBounds(0, 50, 100, 50);
			boton2.setBounds(0, 0, 100, 50);

			boton1.setEnabled(true);
			boton2.setEnabled(true);

			contenedor2.add(boton1);
			contenedor2.add(boton2);

			boton2.addActionListener(new Acciones());
			boton1.addActionListener(new Acciones());
		}

	}

	public static void main(String args[]) {
		UI v = new UI(1);
		v.setVisible(true);
	}

	private class Acciones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("TROLL");
			System.out.println(e.getActionCommand());
			if (e.getActionCommand().equals("Escogencia")) {
				System.out.println("Eligio Escogencia");
				UI w = new UI(2);
				w.setVisible(true);
			} else if (e.getActionCommand().equals("Boton")) {
				System.out.println("Eligio boton");
			}

			if (e.getActionCommand().equals("Regresar")) {
				JOptionPane.showConfirmDialog(null, "Mensajito");
			}
		}
	}
}
