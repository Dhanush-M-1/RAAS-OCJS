import java.util.Scanner;
import java.awt.image.BandedSampleModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class B {


    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int cases = sc.nextInt();


        for(int i=0;i<cases;i++)
        {
            int n = sc.nextInt();
            int grid[][]=new int[n][n];
            // long arr[] = new long[n];
            for(int j=0;j<n;j++)
            {
                String s=sc.next();
                for(int k=0;k<s.length();k++)
                {
                    grid[j][k]=s.charAt(k)-'0';
                }
            }

            int l1=grid[1][0];
            int l2=grid[0][1];
            int r1=grid[n-1][n-2];
            int r2=grid[n-2][n-1];
            //String ans="";
            if(l1==0&&l2==0)
            {
                if(r1==0&&r2==0)
                {
                    System.out.println(2);
                    System.out.println(n+" "+(n-1));
                    System.out.println((n-1)+" "+(n));

                }
                else if(r1==0&&r2==1)
                {
                    System.out.println(1);
                    System.out.println(n+" "+(n-1));
                    //System.out.println((n-1)+" "+(n));
                }
                else if(r1==1&&r2==0)
                {
                    System.out.println(1);
                    //System.out.println(n+" "+(n-1));
                    System.out.println((n-1)+" "+(n));
                }
                else
                {
                    System.out.println(0);
                }
            }
            else if(l1==1&&l2==0)
            {
                if(r1==0&&r2==0)
                {
                    System.out.println(1);
                    //System.out.println(n+" "+(n-1));
                    System.out.println(1+" "+2);

                }
                else if(r1==0&&r2==1)
                {
                    System.out.println(2);
                    System.out.println((n-1)+" "+(n));
                    System.out.println(1+" "+2);
                    //System.out.println((n-1)+" "+(n));
                }
                else if(r1==1&&r2==0)
                {
                    System.out.println(2);
                    System.out.println(1+" "+2);
                    //System.out.println(n+" "+(n-1));
                    System.out.println((n)+" "+(n-1));
                }
                else if(r1==1&&r2==1)
                {
                    System.out.println(1);
                    System.out.println(2+" "+1);
                    //System.out.println(n+" "+(n-1));
                    //System.out.println((n)+" "+(n-1));
                }
            }
            else if(l1==0&&l2==1)
            {
                if(r1==0&&r2==0)
                {
                    System.out.println(1);
                    //System.out.println(n+" "+(n-1));
                    System.out.println(2+" "+1);

                }
                else if(r1==0&&r2==1)
                {
                    System.out.println(2);
                    System.out.println((n-1)+" "+(n));
                    System.out.println(2+" "+1);
                    //System.out.println((n-1)+" "+(n));
                }
                else if(r1==1&&r2==0)
                {
                    System.out.println(2);
                    System.out.println(1+" "+2);
                    //System.out.println(n+" "+(n-1));
                    System.out.println((n-1)+" "+(n));
                }
                else if(r1==1&&r2==1)
                {
                    System.out.println(1);
                    System.out.println(1+" "+2);
                    //System.out.println(n+" "+(n-1));
                    //System.out.println((n)+" "+(n-1));
                }
            }
            else
            {
                if(r1==1&&r2==1)
                {
                    System.out.println(2);
                    System.out.println(n+" "+(n-1));
                    System.out.println((n-1)+" "+(n));

                }
                else if(r1==0&&r2==1)
                {
                    System.out.println(1);
                    System.out.println((n-1)+" "+(n));
                    //System.out.println((n-1)+" "+(n));
                }
                else if(r1==1&&r2==0)
                {
                    System.out.println(1);
                    //System.out.println(n+" "+(n-1));
                    System.out.println((n)+" "+(n-1));
                }
                else
                {
                    System.out.println(0);
                }
            }

        }

    }
}
