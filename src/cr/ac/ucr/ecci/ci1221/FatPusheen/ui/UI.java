package cr.ac.ucr.ecci.ci1221.FatPusheen.ui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class UI extends JFrame implements ActionListener {

	private JFrame contenedor, contenedor2;
	JButton queue, stack, tree, set, map, list;

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("LOL");
	}

	public UI(int i) {
		if (i == 1) {
												
			contenedor = new JFrame();
			setLayout(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			// Asigna un titulo a la barra de titulo
			setTitle("Modelos");
			// tamaño de la ventana
			setSize(400, 350);
			// pone la ventana en el Centro de la pantalla
			setLocationRelativeTo(null);
			
			queue = new JButton();
			stack = new JButton();
			tree = new JButton();
			set = new JButton();
			map = new JButton();
			list = new JButton();
			
			queue.setText("Queue");
			stack.setText("Stack");
			tree.setText("Tree");
			set.setText("Set");
			map.setText("Map");
			list.setText("List");
			
			queue.setSize(50, 50);
			stack.setSize(50, 50);
			tree.setSize(50, 50);
			set.setSize(50, 50);
			map.setSize(50, 50);
			list.setSize(50, 50);
			
			queue.setBounds(0, 0, 100, 50);
			stack.setBounds(0, 50, 100, 50);
			tree.setBounds(0, 100, 100, 50);
			set.setBounds(0, 150, 100, 50);
			map.setBounds(0, 200, 100, 50);
			list.setBounds(0, 250, 100, 50);
					
			contenedor.add(queue);
			contenedor.add(stack);
			contenedor.add(tree);
			contenedor.add(set);
			contenedor.add(map);
			contenedor.add(list);
			
			
			
			
			/*JDialog escrito = new JDialog();
			
			contenedor.add(escrito);
			escrito.setBounds(200, 200, 100, 100);*/
			
		}
		/*if (i == 2) {
			contenedor2 = getContentPane();
			contenedor2.setLayout(null);
			// Asigna un titulo a la barra de titulo
			setTitle("Contenedor 2");
			// tamaño de la ventana
			setSize(400, 300);
			// pone la ventana en el Centro de la pantalla
			setLocationRelativeTo(null);

			
		}*/

	}

	public static void main(String args[]) {
		UI v = new UI(1);
		v.setVisible(true);
	}

	private class Acciones implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("...");
			System.out.println(e.getActionCommand());
			if (e.getActionCommand().equals("Queue")) {
				JDialog escrito = new JDialog();
				escrito.setTitle("Estructuras de queue");
				contenedor.add(escrito);
				
				
			} else if (e.getActionCommand().equals("Boton")) {
				System.out.println("Eligio boton");
			}

			if (e.getActionCommand().equals("Regresar")) {
				JOptionPane.showConfirmDialog(null, "Mensajito");
			}
		}
	}
}
