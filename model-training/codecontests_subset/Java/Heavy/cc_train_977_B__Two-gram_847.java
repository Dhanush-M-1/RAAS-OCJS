

import java.util.*;

public class Main{
    public static void main(String[] args) 
    {
       Scanner s=new Scanner(System.in);
       int len=s.nextInt();
       String str=s.next();
       int i=0,j=1;
       HashMap<String,Integer> mp=new HashMap<>();
       String ans=""+str.charAt(0)+str.charAt(1);
       while(i<len&&j<len)
       {
           String tG=""+str.charAt(i)+str.charAt(j);
           if(!mp.containsKey(tG))
           {
               mp.put(tG,1);
               
           }
           else
           mp.put(tG,mp.get(tG)+1);
          int k=mp.get(ans);
          if(k<mp.get(tG))
          ans=tG;
           i++;
           j++;
       }
       System.out.println(ans);
    }
}