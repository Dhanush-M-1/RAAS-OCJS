import java.util.*;
import java.lang.*;
import java.io.*;

public class U5 {
    public static void main(String[] Args){
        FastReader scan=new FastReader();
        int n=scan.nextInt();
        int mod=998244353;
        int[] arr=new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]=scan.nextInt();
        }
        Map<Integer,Integer> f=new HashMap<>();
        for(int i=0;i<n;i++){
            int temp=arr[i];
            int dig=0;
            while(temp!=0){
                dig++;
                temp/=10;
            }
            f.putIfAbsent(dig,0);
            f.put(dig,f.get(dig)+1);
        }
        double ans=0;
        double[] mult=new double[21];
        double m=1;
        for(int i=1;i<=20;i++){
            mult[i]=m;
            m=(m*10)%mod;
        }
        for(int i=0;i<n;i++){
            for(Integer len:f.keySet()){
                int count=0;
                int index=1;
                int temp=arr[i];
                while(temp!=0){
                    count++;
                    int d=temp%10;
                    if(count>len){
                        ans=(ans%mod+((d*mult[index])%mod*f.get(len))%mod)%mod;
                    }
                    ans=(ans%mod+((d*mult[index++])%mod*f.get(len))%mod)%mod;
                    if(count<=len) {
                        ans = (ans % mod + ((d * mult[index++])%mod * f.get(len)) % mod) % mod;
                    }
                    temp/=10;
                }
            }
        }
        System.out.println((int)ans);
    }
    static class FastReader {
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
}