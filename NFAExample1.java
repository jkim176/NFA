import java.util.ArrayList;
//import java.lang.StringBuilder;

public class NFAExample1{
   // NFA to solve 0*1*0
   private static boolean status;
   private static ArrayList<String> stateList = new ArrayList<>();
   
   public static StringBuilder printStateList(){
      StringBuilder result = new StringBuilder("");
      for(int i = 0; i < stateList.size(); i++){
         if(i == stateList.size() - 1)
            result.append(stateList.get(i));
         else
            result.append(stateList.get(i) + ", ");
      }
      return result;
   }
		
   public static void solve(String input){
      if(input.length() == 0){
         status = false;
      }
      else{
         if(input.charAt(0) == '0'){
            recursive0(input);
         }
         else if(input.charAt(0) == '1'){
            recursive1(input);
         }
         else{
            status = false;
         }
      }
      
      if(status)
         System.out.println("The string " + input + " was accepted.");
      else
         System.out.println("The string " + input + " was rejected.");
      System.out.println("The state sequence for string " + input + ":\n" + printStateList());
      stateList.clear();
   }
		
   public static void recursive0(String input){
      if(input.length() == 1){
         if(input.charAt(0) == '0'){
            stateList.add("Q2");
            status = true;
         }
         else if(input.charAt(0) == '1'){
            stateList.add("Q1");
            status = false;
         }
         else{
            status = false;
         }
      }
      else{
         if(input.charAt(0) == '0'){
            stateList.add("Q0");
            recursive0(input.substring(1));
         }
         else if(input.charAt(0) == '1'){
            stateList.add("Q1");
            recursive1(input.substring(1));
         }
         else{
            status = false;
         }
      }
   }
		
   public static void recursive1(String input){
      if(input.charAt(0) == '0'){
         if(input.length() == 1){
            stateList.add("Q2");
            status = true;
         }
         else{
            stateList.add("Q2");
            status = false;
         }
      }
      else if(input.charAt(0) == '1'){
         if(input.length() == 1){
            stateList.add("Q1");
            status = false;
         }
         else{
            stateList.add("Q1");
            recursive1(input.substring(1));
         }
      }
      else{
         status = false;
      }
   }
}