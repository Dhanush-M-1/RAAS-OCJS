import java.util.*;
import java.io.*;
public class cfb{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] ar=new int[k];
        st=new StringTokenizer(br.readLine());
        int sum=0;
        for(int i=0;i<k;i++){
            ar[i]=Integer.parseInt(st.nextToken());
            sum+=ar[i];
        }
        Arrays.sort(ar);
        int ans=Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            long rem = m - (sum * i);
            if (rem < 0) break;
            int count = k * i + i;
            label:
            for (int a = 0; a < k; a++) {
                for (int j = i; j < n; j++) {
                    if (rem < ar[a])
                     break label;
                    rem -= ar[a];
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }
        System.out.println(ans);

    }

        







    }
