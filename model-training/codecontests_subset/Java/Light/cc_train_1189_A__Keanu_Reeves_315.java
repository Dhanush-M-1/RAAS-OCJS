import java.util.*;
public class HelloWorld{

     public static void main(String []args){
        
        Scanner inp=new Scanner(System.in);
        int n=inp.nextInt();
        int[] forwardone=new int[n];
        int[] forwardzero=new int[n];
        int count1=0;
        int count0=0;
        String s=inp.next();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='0')
                count0++;
            else
               count1++;
        }
        if(count0==count1)
        {
            System.out.println("2");
            System.out.println(s.substring(0,1)+" "+s.substring(1,s.length()));
        }
        else
        {
            System.out.println("1");
            System.out.println(s);
        }
     }
}