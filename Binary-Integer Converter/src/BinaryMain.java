

import javax.swing.JOptionPane;

public class BinaryMain {
	
	
	public static int displayTable() {
		//display conversion table 1- 10
		/* 
		 * 
		 * 
		 * binary digits    integers
		 * 00000000      =  0 
		 * 00000001      =  1
		 * 00000010      =  2
		 * ..  
		 *               = 10
		 * 
		 * */
		
		String content = "binary digits    integers \n";
		content += "00000000      =  0 \n";
		content += "00000001      =  1 \n";
		content += "00000010      =  2 \n";
		content += "00000011      =  3 \n";
		content += "00000100      =  4 \n";
		content += "00000101      =  5 \n";
		content += "00000110      =  6 \n";
		content += "00000111      =  7 \n";
		content += "00001000      =  8 \n";
		content += "00001001      =  9 \n";
		content += "00001010      =  10 \n";
		
		JOptionPane.showMessageDialog(null, content);
		
		//Ask for user for a choice in binary or integer
		//1 - input 8 bit binary
		//2 - input an integer
		//3 - quit program
		int choice = Integer.parseInt(JOptionPane.showInputDialog(
				"1 - input 8 bit binary\r\n" + 
				"2 - input an integer\r\n" + 
				"3 - quit program"));
		
		return choice;
		
	}
	
	public static void convertBitToInt(String str) {
		int sum = 0;
		String allvalues = "";
		
		for(int e = 0; e < 8; e++) {
			
			//read a character from right to left
			char ch = str.charAt(str.length() -(1+e));
			
			//check if it is 1, if so display the value
			//add that value to the variable sum
			if( ch == '1' ) {
				int val = (int) Math.pow(2, e);
				allvalues = val + " " + allvalues;
				sum += val;
			}
			
			//check id it is 0, display 0
			else {
				allvalues = 0 + " " + allvalues;
			}
			
		}
		
		//display sum
		String ms = str + "\n" + allvalues + "\n" + sum;
		
		JOptionPane.showMessageDialog(null, ms);
	}
	
	//converts numbers to bits
	public static void convertIntToBit(int num) {
		
		int original = num;
		
		String strb = "";
		
		String allvalues = "";
		
		
		for(int e = 7; e>=0;e--  ) {
			
			int r = num %2;
			
			if(r == 1){
				int val = (int) Math.pow(2, e);
				allvalues += val + " ";
				strb += 1 + " ";
			}
			else {
				allvalues += 0 + " ";
				strb += 0 + " ";
			}
			
			num /= 2;
			
		}
		
		//display strb
		//display sum
				String ms = original + "\n" + allvalues + "\n" + strb;
				
				JOptionPane.showMessageDialog(null, ms);
		
	}
	
	//takes in user inputs to run the methods accordingly
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c = displayTable();
		
		String inputBit = "";
		int integer = 0;
		
		while(c != 3) {
			
			if(c == 1) {
				inputBit = JOptionPane.showInputDialog("Enter your 8 bit binary: ");
				
				while( inputBit.length() != 8 )
					inputBit = JOptionPane.showInputDialog("Enter your damn 8 bit binary: ");
				
				convertBitToInt(inputBit);
			}
			else {
				integer =  Integer.parseInt(JOptionPane.showInputDialog("Enter your integer: "));
				convertIntToBit(integer);
			}
			
			c = displayTable();
			
		}//close while
		
		//display saying the end
		JOptionPane.showMessageDialog(null, "The end :D");
		
		
		
		
	}

}
