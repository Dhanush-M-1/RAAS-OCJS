import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args)throws IOException{
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        int b=Integer.parseInt(br.readLine());
        int z=0;
        if(a==b)
        {
             bw.write(""+z+"");
              bw.flush();
        }  
        else
        {
            int k=1,sum=0;
            int m=(a+b)/2;
            int h=a;
            //System.out.println(m);
            //System.out.println(a);
            if(a>b)
                h=b;
            else
                h=a;
            for(int i=h;i<m;i++)
            {
                
                sum+=(2*k);
                k++;
                //System.out.println(sum);
            }
        if(((a%2)==0 && (b%2)==1) || (a%2)==1 && (b%2)==0)
            sum+=k;
        bw.write(""+sum+"");
        bw.flush();
    }
    }
}