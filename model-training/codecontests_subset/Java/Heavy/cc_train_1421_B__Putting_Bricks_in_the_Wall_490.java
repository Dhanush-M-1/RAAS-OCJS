import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main{
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
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            String a[] = new String[n];
            for(int i = 0; i<n; i++){
                a[i] = sc.next();
            }
            char b = a[0].charAt(1);
            char c = a[1].charAt(0);
            char e = a[n-1].charAt(n-2);
            char d = a[n-2].charAt(n-1);
            if(b=='0' && c=='0'){
                if(d=='1'&&e=='1'){
                    System.out.println(0);
                }
                else if(d=='0'&&e=='0'){
                    System.out.println(2);
                    System.out.println(1+" "+2);
                    System.out.println(2+" "+1);
                }
                else{
                    System.out.println(1);
                    if(d=='0') System.out.println((n-1)+" "+n);
                    else System.out.println(n+" "+(n-1));
                }
            } 
            else if(b=='1'&&c=='1'){
                if(d=='0'&&e=='0'){
                    System.out.println(0);
                }
                else if(d=='1'&&e=='1'){
                    System.out.println(2);
                    System.out.println(1+" "+2);
                    System.out.println(2+" "+1);
                }
                else{
                    System.out.println(1);
                    if(d=='1') System.out.println((n-1)+" "+n);
                    else System.out.println(n+" "+(n-1));
                }
            }
            else {
                if(d=='0'&&e=='0'){
                    System.out.println(1);
                    if(b =='0') System.out.println(1+" "+2);
                    else System.out.println(2+" "+1);
                }
                else if(d=='1'&&e=='1'){
                    System.out.println(1);
                    if(b =='1') System.out.println(1+" "+2);
                    else System.out.println(2+" "+1);
                }
                else {
                    System.out.println(2);
                    if(b == '0') System.out.println(1+" "+2);
                    else System.out.println(2+" "+1);
                    if(d=='1') System.out.println((n-1)+" "+n);
                    else System.out.println(n+" "+(n-1));
                }
            }
        }
    }
}



















