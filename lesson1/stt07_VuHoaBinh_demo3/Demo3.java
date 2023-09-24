package stt07_VuHoaBinh_demo3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


public class Demo3 extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passText;
	private JButton btn1, btn2;



	public JPasswordField getPassText() {
		return passText;
	}



	public void setPassText(JPasswordField passText) {
		this.passText = passText;
	}



	public JButton getBtn1() {
		return btn1;
	}



	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}



	public JButton getBtn2() {
		return btn2;
	}



	public void setBtn2(JButton btn2) {
		this.btn2 = btn2;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	Demo3(){
		super();
		JPanel jp = new JPanel();
		jp.add(new JLabel("Password: "));
		jp.add(passText = new JPasswordField(10));
		passText.addActionListener(this);
		
		btn1 = new JButton("OK");
		btn1.addActionListener(this);
		btn2 = new JButton("Cancel");
		btn2.addActionListener(this);
		
		jp.add(btn1);
		jp.add(btn2);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
		setResizable(false);
		add(jp);
		pack();
		
		setVisible(true);
		setLocationRelativeTo(null);;
	}
	


	public static void main(String[] args) {
		new Demo3().setVisible(true);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btn1 || o == passText) {
			char[] chPass = passText.getPassword();
	        String strPass = new String(chPass);
	        if(strPass.trim().equals("binh")) {
	        	JOptionPane.showMessageDialog(this, "Correct");
	        	System.exit(0);
			}else {
				JOptionPane.showMessageDialog(this, "Incorrect",
						"Error Message", JOptionPane.ERROR_MESSAGE);
				passText.selectAll();
				passText.requestFocus();
	        }
			
		}else {
			System.exit(0);
		}
		
	}
}
