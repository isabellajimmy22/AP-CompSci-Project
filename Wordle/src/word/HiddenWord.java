package word;

public class HiddenWord 
{  
 private String word; 
  
 public HiddenWord(String hWord) 
 { 
 word = hWord; 
 } 
  //if the letter guessed is in the word "+" appears in the letter
 // if the letter guessed is not in the word "*" appears
 // if the letter is in the right place the letter will appear
 public String getHint(String guess){ 
  String hint = ""; 
  for (int i = 0; i < guess.length(); i++){
	  
   if (guess.substring(i,i+1).equals(word.substring(i,i+1))){  
	   hint += guess.substring(i,i+1); 
  }
   
   else if (word.indexOf(guess.substring(i,i+1))!= -1) 
    {  
	   hint += "+"; 
    } 
   
   else { 
    hint += "*"; 
   } 
   
  }//close for 
    return hint; 
 } 
  
}  
