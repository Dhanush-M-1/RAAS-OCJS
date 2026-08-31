//Code by Sounak, IIEST
import java.io.*;
import java.math.*;
import java.util.*;
import java.util.Arrays;
public class Test3{
    public static void main(String args[])throws IOException{
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        while(--test>=0)
        {
            int n=sc.nextInt();
            int i;
            boolean ch=true;
            int pplay=sc.nextInt();
            int pclear=sc.nextInt();
            if(pclear>pplay)
            ch=false;
            for(i=1;i<n;i++)
            {
                int nplay=sc.nextInt();
                int nclear=sc.nextInt();
                int d1=nplay-pplay;
                int d2=nclear-pclear;
                if(d2<0 || d1<0 || d2>d1)
                ch=false;
                pplay=nplay;
                pclear=nclear;
            }
            if(ch)
            System.out.println("YES");
            else
            System.out.println("NO");
        }
    }
}