package com.pbo.dynamicdrawingtoolkit;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends DrawingObjectBounds {

	public Rectangle() {
		super();
	}

	public Rectangle(int x1, int y1, int x2, int y2, Color color, boolean fill) {
		super(x1, y1, x2, y2, color, fill);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
		g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
	}

	@Override
	public boolean intersect(int mouseX, int mouseY) {
		if (mouseX >= getX1() && mouseX <= getX2() && mouseY >= getY1() && mouseY <= getY2()) {
			return true;
		}
		return false;
	}

}
