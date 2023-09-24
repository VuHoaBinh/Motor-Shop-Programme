package stt07_VuHoaBinh_demo4;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Demo4 extends JFrame implements ItemListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField field;
	JCheckBox bold,italic,Plain;
	Demo4(){
		super();
		setLayout(new GridLayout(2,1));
		JPanel jp1 = new JPanel();
		
		
		jp1.add(field = new JTextField("This text typed by Binh", 20));
		field.setFont(new Font("Times New Roman",Font.PLAIN,16));
	
		
		add(jp1);
		
		//checkbox
		JPanel jp2 = new JPanel();
		
		jp2.add(bold = new JCheckBox("Bold"));
		bold.addItemListener(this);
		jp2.add(italic = new JCheckBox("Italic"));
        italic.addItemListener(this);
        jp2.add(Plain = new JCheckBox("Plain"));
        Plain.addItemListener(this);
        
        jp2.add(Plain);
		jp2.add(bold);
        jp2.add(italic);
		
		add(jp2);
		
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Demo4().setVisible(true);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Font f = field.getFont();
        int style = f.getStyle();

        if (e.getSource() == bold) {
            style ^= Font.BOLD; 
        }
        if (e.getSource() == italic) {
            style ^= Font.ITALIC; 
        }
        if (e.getSource() == Plain) {
            style ^= Font.PLAIN; 
        }

        field.setFont(new Font(f.getName(), style, f.getSize()));
	}

}
