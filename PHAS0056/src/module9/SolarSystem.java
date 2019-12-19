package module9;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.Color;

public class SolarSystem extends JPanel implements ActionListener  {

	public int sunRad;
	public int earthRad;
	public int marsRad;
	public int jupiterRad;
	public int venusRad;
	public int mercuryRad;
	public int saturnRad;
	
	public int earthOrbRad;
	public int marsOrbRad;
	public int jupiterOrbRad;
	public int venusOrbRad;
	public int mercuryOrbRad;
	public int saturnOrbRad;
	public Location centreOfRotation;
	
	public double earthPeriod;
	public double marsPeriod;
	public double jupiterPeriod;
	public double venusPeriod;
	public double mercuryPeriod;
	public double saturnPeriod;
	
	ArrayList<Planet> planets;
	public Planet earth;
	
	public static final int delay = 25;
	public Timer timer;
	
	Location centreOfOrbit = new Location(500,500);
	
	public SolarSystem (int width, int height) {
		
		setPreferredSize(new Dimension(width,height));
		timer = new Timer(delay, this);
		timer.start();
		
		earthPeriod = 10;
		marsPeriod = 19;
		jupiterPeriod = 12;
		venusPeriod = 6;
		mercuryPeriod = 2.5;
		saturnPeriod = 29;
		
		sunRad = 30;
		earthOrbRad = 140;
		marsOrbRad = 70;
		jupiterOrbRad = 250;
		venusOrbRad = 100;
		mercuryOrbRad = 55;
		saturnOrbRad = 400;
		
		earthRad = 10;
		marsRad = 6;
		jupiterRad = 25;
		venusRad = 10;
		mercuryRad = 4;
		saturnRad = 20;
		
		centreOfOrbit = new Location(500,500);
		
		Planet earth = new Planet("Earth", earthOrbRad, earthPeriod, Color.blue, earthRad, centreOfOrbit);
		Planet mars = new Planet("Mars", marsOrbRad, marsPeriod, Color.red, marsRad, centreOfOrbit);
		Planet jupiter = new Planet("Jupiter", jupiterOrbRad, jupiterPeriod, Color.gray, jupiterRad, centreOfOrbit);
		Planet venus = new Planet("Venus", venusOrbRad, venusPeriod, Color.cyan, venusRad, centreOfOrbit);
		Planet mercury = new Planet("Mercury", mercuryOrbRad, mercuryPeriod, Color.darkGray, mercuryRad, centreOfOrbit);
		Planet saturn = new Planet("Saturn", saturnOrbRad, saturnPeriod, Color.orange, saturnRad, centreOfOrbit);
	
		planets = new ArrayList<Planet>();
		
		planets.add(earth);
		planets.add(mars);
		planets.add(jupiter);
		planets.add(venus);
		planets.add(mercury);
		planets.add(saturn);
	
	}
		
		public void start() {
			timer.start();
		}
	
		public void stop() {
			timer.stop();
		}
		
		public void actionPerformed(ActionEvent e) {
			repaint();
		}

		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());
			g.setColor(Color.yellow);
			g.fillOval(centreOfOrbit.getX()-sunRad,centreOfOrbit.getY()-sunRad, sunRad*2, sunRad*2);
		
			for (Planet i: planets) {
				g.setColor(i.getColour());
				g.fillOval(i.getLocation().getX(), i.getLocation().getY(), i.getRad(), i.getRad());
			}
			
			
		}
	
	
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
	
			public void run() {
				
				JFrame frame = new JFrame("Solar System");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(1000,1000);
				JPanel panel = new SolarSystem(1000,1000);
				frame.add(panel);
				frame.setVisible(true);
			}
	 
		});
	
	}	
	
}
