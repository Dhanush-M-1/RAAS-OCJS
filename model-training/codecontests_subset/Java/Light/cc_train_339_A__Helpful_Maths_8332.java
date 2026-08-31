import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


 public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str[] = in.nextLine().split("\\+");
        int len = str.length;
        int ar[] = new int[len];
        for(int i=0;i<len;i++)
            ar[i] = Integer.parseInt(str[i]);
       
        if(len == 1)
            System.out.println(str[0]);
        else{
            Arrays.sort(ar);
            String s = "";
            for(int i=0;i<len-1;i++)
                s = s+Integer.toString(ar[i])+"+";
            s = s+Integer.toString(ar[len-1]);
            System.out.println(s);
        }
   }
}
