import java.util.Scanner;

public class StackQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
    Scanner s = new Scanner(System.in);
    int a = s.nextInt();
    int b = s.nextInt();
    int sum = a;
    
    while(a/b!=0){
      int rem = a%b ;
       sum = sum + a/b  ;
       
      a = a/b + rem;
       
    }
    
    
  

System.out.print(sum);
}
}