/*Developer: Isha Das 
  The primary purpose of the HW2 Class is to write loops utilzing string and array logic aswell as 
   provide static methods that traverse through & modify strings. 
*/  


import javax.swing.JOptionPane;
import java.util.Scanner;

public class HW2
{
  //Returns a String and replaces the charcters found in the occrances of the orginal String with the charcter given in the replacement String given by the user 
  public static String replaceFirstK(String str, char orignalChar, char replaceChar, int occurances) 
  {
    StringBuilder finalString = new StringBuilder("");
    int occurance = 0;

    
    for (int i = 0; i < str.length(); i++)
    {
      char c = str.charAt(i);
      if ((c == orignalChar) && (occurance < occurances))
      {
        occurance++;
        finalString.append(replaceChar);
      }
      else
      {
        finalString.append(c);
      }
    }
    return finalString.toString();
  }
  
  //Returns a string that includes all the input characters from start to end in an orderly fashion
  public static String allChars(char start, char end)
  {
    StringBuilder finalString = new StringBuilder("");
    char c = start;
    int stringLength = end - start;
    for(int i = 0; i <= stringLength; i++)
    {
      finalString.append((char)(c+i));
    }
    
    return finalString.toString();
  }

  //Returns a string that replaces the orginal character in the string with dashes(_) if the charcter is not found otherwise it keeps the charcter.
  public static String showCharOfString(String original, String search)
  {
    StringBuilder finalString = new StringBuilder("");
    
    for (int i = 0; i < original.length(); i++)
    {
      char co = original.charAt(i);
      boolean match = false;
      for (int j = 0; j < search.length(); j++)
      {
        char cs = search.charAt(j);
        if(co == cs)
        {
          match = true;
        }
      }
      if(match)
      {
        finalString.append(co);
      }
      else
      {
        finalString.append('_');
      }
    }
    
    return finalString.toString();
  }
  
  //Returns true if the word is guessed by the user before the limit of maximum number of guesses(must be greater than 0) is reached
  public static boolean hangman(String word, int numBG)
  {
    boolean succesfullyGuessed = true;
    StringBuilder lettersGuessed = new StringBuilder("");
    int numberOfBadGuessed = 0;
    char chGuess = ' ';
    
    String guessedStringBefore = "";
    String guessedStringAfter = "";
    
    while(numBG<1)
    {
      System.out.println("Maximum number of bad guess can not be less than 1.");
      System.out.print("Enter maximum number of bad guess allowed: ");
      Scanner scan = new Scanner(System.in);
      numBG = scan.nextInt();
    }
    
    do 
    {
      guessedStringBefore = showCharOfString(word,lettersGuessed.toString());
      System.out.println(guessedStringBefore);
            
      chGuess = readInputChar();
      
      lettersGuessed.append(chGuess);
      
      guessedStringAfter = showCharOfString(word,lettersGuessed.toString());
      
      if(guessedStringBefore.equals(guessedStringAfter))
      {
        numberOfBadGuessed++;
        if (numberOfBadGuessed == numBG)
        {
          System.out.println("Max guess letter tries reached.");
          succesfullyGuessed = false;           
        }
        else
        {
          System.out.println("Number of Bad Guess " + numberOfBadGuessed +", " 
                               + (numBG - numberOfBadGuessed) + " tries remaining.");
        }
      }
    }while((numberOfBadGuessed < numBG) && !(word.equals(guessedStringAfter)));
    
    System.out.println(showCharOfString(word,lettersGuessed.toString()));
    
    return succesfullyGuessed;
  }
  
  //Helper method to return a character that will read the input and catch any exceptions using JOptionPane
  private static char readInputChar()
  {
    String inputString = "";
    do
    {
      try
      {
        inputString = JOptionPane.showInputDialog("Guess Character");
      }
      catch(Exception e)
      {
        inputString = JOptionPane.showInputDialog("Guess Character");
      }
    }while(inputString.length() != 1);
    
    return inputString.charAt(0);
  }

  
  //Returns true if we can find the input string inside the array by starting at any position of the array going either from backwards to forwards or visa-versa
  public static boolean hiddenString(char[] arr, String str) 
  {
    char firstStrChar = str.charAt(0);
    
    String[] firstCharMatchedWordsFwd = new String[arr.length];
    String[] firstCharMatchedWordsBkwd = new String[arr.length];
    
    StringBuilder sbWord = new StringBuilder("");
    
    int wordsCount = 0;
    
    //Search forward for matching first characters and add to String Array
    for (int i=0; i < arr.length; i++)
    { 
      if(firstStrChar == arr[i])
      {
        for(int j=0; j<str.length(); j++)
        {
          if(i+j < arr.length)
          {
            sbWord.append(arr[i+j]);
          }
        }
        firstCharMatchedWordsFwd[wordsCount] = sbWord.toString();
        wordsCount++;
        sbWord = new StringBuilder("");
      }       
    }

    //Search backward for matching first characters and add to String Array
    wordsCount = 0;
    int length = arr.length-1;
    for (int i=length; i >= 0; i--)
    { 
      if(firstStrChar == arr[i])
      {
        for(int j=0; j<str.length(); j++)
        {
          if(i-j > 0)
          {
            sbWord.append(arr[i-j]);
          }
        }
        firstCharMatchedWordsBkwd[wordsCount] = sbWord.toString();
        wordsCount++;
        sbWord = new StringBuilder("");
      }       
    }

    if(matchStringInArray(firstCharMatchedWordsFwd, str) || matchStringInArray(firstCharMatchedWordsBkwd, str))
    {
      return true;
    }
    else
    {
      return false;
    }
    
  }
  
