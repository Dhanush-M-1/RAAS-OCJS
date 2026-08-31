import java.util.Scanner;
public class MyClass {
    

     public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
     int n = scan.nextInt();
     long total = 0;
     long first = 0;
     for(int i = 0; i<n; i++)
     {
         total += scan.nextInt();
     }
     
     first = total;
     for(int i = 0; i<n-1; i++)
     {
         first -= scan.nextInt();
     }
     
     System.out.println(first);
     
     total = total - first;
     
     for(int i = 0; i<n-2; i++)
     {
         total -= scan.nextInt();
     }
     
     
    
    System.out.println(total);
     
  }
    
}