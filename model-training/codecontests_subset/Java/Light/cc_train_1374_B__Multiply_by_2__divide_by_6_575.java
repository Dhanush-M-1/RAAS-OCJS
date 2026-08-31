import java.util.*;
import java.lang.*;
import java.io.*;
        public class d{
        public static void main (String[] args) {                        
            PrintWriter pw=new PrintWriter(System.out);
            Scanner sc=new Scanner(System.in);
            int t=1;
            t=sc.nextInt();
            for(int i11=0;i11<t;i11++){
                int n=sc.nextInt();
                int res=0,count=0,count1=0,f=0,f1=0;
                while(n%2==0){
                    f=1;
                  n/=2;
                  count++;
                }
                  while(n%3==0){
                      f1=1;
                  n/=3;
                  count1++;
                }
                if(n!=1){
                    pw.println(-1);
                }
                else{
                    if((n==1&&f==0)&&f1==0)
                    pw.println(0);
                    else{
                    res+=Math.min(count,count1);
                    if(count>count1){
                       pw.println(-1); 
                    }
                    else{
                       count1-=count;
                       res+=2*count1;
                       pw.println(res); 
                    }
                    }
                   
                }
                  
                     }
                       
                       pw.close();
    	}
    }