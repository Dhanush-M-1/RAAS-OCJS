
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class Test2 {

    public static void main(String[] args)throws Exception {
    reader in = new reader(System.in);
    int n= in.nextInt();
    String s = in.next();  long count=0; 
    int arr[]= new int[3];
    for(int i= 0;i<n;i++)
        if(s.charAt(i)=='F')
            arr[0]++;
    else
            if(s.charAt(i)=='I')
                arr[1]++;
    else
                arr[2]++;
    for(int i=0;i<n;i++)
        if(s.charAt(i)!='F')
            if(s.charAt(i)=='I'){
                if(arr[1]-1==0)
                if(arr[0]>0||arr[2]>0)
                 count++;}
            else {
             if(arr[1]==0)   
                 if(arr[0]>0||arr[2]>0)
                     count++;
            }

  
        System.out.println(count);
   
    }
   static class reader{ 
      BufferedReader in ; 
      StringTokenizer tok;
      public reader(InputStream stream){
          in = new BufferedReader(new InputStreamReader(stream));
          tok=null;
          
      }
       String next()throws Exception{
           
         while(tok==null||!tok.hasMoreElements()){
             tok=new StringTokenizer(in.readLine());
  }
           return tok.nextToken();
           
       }
       int nextInt()throws Exception{
         return Integer.parseInt(next());
           
       }
 }
    
    
    
    
    
    
    
}