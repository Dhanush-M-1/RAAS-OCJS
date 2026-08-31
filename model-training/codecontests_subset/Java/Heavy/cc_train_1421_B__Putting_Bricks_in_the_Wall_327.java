import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = 1;
         t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    private static void solve() {
        int n = sc.nextInt();
        int a[][]=new int[n][n];
        for (int i = 0; i < a.length; i++) {
            String s=sc.next();
                for (int j = 0; j < a.length; j++) 
              {  if(i==0&&j==0)
               {
                continue;
               }
                if(i==n-1&&j==n-1)
                continue;
                a[i][j]=s.charAt(j)-'0';
              }
        }
        int c=0;
        int c1=0;
        if(a[0][1]==0)
        c++;
        if(a[1][0]==0)
        c++;
        if(a[n-1][n-2]==0)
        c++;
        if(a[n-2][n-1]==0)
        c++;
        if(a[0][1]==1)
        c1++;
        if(a[1][0]==1)
        c1++;
        if(a[n-1][n-2]==1)
        c1++;
        if(a[n-2][n-1]==1)
        c1++;
        if(c==4||c1==4)
        {
            System.out.println(2);
            System.out.println(2+" "+1);
            System.out.println(1+" "+2);
            return;
        }
        if(a[1][0]==a[0][1])
        {
            if(a[n-1][n-2]==a[n-2][n-1])
            {
                System.out.println(0);
                return;
            }
            System.out.println(1);
            if(a[n-2][n-1]!=a[1][0])
            System.out.println((n)+" "+(n-1));
            else
            System.out.println((n-1)+" "+(n));
            return;
           
        }
        else{
            if(a[n-2][n-1]==a[n-1][n-2])
            {
                System.out.println(1);
                if(a[1][0]!=a[n-2][n-1])
                System.out.println((1)+" "+(2));
                else
                System.out.println((2)+" "+(1));
                return;
            }
            System.out.println(2);
            if(a[0][1]==0)
            System.out.println(1+" "+2);
            else
            System.out.println(2+" "+1);
            if(a[n-2][n-1]==1)
            System.out.println((n-1)+" "+(n));
            else
            System.out.println((n)+" "+(n-1));
        }
    }
}