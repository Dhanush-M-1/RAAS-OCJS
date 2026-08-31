import java.io.*;
import java.util.*;

public class Solution{ 
	

 public static void main(String[] args) {
     
     Scanner in = new Scanner(System.in);
     
     int n,k,i,sum=0;
     int[] id;
     
     n=in.nextInt();
     k=in.nextInt();
     
     id=new int[n+1];
     for(i=1;i<=n;i++)id[i]=in.nextInt();
     
     for(i=1;i<=n;i++){
    	 sum+=i;
    	 if(sum>=k)break;
     }
     
     System.out.println(id[k-sum+i]);
 }
}