package math;

import javax.swing.JOptionPane;

public class MathMain {
    /**
     * Requirements:

- The user sets the number of problems they want to do
- The user sets what types of problems they want to do (ex: only multiplication, all problems, multiplication and division etc.)
- Generates random int addition problems from 0-1000
- Generates random int subtraction problems, but never generates a negative answer from 0-1000
- Generates random multiplication problems from 0 - 1000
- Generates random division problems from 0 - 1000 but never generates decimal answers and uses math division rules not CS rules
- Displays the problem for the user
- The user can input the answer
- Keeps track of correct and incorrect answers
- Displays percentage score, correct answers and incorrect answers

     * 
     */
    
    public static boolean addition()
    {
    
            //generate numQs amount of random addition problems
            //generate a random x and y value to be added
            //display problem and take in users answer
            //check if its correct
            //if wrong show correct answer, if correct tell user they are correct
    	 int x = (int)(Math.random()*1000)+1;
    	 int y = (int)(Math.random()*1000)+1;
         int sum = x+y;
         
         String qStr = x  + " + " + y  + " =";
         
         int userA = Integer.parseInt(JOptionPane.showInputDialog( qStr ));
         
         if(userA == sum) {
       	  JOptionPane.showMessageDialog(null,"That is correct");
         return true;
     }
     else {
   	  JOptionPane.showMessageDialog(null,"That is incorrect");
         return false;
     }
      
    }

	public static boolean subtraction()
    {
            //j progress bar to keep progress
            //generate numQs amount of random subtraction problems
            //generate a random x and y value to be subtracted
            //display problem and take in users answer
            //check if its correct
            //if wrong show correct answer, if correct tell user they are correct
            //give percent of correctness
		
        int x = (int)(Math.random()*1000)+1;
        int y = (int)(Math.random()*1000)+1;
        
        int diff = 0;
        
        if(y>=x)
        diff = y-x;
        else
        diff = x-y;
        
        String qStr ="";
        
        if(y>x)
         qStr = y + " - " + x + " =";
        else
         qStr = x + " - " + y + " =";
        
        int userA = Integer.parseInt(JOptionPane.showInputDialog( qStr ));
        
        if(userA == diff) {
      	  JOptionPane.showMessageDialog(null,"That is correct");
        return true;
    }
    else {
  	  JOptionPane.showMessageDialog(null,"That is incorrect");
        return false;
    }
    }
    
    public static boolean multiplication()
    {
            //j progress bar to keep progress
            //generate numQs amount of random multiplied problems
            //generate a random x and y value to be multiplied
            //display problem and take in users answer
            //check if its correct
            //if wrong show correct answer, if correct tell user they are correct
            //give percent of correctness
        int x = (int)(Math.random()*1000)+1;
        int y = (int)(Math.random()*1000)+1;
        int prod = x*y;
        
        String qStr = x  + " * " + y  + " =";
        
        int userA = Integer.parseInt(JOptionPane.showInputDialog( qStr ));
        
        if(userA == prod) {
      	  JOptionPane.showMessageDialog(null,"That is correct");
        return true;
    }
    else {
  	  JOptionPane.showMessageDialog(null,"That is incorrect");
        return false;
    }
    }
    
    public static boolean  division()
    {
            //j progress bar to keep progress
            //no decimal answers, answers round to the nearest whole number using math.round()
            //generate numQs amount of random divided problems
            //generate a random x and y value to be divided
            //display problem and take in users answer
            //check if its correct
            //if wrong show correct answer, if correct tell user they are correct
            //give percent of correctness
    	  int x = (int)(Math.random()*1000)+1;
    	  int y = (int)(Math.random()*x)+1;
          
          while(x % y != 0)
        	  y = (int)(Math.random()*x)+1;
          
          int quo = x/y;
          
          String qStr = x  + " / " + y  + " =";
          
          int userA = Integer.parseInt(JOptionPane.showInputDialog( qStr ));
          
          if(userA == quo) {
        	  JOptionPane.showMessageDialog(null,"That is correct");
              return true;
          }
          else {
        	  JOptionPane.showMessageDialog(null,"That is incorrect");
              return false;
          }
    }
    
    // options the user chooses from
    public static int chooseMath()
    {
            int gradeLevel = Integer.parseInt(JOptionPane.showInputDialog(
            		"-----After Choosing The Number Of Questions You Want To Answer You Can Choose Each Type For Each Question----- \r\n" +
                            "1 - Addition\r \n" +
                            "2 - Subtraction\r\n" +
                            "3 - Multiplication\r\n" +
                            "4 - Division\r\n" +
                            "5 - Randomized"
                            ));        
            while( gradeLevel >= 6 || gradeLevel <=0)
                     gradeLevel = Integer.parseInt(JOptionPane.showInputDialog(
                            " -----Choose Again:------ \r\n"+
                                            "1 - Addition\r \n" +
                                            "2 - Subtraction\r\n" +
                                            "3 - Multiplication\r\n" +
                                            "4 - Division\r\n" +
                                            "5 - Randomized"
                                                    ));        
            return gradeLevel;
    
    }
    
    // number of questions based on the inputed value
    public static int askNumQs()
    {
            int numQs = Integer.parseInt(JOptionPane.showInputDialog("Input the amount of problems you want to do"));
            while( numQs <= 0 )
                    numQs = Integer.parseInt(JOptionPane.showInputDialog("Are you dumb or something? The number HAS to be GREATER than 0"));
            
            return numQs;
            
    }
    
    //executes all the methods and returns the scores of the 
    public static void main(String[] args) {
            
            int numberOfQ = askNumQs();
            
            int currentNQ = 0;
            
            double perScore = 0;
            
            int correct = 0;
            
            int incorrect = 0;
            
            boolean result=false;
            
            while( currentNQ < numberOfQ  ) {
            
            int choice = chooseMath();
            
            
            if(choice == 5) {
            	choice = (int)(Math.random()* 4) + 1; 
            }
            
            if(choice == 1)
            	result  =  addition();
            else if(choice == 2)
            	result  =  subtraction();
            else if(choice == 3)
            	result  =  multiplication();
            else if (choice == 4)
            	result  =  division();
            
            if(result)
            	correct++;
            else
            	incorrect++;
            
            currentNQ++;
            } //close while
            
            //score
            perScore =  ((double) correct / numberOfQ) * 100;
            
            String str ="Score Precentage: " + perScore + "% \nNumber of Correct Answers: " + correct + "\nNumber of Incorrect Answers: " + incorrect ;  
            
            JOptionPane.showMessageDialog(null, str);
    }

}
