import java.util.*;
public class S{
 
   public static void main(String[] args){
	  String dead;
	  String alive;
      Scanner scan = new Scanner(System.in);
      String candidate1 = scan.next();
      String candidate2 = scan.next();
	  System.out.println(candidate1 + " " + candidate2);
      int day = scan.nextInt();
      for(int i = 1;i <= day; i++){
         dead = scan.next();
         alive = scan.next();
 
         if(dead.equals(candidate1)){
			 candidate1 = alive;
			 System.out.println(candidate1 + " " + candidate2);
		 }
		 else{
		 	 candidate2 = alive;
			 System.out.println(candidate1 + " " + candidate2);
		 }
	  }
   }
}