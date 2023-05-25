package desenho;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

public class Painel1 extends JPanel {

	public Painel1() {
		this.setBackground(Color.white);
	}
	
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(0,0,0));
		g.drawArc(85, 150, 300, 270, 0, 360);
		g.drawArc(130, 220, 70, 70, 0, 360);
		g.fillArc(147, 239, 35, 35, 0, 360);
		g.drawArc(265, 220, 70, 70, 0, 360);
		g.fillArc(283, 239, 35, 35, 0, 360);
		g.drawArc(125, 210, 220, 190, -30, -120);
		g.drawLine(200, 340, 230, 290);
		g.drawLine(260, 340, 230, 290);
		g.drawLine(235, 420, 235, 580);
		g.drawLine(190, 650, 235, 580);
		g.drawLine(235, 580, 275, 650);
		g.drawLine(190, 550, 235, 480);
		g.drawLine(235, 480, 275, 550);
	}
}
