import java.util.*;
import java.io.*;
import java.math.*;

public class practice {
    public static int M = 1000003;

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        else {
            return (gcd(b, a % b));
        }
    }

    public static int fact(int n) {
        if (n == 0) return 1;
        else return (n * (fact(n - 1)) % M);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        HashMap<String,Integer> H = new HashMap<>();
        for(int i=0;i<n-1;i++){
            String a ="" + str.charAt(i) + str.charAt(i+1);
            if(H.containsKey(a)){
                int t = H.get(a);
                int v = H.remove(a);
                H.put(a,t+1);
            }
            else{
                H.put(a,1);
            }
        }
        String ans = "";
        int max = Integer.MIN_VALUE;
        for(String i : H.keySet()){
            if(H.get(i)>max){
                ans = i;
                max = H.get(i);
            }
        }
        System.out.println(ans);
    }
}
