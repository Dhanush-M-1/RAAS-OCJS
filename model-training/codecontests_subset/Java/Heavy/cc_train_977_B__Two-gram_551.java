import java.util.*;
import java.lang.*;
import java.io.*;

public class Code
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        char[] s = in.nextLine().toCharArray();
        HashMap<String,Integer> hm = new HashMap<>();
        
        for(int i=0;i<n-1;i++)
        {
            String temp = "";
            temp+=s[i];
            temp+=s[i+1];
            
            if(hm.containsKey(temp))
                hm.put(temp,hm.get(temp)+1);
            else
                hm.put(temp,1);
        }
        
        int max = Integer.MIN_VALUE;
        String ans = "";
        for(String t : hm.keySet())
        {
           if(hm.get(t)>max)
           {
               max = hm.get(t);
               ans = t;
           }
        }
        System.out.println(ans);
    }
}