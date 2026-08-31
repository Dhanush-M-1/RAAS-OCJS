import java.util.*;
public class Main {
    public static void main(String args[]) {
     Scanner in =new Scanner(System.in);
     int t=in.nextInt();
     while(t!=0)
     {
         int a=in.nextInt();
         int b=in.nextInt();
         int c=in.nextInt();
         int an=a^b;
         int d=c%3;
         if(d==0) {System.out.println(a);}
         else if(d==1)  {System.out.println(b);}
         else {System.out.println(an);}
        
    t--;
    }
    }
}