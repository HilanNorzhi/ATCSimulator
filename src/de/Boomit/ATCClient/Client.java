/**
 * 
 */
package de.Boomit.ATCClient;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * @author Johannes Hoppenstedt
 * (c) 2015 All rights reserved.
 *
 */
@SuppressWarnings("serial")
public class Client extends JFrame{

	//Basic variables
	public static String version = "v. 0.1";
	public static String name = "ATC Simulator";
	
	public static Client client;
	public Radar radar = new Radar(this);
	
	/**
	 * 
	 */
	public Client() {
		// TODO Auto-generated constructor stub
		
		super(name + " " + version);
		super.setSize(900, 700);
		super.setLocation(50, 50);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.getContentPane().setBackground(Color.BLACK);
		super.setResizable(false);
		super.setVisible(true);
		
		radar  = new Radar(this);
		
		Thread radarthread = new Thread("radar"){
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
				while(true){
					radar.update(client);
					repaint();
					
					try {
						Thread.sleep(27);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		radarthread.start();
	}
	
	/**
	 * 
	 */
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		radar.paint(g);
	}
	
	/**
	 * 
	 */
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		super.update(g);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		client = new Client();
	}

}
