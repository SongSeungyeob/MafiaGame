package co.sy.prj.JFrame;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class JFrameExe extends JFrame{
	private ImageIcon icon = new ImageIcon(".\\Image\\MainMafia.png");
	
	public JFrameExe() {
		setTitle("MAFIA Game.exe");
		setSize(700, 700);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		
		JButton b1 = new JButton("GAME RULE");
		JButton b2 = new JButton("GAME START");
		container.add(b1);
		container.add(b2);
		setVisible(true);
	}
	
	public void paint(Graphics g) {
		g.drawImage(icon.getImage(), 0, 0, null);
	}
}
