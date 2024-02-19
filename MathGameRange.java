import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import sun.audio.*;

public class MathGameRange extends JFrame implements ItemListener,ActionListener {
	int a = 0;
	//others
	JLayeredPane MainPanel = getLayeredPane();
	Font f = new Font("Brittanic Bold",1, 50);
	Font f2 = new Font("Consolas",Font.BOLD,85);
	
	//settings panel
	JPanel Difficulty = new JPanel();
	JLabel bg2 = new JLabel(new ImageIcon("chooseBG.png"));
	JLabel Settings = new JLabel(new ImageIcon("settings.png"));
	JLabel zerow = new JLabel(new ImageIcon("0-10.png"));
    JRadioButton radTen = new JRadioButton();
    JLabel eleben = new JLabel(new ImageIcon("11-20.png"));
	JRadioButton radTwenty = new JRadioButton();
	JLabel terty = new JLabel(new ImageIcon("21-30.png"));
	JRadioButton radThirty = new JRadioButton();
	ImageIcon btnNext = new ImageIcon("btnNext.png");
	JButton btnDone = new JButton();
	ImageIcon btnTutorialeu = new ImageIcon("btnTutorial.png");
	JButton btnTutorial = new JButton();
	ButtonGroup grpRange = new ButtonGroup();
	
	//tutorial part
	JFrame frame = new JFrame();
	ImageIcon nekst = new ImageIcon("btnNexteu.png");
	JButton nexteu = new JButton();//button for next image
	JLabel tutor1 = new JLabel(new ImageIcon("tutor1.png"));
	JLabel tutor2 = new JLabel(new ImageIcon("tutor2.png"));
	JLabel tutor3 = new JLabel(new ImageIcon("tutor3.png"));
	JLabel tutor4 = new JLabel(new ImageIcon("tutor4.png"));
	private ImageIcon[] image = new ImageIcon[4];
	JLabel ImageLabel = new JLabel(image[0]);
	
	
	int gameRange=0;
	
	public void itemStateChanged(ItemEvent e){
		if(radTen.isSelected()){
			gameRange=1;
		}
		if(radTwenty.isSelected()){
			gameRange=2;
		}
		if(radThirty.isSelected()){
			gameRange=3;
		}
		
	}
	public void actionPerformed(ActionEvent e){
		 if(e.getSource() == btnDone){
		 		if(gameRange==0){
		 			JOptionPane.showMessageDialog(null,"Please enter a difficulty");	
		 		}
		 		else if(gameRange==1){
		 			TheMathGame s = new TheMathGame();
					setVisible(false);
		 		}
		 		else if(gameRange==2){
		 			TheMathGame2 s = new TheMathGame2();
		 			setVisible(false);
		 		}
		 		else if(gameRange==3){
		 			TheMathGame3 s = new TheMathGame3();
		 			setVisible(false);
		 		}
		 	}
	}
	public MathGameRange() {
		super("The Game");
		MainPanel.setLayout(new CardLayout());
    	MainPanel.setVisible(true);
		setVisible(true);  
    	setBounds(200,20,870,650);
    	setDefaultCloseOperation(EXIT_ON_CLOSE); 
    	setResizable(false); 
    	
    	image[0] = new ImageIcon("tutor1.png");
		image[1] = new ImageIcon("tutor2.png");
		image[2] = new ImageIcon("tutor3.png");
		image[3] = new ImageIcon("tutor4.png");
    
       	Container d = getContentPane();
    	d.add(Difficulty);
    	
    	//settings
    	Difficulty.setLayout(null);
    	Settings.setBounds(240,0,450,200);
    	radTen.setBounds(250,160,160,50);
    	zerow.setBounds(270,80,200,200);
    	radTwenty.setBounds(250,250,160,50);
    	eleben.setBounds(250,150,250,250);		
    	radThirty.setBounds(250,340,160,50);
    	terty.setBounds(270,250,250,250);
    	btnDone.setBounds(320,500,120,80);
    	btnTutorial.setBounds(40,470,120,120);
    	bg2.setBounds(0,0,870,650);
    	Difficulty.add(Settings);
    	Difficulty.add(radTen);
    	Difficulty.add(radTwenty);
    	Difficulty.add(radThirty);
    	Difficulty.add(btnDone);
    	Difficulty.add(btnTutorial);
    	Difficulty.add(zerow);
    	Difficulty.add(eleben);
    	Difficulty.add(terty);
    	Difficulty.add(bg2);
    	grpRange.add(radTen);
    	grpRange.add(radTwenty);
    	grpRange.add(radThirty);
    	radTen.addItemListener(this);
    	radTwenty.addItemListener(this);
    	radThirty.addItemListener(this);
    	btnDone.addActionListener(this);
    	
    	btnDone.setOpaque(false);
    	btnDone.setContentAreaFilled(false);
    	btnDone.setBorderPainted(false);
    	btnDone.setIcon(btnNext);
    	
    	btnTutorial.setOpaque(false);
    	btnTutorial.setContentAreaFilled(false);
    	btnTutorial.setBorderPainted(false);
    	btnTutorial.setIcon(btnTutorialeu);
    	
		radTen.setFont(f);
		radTen.setOpaque(false);		
		radTwenty.setFont(f);
		radTwenty.setOpaque(false);		
		radThirty.setFont(f);
		radThirty.setOpaque(false);
		
		btnTutorial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				frame.setLayout(null);
				frame.setBounds(200,20,870,650);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				
				frame.add(nexteu);
				frame.add(ImageLabel);
				
				frame.add(tutor1);
				frame.add(tutor2);
				frame.add(tutor3);
				frame.add(tutor4);
				
				nexteu.setBounds(780,310,70,70);
				ImageLabel.setBounds(0,0,870,650);
				tutor1.setBounds(0,0,870,650);
				tutor2.setBounds(0,0,870,650);
				tutor3.setBounds(0,0,870,650);
				
				nexteu.setOpaque(false);
				nexteu.setContentAreaFilled(false);
				nexteu.setBorderPainted(false);
				nexteu.setIcon(nekst);
				
				nexteu.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent arg0){
						ImageLabel.setIcon(image[1]);
						nexteu.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent arg0){
						ImageLabel.setIcon(image[2]);
						nexteu.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent arg0){
						ImageLabel.setIcon(image[3]);
						nexteu.setVisible(false); } }); } }); } });
				
			}
			});
	}
	public static void main(String args[]){
	MathGameRange s = new MathGameRange();
	JDialog.setDefaultLookAndFeelDecorated(true);
	/*EventQueue.invokeLater(new Runnable() {
   public void run() {
    try {
     	MathGameRange frame = new MathGameRange(a);
     	frame.setVisible(true);
    	} catch (Exception e) {
    }
     	//e.printStackTrace();
   }
  });*/

	}
	}
