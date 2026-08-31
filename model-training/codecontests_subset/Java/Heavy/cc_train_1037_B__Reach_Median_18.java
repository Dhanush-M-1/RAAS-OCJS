import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
import java.util.*;
 
public class Solution 
{ 
       
    public static void main(String[] args) throws IOException 
    { 
  
       BufferedReader br = new BufferedReader( 
                              new InputStreamReader(System.in));
        StringBuilder out=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
         Long m=Long.parseLong(st.nextToken());
        StringTokenizer s=new StringTokenizer(br.readLine());
        long arr[]=new long[n];
        for(int i=0;i<n;i++){
        
            arr[i]=Long.parseLong(s.nextToken());
        }  
        Arrays.sort(arr);
        
        long c=0;
        if(m>arr[n/2]){
            c+=(m-arr[n/2]);
            int j=(n/2)+1;
            while(j<n && arr[j]<m){
                c+=(m-arr[j]);
                j++;
            }
        }else{
             c+=(arr[n/2]-m);
            int j=(n/2)-1;
            while(j>=0 && arr[j]>m){
                c+=(arr[j]-m);
                j--;
            }
        }
        out.append(c);
        System.out.println(out);
       
                
}}
 