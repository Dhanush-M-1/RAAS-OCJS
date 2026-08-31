import java.io.*;
import java.util.*;

public class CreditCard {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        long d = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        st = new StringTokenizer(f.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }
        long balance = 0;
        int count = 0;
        long[] balances = new long[n];
        long[] rightmax = new long[n];
        for(int i = 0; i < n; i++){
            balances[i] = balance;
            balance += arr[i];

            if(balance > d){
                out.println(-1);
                out.close();
                System.exit(0);
            }
        }
        rightmax[n-1] = Math.min(d, d-arr[n-1]);
        for(int i = n-2; i >= 0; i--){
            rightmax[i] = Math.min(d, rightmax[i+1]-arr[i]);
        }
        balance = 0;
        for(int i = 0; i < n; i++){
            balance+=arr[i];
            if(balance < 0 && arr[i] == 0){
                count++;
                if(rightmax[i] < 0){
                    out.println(-1);
                    out.close();
                    System.exit(0);
                }
                balance=rightmax[i];
            }

        }
        out.println(count);
        out.close();
    }
}
