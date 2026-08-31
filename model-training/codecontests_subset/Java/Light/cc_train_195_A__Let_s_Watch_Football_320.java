
import java.util.Scanner;

 
public class A123 {
    
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        System.out.println((int)Math.ceil((c*a-b*c)*1.0/b));
        
         
    }
}
