import java.util.*;
import java.io.*;
public class Main {
	
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStream pr = System.out;
        PrintWriter out = new PrintWriter(pr);
        int t = sc.nextInt();
        for(int i=0;i<t;i++){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long n = sc.nextLong();
            if(n%3==0){
                out.println(a);
            }else if(n%3==1){
                out.println(b);
            }else{
                out.println(a^b);
            }
        }
        out.close();
    }
    public static String dp(int p,int n,String s){
        if(p==n){
            return "no";
        }else{
            boolean boo = dp1(s);
            if(boo){
                return s;
            }else{
                if(dp1(s.substring(0,p-1)+s.substring(p,s.length()))){
                    return s.substring(0,p-1)+s.substring(p,s.length());
                }else{
                    return dp(p+1,n,s);
                }
            }
        }
    }
    public static boolean dp1(String s){
        int val = Integer.parseInt(s);
        if(val%8==0){
            return true;
        }else{
            return false;
        }
    }
}