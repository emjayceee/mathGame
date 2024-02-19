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


public class TheMathGame2 extends JFrame implements ItemListener,ActionListener{
	
	//others
	JLayeredPane MainPanel = getLayeredPane();
	Font f = new Font("Consolas",1, 43);
	Font f2 = new Font("Consolas",Font.BOLD,85);
	Font f3;
	//settings panel
	JPanel Operation = new JPanel();
	JLabel Settings = new JLabel(new ImageIcon("settings2.png"));
	private JLabel bg3 = new JLabel(new ImageIcon("operationBG.png"));
	private JLabel bg4 = new JLabel(new ImageIcon("gameBG.png"));
	private JCheckBox chkAdd = new JCheckBox();
	private JCheckBox chkSub = new JCheckBox();
	private JCheckBox chkMulti = new JCheckBox();
	ImageIcon btnDoneu = new ImageIcon("btnDone.png");
	private JButton btnDone = new JButton();
	
	//Operators
	int gameOperate=0;
	String operatorSwitch=null;
    //Random operatorChoice = new Random();
    //int operator = operatorChoice.nextInt(4);
	int ctr = 0; //Counts up for every selected CheckBox; used in array indexing
	String operator[] = new String[3];
	String Oprt;
	int range,rand,min,max;
		
	//play area panel
	JPanel GamePlay=new JPanel();
	JLabel questionShown = new JLabel("");
	ImageIcon btnStarteu= new ImageIcon("btnStart.png");
	JButton btnStart = new JButton();
	ImageIcon btnCheckeu = new ImageIcon("btnCheck.png");
	JButton btnCheck = new JButton();
	JTextField answer = new JTextField(5);
	
	//BG music
	static File musicPath;                           
    static AudioInputStream audioInput;
    static Clip clip;
	
	//answers
	int num1,num2,stop = 0,correct = 0,wrong = 0;
  	int result;
  	String question; 
	
