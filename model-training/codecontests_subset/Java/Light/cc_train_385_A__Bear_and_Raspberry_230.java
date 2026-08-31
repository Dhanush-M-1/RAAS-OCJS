import java.util.*;
import java.io.*;

public class Appleman {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c=sc.nextInt();
        int a[]=new int[n];
        int max=0;
        int diff=0;
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        for(int i=0;i<a.length-1;i++)
        {
            diff=a[i]-a[i+1];
            max=Math.max(max,diff-c);
        }
        System.out.println(max);
    }
}