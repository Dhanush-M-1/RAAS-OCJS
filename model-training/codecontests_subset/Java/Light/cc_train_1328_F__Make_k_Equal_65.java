import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;
public class D2EqualizingbyDivision {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        int n = in.nextInt();
        int k = in.nextInt();
        int mx = (int)(2e5);
        int mn = (int)(9e9);
        int []num = new int[mx+1];
        int []num2 = new int[mx+1];
        int []cost = new int[mx+1];
        for(int i=0;i<n;i++){
            int next = in.nextInt();
            num[next]++;
            num2[next]++;
        }
        for(int i=2;i<=mx;i++){
            if(num2[i]>0){
                int cur =i;int step=0;
                while (cur!=1){
                    step++;
                    cur>>=1;
                    if(num[cur]<k){
                        int take = Math.min(k-num[cur],num2[i]);
                        num[cur]+=take;
                        cost[cur]+=take*step;
                    }
                }
            }
        }
        for(int i=0;i<=mx;i++){
            if(num[i]>=k){
                mn = Math.min(mn,cost[i]);
            }
        }
        System.out.println(mn);

    }
}
