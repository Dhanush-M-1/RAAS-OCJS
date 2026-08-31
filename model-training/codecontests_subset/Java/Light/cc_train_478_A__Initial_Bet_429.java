import java.util.Scanner;
public class MyClass {
        
     public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
     int x = 0;
     for(int i=0; i<5; i++)
     {
         x = x + scan.nextInt();
     }
     
     if(x!= 0 && x%5 == 0)
         System.out.println(x/5);
     else
         System.out.println("-1");

  }  
}