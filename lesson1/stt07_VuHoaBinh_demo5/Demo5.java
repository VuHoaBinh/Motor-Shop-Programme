package stt07_VuHoaBinh_demo5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Demo5 extends JFrame implements ActionListener, ItemListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JCheckBox italic, bold;
	JRadioButton left, right, center;
	JLabel field;
	
	
	Demo5(){
		super();
        setTitle("Demo5");
        JPanel jp1 = new JPanel();

        jp1.add(italic = new JCheckBox("Italic"));
        italic.addItemListener(this);
        jp1.add(bold = new JCheckBox("Bold"));
        bold.addItemListener(this);
        
        jp1.add(left = new JRadioButton("Left", true));
        left.addActionListener(this);
        jp1.add(center = new JRadioButton("Center"));
        center.addActionListener(this);
        jp1.add(right = new JRadioButton("Right"));
        right.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(left);
        group.add(right);
        group.add(center);

        this.add(jp1, BorderLayout.NORTH);
        
        this.add(field = new JLabel("This text typed by Binh"));
        field.setFont(new Font("Times New Roman",Font.PLAIN,16));
        field.setPreferredSize(new Dimension(300, 100));

        
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        pack();

        setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new Demo5().setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Font f = field.getFont();
		int style = f.getStyle();
		
		if (e.getSource() == italic) {
            style ^= Font.ITALIC; 
        }
		if (e.getSource() == bold) {
            style ^= Font.BOLD; 
        }
		
		field.setFont(new Font(f.getName(), style, f.getSize()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o == left) {
			field.setHorizontalAlignment(SwingConstants.LEFT);
		}
		if(o == center) {
			field.setHorizontalAlignment(SwingConstants.CENTER);
		}
		if(o == right) {
			field.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		
		
	}
}
