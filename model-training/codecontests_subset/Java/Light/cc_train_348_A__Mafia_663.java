import java.io.*;
import java.util.*;

public class CodeForce{
      
        
	public static void main(String[] args) throws IOException {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int n=Integer.parseInt(br.readLine());
          String[] str=br.readLine().split(" ");
         long[] arr=new long[n];
         long max=Long.MIN_VALUE;
         long sum=0;
         for(int i=0;i<n;i++){
             arr[i]=Long.parseLong(str[i]);
             if(max<arr[i])
                 max=arr[i];
             sum+=arr[i];
         }
         
            System.out.println(Math.max(max,(int)Math.ceil((double)sum/(n-1))));
	
        }}