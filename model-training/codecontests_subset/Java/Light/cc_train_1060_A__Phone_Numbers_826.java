import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Main
{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt(),c=0;
        String str=s.next();
        char[] ch=str.toCharArray();
        for(int i=0;i<ch.length;i++)
        if(ch[i]=='8')
        c++;
        if(c>=(n/11))
        System.out.println(n/11);
        else if(c<(n/11) && n>11)
        System.out.println(c);
        else
        System.out.println(0);
        
       
    }
    
}
