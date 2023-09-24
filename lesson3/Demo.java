package stt07_VuHoaBinh_JListDemo;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Demo extends JFrame implements ListSelectionListener {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNhap;
	private JList<String> isEntry;
	Demo(){
		super();
		setTitle("JList Demo");
		setSize(250,250);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

			
		
		JPanel jp_footer = new JPanel();
		jp_footer.setBorder(BorderFactory.createTitledBorder("List Selection"));
		jp_footer.add(new JLabel("Last section: "));
		jp_footer.add(txtNhap = new JTextField(10));
		add(jp_footer,BorderLayout.SOUTH);
		
		
		
		
		JPanel jp_center = new JPanel();
		String[] items = {"Entry 1","Entry 2","Entry 3","Entry 4","Entry 5","Entry 6"};
		isEntry = new JList<>(items);
		isEntry.setVisibleRowCount(4);
		isEntry.addListSelectionListener(this);
		
		JScrollPane listPane = new JScrollPane(isEntry);
		jp_center.add(listPane);
		jp_center.setBorder(BorderFactory.createTitledBorder("Simple JList"));
		add(jp_center,BorderLayout.CENTER);
		
		
	}
	public static void main(String[] args) {
		new Demo().setVisible(true);
	}
	@Override
	public void valueChanged(ListSelectionEvent e) {
		txtNhap.setText(isEntry.getSelectedValue().toString());
		
	}
}
