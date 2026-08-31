

import java.io.*;
import java.util.*;

public class Problems1 {

    public static void main(String[] args) throws IOException {
        BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(r.readLine());
        StringTokenizer  in =new StringTokenizer(r.readLine());
   
        int a[]=new int[n];
        double sum=0;
        long max=a[0];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(in.nextToken());
            sum+=a[i];
            max=a[i]>max?a[i]:max;
        }
        
        double ans=sum/(n-1);
        long s=(long)ans;
        if(s<ans)s++;
        System.out.println(Math.max(s, max));
        
        
         
            
    }
    
    
}