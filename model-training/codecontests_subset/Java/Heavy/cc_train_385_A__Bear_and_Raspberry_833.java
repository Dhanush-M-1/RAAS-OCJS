import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

import javax.swing.table.DefaultTableModel;

public class Test 
{
    static void print(int[] a)
    {
        for(int i=0;i<a.length;i++) System.out.print(a[i]+" ");
        System.out.println();
    }
    static String space(int n)
    {
        String res="";
        for(int i=0;i<n;i++) res+=" ";
        return res;
    }
    static int sum(int a[])
    {
        int res=0;
        for(int i=0;i<a.length;i++) res+=a[i];
        return res;
    }
    static int[] sort(int list[])
    {
        for(int i=0;i<list.length-1;i++)
        {
            for(int j=0;j<list.length-i-1;j++)
            {
                if(list[j]>list[j+1]) 
                {
                    int t=list[j];
                    list[j]=list[j+1];
                    list[j+1]=t;
                }
            }
        }
        return list;
    }
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int c=in.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++) a[i]=in.nextInt();
        int res=0;
        int cur=a[0]-a[1];
        int time=0;
        for(int i=1;i<n-1;i++)
        {
            if(cur<(a[i]-a[i+1])) {time=i; cur=a[i]-a[i+1];}
        }
        if(cur<0||(cur-c)<0) System.out.println("0");
        else System.out.println(cur-c);
        //for(int i=0;i<255;i++) System.out.println(i+" : "+(char)i);
    }
    
}