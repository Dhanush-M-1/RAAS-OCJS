import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CodeForces {
    public static void main(String[] args){
        reader input=new reader();
        String s=input.next();
        int one=0,two=0,three=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
                one++;
            else if(s.charAt(i)=='2')
                two++;
            else if(s.charAt(i)=='3')
                three++;
        }
        StringBuilder answer=new StringBuilder("");
        for(int i=0;i<one;i++){
            answer.append(1+"+");
        }
        for(int i=0;i<two;i++){
            answer.append(2+"+");
        }
        for(int i=0;i<three;i++){
            answer.append(3+"+");
        }
        System.out.println(answer.substring(0,s.length()));
    }

    public static int lcm(int a,int b){
        int lcm=(a*b)/gcd(a,b);
        return lcm;
    }
    public static int gcd(int a,int b){
        if(a==0)
            return b;
        else
            return gcd(b%a,a);
    }
}
class reader {
    BufferedReader br;
    StringTokenizer st;
    public reader() {
        br = new BufferedReader(new
                InputStreamReader(System.in));
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
