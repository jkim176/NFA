import java.util.Scanner;

public class NFAExample1_Driver{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      
      char stop = 'a';
      while(stop != 'x'){
         System.out.println("Enter a string of 0's and 1's.");
         String userString = input.next();
      
         NFAExample1.solve(userString);
         
         System.out.println("\nTo try another string, enter any key.  Enter x to quit.\n");
         String quitString = input.next();
         char quitChar = quitString.charAt(0);
         if(quitChar == 'x'){
            stop = 'x';
            System.out.println("Program has terminated.");
         }
      }
   }
}