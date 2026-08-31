
import java.util.Scanner;

public class A {
  
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a=input.nextInt(),b=input.nextInt();
        int x,y;
        x=Math.abs(a-b)/2;
        y=Math.abs(a-b)/2+Math.abs(a-b)%2;
        
        System.out.println(x*(x+1)/2+y*(y+1)/2);
        
        
    }
}
