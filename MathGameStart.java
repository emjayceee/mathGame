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

public class MathGameStart extends JFrame implements ActionListener{
	Font f = new Font("Arial",0, 21);
	JLabel bg = new JLabel(new ImageIcon("Background.png"));
	Icon icon = new ImageIcon("start button.png");
    JButton btnStart = new JButton(icon);
    
   	static File musicPath;                           
    static AudioInputStream audioInput;
    static Clip clip;
		
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btnStart){
			MathGameRange s = new MathGameRange();
			setVisible(false);
		}
	}
	public static void playBGMusic(String musicLocation){
         try{
         musicPath= new File(musicLocation);
         audioInput= AudioSystem.getAudioInputStream(musicPath);
                 clip= AudioSystem.getClip();
                 clip.open(audioInput);
                 clip.loop(Clip.LOOP_CONTINUOUSLY);
             }catch(Exception e){
                 System.out.println(e);
             }
           
     	}
	public MathGameStart(){
		super("Math Game");
		
		setVisible(true);  
    	setBounds(200,20,870,650);
    	setDefaultCloseOperation(EXIT_ON_CLOSE); 
    	setResizable(false); 
    
       	Container c = getContentPane();
    	c.setLayout(null);
    	
    	btnStart.setBounds(350,500,170,70);
    	bg.setBounds(0,0,870,650);
    	
    	c.add(btnStart);
    	c.add(bg);
    	
    	btnStart.addActionListener(this);
	}	
	public static void main(String args[]){
		
	MathGameStart g = new MathGameStart();
	JDialog.setDefaultLookAndFeelDecorated(true);
	playBGMusic("SoundMath.wav");
	}
}
