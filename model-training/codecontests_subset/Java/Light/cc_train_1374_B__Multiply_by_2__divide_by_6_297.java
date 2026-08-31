import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int p=sc.nextInt();
        for(int t=0;t<p;t++)
        {
            Long x=sc.nextLong();
            if(x==0)
            {
                System.out.println(-1);
                continue;
            }
            int count=0;
            while(x%6L==0L)
            {
                count++;
                x=x/6L;
            }
            if(x%2L==0L){
                System.out.println(-1);
                continue;
            }
            while(x%3L==0L)
            {
                x=x/3L;
                count=count+2;
            }
            if(x==1)
            System.out.println(count);
            else
                System.out.println(-1);
        }
        
        
    }
}