package challenge2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Window.Type;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class ConversorTemperatura extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;
	private JComboBox cboDe;
	private JLabel lblResultado;
	public String de,a;
	public double temperatura, valor;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JLabel lblNewLabel_1;
	
	// metodo para convertir grados
	
	public void convetirTemperatura(){
		valor = Double.valueOf((txtValor.getText()));
		
		switch (de) {
		case "Fahrenheit":
			if(a.equals("Celsius")) {
				temperatura = (valor - 32)* 5/9;  
				
			}else if(a.equals("Kelvin")){
				temperatura = (valor -32) *5/9 +273.15; 
			}else{
				temperatura = valor;
			}break;
			
		case "Celsius":
			if(a.equals("Fahrenheit")) {
				temperatura = (valor * 5/9) + 32 ;  
			}else if(a.equals("Kelvin")){
				temperatura = valor + 273.15;    
			}else{
				temperatura = valor;
			}break;
			
		case "Kelvin":
			if(a.equals("Celsius")) {
				temperatura = (valor - 273.15);  
			}else if(a.equals("Fahrenheit")){
				temperatura = (valor -273.15) * 9/5 +32;
			}else{
				temperatura = valor;
			}break;
		}
		
		lblResultado.setText(String.valueOf(temperatura).toString());
	}
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConversorTemperatura frame = new ConversorTemperatura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ConversorTemperatura() {
		setLocationRelativeTo(this);
		setBackground(new Color(0, 255, 102));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConversorTemperatura.class.getResource("/challenge2/imagenes/Logo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 539);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setDefaultLocale(null);
		
		btnNewButton = new JButton("");
		btnNewButton.setOpaque(false);
		btnNewButton.setBorder(null);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConversorDivisas inicio = new ConversorDivisas();
				inicio.setVisible(true);
				dispose();
				
				
			}
		});
		
		lblNewLabel_1 = new JLabel("Conversor de Temperatura");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(188, 28, 273, 47);
		contentPane.add(lblNewLabel_1);
		btnNewButton.setIcon(new ImageIcon(ConversorTemperatura.class.getResource("/challenge2/imagenes/divisa.png")));
		btnNewButton.setBounds(33, 419, 50, 50);
		contentPane.add(btnNewButton);
		lblNewLabel = new JLabel("by Marlon Franco");
		lblNewLabel.setForeground(new Color(176, 196, 222));
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setBounds(285, 451, 111, 27);
		contentPane.add(lblNewLabel);
		
		txtValor = new JTextField();
		txtValor.setForeground(Color.WHITE);
		txtValor.setFont(new Font("Arial", Font.BOLD, 18));
		txtValor.setHorizontalAlignment(SwingConstants.CENTER);
		txtValor.setBounds(188, 165, 273, 47);
		Border border = BorderFactory.createLineBorder(Color.GREEN, 2);
		txtValor.setBorder(border);
		txtValor.setOpaque(false);
		txtValor.setBackground(Color.GREEN);
		contentPane.add(txtValor); 
		txtValor.setColumns(10);
		
		lblResultado = new JLabel("");
		lblResultado.setForeground(Color.WHITE);
		lblResultado.setBackground(new Color(255, 255, 255));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblResultado.setBounds(143, 297, 378, 87);
		contentPane.add(lblResultado);
		
		JComboBox cboA = new JComboBox();
		cboA.setForeground(new Color(25, 25, 112));
		cboA.setBackground(Color.GREEN);
		cboA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				de = cboDe.getSelectedItem().toString();
				a = cboA.getSelectedItem().toString();
				convetirTemperatura();
			}
			
			
			
			
		});
		cboA.setFont(new Font("Tahoma", Font.BOLD, 16));
		cboA.setBackground(Color.GREEN);
		cboA.setModel(new DefaultComboBoxModel(new String[] {"Fahrenheit", "Celsius", "Kelvin"}));
		cboA.setBounds(461, 165, 120, 47);
		contentPane.add(cboA);
		
		cboDe = new JComboBox();
		cboDe.setForeground(new Color(25, 25, 112));
		cboDe.setBackground(Color.GREEN);
		cboDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				a = cboA.getSelectedItem().toString();
				de = cboDe.getSelectedItem().toString();
				convetirTemperatura();
				
			}
		});
		cboDe.setFont(new Font("Tahoma", Font.BOLD, 16));
		cboDe.setModel(new DefaultComboBoxModel(new String[] {"Fahrenheit", "Celsius", "Kelvin"}));
		cboDe.setBounds(68, 165, 120, 47);
		contentPane.add(cboDe);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 650, 500);
		contentPane.add(lblFondo);
	}
}