	public void itemStateChanged(ItemEvent e){
		ctr=0;
		if(chkAdd.isSelected()){
			gameOperate=1;
			//operatorSwitch= "+";
			operator[ctr] = "+"; //operator[1] = {1, 4, 0, 0}; ctr = 1; c++;
			ctr++;
		}
		if(chkSub.isSelected()){
			gameOperate=2;
			//operatorSwitch= "-";
			operator[ctr] = "-"; //operator[1] = {1, 4, 0, 0}; ctr = 1; c++;
			ctr++;
		}
		if(chkMulti.isSelected()){
			gameOperate=3;
			//operatorSwitch= "x";
			operator[ctr] = "x"; //operator[1] = {1, 4, 0, 0}; ctr = 1; c++;
			ctr++;
		}
		
	}
	public void actionPerformed(ActionEvent e){
		 if(e.getSource() == btnDone){
		 	if(gameOperate==0){
		 	JOptionPane.showMessageDialog(null,"Please enter an operation");	
		 	}
		 	if (operator.length == 0){
		 		JOptionPane.showMessageDialog(null,"Operator selection is empty.");
		 	}
				
		 	else{
            switchPanel(GamePlay);}}
         answer.requestFocus();
    	 if(e.getSource()== btnStart) {
    			btnStart.setVisible(false);
    			stop = 1;
    			btnCheck.setVisible(true);
    			operatorSwitch = operator[randomizer(0,ctr-1)];
    			if (operatorSwitch.equals("+")){
    			num1 = (int) (Math.random()*(20 - 11) + 11); // generating number 0 - 5
				num2 = (int) (Math.random()*(20 - 11) + 11);
    			result = num1+num2;	
    			question = (" " + num1+ " + "+ num2);
    			}
    			else if (operatorSwitch.equals("-")){
    			num1 = (int) (Math.random()*(20 - 11) + 11); // generating number 0 - 5
				num2 = (int) (Math.random()*(20 - 11) + 11);
				while(num1<num2){
    			num1 = (int) (Math.random()*(20 - 11) + 11); // generating number 0 - 5
				num2 = (int) (Math.random()*(20 - 11) + 11);
    			}
    			result = num1-num2;	
    			question = (" " + num1+ " - "+ num2);
    			}
    			else if (operatorSwitch.equals("x")){
    			num1 = (int) (Math.random()*(20 - 11) + 11); // generating number 0 - 5
				num2 = (int) (Math.random()*(20 - 11) + 11);
    			result = num1*num2;	
    			question = (" " + num1+ " x "+ num2);
    			}
				}
    		questionShown.setText(question);
    		}
	public void switchPanel(JPanel pane){ 
        MainPanel.removeAll();
        MainPanel.add(pane);
        MainPanel.repaint();
        MainPanel.revalidate();
    }
    public int randomizer(int min, int max){
		range = max - min + 1;	
		rand = (int)(Math.random() * range) + min;
		return rand;
	}
	/*public static void playBGMusic(String musicLocation){
         try{
         musicPath= new File(musicLocation);
         audioInput= AudioSystem.getAudioInputStream(musicPath);
                 clip= AudioSystem.getClip();
                 clip.open(audioInput);
                 clip.loop(Clip.LOOP_CONTINUOUSLY);
             }catch(Exception e){
                 System.out.println(e);
             }
           
         }*/
	public TheMathGame2(){
		super("Average Round");
		MainPanel.setLayout(new CardLayout());
    	MainPanel.setVisible(true);
		setVisible(true);  
    	setBounds(200,20,870,650);
    	setDefaultCloseOperation(EXIT_ON_CLOSE); 
    	setResizable(false); 
    	try{
			f3 = Font.createFont(Font.TRUETYPE_FONT, new File("SNOW BLUE.ttf")).deriveFont(65f);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("SNOW BLUE.ttf")));
			
		}
		catch(IOException | FontFormatException e){
			
		}
       	Container d = getContentPane();
    	d.add(Operation);
    	
    	//Operation Settings
    	Operation.setLayout(null);
    	Settings.setBounds(250,60,450,100);
    	chkAdd.setBounds(190,190,350,50);	
    	chkSub.setBounds(190,330,350,50);			
    	chkMulti.setBounds(190,460,350,50);	
    	btnDone.setBounds(390,550,120,60);
    	bg3.setBounds(0,0,870,650);
    	Operation.add(Settings);
    	Operation.add(chkAdd);	
    	Operation.add(chkSub);	
    	Operation.add(chkMulti);	
    	Operation.add(btnDone);
    	Operation.add(bg3);
    	chkAdd.addItemListener(this);
    	chkSub.addItemListener(this);
    	chkMulti.addItemListener(this);
    	btnDone.addActionListener(this);
    	
    	chkAdd.setFont(f);
    	chkAdd.setOpaque(false);	
		chkSub.setFont(f);
		chkSub.setOpaque(false);	
		chkMulti.setFont(f);
		chkMulti.setOpaque(false);		

		//play area
    	GamePlay.setLayout(null);
    	
    	GamePlay.add(btnCheck);
    	GamePlay.add(btnStart);
    	GamePlay.add(answer);
    	GamePlay.add(questionShown);
    	GamePlay.add(bg4);
    	
    	btnCheck.setBounds(510,520,110,50);
    	btnStart.setBounds(510,460,110,50);
    	answer.setBounds(340,480,100,60);
    	questionShown.setBounds(120,60,650,500);
    	bg4.setBounds(0,0,870,650);
    	
    	answer.setFont(f);
    	questionShown.setFont(f3);
    	answer.setBackground(Color.GRAY);
		
		btnDone.setOpaque(false);
    	btnDone.setContentAreaFilled(false);
    	btnDone.setBorderPainted(false);
    	btnDone.setIcon(btnDoneu);
    	
		btnStart.setOpaque(false);
    	btnStart.setContentAreaFilled(false);
    	btnStart.setBorderPainted(false);
    	btnStart.setIcon(btnStarteu);
    	
    	btnCheck.setOpaque(false);
    	btnCheck.setContentAreaFilled(false);
    	btnCheck.setBorderPainted(false);
    	btnCheck.setIcon(btnCheckeu);
    	
    	btnStart.addActionListener(this);
    	btnCheck.addActionListener(new ActionListener(){
    		public void actionPerformed(ActionEvent e){
    			if(stop == 0){
    				JOptionPane.showMessageDialog(null,"Please click START!");
    			} else {
    				try{
    				int ans = Integer.parseInt(answer.getText());
    			answer.requestFocus();
    			if (operatorSwitch.equals("+")){
    			result = num1+num2;	
    			}
    			else if (operatorSwitch.equals("-")){
    			result = num1-num2;	
    			}
    			else if (operatorSwitch.equals("x")){
    			result = num1*num2;	
    			}
    			//result = num1+num2; //formula
    			if(ans != result){
    				//JOptionPane.showMessageDialog(null,"You got it wrong! "+num1+" + "+ num2 +" = "+result+"\nTry Again!");
    				JOptionPane.showMessageDialog(null,"You got it wrong! "+num1+operatorSwitch+ num2 +" = "+result+"\nTry Again!");
    				answer.setText("");
    				wrong = 1;
    				//btnNext.setVisible(false);
    			} else {
    				JOptionPane.showMessageDialog(null,"Aye! You are right!\nCONGRATULATIONS!");
    				//btnNext.setVisible(true);
    				correct = 1;
    				if(correct == 1){
    				answer.setText("");
    				operatorSwitch = operator[randomizer(0,ctr-1)];
    				if (operatorSwitch.equals("+")){
    					num1 = (int) (Math.random()*(20 - 11) + 11); // generating number 0 - 5
				num2 = (int) (Math.random()*(20 - 11) + 11);
    					result = num1+num2;	
    					question = (" " + num1+ " + "+ num2);
    				}
    				else if (operatorSwitch.equals("-")){
    					num1 = (int) (Math.random()*(20 - 11) + 11); // generating number 0 - 5
				num2 = (int) (Math.random()*(20 - 11) + 11);
						while(num1<num2){
    						num1 = (int) (Math.random()*(20 - 11) + 11); // generating number 0 - 5
				num2 = (int) (Math.random()*(20 - 11) + 11);
    					}
    					result = num1-num2;	
    					question = (" " + num1+ " - "+ num2);
    				}
    				else if (operatorSwitch.equals("x")){
    					num1 = (int) (Math.random()*(20 - 11) + 11); // generating number 0 - 5
				num2 = (int) (Math.random()*(20 - 11) + 11);
    					result = num1*num2;	
    					question = (" " + num1+ " x "+ num2);
    			}
    			} else {
    				wrong++;
    			}
    			}
    			
    			questionShown.setText(question);
    			} catch (NumberFormatException a){
    				JOptionPane.showMessageDialog(null,"Please enter an integer!");
    				answer.setText("");
    			}	
    			}
    			//btnCheck.setVisible(false);
    			
    		}
    	});
    	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                                                             
        final TheMathGame2 close = this;
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int i = JOptionPane.showConfirmDialog(close,
                        "Do you want to exit?", "Math Game",JOptionPane.YES_NO_OPTION);
                if (i == JOptionPane.YES_OPTION) {
                		MathGameStart g = new MathGameStart();
                		setVisible(false);
                }
            }
        }); 
	}
	
	public static void main(String args[]){
		
	TheMathGame2 s = new TheMathGame2();
	JDialog.setDefaultLookAndFeelDecorated(true);
	//playBGMusic("SoundMath.wav");
	}
}