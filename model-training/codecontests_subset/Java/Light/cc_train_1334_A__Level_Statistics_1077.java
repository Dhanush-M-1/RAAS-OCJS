//package cf;


import java.util.*;
import java.io.*;
public class Cf{
    public static void main(String[]args)throws IOException{
       // BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       // String []s=br.readLine().trim().split("\\s+");
       Scanner sc=new Scanner(System.in); 
       int t=sc.nextInt();
       out:while(t-->0){
           int n=sc.nextInt();
           int []p=new int[n];
           int []c=new int[n];
           boolean flag=true;
          
           in:for(int i=0;i<n;i++){
               p[i]=sc.nextInt();
               c[i]=sc.nextInt();
               
                if(c[i]>p[i]){
                       flag=false;
                       continue in;
                   }
                if(i!=0){
                    if(p[i]<p[i-1]){
                        flag=false;
                        continue in;
                    }
                    if(c[i]<c[i-1]){
                        flag=false;
                        continue in;
                    }
                    if(c[i]-c[i-1]>p[i]-p[i-1]){
                        flag=false;
                        continue in;
                        
                    }
                }
               
           }
           
           if(flag)
           System.out.println("YES");
           else System.out.println("NO");
           
       
       
    }
    
}
}