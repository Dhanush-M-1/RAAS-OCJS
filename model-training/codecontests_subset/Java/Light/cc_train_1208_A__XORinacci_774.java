import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
        long a=sc.nextLong();
        long b=sc.nextLong();
        long c=sc.nextLong();
        if(c%3==0)
            System.out.println(a);
        else if(c%3==1)
            System.out.println(b);
        else
            System.out.println(a^b);
        }
    }
}

