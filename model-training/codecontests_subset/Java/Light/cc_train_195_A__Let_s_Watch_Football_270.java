import java.io.*;
import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        double k=c*(a-b);
        if(b>=a)
        System.out.println("0");
        else
         {
             double ans=k/b;
             int z=(int)Math.ceil(ans);
             System.out.println(z);
         }
       

       
    }
}
