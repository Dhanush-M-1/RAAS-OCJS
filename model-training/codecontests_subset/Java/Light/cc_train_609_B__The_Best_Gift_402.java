import java.util.*;
import java.io.*;
 public class Test2 {

public static void main(String[] args) throws Exception{
BufferedReader  in = new BufferedReader(new InputStreamReader(System.in));
 StringTokenizer tok = new StringTokenizer(in.readLine());
 int n= nextInt(tok);
 int m= nextInt(tok);
 int arr[]= new int [n];
 tok = new StringTokenizer(in.readLine());
 for(int i= 0 ; i<n; i++)
     arr[i]=nextInt(tok);
 Arrays.sort(arr);long c= 0 ;int f=1;
for(int i = 0 ;i<n-1;i++){
    if(arr[i]==arr[i+1]){
        f++;
        
    }
    else{
        if(i!=0)
            c+=(n-(i+1))*f;
        else
            c+=n-1;
        f=1;
        
    }  
}
 
    System.out.println(c);
 
 
}
     static double nextDouble(StringTokenizer tok){
    return Double.parseDouble(tok.nextToken());
}
public static int nextInt(StringTokenizer s) throws Exception {
        return Integer.parseInt(s.nextToken());
    }
public static long nextLong(StringTokenizer s) throws Exception {
        return Long.parseLong(s.nextToken());
    }
}