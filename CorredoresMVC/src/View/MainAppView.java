package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractAction;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import Controller.MainController;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MainAppView extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private InicialView iView;
	private CorredoresView cView;
	private JTextField mensajes;

	/**
	 * Create the frame.
	 */
	public MainAppView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//Incorporamos el menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnPantallas = new JMenu("Pantallas");
		menuBar.add(mnPantallas);
		
		JMenuItem mntmInicial = new JMenuItem("Inicial");
		mnPantallas.add(mntmInicial);
		JMenuItem mntmCorredores = new JMenuItem(new AbstractAction("Corredores") {
		    public void actionPerformed(ActionEvent ae) {
		    	MainController.getInstance().showCorredores();
		    }
		});
		mnPantallas.add(mntmCorredores);
		

		//Contenedor de Ventanas
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));
		
		//A�adimos las diferentes ventanas
		iView = new InicialView();
		panel.add(iView,"Inicial");
		cView = new CorredoresView();
		panel.add(cView,"Corredores");
		
		//A�adimos componente de mensajes
		mensajes = new JTextField("Mensajes de ventana");
		contentPane.add(mensajes, BorderLayout.SOUTH);
	}
	
	public void showInicial(ArrayList<String> usuarios){
		this.iView.putUsuarios(usuarios);
	}
	
	public void showCorredores(){
		
	}
	
	public void mensajeInf(String msj){
		mensajes.setText(msj);
	}

}
