package interfaceGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bd.Bd;
import classesDeObjecto.Candidato;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class RegistoCadidato extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtBi;
	private JTextField txtHistorico;
	private JComboBox cbMuni;
	private String municipio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistoCadidato frame = new RegistoCadidato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistoCadidato() {
		setTitle("Registo Candidado\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 307);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NOME");
		lblNewLabel.setBounds(27, 35, 46, 14);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(101, 32, 202, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("BI");
		lblNewLabel_1.setBounds(27, 75, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		txtBi = new JTextField();
		txtBi.setColumns(10);
		txtBi.setBounds(101, 72, 202, 20);
		contentPane.add(txtBi);
		
		JLabel lblNewLabel_2 = new JLabel("HISTORICO");
		lblNewLabel_2.setBounds(27, 142, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnR = new JButton("REGISTAR");
		btnR.setEnabled(false);
		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Candidato.registoCandidato(txtNome.getText(), txtBi.getText(), txtHistorico.getText(), municipio);
//				Candidato.registoCandidato(txtNome.getText(), txtBi.getText(),txtHistorico.getText(),municipio);
			}
		});
		btnR.setBounds(105, 216, 113, 23);
		contentPane.add(btnR);
		
		JLabel lblNewLabel_1_1 = new JLabel("MUNICIPIO");
		lblNewLabel_1_1.setBounds(27, 108, 80, 14);
		contentPane.add(lblNewLabel_1_1);
		
		cbMuni = new JComboBox();
		cbMuni.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cbMuni.getSelectedItem() != null) {
					btnR.setEnabled(true);
				}
				municipio=cbMuni.getSelectedItem().toString();
			}
		});
		cbMuni.setModel(new DefaultComboBoxModel(Bd.listarMunicipio()));
		cbMuni.setBounds(101, 103, 202, 22);
		contentPane.add(cbMuni);
		
		txtHistorico = new JTextField();
		txtHistorico.setBounds(101, 139, 202, 20);
		contentPane.add(txtHistorico);
		txtHistorico.setColumns(10);
	}
}
