import java.util.Arrays;
import java.util.Scanner;
public class NewClass1{   
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in); 
       int a=sc.nextInt(),b=sc.nextInt(),sum=a;
        while (a>=b) {            
            sum+=(a/b);
            a=(a/b)+(a%b);
        }
        System.out.println(sum);
    }
}
