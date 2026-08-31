import java.io.*;
import java.util.*;
public class Main {
    static int n=0;
    static long pos[];
    static long ht[];
    
	public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String st[] = br.readLine().split(" ");
            n=Integer.parseInt(st[0]);
            pos=new long[n];
            ht=new long[n];

            for(int i=0;i<n;i++){
                st=br.readLine().split(" ");
                pos[i]=Long.parseLong(st[0]);
                ht[i]=Long.parseLong(st[1]);
            }
           int count=2;
           
           for(int i=1;i<n-1;i++){
               if(pos[i-1]<pos[i]-ht[i])count++;
               else if(pos[i+1]>pos[i]+ht[i]){
                   pos[i]+=ht[i];
                   count++;
               }
           }
           if(n<=2){
               System.out.println(n);
           }
           else{
               System.out.println(count);
           }
	}
}
