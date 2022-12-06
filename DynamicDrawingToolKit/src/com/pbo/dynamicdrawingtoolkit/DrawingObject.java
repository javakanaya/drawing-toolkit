package com.pbo.dynamicdrawingtoolkit;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public abstract class DrawingObject {

	// koordinat objek
	private int x1, y1, x2, y2;

	// warna
	private Color color;

	public boolean reverse = false;

	public DrawingObject() {
		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = 0;
		color = Color.BLACK;
	}

	public DrawingObject(int x1, int y1, int x2, int y2, Color color) {
		this.x1 = Math.min(x1, x2);
		this.y1 = Math.min(y1, y2);
		this.x2 = Math.max(y1, y2);
		this.y2 = Math.max(y1, y2);
		this.color = color;
	}
	
	// Setter
	public void setX1(int x1) {
		this.x1 = x1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void setRandColor() {
		Random rand = new Random();
		this.color = new Color(rand.nextInt(5, 120), rand.nextInt(4, 225), rand.nextInt(1, 200));
	}

	// Getter
	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	public Color getColor() {
		return color;
	}

	public void objectTranslation(int deltaX, int deltaY) {
		x1 += deltaX;
		x2 += deltaX;
		y1 += deltaY;
		y2 += deltaY;
	}
	
	abstract public void draw(Graphics g);
	abstract public boolean intersect(int mouseX, int mouseY);
	public abstract void setFixedXY();
}
