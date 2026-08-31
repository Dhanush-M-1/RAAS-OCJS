import java.util.*;
import java.math.*;
public class Main{
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int count=0;
        count+=a;
        int can=a/b;
        int rem=a%b+can;
        count+=can;
        while(rem>=b)
        {
            can=rem/b;
            count+=can;
            rem=can+rem%b;
        }
        System.out.println(count);
    }
}