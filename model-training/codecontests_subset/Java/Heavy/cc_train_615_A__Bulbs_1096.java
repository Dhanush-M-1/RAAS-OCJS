import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) {
        MyScanner sc=new MyScanner();
        int button=sc.nextInt();
        int bulb=sc.nextInt();
        int arr[]=new int[bulb];
        for(int i=0;i<button;i++){
            int n_tmp=sc.nextInt();
            for(int j=0;j<n_tmp;j++){
                int t=sc.nextInt();
                arr[t-1]=1;
            }
        }
        int sum=0;
        for(int i=0;i<bulb;i++){
            sum+=arr[i];
        }
        if(sum==bulb){
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
    }
    
    
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
           br = new BufferedReader(new InputStreamReader(System.in));
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

        String nextLine(){
            String str = "";
          try {
             str = br.readLine();
          } catch (IOException e) {
             e.printStackTrace();
          }
          return str;
        }
    }

}
