package Main;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;


public class Main {
	

	public static void fillHotel(String[][] hb) {
		//going through every row (going through every month)
				for(int r = 0; r < hb.length; r++) {
					
					//go through every column - room 
					for(int c = 0; c < hb[0].length;c++) {
						
						//low
						if(c == 0)
						 hb[r][c] = "20";
						
						//medium
						else if(c == 1)
						 hb[r][c] = "40";
						
						else
							hb[r][c] = "100";
					}
					
				}
	}
	
	
	
	public static void printBooking(String[][] hb) {
		
		ImageIcon hotel = new ImageIcon("Hotel.png");
		JOptionPane.showMessageDialog(null, "Welcome to the our lovely hotel, where crimes may or may not have taken place! Keep your expectations very, very, very low.","Disclaimer",JOptionPane.INFORMATION_MESSAGE, hotel);
		
		//JOptionPane.showMessageDialog(null,"Display Image", null, JOptionPane.INFORMATION_MESSAGE,hotel);
		String allB = "";
		
		//System.out.println("Dec\tLow\tMedium\tHigh");
		allB += "Dec   Low   Medium   High \n";
		
		for(int r = 0; r < hb.length; r++) {
			
		//System.out.print( "day " + (r+1) + "\t");
			allB += "day " + (r+1) + "   ";
			
			//go through every column - room 
			for(int c = 0; c < hb[0].length;c++) {
			 if(hb[r][c].equals("booked"))
			//	 System.out.print(hb[r][c] + "\t" );
				 allB += hb[r][c] + "   ";
			 else
			//	System.out.print( "$" + hb[r][c] + "\t" );
				 allB += "$" + hb[r][c] + "   ";
			}
			
			//System.out.println();
			allB += "\n";
			
		}
		
		JOptionPane.showMessageDialog(null, allB);
	}
	
	
	public static void book(String[][] hotel_booking, Scanner in) {
	
		
		//ask the user for day and price
		String d = JOptionPane.showInputDialog("Choose a day by entering a number: ");
		
		int day = Integer.parseInt(d);
		
		String price = JOptionPane.showInputDialog("Choose a price (low, medium, high): ");
		
		
		int p;
		
		if( price.equals("low") )
			p = 0;
		else if( price.equals("medium") )
			p = 1;
		else
			p = 2;
		
		
		
		//check if it is booked
		while( hotel_booking[day - 1][p].equals("booked")   ) {
			JOptionPane.showMessageDialog(null, "Sorry, that is booked.");
			
			//ask the user for day and price
			d = JOptionPane.showInputDialog("Choose a day by entering a number: ");
			
			day = Integer.parseInt(d);
			
			price = JOptionPane.showInputDialog("Choose a price (low, medium, high): ");
			
			
			if( price.equals("low") )
				p = 0;
			else if( price.equals("medium") )
				p = 1;
			else
				p = 2;
		}
		
		hotel_booking[day - 1][p] = "booked";
		JOptionPane.showMessageDialog(null, "It is booked.");
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//row - days
		//columns - 3 rooms
		String[][] hotel_booking = new String[31][3];
		
		String action;
		
		//low - 20
		//medium - 40 
		//high - 100
		fillHotel( hotel_booking );
		
		
		
		
		printBooking(hotel_booking);
		
		
		
		Scanner in = new Scanner(System.in);
		
		/*
		System.out.println("Menu");
		System.out.println("D - display the available rooms");
		System.out.println("B - book a room");
		System.out.println("E - exit the program");
		
		System.out.println("Please enter an action:");
		action = in.next();
		*/
		String menu = "Menu \n";
		menu += "D - display the available rooms \n";
		menu += "B - book a room \n";
		menu += "E - exit the program \n";
		menu += "Please enter an action: \n";
		action = JOptionPane.showInputDialog(menu);
		
		while( !(action.equals("E")) ) {
			
			if(action.equals("D")) 
				 printBooking(hotel_booking);

			else if(action.equals("B"))
				book(hotel_booking, in);
			
			else
				JOptionPane.showMessageDialog(null, "That is an invalid action.");
			
			//System.out.println("Please enter an action:");
			//action = in.next();
			action = JOptionPane.showInputDialog(menu);
		}
		
		
		JOptionPane.showMessageDialog(null, "The program is done.");
	
		in.close();

	}

}

