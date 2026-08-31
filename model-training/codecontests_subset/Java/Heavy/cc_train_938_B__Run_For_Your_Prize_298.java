import java.util.*;
import java.io.*;
import java.math.*;
public class Codeforces{
    static FR in;
    public static void main(String[] args){
        in = new FR();
        int n=ni();
        int[]a=ia(n);
        int pos=(int)1e6;
        long ans=0;
        int i=0, lpos=1, llpos=pos;
        while( i<n && a[i]<=pos/2){
        	ans+=a[i]-lpos;
        	lpos=a[i];
        	i++;
        }
        long ans2=0;
        i=n-1;
        llpos=pos;
        while( i>=0 && a[i]>pos/2){
        	ans2+=llpos-a[i];
        	llpos=a[i];
        	i--;
        }
        System.out.println(ans>ans2 ? ans : ans2);
        
    }
    
    static void p(Object o){
        System.out.print(o);
    }
    
    static void pl(Object o){
        System.out.println(o);
    }
    
    static String n(){
        return in.next();
    }
    
    static String nln(){
        return in.nextLine();
    }
    
    static int ni(){
        return Integer.parseInt(in.next());
    }
    
    static long nl(){
        return Long.parseLong(in.next());
    }
    
    static long[]la( int N ){
    	long[]a=new long[N];
    	for( int i=0;i<N;i++ )a[i]=nl();
    	return a;
    }
    
    static int[] ia(int N){
        int[] a = new int[N];
        for(int i = 0; i<N; i++)a[i] = ni();
        return a;
    }
    
    static class FR{
        BufferedReader br;
        StringTokenizer st;
        public FR(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next(){
            while (st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException  e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }
}