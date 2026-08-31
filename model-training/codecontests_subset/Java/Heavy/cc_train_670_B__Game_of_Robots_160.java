import java.util.*;
import java.math.*;
import java.io.*;
import java.text.*;

public class practice {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
    public static int mod(int a,int b ,int m){
        if(b == 0){
            return 1;
        }
        else if(b == 1){
            return a%m;
        }
        else{
            if(b%2 == 0){
                return ((mod(a,b/2,m)%m)*(mod(a,b/2,m))%m)%m;
            }
            else{
                return (a*((mod(a,b/2,m)%m)*(mod(a,b/2,m))%m))%m;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long a[] = new long[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            a[i] = Long.parseLong(st.nextToken());
        }
        int i = 1;
        long sum = 0;
        while (sum<k){
            sum+=i;
            i++;
        }
        sum-=(i-1);
        int ind = (int)(k-sum);
        System.out.println(a[ind]);
    }
}

class sort implements Comparator<ArrayList<Long>> {

    @Override
    public int compare(ArrayList<Long> o1, ArrayList<Long> o2) {
        int c = o1.get(0).compareTo(o2.get(0));
        return c;
    }

}