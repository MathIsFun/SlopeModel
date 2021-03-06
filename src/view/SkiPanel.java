package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import main.Main;
import slope.Slope;

/**
 * Place to draw data received from model.
 * @author Kruchy
 *
 */
public class SkiPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Dimension dim;
	public Image image;
	boolean[][] agent;
	int height;
	int width;

	/**
	 * Default constructor.
	 */
	public SkiPanel() {
		super();
		agent = new boolean[Slope.getHeight() + 2][Slope.getWidth() + 2];
		setVisible(true);
	}

	/**
	 * Function to draw given map of agents on the panel.
	 * @param agent Rectangle table of agents on the slope
	 */
	public void drawing(boolean[][] agent) {
		URL url = Main.class.getResource("/doge.png");
		image = new ImageIcon(url).getImage();
		/*
		 * String path = new File("").getAbsolutePath(); image = new
		 * ImageIcon(path + File.pathSeparator + "res" + File.pathSeparator +
		 * "img" + File.pathSeparator + "doge.png").getImage();
		 * System.out.println(image.getHeight(this));
		 */
		this.agent = agent;
		repaint();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.setBackground(Color.white);
		int xDim = (int) (getWidth() / 56);
		int yDim = (int) (getHeight() / 66);
		g2d.drawLine(0, (agent[0].length) * yDim, Slope.getWidth() * xDim,
				(agent[0].length) * yDim);
		g2d.drawRect((Slope.getWidth() - 3) * xDim, 0, 15, Slope.getHeight()
				* yDim);

		for (int k = 0; k < Slope.getHeight(); k++)
			for (int l = 0; l < Slope.getWidth(); l++) {

				g2d.setColor(new Color(0, 0, 0, 1));
				g2d.drawRect(k * getWidth() / 56, l * getHeight() / 66, 30, 30);
			}

		for (int i = 0; i < agent.length; i++) {
			for (int j = 0; j < agent[0].length; j++) {
				g2d.setColor(Color.blue);
				if (agent[i][j]) {
					// g2d.drawString("*", i*getWidth()/56, j*getHeight()/66);
					g2d.drawImage(image, i * getWidth() / 56, j * getHeight()
							/ 66, null);
				}
			}
		}
	}

	
	public Dimension getDim() {
		return dim;
	}

	public void setDimensions(int x, int y) {
		if (dim == null) {
			System.out.println("SET" + x);
			setDim(new Dimension(x, y));
		}
	}

	public void setDim(Dimension dim) {
		this.dim = dim;
	}
}
