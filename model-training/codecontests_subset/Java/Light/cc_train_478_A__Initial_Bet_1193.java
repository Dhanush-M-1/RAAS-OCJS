import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Test{
 
public static void main(String[] args) throws IOException{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    String[] s=br.readLine().split(" ");
    int n=0;
    for(int i=0;i<5;i++){
    	n+=Integer.parseInt(s[i]);
   }
   if(n==0){
	System.out.println(-1);
   }
   else if(n%5==0){
	System.out.println(n/5);
   }
   else{
	System.out.println(-1);
	}
}
}