package stt07_VuHoaBinh_demo2;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Demo2 extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nmText;
	private JLabel resultLabel;
	JButton btnExit;
	//get and set
	public JTextField getNmText() {
		return nmText;
	}
	public void setNmText(JTextField nmText) {
		this.nmText = nmText;
	}
	public JLabel getResultLabel() {
		return resultLabel;
	}
	public void setResultLabel(JLabel resultLabel) {
		this.resultLabel = resultLabel;
	}
	
	//constructor
	public Demo2(JTextField nmText, JLabel resultLabel) throws HeadlessException {
		super();
		this.nmText = nmText;
		this.resultLabel = resultLabel;
	}
	
	Demo2(){
		super("Converge mm to cm");

		JPanel jp = new JPanel();
		// input
		
		jp.add(new JLabel("Input number of millimet: "));
		jp.add(nmText = new JTextField(10));
		nmText.addActionListener(this);
		
		jp.add(new JLabel("Result -> m : "));
		jp.add(resultLabel = new JLabel("....."));
		
		// btn
		btnExit = new JButton("Exit");
		btnExit.addActionListener(this);
		
		jp.add(btnExit, BorderLayout.CENTER);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		add(jp);
		pack();
		
		setSize(300, 250);
		setLocationRelativeTo(null);
        setVisible(true);
        
        
        
	}
	public static void main(String[] args) {
		new Demo2().setVisible(true);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnExit)) {
			System.exit(0);
		}
		double mm = Double.parseDouble(nmText.getText()); // get value
		double cm = mm/10;
		String str = convertNumberToWords(cm);
		resultLabel.setText(str);
	}
	
	public static String convertNumberToWords(double number) {
		if (number <0 ) {
			return "Nhap lai";
		}

		if (number == 0) {
            return "Zero";
        }

        String[] numbers = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };

        String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };
        

        if (number < 20) {
            return numbers[(int) number];
        } else if (number < 100) {
            return tens[(int) (number / 10)] + " " + numbers[(int) (number % 10)];
        } else if (number < 1000) {
            return numbers[(int) (number / 100)] + " Hundred "  + convertNumberToWords(number % 100);
        } else if (number < 10000) {
            return numbers[(int) (number / 1000)] + " Million "  + convertNumberToWords(number % 1000);
        } else if (number < 100000) {
            return numbers[(int) (number / 10000)] + " Billions "  + convertNumberToWords(number % 10000);
        }else {
        	return "Number too large to convert.";        	
        }

    }

}
