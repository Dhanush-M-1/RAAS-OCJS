import java.io.*;
import java.util.*;

public class Main{ 
   static class Fast{
     public BufferedReader br;
     public StringTokenizer st;
     
     public Fast(){
          br =new BufferedReader(new InputStreamReader(System.in));
     }
     
     String next(){
          while(st==null || !st.hasMoreTokens()){
               try{
                    st=new StringTokenizer(br.readLine());
               }
               catch(IOException e){
                    throw new RuntimeException(e);
               }
               
          }
               return st.nextToken();
          }
     int nextInt(){
          return Integer.parseInt(next());
     }

     long nextLong(){
          return Long.parseLong(next());
     }

 }
  

	public static void main(String[] args)throws Exception{
         //StringTokenizer st;//! @ % & * () _ {} # ~ : < > ? "" | ^
          Fast f=new Fast();
         PrintWriter out = new PrintWriter(System.out);
        // StringBuilder str=new StringBuilder();
         //  int x=Integer.parseInt(st.nextToken());
         
        //st=new StringTokenizer(br.readLine()); 

        
        int t=f.nextInt();
        while(t-->0){
              int n=f.nextInt();
              int m=f.nextInt();

              Set<Integer> s=new HashSet<>();
              boolean k=false;
              int j=0;
               int x=0;
              for (int i=0;i<n;i++ ) {
                 x=f.nextInt();
                 s.add(x);
              }
               int b[]=new int[m];
              for (int i=0;i<m ;i++) {
                b[i]=f.nextInt();
              }

              for (int i=0;i<m ;i++) {
               if (s.contains(b[i])) {
                  k=true;j=i;break;
               }
              }
              


              if (k) {
                out.println("YES");
                out.println(1+" "+b[j]);
              }
              else out.println("NO");
             
        }
   
        //out.println(ans);
        
        //out.println(mh);
    out.close();

}
}


