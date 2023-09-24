package stt07_VuHoaBinh_demo6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Demo6 extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel field;
	JComboBox<String> menuCombo;
	Demo6(){
		super();
		setTitle("Demo6");
		JPanel jp = new JPanel();
		
		
		jp.add(field = new JLabel("The quick brown for jumps over the lazy dog"));
        field.setFont(new Font("Bauhaus 93",Font.PLAIN,16));
        field.setPreferredSize(new Dimension(300, 100));
		
		add(field, BorderLayout.CENTER);
		
		menuCombo = new JComboBox<>();
		menuCombo.addItem("Bauhaus 93");
		menuCombo.addItem("Times New Roman");
		menuCombo.addItem("Blackadder ITC");
		menuCombo.addItem("Arial Black");
		
		
		add(menuCombo, BorderLayout.SOUTH);
		
		menuCombo.addActionListener(this);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setVisible(true);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new Demo6().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String fontName = (String)menuCombo.getSelectedItem();
		field.setFont(new Font(fontName, field.getFont().getStyle(), field.getFont().getSize()));
		
	}

}
