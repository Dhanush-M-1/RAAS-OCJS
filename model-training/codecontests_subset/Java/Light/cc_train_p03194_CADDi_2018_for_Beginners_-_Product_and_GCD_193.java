

import java.util.*;
class Main {
  public static void main (String[] args) throws Exception {
    
    Scanner sc = new Scanner(System.in);
    
    long p = sc.nextLong();
    long l = sc.nextLong();
    
    long ans =1;
    
    long first = l;
    
    long count=0;
    
    if(p==1)ans=l;
    else{
    	for(long i=2; i<=Math.sqrt(l);i++){
          if(i==l && l==first)break;
       
          if(l%i == 0){
            while (l%i==0){
              count++;
              l=l/i;
            }
          if(count >=p){
            for(int j=1;j<=count/p;j++){
        		ans=ans*i; 
        	 }
         }
         count =0;
         }
         
     }
    } 
       System.out.println(ans);

  }
}
