import java.util.*;
import java.io.*;

public class cheap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
       String s=sc.next();
       int count0=0;
       int count1=0;
    //   int start=0;
      // int end=n-1;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                count1++;
            }else{
                count0++;
            }
        }
        if(count1!=count0)
        {
           System.out.println("1");
           System.out.println(s);
        }else{
           // start=0;
            //end=n-1;
            //int mid=start+(end-start)/2;
            System.out.println("2");
            System.out.println(s.substring(0,n-1)+"");
            System.out.println(s.charAt(n-1)+"");
          //  System.out.println(s.charAt(n-1));
        }
    }
}
