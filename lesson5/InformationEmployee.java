package stt07_VuHoaBinh_JListDemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class InformationEmployee extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbID;
	private JTextField txtID;
	private JLabel lbFirstName;
	private JTextField txtFirstName;
	private JLabel lbLastName;
	private JTextField txtLastName;
	private JLabel lbAge;
	private JTextField txtAge;
	private JRadioButton radMen;
	private JRadioButton radWomen;
	private JLabel lbSalary;
	private JTextField txtSalary;
	DefaultTableModel modelEmployee;
	JTable tblEmployee;
	private JLabel lbNhap;
	private JTextField txtNhap;
	private JButton btnFind;
	private JButton btnAdd;
	private JButton btnDeleteSpace;
	private JButton btnDelete;
	private JButton btnSave;
	private Nhanvien_collections listNV;
	
	InformationEmployee(){		
		super();
		
		//list NV
		listNV = new Nhanvien_collections();
		
		setTitle("^-^");
		setSize(700, 500);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// south
		JPanel jp_South = new JPanel();
		Box b_title, b1, b2, b3, b;
		b = Box.createVerticalBox();
		
		// title
		JLabel lb_title = new JLabel("THONG TIN NHAN VIEN");
		lb_title.setFont(new Font("Times New Roman", Font.BOLD,20));
		lb_title.setForeground(Color.blue);

		b.add(b_title = Box.createHorizontalBox());
		b_title.add(lb_title);
		
		// input
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b1.add(lbID = new JLabel("Ma nhan vien:"));
		b1.add(txtID = new JTextField(20));
		
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b1.add(lbFirstName = new JLabel("Ho:"));
		b1.add(txtFirstName = new JTextField());
		b1.add(lbLastName = new JLabel("Ten nhan vien:"));
		b1.add(txtLastName = new JTextField());
		
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b2.add(lbAge = new JLabel("Tuoi:"));
		b2.add(txtAge = new JTextField());
		b2.add(lbLastName = new JLabel("Phai:"));
		b2.add(radMen = new JRadioButton("Nam"));
		b2.add(radWomen = new JRadioButton("Nu"));
		
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createHorizontalStrut(10));
		b3.add(lbSalary = new JLabel("Luong:"));
		b3.add(txtSalary = new JTextField());
		
		lbID.setPreferredSize(lbID.getPreferredSize());
		lbFirstName.setPreferredSize(lbID.getPreferredSize());
		lbAge.setPreferredSize(lbID.getPreferredSize());
		lbSalary.setPreferredSize(lbID.getPreferredSize());
		
		
		jp_South.add(b);
		add(jp_South, BorderLayout.NORTH);
		
		
		
		// center
		String[] cols = {"Ma so", "Ho", "Ten nhan vien", "Tuoi", "Phai", "Tien luong"};
		modelEmployee = new DefaultTableModel(cols,0);
		tblEmployee = new JTable(modelEmployee);
		JScrollPane pane = new JScrollPane(tblEmployee);
		add(pane,BorderLayout.CENTER);
		
		modelEmployee.addRow(new Object[]{"1111", "Nguyen","Hoang","26","Nam", "4.500$"});
        modelEmployee.addRow(new Object[]{"2222", "Le","Thu","28","Nu", "5.000$"});
        modelEmployee.addRow(new Object[]{"3333", "Hoang","Le","30","Nam","5.500$"});
        modelEmployee.addRow(new Object[]{"4444", "Tran","Lan","27","Nam", "3.500$"});
        
        // "nam" and "nu" use Jcombobox
        JComboBox<String> genderComboBox = new JComboBox<>(new String[]{"Nam", "Nu"});
        
        DefaultCellEditor genderEditor = new DefaultCellEditor(genderComboBox);
        
        TableColumn phai_Column = tblEmployee.getColumnModel().getColumn(3);
        phai_Column.setCellEditor(genderEditor);

        
        // footer
		JPanel jp_footer = new JPanel();
		jp_footer.add(lbNhap = new JLabel("Nhap ma so can tim:"));
		jp_footer.add(txtNhap = new JTextField(15));
		jp_footer.add(btnFind = new JButton("Tim"));
		jp_footer.add(btnAdd = new JButton("Them"));
		jp_footer.add(btnDeleteSpace = new JButton("Xoa trang"));
		jp_footer.add(btnDelete = new JButton("Xoa"));
		jp_footer.add(btnSave = new JButton("Luu"));
		
//		lbNhap.addAncestorListener(this);
//		btnFind.addAncestorListener(this);
		btnAdd.addActionListener(this);
//		btnDeleteSpace.addAncestorListener(this);
//		btnDelete.addAncestorListener(this);
//		lbNhap.addAncestorListener(this);
//		btnSave.addAncestorListener(this);

		
		
		add(jp_footer, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		new InformationEmployee().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnAdd)) {
			String ID = txtID.getText();
			String FirstName = txtFirstName.getText();
			String LastName = txtLastName.getText();
			int Age = Integer.parseInt(txtAge.getText());
			System.out.println(Age);
			System.out.println("===================");
			Boolean isSex = radWomen.isSelected();
			String gender;
	        if (isSex) {
	            gender = "Nữ";
	        } else {
	            gender = "Nam";
	        }
			double Salary = Double.parseDouble(txtSalary.getText());
			NhanVien nv1 = new NhanVien(ID, FirstName, LastName, Age, isSex, Salary);
			if(!listNV.themNhanVien(nv1)) {
				JOptionPane.showMessageDialog(this, "Trùng");
			}else {
				modelEmployee.addRow(new Object[] {nv1.getEmployeeID(), nv1.getFirstName(), 
						nv1.getLastName(), nv1.getAge(), gender, nv1.getSalary() +"$"} );
			}
			
		}
		
	}
}
