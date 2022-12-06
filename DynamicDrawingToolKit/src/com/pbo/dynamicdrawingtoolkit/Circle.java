package com.pbo.dynamicdrawingtoolkit;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends DrawingObjectBounds {

	private double diameter, radius, x, y;

	public Circle() {
		super();
	}

	public Circle(int x1, int y1, int x2, int y2, Color color, boolean fill) {
		super(x1, y1, x2, y2, color, fill);
	}

	@Override
	public void draw(Graphics g) {
		diameter = Math.sqrt(Math.pow((getX2() - getX1()), 2) + Math.pow(getY2() - getY1(), 2));
		radius = diameter / 2.0;
		x = (getX1() + getX2()) / 2.0;
		y = (getY1() + getY2()) / 2.0;
		g.setColor(getColor());
		
		g.drawOval((int)(x - radius), (int)(y - radius), (int)diameter, (int)diameter);
		g.fillOval((int)(x - radius), (int)(y - radius), (int)diameter, (int)diameter);
	}

	@Override
	public boolean intersect(int mouseX, int mouseY) {
		double dist = Math.sqrt(Math.pow((mouseX - x), 2) + Math.pow(mouseY - y, 2));
		if (dist <= radius) {
			return true;
		}
		return false;
	}

}
