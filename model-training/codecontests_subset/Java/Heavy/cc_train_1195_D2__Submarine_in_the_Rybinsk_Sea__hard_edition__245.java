import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class D_574_v3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        String[] input = br.readLine().split(" ");
        String[] v = new String[N];
        BigInteger[] ssums = new BigInteger[11];
        int[] amounts = new int[11];
        for(int i = 0; i < N; i++){
            String n = input[i];
            v[i] = n;
            amounts[n.length()]++;
        }
        for(int i = 1; i < 11; i++){
            BigInteger ssum = new BigInteger("0");
            for(int j = 0; j < N; j++){
                String n = v[j];
                int start = Integer.max(n.length() - i, 0);
                StringBuilder s = new StringBuilder(n.substring(0, start));
                for(int k = start; k < n.length(); k++){
                    s.append("0");
                    s.append(n.substring(k, k + 1));
                }
                ssum = ssum.add(new BigInteger(s.toString()));
            }
            ssums[i] = (ssum);
        }
        BigInteger sum = new BigInteger("0");
        for(int i = 0; i < N; i++){
            String n = input[i];

            BigInteger[] values = new BigInteger[11];
            for(int j = 1; j < 11; j++){
                int start = Integer.max(n.length() - j, 0);
                StringBuilder s = new StringBuilder(n.substring(0, start));
                for(int k = start; k < n.length(); k++){
                    s.append(n.substring(k, k + 1));
                    s.append("0");
                }
                values[j] = new BigInteger(s.toString());
            }
            BigInteger t = new BigInteger("0");
            for(int j = 1; j < amounts.length; j++){
                BigInteger temp = new BigInteger(values[j].toString());
                temp = temp.multiply(new BigInteger(Integer.toString(amounts[j])));
                t = t.add(temp);
            }
            sum = sum.add(ssums[n.length()]);
            sum = sum.add(t);
        }
        sum = sum.mod(new BigInteger("998244353"));
        System.out.println(sum.toString());
    }
}
