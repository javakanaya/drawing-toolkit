package com.pbo.dynamicdrawingtoolkit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;

public class DrawingCanvas extends JPanel {

	private ArrayList<DrawingObject> myShapes;
	private int currentShapeType;
	private DrawingObject currentShapeObject;
	private Color currentShapeColor;

	JLabel statusLabel;

	public DrawingCanvas(JLabel statusLabel) {
		myShapes = new ArrayList<DrawingObject>();
		currentShapeType = 0;
		currentShapeObject = null;
		currentShapeColor = Color.BLACK;

		this.statusLabel = statusLabel;
		setLayout(null);
		setBackground(Color.WHITE);
		add(statusLabel, BorderLayout.SOUTH);

		MouseHandler mHandler = new MouseHandler();
		addMouseListener(mHandler);
		addMouseMotionListener(mHandler);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// menggambar semua objek didalam arrayList
		for (int counter = myShapes.size() - 1; counter >= 0; counter--) {
			myShapes.get(counter).draw(g);
		}

		if (currentShapeObject != null) {
			currentShapeObject.draw(g);
		}
	}

	public void setCurrentShapeType(int type) {
		currentShapeType = type;
	}

	public void clearDrawing() {
		myShapes.clear();
		repaint();
	}

	private class MouseHandler extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			switch (currentShapeType) {
			case 0:
				currentShapeObject = new Line(e.getX(), e.getY(), e.getX(), e.getY(), currentShapeColor);
				break;
			case 1:
				currentShapeObject = new Circle(e.getX(), e.getY(), e.getX(), e.getY(), currentShapeColor, false);
				break;
			case 2:
				currentShapeObject = new Rectangle(e.getX(), e.getY(), e.getX(), e.getY(), currentShapeColor, false);
				break;
			}
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// update ukuran objek ketika mouse bergerak
			currentShapeObject.setX2(e.getX());
			currentShapeObject.setY2(e.getY());
			
			repaint();
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// update ukuran objek ketika mouse bergerak
			currentShapeObject.setX2(e.getX());
			currentShapeObject.setY2(e.getY());
			
			// menyimpan objek kedalam arrayList
			myShapes.add(currentShapeObject);
			
			currentShapeObject = null;
			repaint();
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			
		}
	}
}
