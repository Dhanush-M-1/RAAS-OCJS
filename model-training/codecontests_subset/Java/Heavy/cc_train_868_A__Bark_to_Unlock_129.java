import java.io.*;
import java.util.*;



public class Solution{ 
	
 public static void main(String[] args) { 
     
     Scanner in = new Scanner(System.in);
     
     int i,j,n;
     String pass;
     String[] w;
     boolean exist=false;
     
     pass=in.next();
     n=in.nextInt();
     w=new String[n+1];
     
     for(i=1;i<=n;i++){
    	 w[i]=in.next();
    	 if(w[i].equals(pass))exist=true;
    	 if(w[i].charAt(0)==pass.charAt(1) && w[i].charAt(1)==pass.charAt(0))exist=true;
     }
     
     for(i=1;i<=n;i++){
    	 for(j=1;j<=n;j++){
    		 if(((w[i]+w[j]).substring(1, 3)).equals(pass))exist=true;
    	 }
     }
     
     if(exist){
    	 System.out.println("YES");
     }
     else{
    	 System.out.println("NO");
     }
     
     
     
 }
}
