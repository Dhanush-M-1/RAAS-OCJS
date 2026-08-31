import java.util.*;
import java.math.*;
import java.io.*;

public class Main
    {
    public static void main(String args[]) throws IOException
        {
        BufferedReader c=new BufferedReader(new InputStreamReader(System.in));
        String S=c.readLine();
        HashMap<String, Integer> M=new HashMap<String, Integer>();
        int Days[]=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        for(int i=0;i<=S.length()-10;i++)
            {
            String now=S.substring(i,i+10);
            //System.out.println(now);
            String parts[]=now.split("-");
            //System.out.println(Arrays.toString(parts));
            if(parts.length==3&&parts[0].length()==2&&parts[1].length()==2&&parts[2].length()==4)
                {
                //System.out.println(Arrays.toString(parts));
                int year=Integer.parseInt(parts[2]);
                if(year<2013||year>2015)
                    continue;
                int month=Integer.parseInt(parts[1]);
                if(month<=0||month>12)
                    continue;
                int day=Integer.parseInt(parts[0]);
                if(day<1||day>Days[month-1])
                    continue;
                if(M.containsKey(now))
                    M.put(now,M.get(now)+1);
                else
                    M.put(now,1);
                }
            }
        String maxDate="";
        int maxOcc=0;
        for(String k:M.keySet())
            {
            if(M.get(k)>maxOcc)
                {
                maxOcc=M.get(k);
                maxDate=k;
                }
            }
        System.out.println(maxDate);
        }
    }

//must declare new classes here