import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

public class DisplayCard {

	private JFrame frame;
	private int[] deck = new int[52]; //A deck has 52 cards
	private int count = 4; // Count the cards whitch they are be drawn
	ImageIcon[] card = new ImageIcon[4]; //four images
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
	        public void run() {
		try {
			DisplayCard window = new DisplayCard();
			window.frame.setVisible(true);
		} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
  
  //shuffle cards
	public void shuffle(){
		for(int i=0; i<deck.length; i++){
			int index = (int)(Math.random() * deck.length);
			int temp = deck[i];
			deck[i] = deck[index];
			deck[index] = temp;
		}
	}
	
	public DisplayCard() {
		DisplayCards();
	}

	
	private void DisplayCards() {
		frame = new JFrame("Pick Four Cards");
    
    //initialize the cards
		for(int i=0; i<deck.length; i++)
			deck[i] = i;
		
		shuffle();
		
		for(int i=0; i<4; i++){
			String handcard = Integer.toString(deck[i]+1);
			card[i] = new ImageIcon(getClass().getResource("card/"+handcard+".png"));
		} 
		
		JLabel card1 = new JLabel(card[0]); //Label with an image
		card1.setBounds(0, 2, 91, 120); // 0 is x, 2 is y,the card's width is 91,and the card's height is 120
		frame.getContentPane().add(card1);
		
		JLabel card2 = new JLabel(card[1]);
		card2.setBounds(92, 2, 91, 120);
		frame.getContentPane().add(card2);
		
		JLabel card3 = new JLabel(card[2]);
		card3.setBounds(185, 2, 91, 120);
		frame.getContentPane().add(card3);
		
		JLabel card4 = new JLabel(card[3]);
		card4.setBounds(277, 2, 91, 120);
		frame.getContentPane().add(card4);
		
		
		//set frame size and location
		frame.setBounds(400, 200, 390, 210);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		JButton refresh = new JButton("refresh");
	
		//The refresh button action
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { 
				for(int i=0; i<4; i++){
					String handcard = Integer.toString(deck[i+count]+1);
					card[i] = new ImageIcon(getClass().getResource("card/"+handcard+".png"));
				}
				count = count + 4;
				card1.setIcon(card[0]);
				card2.setIcon(card[1]);
				card3.setIcon(card[2]);
				card4.setIcon(card[3]);
				
				//There are not remaining cards in the deck. Shuffle cards again.
				if(count == 48){ 
					count = 0;
					shuffle();
					JOptionPane.showMessageDialog(null, "shuffle card!");
				}
			}
		});
		refresh.setBounds(131, 138, 91, 23);
		frame.getContentPane().add(refresh);
		
		
	}
}
