package challenge2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class ConversorDivisas extends JFrame {

	private JPanel contentPane;
	private final JLabel fondo = new JLabel("");
	private JTextField Valor;
	private JLabel lblResultado;
	public String de="USD", a="USD";
	public double conversion,valor;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	

	//METODO PARA CONVERTIR MONEDAS
	
public void convertir() {
		valor = Double.valueOf(Valor.getText());
	
		switch (de) {
		case "USD":
			if (a.equals("EUR")) {
			 conversion = valor *0.91;
			}else if (a.equals("GBP")) {
				conversion = valor *0.78;
			}else if (a.equals("JPY")) {
				conversion = valor *141.01;
			}else if (a.equals("KRW")) {
				conversion = valor *1273.38;
			}else {
				conversion = valor;
			}break;
			
			
	
		case "EUR":
			if (a.equals("USD")) {
			 conversion = valor *1.10;
			}else if (a.equals("GBP")) {
				conversion = valor *0.86;
			}else if (a.equals("JPY")) {
				conversion = valor *155.30;
			}else if (a.equals("KRW")) {
				conversion = valor *1403.91;
			}else {
				conversion = valor;
			}break;
			

		case "GBP":
			if (a.equals("EUR")) {
			 conversion = valor *1.17;
			 }else if (a.equals("USD")) {
				conversion = valor *1.29;	
			}else if (a.equals("JPY")){
				conversion = valor *181.06;
			}else if (a.equals("KRW")) {
				conversion = valor *1636.63;
			}else {
				conversion = valor;
			}break;
			
			
			
		case "JPY":
			if (a.equals("EUR")) {
			 conversion = valor *0.0064;
			 }else if (a.equals("USD")) {
				conversion = valor *0.0071;	
			}else if (a.equals("GBP")){
				conversion = valor *0.0055;
			}else if (a.equals("KRW")) {
				conversion = valor *9.04;
			}else {
				conversion = valor;
			}break;
			
			
		case "KRW":
			if (a.equals("EUR")) {
			 conversion = valor *0.00071;
			 }else if (a.equals("USD")) {
				conversion = valor *0.00079;	
			}else if (a.equals("JPY")){
				conversion = valor *0.11;
			}else if (a.equals("GBP")) {
				conversion = valor *0.00061;
			}else {
				conversion = valor;
			}break;
			
			
		}
		
		
		lblResultado.setText( a +" "+ (String.valueOf(conversion)));
		
}
		
		
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorDivisas frame = new ConversorDivisas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ConversorDivisas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConversorDivisas.class.getResource("/challenge2/imagenes/Logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 539);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConversorTemperatura temp = new ConversorTemperatura();
				temp.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setIcon(new ImageIcon(ConversorDivisas.class.getResource("/challenge2/imagenes/btn-actualizar.png")));
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(24, 423, 50, 50);
		contentPane.add(btnNewButton);
		
		lblNewLabel_1 = new JLabel("by Marlon Franco");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(288, 423, 133, 22);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("Conversor de Divisas");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(229, 27, 204, 47);
		contentPane.add(lblNewLabel);
		
		lblResultado = new JLabel("");
		lblResultado.setForeground(new Color(255, 250, 250));
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setBounds(240, 310, 204, 56);
		contentPane.add(lblResultado);
		
		JComboBox divisa2 = new JComboBox();
		divisa2.setBackground(new Color(173, 255, 47));
		divisa2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = divisa2.getSelectedItem().toString();
				convertir();
			}
		});
		divisa2.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		divisa2.setModel(new DefaultComboBoxModel(new String[] {"USD", "EUR", "GBP", "JPY", "KRW"}));
		divisa2.setBounds(448, 145, 67, 47);
		contentPane.add(divisa2);
		
		JComboBox divisa1 = new JComboBox();
		divisa1.setBackground(new Color(173, 255, 47));
		divisa1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				de= divisa1.getSelectedItem().toString();
				
				convertir();
			}
		});
		divisa1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		divisa1.setModel(new DefaultComboBoxModel(new String[] {"USD", "EUR", "GBP", "JPY", "KRW"}));
		divisa1.setBounds(139, 145, 67, 47);
		contentPane.add(divisa1);
		
		Valor = new JTextField();
		Valor.setForeground(new Color(0, 102, 0));
		Valor.setFont(new Font("Tahoma", Font.BOLD, 18));
		Valor.setHorizontalAlignment(SwingConstants.CENTER);
		Valor.setBounds(206, 145, 243, 47);
		contentPane.add(Valor);
		Valor.setColumns(10);
		fondo.setBounds(0, 0, 650, 500);
		contentPane.add(fondo);
	}
}
