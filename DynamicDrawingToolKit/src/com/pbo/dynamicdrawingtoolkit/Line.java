package com.pbo.dynamicdrawingtoolkit;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends DrawingObject {

	public Line() {
		super();
	}

	public Line(int x1, int y1, int x2, int y2, Color color) {
		super(x1, y1, x2, y2, color);
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(getX1(), getY1(), getX2(), getY2());
	}

	@Override
	public void setFixedXY() {
	}

	@Override
	public boolean intersect(int mouseX, int mouseY) {
		double m = getSlope();
		double b = getY2() - m * getX2();
		double yPoint = m * mouseX + b;

		if (Math.abs(mouseY - yPoint) < 3.0) {
			return true;
		}
		return false;
	}

	private double getSlope() {
		double m = (double) (getY2() - getY1()) / (double) (getX2() - getX1());
		return m;
	}

}
