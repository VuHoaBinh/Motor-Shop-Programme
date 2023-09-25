package stt07_VuHoaBinh_JListDemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

public class InformationEmployee extends JFrame implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//label
	private JLabel lbID;
	private JLabel lbFirstName;
	private JLabel lbLastName;
	private JLabel lbAge;
	private JLabel lbSalary;
	private JLabel lbNhap;
	
	//txt
	private JTextField txtID;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAge;
	private JTextField txtSalary;
	private JTextField txtNhap;
	
	//rad
	private JRadioButton radMen;
	private JRadioButton radWomen;
	private Nhanvien_collections listNV;
	
	
	DefaultTableModel modelEmployee;
	JTable tblEmployee;
	private JTable btnGroup;

	//btn
	private JButton btnFind;
	private JButton btnAdd;
	private JButton btnDeleteSpace;
	private JButton btnDelete;
	private JButton btnSave;
	
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
		
		//list table
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
		
		
		
		btnFind.addActionListener(this);
		btnAdd.addActionListener(this);
		btnDeleteSpace.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSave.addActionListener(this);

		tblEmployee.addMouseListener(this);
		
		
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
		
		if (o == btnDeleteSpace) {
			txtID.setText("");
			txtID.requestFocus();
			txtFirstName.setText("");
			txtLastName.setText("");
			txtAge.setText("");
			txtSalary.setText("");
			if(radMen.isSelected() || radWomen.isSelected() )
            {
				btnGroup.clearSelection();
            }
		}
		
		
		if(o == btnFind) {
			String valueID = txtID.getText();
			if(valueID !=null && valueID.trim().length()>0) {
				try {
					NhanVien nv = listNV.timNhanVien(valueID);
					if(nv != null) {
						deleteAll();
						String gender = nv.isSex() ? "Nam" : "Nu";
						modelEmployee.addRow(new Object[] {nv.getEmployeeID(),
								nv.getFirstName(), nv.getLastName(), nv.getAge(),
								gender,nv.getSalary()});
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Wrong");
					txtID.selectAll();
					txtID.requestFocus();
				}
			}else {
				deleteAll();
				ReadDataToList();
				tblEmployee.setModel(modelEmployee);
			}
		}
			
		
		if(o == btnDelete) {
			int rowChoice = tblEmployee.getSelectedRow();
			modelEmployee.removeRow(rowChoice);
			NhanVien nv = listNV.getElement(rowChoice);
			listNV.xoaNhanVien(nv.getEmployeeID());
		}
		
		if(o == btnSave) {
			// get row
			int rowChoice = tblEmployee.getSelectedRow(); 

	        String ID = txtID.getText();
	        String FirstName = txtFirstName.getText();
	        String LastName = txtLastName.getText();
	        String Age = txtAge.getText();
	        String gender = null;
	        if (radMen.isSelected()) {
	            gender = "Nam";
		        radWomen.setSelected(false);
	        } else {
	            gender = "Nu";
	            radMen.setSelected(false);
	        }
	        String Salary = txtSalary.getText();

	        // Update 
	        modelEmployee.setValueAt(ID, rowChoice, 0);
	        modelEmployee.setValueAt(FirstName, rowChoice, 1);
	        modelEmployee.setValueAt(LastName, rowChoice, 2);
	        modelEmployee.setValueAt(Age, rowChoice, 3);
	        modelEmployee.setValueAt(gender, rowChoice, 4);
	        modelEmployee.setValueAt(Salary + "$", rowChoice, 5);
		    
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowSelection = tblEmployee.getSelectedRow();
		txtID.setText(modelEmployee.getValueAt(rowSelection, 0).toString());
		txtFirstName.setText(modelEmployee.getValueAt(rowSelection, 0).toString());
		txtLastName.setText(modelEmployee.getValueAt(rowSelection, 0).toString());
		txtAge.setText(modelEmployee.getValueAt(rowSelection, 0).toString());
		String gender = modelEmployee.getValueAt(rowSelection, 4).toString();
	    
	    // Set the gender radio buttons 
	    if (gender.equals("Nam")) {
	        radMen.setSelected(true);
	        radWomen.setSelected(false);
	    } else if (gender.equals("Nu")) {
	    	radMen.setSelected(false);
	        radWomen.setSelected(true);
	    }
		
		txtSalary.setText(modelEmployee.getValueAt(rowSelection, 0).toString());

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void ReadDataToList() {
		for(int i=0;i<listNV.getSize();i++) {
			NhanVien nv = listNV.getElement(i);
			String gender = nv.isSex() ? "Nam" : "Nu";
			modelEmployee.addRow(new Object[] {nv.getEmployeeID(),
					nv.getFirstName(), nv.getLastName(), nv.getAge(),
					gender,nv.getSalary()});
		}
	}
	
	public void deleteAll() {
		DefaultTableModel tableModel = (DefaultTableModel) tblEmployee.getModel();
		tableModel.getDataVector().removeAllElements();
	}
}
