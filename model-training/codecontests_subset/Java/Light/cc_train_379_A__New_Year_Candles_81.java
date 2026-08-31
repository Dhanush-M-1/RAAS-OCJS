/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
/**
 *
 * @author Elcot
 */
public class candles {
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String s[]=in.readLine().split(" ");
        int a=Integer.parseInt(s[0]);
        int b=Integer.parseInt(s[1]);
        int count=0;
        while(a>=b)
        {
            a=a-b+1;
            count+=b;
        }
        count+=a;
        System.out.println(count);
    }
}
