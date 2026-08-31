import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class a {
    static FastReader fs = new FastReader();
    public static void main(String[] args) {

        int t = fs.readInt();
        while(t-->0){
            solve();
        }
    }
    public static void solve(){
        int n =fs.readInt();
        int [] a = new int[n];
        for(int i=0;i<n;i++)a[i] = fs.readInt();
        if(a[0]+a[1] <= a[n-1])
            System.out.printf("%d %d %d\n",1,2,n);
        else
            System.out.println(-1);
    }

    static class FastReader{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
        public String next(){
            while(!st.hasMoreElements()){
                try {
                    st = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        public int readInt(){
            return Integer.parseInt(next());
        }
    }
}
