package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class GiaoDien extends JFrame implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GiaoDien() {
		this.setTitle("MOTOR SHOP");
		this.setSize(1200,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel jp_West = new JPanel();
		
		JMenuBar menuBar = new JMenuBar();
		
		
		JMenu menu = new JMenu("Menu");
		JMenuItem trangChu = new JMenuItem("Trang Chu");
		menu.add(trangChu);
		trangChu.addActionListener(this);
		menu.addSeparator();
		JMenuItem muaHang = new JMenuItem("Mua Hang");
		menu.add(muaHang);
		muaHang.addActionListener(this);
		menu.addSeparator();
		JMenuItem thongKe = new JMenuItem("Thong Ke");
		menu.add(thongKe);
		thongKe.addActionListener(this);
		menuBar.add(menu);
		
		
		JMenu help = new JMenu("Help");
		JMenuItem caidat = new JMenuItem("Cai Dat");
		help.add(caidat);
		caidat.addActionListener(this);
		help.addSeparator();
		JMenuItem hotro = new JMenuItem("Ho Tro");
		help.add(hotro);
		hotro.addActionListener(this);
		menuBar.add(help);
		
		jp_West.add(menuBar);
		add(jp_West, BorderLayout.NORTH);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GiaoDien().setVisible(true);
            }
        });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		JTabbedPane tplMainBoard = new JTabbedPane();
		
		//Trang chu
		if(button.equalsIgnoreCase("Trang Chu")) {
			TrangChu trangChuPanel = new TrangChu();
			if(trangChuPanel!=null) {
				ImageIcon icon = new ImageIcon(getClass().getResource("/icons/10207-man-student-light-skin-tone-icon-16.png"));
				tplMainBoard.addTab("Trang Chu", icon, trangChuPanel, "Trang Chu");
			}
			tplMainBoard.setSelectedComponent(trangChuPanel);
		}
		
		// mua hang
		if(button.equalsIgnoreCase("Mua Hang")) {
			MuaHang muaHangPanel = new MuaHang();
			if(muaHangPanel!=null) {
				ImageIcon icon = new ImageIcon(getClass().getResource("/icons/10207-man-student-light-skin-tone-icon-16.png"));
				tplMainBoard.addTab("Mua Hang", icon, muaHangPanel, "Mua Hang");
			}
			tplMainBoard.setSelectedComponent(muaHangPanel);
		}
		
		// thong ke
		if(button.equalsIgnoreCase("Thong Ke")) {
			ThongKe thongKePanel = new ThongKe();
			if(thongKePanel!=null) {
				ImageIcon icon = new ImageIcon(getClass().getResource("/icons/10207-man-student-light-skin-tone-icon-16.png"));
				tplMainBoard.addTab("Thong Ke", icon, thongKePanel, "Thong Ke");
			}
			tplMainBoard.setSelectedComponent(thongKePanel);
		}
		 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
