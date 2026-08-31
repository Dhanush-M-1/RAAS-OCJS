import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Reverse_Sub_Str {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        String nextLine(){
            String str = "";
            try
            {
                str = br.readLine();
            }catch (IOException e){
                e.printStackTrace();
            }
            return str;
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
    }
    public static void main(String[] args) {
       FastReader in = new FastReader();
       int n = in.nextInt();
       String s = in.nextLine();
       int l  = 0;
       int r = 0;
       boolean ty = false;
       for(int i = 1; i < n; i++){
           if(s.charAt(i) < s.charAt(i-1)){
               l = i;
               r = i+1;
               ty = true;
               break;
           }
       }
       if(ty){
           System.out.println("YES");
           System.out.println(l +" "+r);
       }else{
           System.out.println("NO");
       }
    }
}
