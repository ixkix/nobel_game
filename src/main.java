import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.*;

class main extends JFrame implements ActionListener {

	main() {	
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
	}
	
	
	public static void main(String[] args){
		new main();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {	//ここはイベント処理
		if(e.getActionCommand() == "Save") {
			System.out.println("save");				//セーブ処理(未実装)
		} else if(e.getActionCommand() == "Load") {
			System.out.println("load");				//ロード処理(未実装)
		} else if(e.getActionCommand() == "Exit") {
			setVisible(false);						//終了処理
		} else if(e.getActionCommand() == "Version") {
			Verinfo dlg = new Verinfo(this); // ダイアログを表示(バージョンとか
			dlg.show();
		}
}
	
	class Verinfo extends JDialog implements ActionListener {	//バージョン表示処理開始
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
	}//ここまでバージョン表示処理
}