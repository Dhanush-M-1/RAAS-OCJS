import java.util.Scanner; 
public class NewYearCandles{
 
  
  
  public static void main(String[]args){
  
  Scanner sc = new Scanner(System.in); 
  
  int a = sc.nextInt(); 
  int b = sc.nextInt(); 
  
  int hours = 0; 
  
  while(a - b >= 0){
   hours += b; 
    a -= b-1; 
  }
  hours += a; 
  
  System.out.println(hours); 
  
}
}