import java.util.*;
import java.io.*;

public class B260
{
    static int[] numdays=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

    public static void main(String[] args) throws IOException
    {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            String s=sc.next();
            Vector<String> v=new Vector<String>();
            for(int i=0;i+10<=s.length();i++)
            {
                String sub=s.substring(i,i+10);
                if(sub.charAt(2)!='-'||sub.charAt(5)!='-')
                    continue;
                boolean ok=true;
                for(int j=0;j<sub.length();j++)
                    if(j!=2 && j!=5 && (sub.charAt(j)<'0' || sub.charAt(j)>'9'))
                        ok=false;
                if(!ok)
                    continue;
                try
                {
                    int dd=Integer.parseInt(sub.substring(0,2)); // " 9"
                    int mm=Integer.parseInt(sub.substring(3,5));
                    int yy=Integer.parseInt(sub.substring(6,10));
                    if(mm>=1&&mm<=12 && numdays[mm-1]>=dd && dd>=1 && yy>=2013 && yy<= 2015)
                        v.add(sub);
                }
                catch(Exception e)
                {
                }
            }
            Collections.sort(v);
            //for(int i=0;i<v.size();i++)
            //    System.out.println("> "+v.get(i));
            String best="?";
            int numbest=-1;
            for(int i=0;i<v.size();i++)
            {
                int j=i;
                while(j+1<v.size()&&v.get(j+1).equals(v.get(i)))
                    j++;
                if(j-i>numbest)
                {
                    best=v.get(i);
                    numbest=j-i;
                }
                //System.out.println("["+i+", "+j+"]");
                i=j;
            }
            System.out.println(best);
        }
    }
}