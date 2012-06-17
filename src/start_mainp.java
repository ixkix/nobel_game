import javax.swing.*;
import java.awt.*;

class start_mainp extends main {


	start_mainp(){

		JButton new_g = new JButton("New  Game");
		JButton lod_g = new JButton("Load Game");
		JButton ext_g = new JButton("Exit Game");
		

		main_p.setLayout(new BorderLayout());
		main_p.add(new_g);
		main_p.add(lod_g);
		main_p.add(ext_g);
	}
	
}
