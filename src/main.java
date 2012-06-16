import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;




public class main extends JFrame implements ActionListener {
	
	JPanel main_p = new JPanel();	
	main(){
		setResizable(false);
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
	
	private void stmp() {//最初の画面処理
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

	JLabel pic_p = new JLabel();
	JPanel txt_p = new JPanel();
	private void game_p(){//ゲーム中の画面の処理
		add(main_p);
		ImageIcon icon = new ImageIcon("D://workspace/novel-game/src/test.png");
		main_p.setLayout(new BorderLayout(2,0));
		
		main_p.add(pic_p);
		main_p.add(txt_p);
		
		pic_p.setSize(800,400);
		pic_p.setIcon(icon);
		txt_p.setSize(800,200);
		txt_p.setBackground(Color.blue);
		
		
		System.out.println("kita-");
	}
	

	public static void main(String[] args){
		new main();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {	//ここはイベント処理
		if(e.getActionCommand() == "Save") {
			System.out.println("save");				//セーブ処理(未実装)
		} else if(e.getActionCommand() == "Load" || e.getActionCommand() == "Load Game") {
			System.out.println("load");				//ロード処理(未実装)
		} else if(e.getActionCommand() == "Exit" || e.getActionCommand() == "Exit Game") {
			setVisible(false);						//終了処理
		} else if(e.getActionCommand() == "Version") {
			Verinfo dlg = new Verinfo(this); // ダイアログを表示(バージョンとか
			dlg.show();
		} else if(e.getActionCommand() == "New  Game") {//ニューゲームの処理
			main_p.remove(sub_p);
			remove(main_p);
			repaint();
			game_p();
		}
}
	
	class Verinfo extends JDialog implements ActionListener {	//バージョン表示処理開始
		Verinfo(JFrame owner) {
			super(owner);
			getContentPane().setLayout(new GridLayout(4,1));
			JLabel info_t = new JLabel("Nobel_Game");
			JLabel info_l = new JLabel("Created by ixkix");
			JLabel info_v = new JLabel("Version 0.3a");
			
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
	}//ここまでバージョン表示処理
	
}