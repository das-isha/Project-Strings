import org.junit.*;
import static org.junit.Assert.*;
/*Developer: Isha Das
  This class is used to test all the methods of the HW2 class (except for hangman which has its testing in the Report Document
*/

public class HW2Tester 
{ 
  @Test
  //Tests the replaceFirstK method in the HW2 class
  public void testReplaceFirstK() 
  {
    String strInput = new StringBuilder("Mississippi River").toString();  // avoids compiler optimization of strings
    
    // Test for no occurance
    String s = new StringBuilder("Mississippi River").toString();
    assertEquals(s, HW2.replaceFirstK(strInput, 'i', 'I', 0));

    // Test for 1 occurance
    s = new StringBuilder("MIssissippi River").toString();
    assertEquals(s, HW2.replaceFirstK(strInput, 'i', 'I', 1));

    // Test for 3 occurances
    s = new StringBuilder("MIssIssIppi River").toString();
    assertEquals(s, HW2.replaceFirstK(strInput, 'i', 'I', 3));

    strInput = new StringBuilder("my name is isha").toString();  // avoids compiler optimization of strings
    
    // Test for first character replacement
    s = new StringBuilder("My name is isha").toString();
    assertEquals(s, HW2.replaceFirstK(strInput, 'm', 'M', 1));

    // Test middle chacter replacement with more than one replacements
    s = new StringBuilder("My naMe is isha").toString();
    assertEquals(s, HW2.replaceFirstK(strInput, 'm', 'M', 3));

    strInput = new StringBuilder("Java is great").toString();  
    
    // Test for last character replacement
    s = new StringBuilder("Java is greaT").toString();
    assertEquals(s, HW2.replaceFirstK(strInput, 't', 'T', 1));

  }

  @Test
  //Tests the allChar method in the HW2 class
  public void testAllChars() 
  {
    String s = new StringBuilder("").toString();  // avoids compiler optimization of strings
    
    // Test 0-- for same start and end charcter
    s = new StringBuilder("d").toString();
    assertEquals(s, HW2.allChars('d', 'd'));

    // Test 1-- for start and end characters being next to each other
    s = new StringBuilder("ef").toString();
    assertEquals(s, HW2.allChars('e', 'f'));

    // Test many--for start and end characters apart with few charcters
    s = new StringBuilder("defghijklm").toString();
    assertEquals(s, HW2.allChars('d', 'm'));

  }
  
  @Test
  //Tests the showCharOfString method in the HW2 class
  public void testShowCharOfString() 
  {
    String s = new StringBuilder("").toString();  // avoids compiler optimization of strings
    // Test for first charcter of string 
    s = new StringBuilder("_issouri River").toString();
    assertEquals(s, HW2.showCharOfString("Missouri River", "issouri River"));
    
    // Test the middle 
    s = new StringBuilder("__ss__r_ R___r").toString();
    assertEquals(s, HW2.showCharOfString("Missouri River", "s SR!r"));
    
    // Test the end 
    s = new StringBuilder("This is grea_").toString();
    assertEquals(s, HW2.showCharOfString("This is great", "This grea"));
    
  }
  
  @Test 
  //Tests the hiddenString method in the HW2 class
  public void testHiddenString()
  {
        
        boolean hiddenStringAnswer = true;
        
        // Test for zero occurence
        //outputs false
       // assertEquals(hiddenStringAnswer,HW2.hiddenString(new char[]{'a','b','r','a','c','a','d','a'}, ""));
        
        //Test for first occurence forward
        assertEquals(hiddenStringAnswer,HW2.hiddenString(new char[]{'a','b','r','a','c','a','d','a'}, "abr"));
        
        //Test for first occurence backward
        assertEquals(hiddenStringAnswer,HW2.hiddenString(new char[]{'a','b','r','a','c','a','d','a'}, "arb"));
        
       //Test for middle occurence forward
        assertEquals(hiddenStringAnswer,HW2.hiddenString(new char[]{'a','b','r','a','c','a','d','a'}, "raca"));
        
        //Test for middle occurence backward
        assertEquals(hiddenStringAnswer,HW2.hiddenString(new char[]{'a','b','r','a','c','z','d','a'}, "carb"));        
        
        
         //Test for last occurence forward
        assertEquals(hiddenStringAnswer,HW2.hiddenString(new char[]{'a','b','r','a','c','a','d','a'}, "cada")); 
        
        
        //Test for last occurence backward
        assertEquals(hiddenStringAnswer,HW2.hiddenString(new char[]{'a','b','r','a','c','z','d','a'}, "adz"));
        
        //outputs false since "brad is not found forwards or backwards
        //assertEquals(testHiddenString,HW2.hiddenString(new char[]{'a','b','r','a','c','a','d','a'}, "brad"));
        
   }
 
   @Test
   //tests the second hiddenString method in HW2 that is overloaded with a 2-dimensional array of char and a String as input
   public void testHiddenString2()
   {
     boolean hiddenStringAnswer = true;
     
     //Test for first occurence right
      assertEquals(hiddenStringAnswer, HW2.hiddenString(new char[][]{{'a', 'b', 'c'},{'r','c','a','d'},{'b','r'}}, "abc"));
      
       //Test for first occurence left
      assertEquals(hiddenStringAnswer, HW2.hiddenString(new char[][]{{'a', 'b', 'c'},{'r','c','a','d'},{'b','r'}}, "rb"));
      
       //Test for middle occurence right
      assertEquals(hiddenStringAnswer, HW2.hiddenString(new char[][]{{'a', 'b', 'c'},{'r','c','a','d'},{'b','r'}}, "cad"));
      
       //Test for middle occurence left
     assertEquals(hiddenStringAnswer, HW2.hiddenString(new char[][]{{'a', 'b', 'c'},{'r','c','a','d'},{'b','r'}}, "dac"));
     
       //Test for last occurence right
      assertEquals(hiddenStringAnswer, HW2.hiddenString(new char[][]{{'a', 'b', 'c'},{'r','c','a','d'},{'b','r'}}, "ad"));
      
       //Test for last occurence left
     assertEquals(hiddenStringAnswer, HW2.hiddenString(new char[][]{{'a', 'b', 'c'},{'r','c','a','d'},{'b','r'}}, "rb"));
     
     //Test for diagonal occurence 
     assertEquals(hiddenStringAnswer, HW2.hiddenString(new char[][]{{'a', 'b', 'c'},{'r','c','a','d'},{'b','r'}}, "bcc"));
     
      //Test for down occurence 
     assertEquals(hiddenStringAnswer, HW2.hiddenString(new char[][]{{'a', 'b', 'c'},{'r','c','a','d'},{'b','r'}}, "arb"));
     
   }
  
  @Test 
  //tests the capitalizeWords method in the HW2 class
  public  void testcapitalizeWords()
  {
    String s = new StringBuilder("").toString();
    //test first words capitalized
    s = new StringBuilder("GUESS what??").toString();
    assertEquals(s, HW2.capitalizeWords("Guess what??"));
    //test middle words capitalized
    s = new StringBuilder("GUESS what??  THERE are TWENTY-SIX letters in the ENGLISH ALPHABET!").toString();
    assertEquals(s, HW2.capitalizeWords("Guess what??  There are twenty-sIx letters in the English alphABEt!"));
    //test last word capitalized
     s = new StringBuilder("guess WHAT??").toString();
    assertEquals(s, HW2.capitalizeWords("guess whaT??"));
        
  }
  
}
