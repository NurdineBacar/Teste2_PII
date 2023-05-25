package desenho;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Janela extends JFrame {
	private JButton btn;
	private JPanel painel;
	public Janela() {
		super("Minha Janela");
		
		this.add(new Painel2());
		this.setBackground(Color.white);
		this.setSize(500,700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		new Janela();	}
}
