package ui;
import java.awt.BorderLayout;
import java.awt.Color;
import javafx.embed.swing.JFXPanel;
import javax.swing.*;
import java.io.File;
import ui.GoogleMapsScene;

public class MainFrame extends JFrame {
	private JPanel currentPanel;
	
	public MainFrame(String[] args) {
		setSize(1024, 768);
		setLayout(new BorderLayout());
		add(new LeftNavigation(this), BorderLayout.WEST);
		this.currentPanel = new SearchPanel();
		add(this.currentPanel, BorderLayout.CENTER);
		setBackground(Color.YELLOW);
		this.getContentPane().setBackground(Color.white);
		
		setVisible(true);
	}
	
	public void changePanel(String name) {		
		this.getContentPane().remove(this.currentPanel);
		if(name == "공항검색") {
			this.currentPanel = new SearchPanel();
		}else if(name == "즐겨찾기") {
			this.currentPanel = new FavoritePanel();
		}else if(name == "국가별 통계") {
			this.currentPanel = new StatisticsPanel(new CountryChartPanel());
		}else {
			this.currentPanel = new StatisticsPanel(new RegionChartPanel());
		}
		this.getContentPane().add(this.currentPanel);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			UIManager.setLookAndFeel("com.formdev.flatlaf.FlatDarkLaf" );
			//set look and feel 
			MainFrame mf = new MainFrame(args);
			mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
			System.out.println("가나다라마바사");
		} catch (Exception e) {
			
		}
		/*
		MainFrame mf = new MainFrame(args);
		mf.setDefaultCloseOperation(EXIT_ON_CLOSE);
		*/
	}

}
