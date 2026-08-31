import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int t=Integer.parseInt(bu.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(bu.readLine());
            int i,k,g=0,s=0,b=0,tot=n;
            String st[]=bu.readLine().split(" ");
            HashMap<Integer,Integer> hm=new HashMap<>();
            ArrayList<Integer> key=new ArrayList<>();

            for(i=0;i<n;i++)
            {
                k=Integer.parseInt(st[i]);
                if(hm.get(k)==null)
                {
                    hm.put(k,1);
                    key.add(k);
                }
                else hm.put(k,hm.get(k)+1);
            }
            g=hm.get(key.get(0));
            n=key.size();
            for(i=1;i<n;i++)
            {
                if(s>g) break;
                s+=hm.get(key.get(i));
            }
            while(i<n)
            {
                int te=hm.get(key.get(i));
                if(g+s+b+te<=tot/2) b+=te;
                else break;
                i++;
            }
            if(g>0 && s>0 && b>0 && s>g && b>g && s+b+g<=tot/2) sb.append(g+" "+s+" "+b+"\n");
            else sb.append("0 0 0\n");
        }
        System.out.print(sb);
    }
}