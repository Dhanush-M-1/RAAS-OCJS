import java.io.*;
import java.util.*;

public class Codeforces
{
    public static void main(String args[])throws Exception
    {
        BufferedReader bu=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        String s[]=bu.readLine().split(" ");
        int n=Integer.parseInt(s[0]),k=Integer.parseInt(s[1]);
        ArrayList<Integer> ab=new ArrayList<>();
        ArrayList<Integer> a=new ArrayList<>();
        ArrayList<Integer> b=new ArrayList<>();
        int i,al=0,bo=0,x,y,z;
        for(i=0;i<n;i++)
        {
            s=bu.readLine().split(" ");
            x=Integer.parseInt(s[0]); y=Integer.parseInt(s[1]); z=Integer.parseInt(s[2]);
            if(y==1) al++;
            if(z==1) bo++;
            if(y==1 && z==1) {ab.add(x); continue;}
            if(y==1) a.add(x);
            if(z==1) b.add(x);
        }
        if(al<k || bo<k) {System.out.print("-1"); return;}
        Collections.sort(a); Collections.sort(b);

        for(i=0;i<Math.min(a.size(),b.size());i++)
            ab.add(a.get(i)+b.get(i));
        Collections.sort(ab);
        int min=0;
        for(i=0;i<k;i++)
        min+=ab.get(i);
        System.out.print(min);
    }
}