import java.io.*;
import java.util.*;
public class c2014{
   public static void main(String[] args) {
      MyScanner obj = new MyScanner();
      int n=obj.nextInt();
      int m=obj.nextInt();
      int a[]=new int[n+1];
      int seq[]=new int[m+1];
      for(int i=1;i<=n;i++)
      {a[i]=obj.nextInt();}
	  for(int i=1;i<=m;i++)
	  {seq[i]=obj.nextInt();}
	  int f,pos,fil=1,sum=0;
	  int b[]=new int[n+1];
	  int seq1[]=new int[n+1];
	  Arrays.fill(b,0);
	  for(int j=1;j<=m;j++)
	  {
		  f=0;pos=1;
		  for(int i=1;i<=n;i++)
		  {
			 if(a[seq[j]]==b[i]&&seq[j]==seq1[i])
			 {   
				 f=1;
				 pos=i;
			 } 
			 if(b[i]==0)fil=i;
		 }
		 if(f!=1)
		 {
			 for(int i=fil;i>1;i--){
			 b[i]=b[i-1];
			 seq1[i]=seq1[i-1];
			 sum+=b[i];}
			 b[1]=a[seq[j]];
			 seq1[1]=seq[j];
			 
			 
		 }
		 if(f==1)
		 {
			 for(int i=pos;i>1;i--)
			 {
				 b[i]=b[i-1];
				 seq1[i]=seq1[i-1];
				 sum+=b[i];
			 }
			// sum-=a[seq[pos]];
			 b[1]=a[seq[j]];
			 seq1[1]=seq[j];	
		 }
	 }
	 System.out.println(sum);
}
   
   public static class MyScanner {
      BufferedReader br;
      StringTokenizer st;
 
      public MyScanner() {
         br = new BufferedReader(new InputStreamReader(System.in));
      }
 
      String next() {
          while (st == null || !st.hasMoreElements()) {
              try {
                  st = new StringTokenizer(br.readLine());
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
          return st.nextToken();
      }
 
      int nextInt() {
          return Integer.parseInt(next());
      }
 
      long nextLong() {
          return Long.parseLong(next());
      }
 
      double nextDouble() {
          return Double.parseDouble(next());
      }
 
      String nextLine(){
          String str = "";
	  try {
	     str = br.readLine();
	  } catch (IOException e) {
	     e.printStackTrace();
	  }
	  return str;
      }

   }
}
