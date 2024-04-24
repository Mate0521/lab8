package calendario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FCalendario extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Calendario calendario;
	private JPanel pSeleccion;
	private JPanel pMes;
	private JLabel lMes;
	private JLabel lAno;
	private JTextField tMes;
	private JTextField tAno;
	private JButton bMostrar;
	
	private JButton bDias[][] = new JButton[6][7];
	

	public FCalendario() {
		this.calendario = new Calendario();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Calendario POO");
		this.setSize (800, 600);
		this.setLayout(new BorderLayout());
		
		this.pSeleccion = new JPanel();
		this.add(this.pSeleccion, BorderLayout.NORTH);
		this.pSeleccion.setLayout(new FlowLayout());
		
		this.pMes = new JPanel();
		this.add(this.pMes, BorderLayout.CENTER);
		this.pMes.setLayout(new GridLayout(6,7));
		
		this.lMes = new JLabel("Mes");
		this.lAno = new JLabel("Año");
		this.tMes = new JTextField("4");
		this.tAno = new JTextField("2024");
		
		this.bMostrar = new JButton("Mostrar");
		this.bMostrar.addActionListener(this);
		
		this.pSeleccion.add(this.lMes);
		this.pSeleccion.add(this.tMes);
		this.pSeleccion.add(this.lAno);
		this.pSeleccion.add(this.tAno);
		this.pSeleccion.add(this.bMostrar);
		
		for(int i=0; i<6; i++) {
			for(int j=0; j<7; j++) {
				this.bDias[i][j] = new JButton();
				this.pMes.add(this.bDias[i][j]);
				this.bDias[i][j].addActionListener(this);
			}
		}
		this.setVisible(true);
		this.mostrarCalendario();
	}
	
	public static void main(String[] args) {
		new FCalendario();
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource() == this.bMostrar) {
			this.mostrarCalendario();
		}else {
			JButton botonOprimido = (JButton)e.getSource();
			String dia = botonOprimido.getText();
			if(dia.length() == 1) {
				dia = "0" + dia;
			}
			String mes = this.tMes.getText();
			if(mes.length() == 1) {
				mes = "0" + mes;
			}			
			String fecha = this.tAno.getText() + "-" + mes + "-" + dia;
			
			String mensaje = "Fecha: " + fecha + "\n";
			if(this.calendario.getEventos().containsKey(fecha)) {
				mensaje += "Evento: " + this.calendario.getEventos().get(fecha).getDescripcion();	
			}else {
				mensaje += "No hay envento";
			}
			
			JOptionPane.showMessageDialog(this, mensaje, "Lista de eventos", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@SuppressWarnings("deprecation")
	public void mostrarCalendario() {
		Calendar cal = Calendar.getInstance();
	    cal.setTime(new Date(Integer.valueOf(this.tAno.getText())-1900, Integer.valueOf(this.tMes.getText())-1, 1));
	    int diaDeSemana = cal.get(Calendar.DAY_OF_WEEK) - 1;
	    int ultimoDia = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		boolean imprimir = false;
		int dia = 1;
		for(int i=0; i<6; i++) {
			for(int j=0; j<7; j++) {
				if(dia==1 && j==diaDeSemana) {
					imprimir = true;
				}
				if(imprimir) {
					this.bDias[i][j].setEnabled(true);
					this.bDias[i][j].setText(String.valueOf(dia));
					dia++;
				}else {
					this.bDias[i][j].setEnabled(false);
					this.bDias[i][j].setText("");
				}
				if(ultimoDia == dia-1) {
					imprimir = false;
				}
			}
		}
	}
}
