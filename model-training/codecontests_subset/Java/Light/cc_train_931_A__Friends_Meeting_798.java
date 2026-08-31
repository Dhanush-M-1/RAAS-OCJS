import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args)throws IOException {

BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
        int a=Integer.parseInt(br.readLine());
        int b=Integer.parseInt(br.readLine());
         int max=Math.max(a,b);
          int min=Math.min(a,b);
          int i=1,c1=0,c2=0;
          while(max-min>1)
          {
              c1+=i;
              c2+=i;
              max--;min++;i++;
          }
          if(max-min==1)
            System.out.println(c1+c2+i);
        else
        System.out.println(c1+c2);
}
}