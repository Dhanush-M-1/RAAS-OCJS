import java.util.*;

public class Main {

    long INF = Long.MAX_VALUE;

    public static void main(String[] args) {
        new Main().solve();
    }

    void solve() {
        Scanner sc = new Scanner(System.in);
        String X=sc.next();
        char[] x=X.toCharArray();
        long ans=0;
        long c=0;
        for(int i=0;i<X.length();i++){
              if(x[i]=='T'){
              c--;
              if(c<0){
              ans++;
              c=0;
               }
               }else{
               c++;
               }
        }
        System.out.println(ans+c);
    }
}
