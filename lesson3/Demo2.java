package stt07_VuHoaBinh_JListDemo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Demo2 extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<Object> listmodelName;
	private JButton btnAdd;
	private JButton btnRemove;
	private JTextField txtName;
	private JButton btnEdit;
	@SuppressWarnings("rawtypes")
	private JList listName;

	Demo2(){
		super();
		setTitle("List Edit Demo");
		setSize(500,500);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		listmodelName =  new DefaultListModel<>();
		listName = new JList<>(listmodelName);
		add(new JScrollPane(listName),BorderLayout.CENTER);
		
		JPanel jp_Top = new JPanel();
		jp_Top.add(new JLabel("Input Name: "));
		jp_Top.add(txtName = new JTextField(15));
//		txtName.addActionListener(this);
		AbstractAction action = new AbstractAction()
		{
		    /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e)
		    {
		    	String name = txtName.getText().trim();
				listmodelName.addElement(name);
				txtName.setText( "" );
		    }
		};
		txtName.addActionListener( action );
		
		
		JPanel jp_btn = new JPanel();
		jp_btn.add(btnAdd = new JButton("Add item"));
		jp_btn.add(btnRemove = new JButton("Remove item"));
		jp_btn.add(btnEdit = new JButton("Edit item"));
		btnAdd.addActionListener(this);
		btnRemove.addActionListener(this);
		btnEdit.addActionListener(this);
		
		JPanel jp_right = new JPanel(new BorderLayout());
		jp_right.add(jp_Top, BorderLayout.NORTH);
		jp_right.add(jp_btn,BorderLayout.CENTER);
		
		add(jp_right, BorderLayout.EAST);
		
		
		listName.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedIndex = listName.getSelectedIndex();
                    if (selectedIndex != -1) {
                        txtName.setText((String) listmodelName.getElementAt(selectedIndex));
                    }
                }
            }
        });
		
	}
	public static void main(String[] args) {
		new Demo2().setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o =e.getSource();
		if(o==btnAdd) {
			String name = txtName.getText().trim();
			if(name == "") {
				JOptionPane.showMessageDialog(this, "Plz input");
			}else {
				listmodelName.addElement(name);
				txtName.setText("");
			}
		}
		if(o==btnRemove) {
			listmodelName.removeElement(listName.getSelectedValue());
		}
		if(o==btnEdit) {
			int selectedIndex = listName.getSelectedIndex();
            if (selectedIndex != -1) {
            	listmodelName.setElementAt(txtName.getText(), selectedIndex);
                txtName.setText("");
            }
		}
	}
	
}
