//package codeforces;
import java.io.*;
import java.util.*;
public final class Codeforces {
    public static void main(String[] args) throws Exception{
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);        
        FastReader sc = new FastReader();
          int k=sc.nextInt();
          String s=sc.next();
          int a[]=new int[26];
          for(char c:s.toCharArray())
          {
              a[c-'a']++;
          }
          boolean bool=true;
          for(int i=0;i<26;i++)
          {
              if(a[i]%k!=0){bool=false;break;}
          }
           if(bool==false)out.write("-1");
           else
           {
               StringBuffer ss=new StringBuffer("");
               for(int i=0;i<26;i++)
               {
                   int j=a[i]/k;
                   while(j-->0)
                   {
                       ss.append((char)(i+'a'));
                       
                   }
                   
               }
               for(int i=0;i<k;i++)out.write(ss+"");
           }
           out.flush();
        }
     
   
    static class FastReader {        

        BufferedReader br;        
        StringTokenizer st;        
       
        public FastReader() {            
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
        
        String nextLine() {            
            String str = "";            
            try {                
                str = br.readLine();                
            } catch (IOException e) {                
                e.printStackTrace();                
            }            
            return str;            
        }        
    }   
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////// 
}
