package stt07_VuHoaBinh_JListDemo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Demo3 extends JFrame implements ActionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnAdd;
	private JButton btnRemove;
	private JTextField txtFirstName, txtLastName;
	private JButton btnEdit, btnExist;
	DefaultTableModel model;
	JTable table;
	Demo3(){
		super();
		setTitle("List Edit Demo");
		setSize(500,500);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		String[] cols = {"HO", "TEN"};
		model = new DefaultTableModel(cols,0);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		add(pane,BorderLayout.CENTER);
		
		
		
		
		Box b, b1, b2;
		b = Box.createVerticalBox();
		
		b1 = Box.createHorizontalBox();
		b1.add(new JLabel("Ho: "));
		b1.add(txtFirstName = new JTextField());
		txtFirstName.addActionListener(this);
		
		b2 = Box.createHorizontalBox();
		b2.add(new JLabel("Ten: "));
		b2.add(txtLastName = new JTextField());
		txtLastName.addActionListener(this);
		
		b.add(Box.createRigidArea(new Dimension(5,10)));
		b.add(b1);
		b.add(Box.createRigidArea(new Dimension(5,10)));
		b.add(b2);
		this.add(b, BorderLayout.NORTH);
		
		
		
		JPanel jp_btn = new JPanel();
		jp_btn.add(btnAdd = new JButton("Add item"));
		jp_btn.add(btnRemove = new JButton("Remove item"));
		jp_btn.add(btnEdit = new JButton("Edit item"));
		jp_btn.add(btnExist = new JButton("Exist"));
		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnEdit.addActionListener(this);
		btnExist.addActionListener(this);
		
		
		JPanel jp_right = new JPanel(new BorderLayout());
		jp_right.add(b, BorderLayout.NORTH);
		jp_right.add(jp_btn,BorderLayout.CENTER);
		
		add(jp_right, BorderLayout.NORTH);
	
		
		// show data in table to fields
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    // Get data from the selected row and display it in the text fields
                    txtFirstName.setText(model.getValueAt(selectedRow, 0).toString());
                    txtLastName.setText(model.getValueAt(selectedRow, 1).toString());
                }
            }
        });
	}
	public static void main(String[] args) {
		new Demo3().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o =e.getSource();
		if(o == btnAdd) {
			if(txtFirstName.getText().equals("") || txtLastName.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "Plz input");
			}else {
				Object[] obj = new Object[2];
				obj[0] = txtFirstName.getText();
				obj[1] = txtLastName.getText();
				model.addRow(obj);
				txtFirstName.setText("");
				txtLastName.setText("");
			}
		}
		
		if(o.equals(btnRemove)) {
			if(table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Plz choice to delete");				
			}else {
				int confirmResult = JOptionPane.showConfirmDialog(this, "Do you want to delete this row?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
	            if (confirmResult == JOptionPane.YES_OPTION) {
	                model.removeRow(table.getSelectedRow());
	            }
			}
		}

		
		if(o == btnEdit) {
			if (table.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this, "Plz choice to edit");
            } else {
                int row = table.getSelectedRow();
                model.setValueAt(txtFirstName.getText(), row, 0);
                model.setValueAt(txtLastName.getText(), row, 1);
            }
		}
		
		
		if(o == btnExist) {
			System.exit(0);
		}
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
	    txtFirstName.setText(table.getValueAt(row, 0).toString());
	    txtLastName.setText(table.getValueAt(row, 1).toString());
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
	
}
