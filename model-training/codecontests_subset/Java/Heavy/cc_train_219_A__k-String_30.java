import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ar {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
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

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
static boolean[] seen;
static long[] larr;
static int[] arr;

 public static void main(String[] args) throws java.lang.Exception {
        FastReader scn = new FastReader();

arr=new int[26];        
int k=scn.nextInt();
String s=scn.next();
if(k==1){
    System.out.print(s+"\n");
return;}

for(char c:s.toCharArray()){
    arr[c-'a']++;
}
int rep=0;
String ans = "";

for(int i=0;i<26;i++){
    if (arr[i] == 0)continue;
    if(arr[i]%k!=0){
        System.out.print(-1+"\n");return;
    }
    for(int j=0;j<arr[i]/k;j++){
        ans+=""+(char)(i+'a');
    }
}
String tmp=ans;
for(int j=0;j<k-1;j++){
    ans=ans+tmp;
}
System.out.print(ans+"\n");


}



}