package com.pbo.dynamicdrawingtoolkit;

import java.awt.Color;

public abstract class DrawingObjectBounds extends DrawingObject {

	public DrawingObjectBounds() {
		super();
	}
	
	public DrawingObjectBounds(int x1, int y1, int x2, int y2, Color color, boolean fill) {
		super(x1, y1, x2, y2, color);
	}
	
	public int getUpperLeftX() {
		return Math.min(getX1(), getX2());
	}
	public int getUpperLeftY() {
		return Math.min(getY1(), getY2());
	}
	public int getWidth() {
		return Math.abs(getX1()- getX2());
	}
	public int getHeight() {
		return Math.abs(getY1()- getY2());
	}
	
	public void setFixedXY() {
		if(getX1() > getX2()) {
			int temp = getX1();
			setX1(getX2());
			setX2(temp);
		}
		if(getY1() > getY2()) {
			int temp = getY1();
			setY1(getY2());
			setY2(temp);
		}
	}
	

}
