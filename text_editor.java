package org.example;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

public class Main implements ActionListener {
	
	static JTextArea textArea = new JTextArea();
	
	static String path = JOptionPane.showInputDialog("Enter file path");
	
	public static void main(String[] args)
	{
		
		if (!new File(path).exists()) {
			JOptionPane.showMessageDialog(null, "this file is not exists");
			System.exit(-1);
		}
		
		if (path != null)
		{
			JFrame frame = new JFrame();
			
			JButton button = new JButton("Save");
			
			JButton button_2 = new JButton("Open file");
			
			Font font = new Font("Arial", Font.ITALIC, 30);
			
			JPanel panel = new JPanel();
						
			textArea.setFont(font);
			
			textArea.setLineWrap(true);
			
			textArea.setWrapStyleWord(true);
			
			button.addActionListener(new Main());
			
			button_2.addActionListener(new changeFilePathListener());
			
			panel.add(button);
			
			panel.add(button_2);
			
			frame.getContentPane().add(BorderLayout.NORTH, panel);
			
			frame.getContentPane().add(BorderLayout.CENTER, textArea);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			frame.setSize(500, 500);
			
			frame.setVisible(true);
		
		} else {
			JOptionPane.showMessageDialog(null, "File path must be not null!");
			System.exit(-1);
		}
	}
	
	public void actionPerformed(ActionEvent event) {
		
		try {
			
			FileWriter writeFile = new FileWriter(path, false);
			
			String text = textArea.getText().toString();
			
			writeFile.write(text);
			
			JOptionPane.showMessageDialog(null, "Text writed");
			
			writeFile.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	static class changeFilePathListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			path = JOptionPane.showInputDialog("Enter file path");
			
		}
		
	}
	
}