

import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.util.*;
  
public class c676b
{ 
    //By shwetank_verma
    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
    static int mod=1000000007;
    static boolean primes[]=new boolean[1000007];
    
    static boolean seive(int n){
        Arrays.fill(primes,true);
        primes[0]=primes[1]=false;
        for(int i=2;i*i<=n;i++){
            if(primes[i]==true){
                for(int p=i*i;p<=n;p+=i){
                    primes[p]=false;
                }
            }
        }
        if(n<1000007){
            return primes[n];
        }
        return false;
        
    }
    static int gcd(int a,int b){
        if(b==0)
        return a;
        return gcd(b,a%b);
    }
    static long GCD(long a,long b){
        if(b==0)
        return a;
        return GCD(b,a%b);
    }
    
  
    public static void main(String[] args) 
    { 
        FastReader sc=new FastReader(); 
        try{
           
                int t=sc.nextInt();
                while(t-->0){
                int n=sc.nextInt();
                
                ArrayList<Integer> l=new ArrayList<>();
                char ch[][]=new char[n][n];
                String str="";
                for(int i=0;i<n;i++) {
                	str=sc.next();
                	char c[]=str.toCharArray();
                	for(int j=0;j<n;j++) {
                		ch[i][j]=c[j];
                	}
                }
                if(ch[n-1][n-2]==ch[n-2][n-1]) {
                	if(ch[n-1][n-2]=='0') {
                		if(ch[0][1]=='0') {
                			l.add(1);
                			l.add(2);
                			
                		}
                		if(ch[1][0]=='0') {
                			l.add(2);
                			l.add(1);
                			
                		}
                	}
                	else {
                		if(ch[0][1]=='1') {
                			l.add(1);
                			l.add(2);
                			
                		}
                		if(ch[1][0]=='1') {
                			l.add(2);
                			l.add(1);
                		}
                	}
                }
                else {
                	
                	if(ch[1][0] == '0' && ch[0][1] == '0'){
                        if(ch[n - 1][n - 2] == '0'){
                           l.add(n);
                           l.add(n-1);
                        }
                        if(ch[n - 2][n - 1] == '0'){
                            l.add(n-1);
                            l.add(n);
                        }
                    }else if(ch[1][0] == '1' && ch[0][1] == '1'){
                        if(ch[n - 1][n - 2] == '1'){
                            l.add(n);
                            l.add(n-1);
                        }
                        if(ch[n - 2][n - 1] == '1'){
                            l.add(n-1);
                            l.add(n);
                        }
                    }else if(ch[n - 1][n - 2] == '1'){
                        l.add(n);
                        l.add(n-1);
                        if(ch[0][1] == '0'){
                            l.add(1);
                            l.add(2);
                        }
                        if(ch[1][0] == '0'){
                            l.add(2);
                            l.add(1);
                         }
                    }else{
                        l.add(n);
                        l.add(n-1);
                        if(ch[0][1] == '1'){
                            l.add(1);
                            l.add(2);
                        }
                        if(ch[1][0] == '1'){
                            l.add(2);
                            l.add(1);
                        }
                    }
                }
                System.out.println(l.size()/2);
                for(int i=0;i<l.size();i+=2) {
                	System.out.println(l.get(i)+" "+l.get(i+1));
                }
                
        
                }
           
            
        }catch(Exception e){
            return;
        }
    } 
}
