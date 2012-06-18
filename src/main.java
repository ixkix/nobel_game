//	Nobel Game(Demo)
//	Created by ixkix
//	(」・ω・)」うー！(／・ω・)／にゃー！
//	Since 15.6.2012


import javax.imageio.*;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.event.*;


public class main extends JFrame implements ActionListener {
	
	
	////////////////////////////////////////////////////////////////////////////////////////
	//＿人人人人人＿
	//＞ 突然の宣言 ＜
	//￣Y^Y^Y^Y^Y￣
	
	JPanel main_p = new JPanel();
	JPanel sub_p = new JPanel();
	
	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("Menu");
	JMenuItem menuLoad = new JMenuItem("Load");
	JMenuItem menuSave = new JMenuItem("Save");
	JMenuItem menuExit = new JMenuItem("Exit");
	JMenu info = new JMenu("Info");
	JMenuItem infoSet = new JMenuItem("Settings");
	JMenuItem infoVer = new JMenuItem("Version");
	
	
	JButton new_g = new JButton("New  Game");
	JButton lod_g = new JButton("Load Game");
	JButton ext_g = new JButton("Exit Game");
	
	JLabel pic_p = new JLabel();
	JPanel txt_p = new JPanel();
	
	JButton save1 = new JButton("first save data");
	JButton save2 = new JButton("second save data");
	JButton save3 = new JButton("third save data");
	
	JLabel info_t = new JLabel("Nobel_Game");
	JLabel info_l = new JLabel("Created by ixkix");
	JLabel info_v = new JLabel("Version 0.5a");
	
	JButton exit_btn = new JButton("Exit");
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	GridBagConstraints gb2 = new GridBagConstraints();
	
	/////////////////////////////////////////////////////////////////////////////////////////
	
	
	main(){										//メインの処理
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
		setTitle("Nobel_Game");
		setSize(800, 600);
		setVisible(true);
		setResizable(false);
		start_main_panel();
	}
	
	BufferedImage bgi = null;
	
	private void start_main_panel() {		//最初の画面処理

		main_p.setLayout(gbl);
//		new_g.setMaximumSize(new Dimension(100,100));
//		lod_g.setMaximumSize(new Dimension(100, 100));
//		ext_g.setMaximumSize(new Dimension(100,100));
		
		//bgi = ImageIO.read(new File("./start.png"));

		//main_p.add(new bgi);
	
		new_g.addActionListener(this);
		lod_g.addActionListener(this);
		ext_g.addActionListener(this);
		
		gbc.gridx = 4;
		gbc.gridheight = 2;
		gbc.gridwidth = 6;
		gbc.insets.bottom = 2;
		gbc.insets.top = 2;
		
		gbc.gridy = 1;
		gbl.setConstraints(new_g,gbc);
		gbc.gridy = 3;
		gbl.setConstraints(lod_g,gbc);
		gbc.gridy = 5;
		gbl.setConstraints(ext_g,gbc);
		
		main_p.add(new_g);
		main_p.add(lod_g);
		main_p.add(ext_g);
		
	}

	private void game_p(){				//ゲーム中の画面の処理
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


	void lod_g_s() {
		add(main_p);
		main_p.setLayout(gbl);
		main_p.setBackground(Color.cyan);
		
		gb2.gridx = 1;
		gb2.gridheight = 2;
		gb2.gridwidth = 10;	
		gb2.insets.bottom = 5;
		gb2.insets.top = 5;
		gb2.ipadx = 2;

		gb2.gridy = 1;
		gbl.setConstraints(save1,gb2);
		gb2.gridy = 3;
		gbl.setConstraints(save2,gb2);
		gb2.gridy = 5;
		gbl.setConstraints(save3,gb2);
		
		main_p.add(save1);
		main_p.add(save2);
		main_p.add(save3);
		setVisible(true);

	}


	void new_g_s(){
		FileReader f;
		try {
			f = new FileReader("D://workspace/novel-game/src/c1.ngs");
			BufferedReader b = new BufferedReader(f);
			String s;
	        s = b.readLine();
	        System.out.println(s);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		new main();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	//ここはイベント処理
		if(e.getActionCommand() == "Save") {
			System.out.println("save");				//セーブ処理(未実装)
		} else if(e.getActionCommand() == "Load" || e.getActionCommand() == "Load Game") {
			System.out.println("load");			//ロード処理(未実装)
			main_p.remove(new_g);
			main_p.remove(lod_g);
			main_p.remove(ext_g);
			main_p.remove(save1);
			main_p.remove(save2);
			main_p.remove(save3);
			getContentPane().remove(main_p);
			repaint();
			lod_g_s();
		} else if(e.getActionCommand() == "Exit" || e.getActionCommand() == "Exit Game") {
			setVisible(false);						//終了処理
		} else if(e.getActionCommand() == "Version") {
			Verinfo dlg = new Verinfo(this); // ダイアログを表示(バージョンとか
			dlg.show();
		} else if(e.getActionCommand() == "New  Game") {//ニューゲームの処理
			main_p.remove(new_g);
			main_p.remove(lod_g);
			main_p.remove(ext_g);
			getContentPane().remove(main_p);
			repaint();
			game_p();
//			new_g_s();
		}
}
	
	class Verinfo extends JDialog implements ActionListener {	//バージョン表示処理開始
		Verinfo(JFrame owner) {
			super(owner);
			getContentPane().setLayout(new GridLayout(4,1));

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
	}//ここまでバージョン表示処
}