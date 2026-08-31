import java.util.*;
import java.io.*;

public class HelloWorld{

     public static void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int p = 0;
        int q = 0;
        for(int i = 0; i < n; i++)
        {
            if(s.charAt(i) == '0') p++;
            else q++;
        }
        if(p == q)
        {
            System.out.println(2);
            System.out.println(s.substring(0,1)+" "+s.substring(1));
        }
        else
        {
            System.out.println(1);
            System.out.println(s);
        }
     }
}
