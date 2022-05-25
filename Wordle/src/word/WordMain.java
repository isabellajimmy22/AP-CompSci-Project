package word;

import javax.swing.JOptionPane;

public class WordMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//list of possible hidden words 
		//if you want to add words remember to change the amount in
		//math.random
		String[] arr = {"small",
				"quizz",
				"cruel",
				"janky",
				"junks",
				"bogus",
				"crazy",
				"joked",
				"wrong",
				"jerks", 
				"gnome", 
				"ratty", 
				"dummy", 
				"ahole",
				"gimme",
				"gross",
				"short",
				"swine",
				"panic",
				"troll"};
		//randomly chooses a word from the array of words 0-20
		int r = (int)(Math.random() * 20);
		
		//the chosen word is called w for convenience 
		 String w = arr[r];
		
		HiddenWord w1 = new HiddenWord(w);
		//these are the tries the user gets 
		int count = 6;
		
		boolean result = false;
		
		
		while(count > 0) {
			
		 String d1 = "Guess the word (5 letters all lower case) \nnumber of tries: " + count; 
			
		 String g = JOptionPane.showInputDialog(d1);
		 //if the user types in an amount of letters that is not five yell at them
		 while( g.length() != 5 )
			 g = JOptionPane.showInputDialog("I SAID A FIVE LETTER WORD!");
			 
		
		
		 String d2 = "The result: " + w1.getHint(g);
		
		
		 JOptionPane.showMessageDialog(null, d2);
		 
		 
		 if( w1.getHint(g).indexOf("*") == -1 && w1.getHint(g).indexOf("+") == -1 ) {
			 result = true;
			 break;
		 }
		 
		 
		 
		 count--;
		}
		
		//when the game ends be passive aggressive to the user
		if(result) {
			JOptionPane.showMessageDialog(null, "Congratulations! You wasted your time winning a dumb game!");
		}
		else {
			JOptionPane.showMessageDialog(null, "That was simple and you still lost... (-_-) Disapointing.");
		}
		
		
		
		
	}

}
