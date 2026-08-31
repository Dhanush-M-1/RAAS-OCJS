import java.util.*;
import java.io.*;

public class ChatTraffic5A
{
    public static class MyFasterScanner 
    {
        BufferedReader br;
        StringTokenizer st;

        public MyFasterScanner() {
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
            String str="";
            try {
                str =  br.readLine().toString();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) 
    {
        // Set up scanner
        Scanner sc = new Scanner(System.in); 
        int answer = 0;
        int members = 0;
        while (sc.hasNext())
        {
            String st = sc.nextLine();
            if (st.substring(0,1).equals("+"))
            {
                members++;
            }
            else if (st.substring(0,1).equals("-"))
            {
                members--;
            }
            else    // Must compute the message sent
            {
                int colonpos = st.indexOf(":");
                String rest = st.substring(colonpos+1);
                int length = rest.length();
                answer += members * length;
            }
        }
        System.out.println(answer);
    }
}
        