  import java.io.*;
  import java.util.*;
 public class f2{
             
  public static void main(String[] args) throws IOException
  {
    Scanner sc=new Scanner(System.in);
     int n=sc.nextInt();
     int h[]=new int[n];
     int g[]=new int[n];
     for(int i=0;i<n;i++){
      h[i]=sc.nextInt();
      g[i]=sc.nextInt();
     }
     int cnt=0;
     for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        if(h[i]==g[j]){
          cnt++;
        }
      }
     }
     System.out.println(cnt);


  }
 
  
}