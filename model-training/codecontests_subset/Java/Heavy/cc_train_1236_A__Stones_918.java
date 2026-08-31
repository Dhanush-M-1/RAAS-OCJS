import java.util.*;
import java.lang.*;
import java.io.*;
public class codeforces
{
    public static void main (String[] args) 
    {

        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        while(n-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int count = 0;
            while(b>=1&&c>=2){
                b-=1;
                c-=2;
                count+=3;
            }
            while(a>=1&&b>=2){
                a-=1;
                b-=2;
                count+=3;
            }
            System.out.println(count);
        }

    }

}
