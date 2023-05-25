package interfaceGrafica;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bd.Bd;
import classesDeObjecto.Candidato;
import classesDeObjecto.Voto;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class InterfacaeVtoMunicipio extends JFrame {

	private JPanel contentPane;
	private JTable tabelaCadidato;
	private JTable tabelaMunicipio;
	private JComboBox cbCandidato;
	private String voto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfacaeVtoMunicipio frame = new InterfacaeVtoMunicipio();
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
	public InterfacaeVtoMunicipio() {
		setTitle("Voto");
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 501);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cbMuni = new JComboBox();
		cbMuni.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String muni= cbMuni.getSelectedItem()+"";
				if(cbMuni.getSelectedItem()!= null) {
					cbCandidato.setModel(new DefaultComboBoxModel(Bd.listarCandidatosFiltro(muni)));
				}
			}
		});
		cbMuni.setModel(new DefaultComboBoxModel(Bd.listarMunicipio()));
		cbMuni.setBounds(134, 29, 319, 22);
		contentPane.add(cbMuni);
		
		JLabel lblNewLabel = new JLabel("MUNICIPIO DE: ");
		lblNewLabel.setBounds(27, 33, 97, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CADIDATO: ");
		lblNewLabel_1.setBounds(27, 77, 83, 14);
		contentPane.add(lblNewLabel_1);
		
		cbCandidato = new JComboBox();
		cbCandidato.setModel(new DefaultComboBoxModel(Bd.listarCandidatos()));
		cbCandidato.setBounds(134, 73, 319, 22);
		
		contentPane.add(cbCandidato);
		
		JButton btnNewButton = new JButton("VOTAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index=cbCandidato.getSelectedIndex();
				int codigo=0;
				ArrayList<Candidato> cand= Bd.lerCandidato();
				for(int i=0;i<cand.size();i++) {
					if(index==i) {
						codigo=cand.get(index).getCodigo();
					}
				}
				
				tabelaCadidato.setModel(new DefaultTableModel(
						Bd.tabelaCandidato(),
						new String[] {
							"#", "NOME", "BI", "HISTORICO", "VOTOS"
						}
					));
				
				Voto.registarVoto(codigo, "voto");
			}
		});
		btnNewButton.setBounds(309, 124, 144, 33);
		contentPane.add(btnNewButton);
		
		JButton btnVotoBranco = new JButton("VOTO BRANCO");
		btnVotoBranco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String muni=cbMuni.getSelectedItem()+"";
				Voto.votoBranco(muni);
				tabelaMunicipio.setModel(new DefaultTableModel(
						Bd.tabelaMunicipio(),
						new String[] {
							"#", "MUNICIPIO", "DESCRICAO", "PROVINCIA", "QUANTIDADE DE RECENCIADOS", "VOTOS BRANCOS"
						}
					));
					
			}
		});
		btnVotoBranco.setBounds(134, 124, 144, 33);
		contentPane.add(btnVotoBranco);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 168, 471, 131);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		tabelaCadidato = new JTable();
		scrollPane.setViewportView(tabelaCadidato);
		tabelaCadidato.setModel(new DefaultTableModel(
			Bd.tabelaCandidato(),
			new String[] {
				"#", "NOME", "BI", "HISTORICO", "VOTOS"
			}
		));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 310, 471, 138);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		
		tabelaMunicipio = new JTable();
		scrollPane_1.setViewportView(tabelaMunicipio);
		tabelaMunicipio.setModel(new DefaultTableModel(
			Bd.tabelaMunicipio(),
			new String[] {
				"#", "MUNICIPIO", "DESCRICAO", "PROVINCIA", "QUANTIDADE DE RECENCIADOS", "VOTOS BRANCOS"
			}
		));
		
		JButton btnCand = new JButton("Candidatos");
		btnCand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistoCadidato a=new RegistoCadidato();
				a.setVisible(true);
			}
		});
		btnCand.setBounds(0, -1, 89, 23);
		contentPane.add(btnCand);
	}
}
