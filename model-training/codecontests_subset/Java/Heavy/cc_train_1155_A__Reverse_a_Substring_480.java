import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class java {
    public static void main(String[] args) {
       Scanner input=new Scanner(System.in);
       int n=input.nextInt();
       String str=new String();
       str=input.next();
       Boolean ok=true;
       int p=0,q=0;
       for(int i=0;i<n-1;i++)
       {
         if((int)str.charAt(i)>(int)str.charAt(i+1))
         {
           ok=false;
           p=i+1;q=i+2;
           break;
         }
       }        
       if(ok==false)
       {
        System.out.println("YES");
        System.out.println(p+" "+q);
       }
       else
       System.out.println("NO");

         

         



    }
}
