package com.pbo.dynamicdrawingtoolkit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DrawingFrame extends JFrame {

	private JButton jbClear, jbLine, jbCircle, jbRectangle, jbSelection;
	private JPanel toolboxPanel, toolboxPadding;
	public static DrawingCanvas canvas;

	public DrawingFrame() {
		super("Drawing Toolkit");
		JLabel statusLabel = new JLabel("");

		canvas = new DrawingCanvas(statusLabel);
		canvas.setBorder(BorderFactory.createLineBorder(Color.GRAY, 15));

		jbClear = new JButton("Clear");
		jbLine = new JButton("Line");
		jbCircle = new JButton("Circle");
		jbRectangle = new JButton("Rectangle");
		jbSelection = new JButton("Select");

		toolboxPanel = new JPanel();
		toolboxPanel.setLayout(new GridLayout(1, 1, 1, 1));
		toolboxPadding = new JPanel();
		toolboxPadding.setLayout(new FlowLayout(FlowLayout.LEADING, 1, 1));

		toolboxPanel.add(jbClear);
		toolboxPanel.add(jbLine);
		toolboxPanel.add(jbCircle);
		toolboxPanel.add(jbRectangle);
		toolboxPanel.add(jbSelection);
		toolboxPadding.add(toolboxPanel);

		add(toolboxPadding, BorderLayout.NORTH);
		add(canvas, BorderLayout.CENTER);

		ButtonHandler bHandler = new ButtonHandler();
		jbClear.addActionListener(bHandler);
		jbLine.addActionListener(bHandler);
		jbCircle.addActionListener(bHandler);
		jbRectangle.addActionListener(bHandler);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int choose = JOptionPane.showConfirmDialog(null, "Do you really want to exit the application ?",
						"Confirm Close", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (choose == JOptionPane.YES_OPTION) {
					e.getWindow().dispose();
					System.out.println("Close");
				} else
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});

		setSize(500, 500);
		setVisible(true);
	}

	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Clear")) {
				canvas.clearDrawing();
			} else if (e.getActionCommand().equals("Select")) {
				canvas.setSelectionMode(true);
			} else if (e.getActionCommand().equals("Line")) {
				canvas.setSelectionMode(false);
				canvas.setCurrentShapeType(0);
			} else if (e.getActionCommand().equals("Circle")) {
				canvas.setSelectionMode(false);
				canvas.setCurrentShapeType(1);
			} else if (e.getActionCommand().equals("Rectangle")) {
				canvas.setSelectionMode(false);
				canvas.setCurrentShapeType(2);
			}
		}

	}
}
