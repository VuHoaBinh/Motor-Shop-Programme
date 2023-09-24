package stt07_VuHoaBinh_Tuan1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Bai1 extends JFrame implements ActionListener {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnRun;
	private JButton btnDelete;
	private JButton btnExit;
	private JTextField txtNhapA;
	private JTextField txtNhapC;
	private JTextField txtNhapB;
	private JLabel txtResult;

	public Bai1() {
		super();
		setTitle("^-^");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,500);
//		setResizable(false);
		setLocationRelativeTo(null);
		
		
		// label in south
		JLabel label_title = new JLabel("GIAI PHUONG TRINH BAC HAI");
		label_title.setFont(new Font("Times New Roman", Font.BOLD,20));
		JPanel jp_Title = new JPanel();
		jp_Title.add(label_title);
		jp_Title.setBackground(Color.green);
		add(jp_Title, BorderLayout.NORTH);
		
		
		
		// label in south
		
		JPanel jp_footer = new JPanel();
		jp_footer.setBorder(BorderFactory.createTitledBorder("Chon tac vu"));
		
		btnRun = new JButton("Giai");
		jp_footer.add(btnRun);
		btnRun.addActionListener(this);
		
		btnDelete = new JButton("Xoa rong");
		jp_footer.add(btnDelete);
		btnDelete.addActionListener(this);
		
		btnExit = new JButton("Thoat");
		jp_footer.add(btnExit);
		btnExit.addActionListener(this);
		
		add(jp_footer,BorderLayout.SOUTH);
		
		
		//label in center
		Box b, b1, b2, b3, b4;
		b = Box.createVerticalBox();
		
		b1 = Box.createHorizontalBox();
		b1.add(new JLabel("Nhap a: "));
		b1.add(txtNhapA = new JTextField());
		txtNhapA.addActionListener(this);
		
		b2 = Box.createHorizontalBox();
		b2.add(new JLabel("Nhap b: "));
		b2.add(txtNhapB = new JTextField(15));
		txtNhapB.addActionListener(this);
		
		b3 = Box.createHorizontalBox();
		b3.add(new JLabel("Nhap c: "));
		b3.add(txtNhapC = new JTextField(15));
		txtNhapC.addActionListener(this);
		
		b4 = Box.createHorizontalBox();
		b4.add(new JLabel("Ket qua: "));
		b4.add(txtResult = new JLabel());
//		txtResult.setEnabled(false);
		
		b.add(b1);
		b.add(b2);
		b.add(b3);
		b.add(b4);
		
		add(b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Bai1().setVisible(true);
	}

	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o == btnExit) {
			System.exit(0);
		}
		if(o.equals(btnDelete)) {
			txtNhapA.removeAll();
			txtNhapB.removeAll();
			txtNhapC.removeAll();
			txtResult.removeAll();
		}
		if(o == btnRun) {
			double a = Double.parseDouble(txtNhapA.getText());
			double b = Double.parseDouble(txtNhapB.getText());
			double c = Double.parseDouble(txtNhapC.getText());
			double calculatorSum = a+b+c;
			txtResult.setText(Double.toString(calculatorSum));
		}
	}

}
