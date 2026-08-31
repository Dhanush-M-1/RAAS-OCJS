import java.io.*;
import java.util.StringTokenizer;

public class P1334A1200 {
    public static void main(String[] args) throws IOException {
        BufferedReader bread = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int tests = Integer.parseInt(bread.readLine());
        while(tests-->0){
            int n = Integer.parseInt(bread.readLine());
            int prevPlayed = 0;
            int prevCleared = 0;
            boolean passed = true;
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(bread.readLine());
                int played = Integer.parseInt(st.nextToken());
                int cleared = Integer.parseInt(st.nextToken());
                int cdiff = cleared - prevCleared;
                int pdiff = played - prevPlayed;
                if(cdiff > pdiff || cdiff < 0 || pdiff < 0){
                    passed = false;
                }
                prevCleared = cleared;
                prevPlayed = played;
            }
            if(passed){
                out.println("YES");
            }
            else{
                out.println("NO");
            }

        }
        out.close();
    }
}