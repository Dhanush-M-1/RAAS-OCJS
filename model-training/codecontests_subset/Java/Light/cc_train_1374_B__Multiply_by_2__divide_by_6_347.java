import java.util.*;
public class solution {
    
   
    public static void main(String[] args){
        Scanner scn=new Scanner(System.in);
        int tc=scn.nextInt();
        long[] res=new long[tc];
        
        for(int i=0;i<tc;i++){
           int n=scn.nextInt();
           
        int ans=-1;  
        int div3=0;
        int div6=0;
        
        while(n%6==0){
            div6++;
            n=n/6;
        }
        while(n%3==0){
            div3++;
            n=n/3;
        }
        
        if(n<=1){
            ans=2*div3+div6;
        }
        
         res[i]=ans;
        }
        
        for(int i=0;i<tc;i++){
             System.out.println(res[i]);
        }
    }
}



