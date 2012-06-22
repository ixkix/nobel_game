//	Nobel Game(Demo)
//	Created by ixkix
//	(」・ω・)」うー！(／・ω・)／にゃー！
//	Since 15.6.2012


import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.border.*;


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
	
	
	JLabel txt_l = new JLabel("");
	
	JButton exit_btn = new JButton("Exit");
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	GridBagConstraints gb2 = new GridBagConstraints();
	
	static String no1ngs = null;
	static String no2ngs = null;
	
	String lod_sina[] = new String[256];
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
		main_p.removeAll();
		main_p.setLayout(new BoxLayout(main_p,BoxLayout.Y_AXIS));
				
		main_p.add(pic_p);
		main_p.add(txt_p);
		pic_p.setMaximumSize(new Dimension(800,400));
//		txt_p.setMaximumSize(new Dimension(800,200));
		
		System.out.println("kita-");
		txt_p.setBackground(Color.black);
		setVisible(true);
	}


	void lod_g_s() {
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
}
	
	
	void load_scenario(KeyEvent k){
		int key = 0;
		int i = 0;
		int sina_long =  0;
/*		txt_p.add(txt_l);
		txt_l.setSize(800,200);*/
		txt_p.add(txt_l);
		txt_p.setBackground(Color.white);
		txt_p.setBorder(new LineBorder(Color.magenta,2));
		FileReader f;

//分岐処理
		try {

			txt_l.setMaximumSize(new Dimension(800,200));
			f = new FileReader(no1ngs);
			BufferedReader b = new BufferedReader(f);

			while((lod_sina[i] = b.readLine())!=null){
	
				System.out.println(lod_sina[i]);
				i++;
			}
			
			i=0;
			
			while(true){
				sina_long = 0;
				key=0;
				String tag = null;

					if(lod_sina[i].indexOf("<text>") != -1){
						tag = "text";
						sina_long = lod_sina[i].length();
					}else if(lod_sina[i].indexOf("<pict>") != -1){
						tag = "pict";
						sina_long = lod_sina[i].length();
					}else if(lod_sina[i].indexOf("<exit>") != -1){
						tag = "exit";
					}
			
				switch(tag){//命令の処理はここに
					case "text":
						lod_sina[i] = lod_sina[i].substring(6, sina_long);
						txt_l.setText(lod_sina[i]);
						
						int kc;
						 do{
							 kc = k.getKeyCode();
							 String kca = KeyEvent.getKeyText(kc);
						    }while(kca != ENTER);							//エンターキーを押すまで待機させる、それができたらおｋ
						break;
					
					case "pict":
						lod_sina[i] = lod_sina[i].substring(6, sina_long);
						ImageIcon icon = new ImageIcon("test.png");
						pic_p.setIcon(icon);
						break;
					
					case "exit":
						setVisible(false);
						break;
				}
				i++;

			}
			
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}
	
	public void mouseClicked(MouseEvent e){
	  }
	
	static void load_ini(){
	try {
		java.util.Properties prop = new java.util.Properties();
		prop.load(new java.io.FileInputStream("test.ini"));
		no1ngs = prop.getProperty("no1ngs");
		no2ngs = prop.getProperty("no2ngs");
		System.out.println(no1ngs);
		System.out.println(no2ngs);
		} catch (java.io.IOException e) {
		e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args){
		new main();
		load_ini();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	//ここはイベント処理
		if(e.getActionCommand() == "Save") {
			System.out.println("save");				//セーブ処理(未実装)
		} else if(e.getActionCommand() == "Load" || e.getActionCommand() == "Load Game") {
			System.out.println("load");			//ロード処理(未実装)
			main_p.removeAll();
			lod_g_s();
		} else if(e.getActionCommand() == "Exit" || e.getActionCommand() == "Exit Game") {
			setVisible(false);						//終了処理
		} else if(e.getActionCommand() == "Version") {
			Verinfo dlg = new Verinfo(this); // ダイアログを表示(バージョンとか
			dlg.show();
		} else if(e.getActionCommand() == "New  Game") {//ニューゲームの処理
			game_p();
//			new_g_s();
			load_scenario(null);
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