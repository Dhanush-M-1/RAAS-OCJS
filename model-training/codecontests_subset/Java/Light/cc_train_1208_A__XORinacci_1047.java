import java.io.*;
import java.util.*;
public class XORinacci{
public static void main(String[] args) throws Exception  {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t;
        t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {   String []s=br.readLine().split(" ");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            int n=Integer.parseInt(s[2]);
            long x=a^b;
            if((n%3)==2)
                System.out.println(x+"\n");
            else if((n%3)==0)
                System.out.println(a+"\n");
            else
                System.out.println(b+"\n");
        }
    }
}