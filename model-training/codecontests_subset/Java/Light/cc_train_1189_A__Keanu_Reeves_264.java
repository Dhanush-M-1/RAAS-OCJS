import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class codeforces {
    public static void main(String[] args) {
           Scanner sc=new Scanner(System.in);
           int n=sc.nextInt();
           String s=sc.next();
           int bal=0;
           for(int i=0;i<n;i++)
           {
               if(s.charAt(i)=='0')
                   bal+=1;
               else
                   bal-=1;
           }
           if(bal!=0)
           {  
               System.out.println("1");
               System.out.println(s);
           }
           else
           {
               System.out.println("2");
               System.out.println(s.substring(0,n-1)+" "+s.substring(n-1,n));
           }
}
}
