import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;




public class main extends JFrame implements ActionListener {
	
	JPanel main_p = new JPanel();	
	main(){
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem menuLoad = new JMenuItem("Load");
		JMenuItem menuSave = new JMenuItem("Save");
		JMenuItem menuExit = new JMenuItem("Exit");
		JMenu info = new JMenu("Info");
		JMenuItem infoSet = new JMenuItem("Settings");
		JMenuItem infoVer = new JMenuItem("Version");
		
		setBackground(Color.black);
	
		menuSave.addActionListener(this);
		menuLoad.addActionListener(this);
		menuExit.addActionListener(this);
		infoVer.addActionListener(this);

		getContentPane().add(main_p);
		getRootPane().setJMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(menuSave);
		menu.add(menuLoad);
		menu.add(menuExit);
		menuBar.add(info);
		info.add(infoSet);
		info.add(infoVer);	
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("nobel_game");
		setSize(800, 600);
		setVisible(true);
		
		stmp();
	}
	
	JPanel sub_p = new JPanel();
	
	private void stmp() {//�ŏ��̉�ʏ���
		JButton new_g = new JButton("New  Game");
		new_g.setMaximumSize(new Dimension(100,100));
		JButton lod_g = new JButton("Load Game");
		lod_g.setMaximumSize(new Dimension(100, 100));
		JButton ext_g = new JButton("Exit Game");
		ext_g.setMaximumSize(new Dimension(100,100));
		
		new_g.addActionListener(this);
		lod_g.addActionListener(this);
		ext_g.addActionListener(this);
		

		sub_p.setLayout(new GridLayout(3,0,10,10));
		sub_p.setBackground(Color.black);
		main_p.setBackground(Color.black);
		main_p.add(sub_p);
		
		sub_p.add(new_g);
		sub_p.add(lod_g);
		sub_p.add(ext_g);
		
	}

	private void game_p(){//�Q�[�����̉�ʂ̏���
		System.out.println("kita-");
	}
	

	public static void main(String[] args){
		new main();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {	//�����̓C�x���g����
		if(e.getActionCommand() == "Save") {
			System.out.println("save");				//�Z�[�u����(������)
		} else if(e.getActionCommand() == "Load" || e.getActionCommand() == "Load Game") {
			System.out.println("load");				//���[�h����(������)
		} else if(e.getActionCommand() == "Exit" || e.getActionCommand() == "Exit Game") {
			setVisible(false);						//�I������
		} else if(e.getActionCommand() == "Version") {
			Verinfo dlg = new Verinfo(this); // �_�C�A���O��\��(�o�[�W�����Ƃ�
			dlg.show();
		} else if(e.getActionCommand() == "New  Game") {//�j���[�Q�[���̏���
			main_p.remove(sub_p);
			repaint();
			game_p();
		}
}
	
	class Verinfo extends JDialog implements ActionListener {	//�o�[�W�����\�������J�n
		Verinfo(JFrame owner) {
			super(owner);
			getContentPane().setLayout(new GridLayout(4,1));
			JLabel info_t = new JLabel("Nobel_Game");
			JLabel info_l = new JLabel("Created by ixkix");
			JLabel info_v = new JLabel("Version 0.1a");
			
			JButton exit_btn = new JButton("Exit");
			exit_btn.addActionListener(this);
			getContentPane().add(info_t);
			getContentPane().add(info_v);
			getContentPane().add(info_l);
			getContentPane().add(exit_btn);
			setTitle("Version");
			setSize(200, 150);
			setVisible(true);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			hide();

		}
	}//�����܂Ńo�[�W�����\������
	
}