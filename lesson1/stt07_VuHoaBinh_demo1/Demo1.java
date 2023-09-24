package stt07_VuHoaBinh_demo1;

import java.awt.Color;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Demo1 extends JFrame implements ActionListener{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField textPass;
	private JTextField textUser;
	private JButton btn1;
	private JButton btn2;
	
	// get and set
	public JPasswordField getTextPass() {
		return textPass;
	}
	public void setTextPass(JPasswordField textPass) {
		this.textPass = textPass;
	}
	
	public JTextField getTextUser() {
		return textUser;
	}
	public JTextField setTextUser(JTextField textUser) {
		this.textUser = textUser;
		return textUser;
	}
	
	// constructor
	public Demo1(JTextField textUser, JPasswordField textPass) throws HeadlessException {
		super();
		this.setTextUser(textUser);
		this.textPass = textPass;
	}
	
	
	
	Demo1() {
		super("Demo1");
		
		JPanel jp = new JPanel();
		
		
		jp.setBackground(Color.white);
		jp.setBounds(0, 0, 250, 250);
		
		// input
		jp.add(new JLabel("User Name: "));
		jp.add(setTextUser(new JTextField(10)));
		
		jp.add(new JLabel("Password: "));
		jp.add(textPass = new JPasswordField(10));
		
		// button
		btn1 = new JButton("Login");
		btn1.addActionListener(this);
		btn2 = new JButton("Exit");
        btn2.addActionListener(this);

		jp.add(btn1);
		jp.add(btn2);		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		add(jp);
		pack();
		
		setSize(250, 250);
		setLocationRelativeTo(null);
        setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btn2)) {
			System.exit(0);
		}
		if(o.equals(btn1) || o == textPass) {
			char chPass[] = textPass.getPassword();
			String strPass = new String(chPass);
			if(strPass.trim().equals("binh")) {
				JOptionPane.showMessageDialog(this, "Correct");
			}else {
				JOptionPane.showMessageDialog(this, "Incorrect"
						,"Error Message", JOptionPane.ERROR_MESSAGE);;
				textPass.selectAll();
				textPass.requestFocus();
			}
		}
	}

		
	public static void main(String[] args) {
			
			new Demo1().setVisible(true);
			
		}


}
