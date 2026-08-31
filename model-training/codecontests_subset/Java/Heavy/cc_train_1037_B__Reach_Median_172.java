import java.util.*;
import java.io.*;
public class MyClass {
    public static void main(String args[]) 
    {
        MyScanner sc=new MyScanner();
        int n=sc.nextInt();
       int s=sc.nextInt();
       int a[]=new int [n];
       for(int i=0;i<n;i++)
       {
           a[i]=sc.nextInt();
       }
       Arrays.sort(a);
       int med=a[n/2];
       if(med==s)
       System.out.println(0);
       else if(med<s)
       {
           long res=0;
           for(int i=n/2;i<n;i++)
           {
               if((s-a[i])>0)
               res=res+s-a[i];
               else
               break;
           }
           System.out.println(res);
       }
       else
       {
            long res=0;
           for(int i=n/2;i>=0;i--)
           {
               if((a[i]-s)>0)
               res=res+a[i]-s;
               else
               break;
           }
           System.out.println(res);
           
       }
           
       
        
      
      
        
       
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
 
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
         
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
