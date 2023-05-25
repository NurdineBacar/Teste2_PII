package desenho;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Painel2 extends JPanel{

	public Painel2() {
		this.setBackground(Color.white);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.drawRect(150, 100, 200, 500);
		g.setColor(Color.red);
		g.fillArc(165, 120, 170, 170, 0, 360);
	}
}