  //Helper method to match a sring with array of strings - if one match found return true
  private static boolean matchStringInArray(String[] arrStr, String str)
  {
    boolean stringMatched = false;

    for(int i=0; i < arrStr.length; i++)
    {
      boolean wordNotFound = true;
      if(str.equals(arrStr[i]) && wordNotFound)
      {
        stringMatched = true;
        wordNotFound = false;
      }
    }
    return stringMatched;
  }
  
  //Returns true if the input string is found in the 2-D array either horizontally, vertically, or diagnoally in all directions
  public static boolean hiddenString(char[][] arr2D, String str) 
  {
    boolean foundMatchString = false;
    
    int rows = 0;
    int columns = 0;
   
    do
    {
      char[] horizontalArray = new char[arr2D[rows].length];
      
      
      for(columns = 0; columns < arr2D[rows].length; columns++) 
      {
        horizontalArray[columns] = arr2D[rows][columns];
      }
      
      foundMatchString = hiddenString(horizontalArray, str);
      rows++;
    }while(!foundMatchString && rows < arr2D.length);
   
    //Reset rows and columns
    rows = 0;
    columns =0;

    if(!foundMatchString)
    {
      do
      {
        char[] verticalArray = new char[arr2D.length];
        
        try
        {
          for(rows = 0; rows < arr2D.length; rows++) 
          {
            verticalArray[rows] = arr2D[rows][columns];
          }
        }
        catch(Exception e)
        {
          //do nothing
        }
        
        foundMatchString = hiddenString(verticalArray, str);
        columns++;
      }while(!foundMatchString && columns < arr2D[0].length);
    }
    
    //Reset rows and columns
    rows = 0;
    columns =0;
    
    if(!foundMatchString)
    {
      char[] diagonalArrayDown = new char[arr2D.length];
      try
      {
        do
        {
          diagonalArrayDown[rows] = arr2D[rows][columns];
          rows++;
          columns++;
        }while(rows < arr2D.length && columns < arr2D[rows].length );
      }
      catch(Exception e)
      {
        //do nothing
      }
      System.out.println(diagonalArrayDown);
      foundMatchString = hiddenString(diagonalArrayDown, str);   
    }

    //Reset rows and columns
    rows = arr2D.length -1;
    columns = 0;
    
    if(!foundMatchString)
    {
      char[] diagonalArrayUp = new char[arr2D.length];
      try
      {
        do
        {
          diagonalArrayUp[columns] = arr2D[rows][columns];
          rows--;
          columns++;
        }while(rows >= 0 && columns < arr2D[rows].length );
      }
      catch(Exception e)
      {
        //do nothing
      }
      System.out.println(diagonalArrayUp);
      foundMatchString = hiddenString(diagonalArrayUp, str);   
    }    
    
    return foundMatchString;
  }
  
  
  //Returns a string that capitalizes all the words if one of the charcters in the input string is captalized
  public static String capitalizeWords(String str)
  {
    StringBuilder finalString = new StringBuilder("");
    StringBuilder word = new StringBuilder("");

    int wordStartIndex = 0;
    boolean foundUpperCase = false;

    for (int i = 0; i < str.length(); i++)
    {
      char c = str.charAt(i);
      
      // Same word
      if(c != ' ')
      {
        word.append(c);
        if(Character.isUpperCase(c))
        {
          foundUpperCase = true;
        }
      }
      //New word end of sentence
      if( (c == ' ') ||  (i == (str.length()-1)) )
      {
        if(foundUpperCase)
        {
          for(int j=0; j < word.length(); j++)
          {
            finalString.append(Character.toUpperCase(word.charAt(j)));
          }
          foundUpperCase = false;
        }
        else
        {
          finalString.append(word);
        }
        if(i != (str.length()-1))
        {
          finalString.append(' ');
        }
        word = new StringBuilder("");
      }
    }
    return finalString.toString();
  }
}
