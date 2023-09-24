package JListCheckbox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Checkbox extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton btnBoldEven;
	JButton btnBoldOld;
	JButton btnExitBold;
	JButton btnPrime;
	JButton btnDelete;
	JButton btnSum, btn_exist,btnRandom;
	JButton btnNhap;
	JTextField txtInput;   
	JCheckBox chkSoAm;
	
	DefaultListModel<Integer> listmodel;
	private JList<Integer> listItems;
	
	
	public Checkbox() {
		super();
		setTitle("Thao tac tren JList");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setSize(700, 500);
		setResizable(false);
		
		
		// label in south
		JLabel label_title = new JLabel("Thao tac tren JList - Checkbox");
		label_title.setFont(new Font("Times New Roman", Font.BOLD,20));
		JPanel jp_Title = new JPanel();
		jp_Title.add(label_title);
		label_title.setForeground(Color.GREEN);
		add(jp_Title, BorderLayout.NORTH);
		
		
		//west
		JPanel jp_functions = new JPanel();
		jp_functions.setBorder(BorderFactory.createTitledBorder("Chon tac vu"));
		jp_functions.setLayout(new GridLayout(9,1));
		jp_functions.add(btnBoldEven = new JButton("To den so chan"));
		jp_functions.add(btnBoldOld = new JButton("To den so le"));
		jp_functions.add(btnPrime = new JButton("To den so nguyen to"));
		jp_functions.add(btnExitBold = new JButton("Bo to den"));
		jp_functions.add(btnDelete = new JButton("xoa cac gia tri dang to den"));
		jp_functions.add(btnSum = new JButton("Tong gia tri trong Jlist"));
		
		btnBoldEven.addActionListener(this);
		btnBoldOld.addActionListener(this);
		btnPrime.addActionListener(this);
		btnExitBold.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSum.addActionListener(this);
		
		add(jp_functions,BorderLayout.WEST);
		
		
		// center
		JPanel jp_center = new JPanel();
		jp_center.setBorder(BorderFactory.createTitledBorder("Nhap thong tin"));
		
		JPanel jp_north = new JPanel();
		jp_north.add(btnNhap = new JButton("Nhap"));
		btnNhap.addActionListener(this);
		jp_north.add(txtInput = new JTextField(15));
		AbstractAction action = new AbstractAction()
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			public void actionPerformed(ActionEvent e)
			{
				Integer number = Integer.parseInt(txtInput.getText());
				if(!chkSoAm.isSelected() && number>0) {
					listmodel.addElement(number);
				}else if(chkSoAm.isSelected()) {
					listmodel.addElement(number);
				}else {
					JOptionPane.showMessageDialog(null, "Input Number!! Not numeric");
				}
				txtInput.setText("");
				txtInput.requestFocus();
			}
		};
		txtInput.addActionListener(action);
		
		jp_north.add(chkSoAm = new JCheckBox("Cho nhap so am"));
		jp_center.add(jp_north,BorderLayout.CENTER);
		
		JPanel jp_south = new JPanel();
		listmodel = new DefaultListModel<Integer>();
		listItems = new JList<Integer>(listmodel);
		listItems.setVisibleRowCount(10);
//		listItems.setPreferredSize(new Dimension(200, 200));
		jp_south.add(new JScrollPane(listItems), BorderLayout.CENTER);
		jp_center.add(jp_south, BorderLayout.SOUTH);
		
		jp_south.add(btnRandom = new JButton("Create numbers random"));
		btnRandom.addActionListener(this);
		
		
		add(jp_center, BorderLayout.CENTER);
		
		
		
		
		//south
		btn_exist = new JButton("Thoat chuong trinh");
		btn_exist.addActionListener(this);
		btn_exist.setFont(new Font("Times New Roman", Font.BOLD,20));
		JPanel jp_exist = new JPanel();
		jp_exist.add(btn_exist);
		jp_exist.setBackground(Color.cyan);
		add(jp_exist, BorderLayout.SOUTH);
		
	}
	public static void main(String[] args) {
		new Checkbox().setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		
		if(o == btnNhap) {
			int number = Integer.parseInt(txtInput.getText());
			if(!chkSoAm.isSelected() && number>0) {
				listmodel.addElement(number);
			}else if(chkSoAm.isSelected()) {
				listmodel.addElement(number);
			}else {
				JOptionPane.showMessageDialog(this, "Input Number!! Not numeric");
			}
			txtInput.setText("");
			txtInput.requestFocus();
		}
		
		if(o == btnBoldEven) {
			listItems.clearSelection();
			for (int i =0; i<listmodel.size();i++) {
				if(listmodel.getElementAt(i)%2==0) {
					listItems.addSelectionInterval(i, i);
				}
			}
		}
		if(o == btnBoldOld) {
			listItems.clearSelection();
			for (int i =0; i<listmodel.size();i++) {
				if(listmodel.getElementAt(i)%2!=0) {
					listItems.addSelectionInterval(i, i);
				}
			}
		}
		if(o ==btnPrime) {
			listItems.clearSelection();
			for (int i =0; i<listmodel.size();i++) {
				if(isPrime(listmodel.getElementAt(i),2) == true) {
					listItems.addSelectionInterval(i, i);
				}
			}
			
		}
		if(o == btnDelete) {
			int numberChoice = listItems.getSelectedValuesList().size();
			for (int i =0; i<numberChoice;i++) {
				listmodel.removeElementAt(listItems.getSelectedIndex());
			}
		}
		if(o == btnExitBold) {
			listItems.clearSelection();
		}
		if(o == btnSum) {
			JOptionPane.showMessageDialog(this, "Sum: " + tong());
		}
		if(o == btn_exist) {
			System.exit(0);
		}
		if(o==btnRandom) {
			for (int i =0; i<10;i++) {
				if(chkSoAm.isSelected()) {
					listmodel.addElement(new Random().nextInt(100)-10);
				}else {
					listmodel.addElement(new Random().nextInt(100));
				}
			}
		}
	}
	private boolean isPrime(int n, int i)
    {
   
        if (n <= 2) 
           return (n == 2) ? true : false; 
       if (n % i == 0) 
           return false; 
       if (i * i > n)
            return true;
 
        return isPrime(n, i + 1);
    }
	private int tong()
    {
		int sum = 0;
		for (int i =0; i<listmodel.size();i++) {
			sum+=listmodel.getElementAt(i);
		}
		return sum;
    }

}
