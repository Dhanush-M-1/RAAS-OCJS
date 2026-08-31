import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ERound_93D2P1 {
    static final FS sc = new FS();
    static final PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] a = sc.nextArray(n);
            int s1 = 0, s2 = 0, s3 = 0, f=0;
            int a1 = 0, a2 = 0, a3 = 0;
            /*for(int i=0; i<n; i++){
                for(int j=i+1; j<n; j++){
                    s1 = a[i]; s2 = a[j]; s3 = s1+s2; f = 0;
                    a1 = i; a2 = j;
                    //System.out.println(s1+" "+s2+" "+s3);
                    int l = j+1, r = n-1;
                    while(l<=r){
                        if(a[(l+r)/2]>s3){
                            s3 = a[(l+r)/2];
                            a3 = (l+r)/2;
                            f = 1;
                            break;
                        }
                        else{
                            if(l==(l+r)/2) l++;
                            else l = (l+r)/2 + 1;
                        }
                    }
                    if(f==1){
                        break;
                    }
                }
                if(f==1){
                    break;
                }
            }*/
            int i,j;
            /*for(i=0; i<n-2; i++){
                if(a[i+2]<a[i]+a[i+1]){
                    continue;
                }
                else{
                    a1 = i; a2 = i+1; a3 = i+2;
                    System.out.println((a1+1)+" "+(a2+1)+" "+(n));
                    f=1;
                    break;
                    //System.out.println();
                }
            }
            if(i==n-2) System.out.println("-1");*/


            for(j=0;j<n-2;j++)
            {
                if( (a[j]+a[j+1]) > a[n-1] )
                {
                    continue;
                }
                else
                {
                    System.out.println( (j+1)+" "+(j+2)+" "+ (n) );
                    break;
                }

            }
            if(j==n-2)
            {
                System.out.println(-1);
            }
            /*if(f==1){
                System.out.println((a1+1)+" "+(a2+1)+" "+(a3+1));
            }
            else{
                System.out.println("-1");
            }*/
        }
        //pw.println("hello");
        //pw.flush();
    }

    static class FS {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (Exception ignored) {
                }
            }
            return st.nextToken();
        }

        int[] nextArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}
