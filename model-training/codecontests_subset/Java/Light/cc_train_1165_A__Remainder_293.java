
import javax.swing.*;
import java.util.*;
import java.lang.*;


//--------------------------------------------------------------------

public class date {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),x=sc.nextInt(),y=sc.nextInt();
        String a=sc.next();
        int count=0;
        for(int i=n-1;i>=n-x;i--)
        {
            if(i==n-y-1)
            {
                if(a.charAt(i)=='0')
                {
                    count++;
                }
            }
            else if(a.charAt(i)=='1')
            {
                count++;
            }
        }
        System.out.println(count);
    }
}