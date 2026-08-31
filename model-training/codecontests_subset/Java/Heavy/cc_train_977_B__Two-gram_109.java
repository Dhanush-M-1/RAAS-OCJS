import java.util.*;
import java.io.*;
public class one
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st=null;
    static String next()
    {
        while(st==null || !st.hasMoreElements())
        {
            try{
                st=new StringTokenizer(br.readLine());
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    static int nextInt()
    {
        return Integer.parseInt(next());
    }
    static long nextLong()
    {
        return Long.parseLong(next());
    }
    
    static double nextDouble(){
        return Double.parseDouble(next());
    } 
   public static void main(String[] args) {
        try{
               int n=nextInt();
               String s=next();
               int i=1;
               TreeSet<String> ts=new TreeSet<>();
               String str="";
               String sm="";
               int max=Integer.MIN_VALUE;
               HashMap<String,Integer> hm=new HashMap<>();
               while(i<s.length())
               {
                   str+=s.substring(i-1,i+1);
                   if(ts.contains(str)==false)
                   {
                       hm.put(str,1);
                       if(1>max)
                       {
                           max=1;
                           sm="";
                           sm+=str;
                       }
                       ts.add(str);
                   }
                   else
                   {
                       int x=hm.get(str);
                       if((x+1)>max)
                       {
                           max=(x+1);
                           sm="";
                           sm+=str;
                       }
                       hm.put(str,x+1);
                   }
                  // bw.write(str+"\n");
                   str="";
                   i++;
               }
              // bw.write(max+"\n");
               bw.write(sm+"\n");
                 bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}