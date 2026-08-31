import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String s;
        int c = 0, p = 0;
        while ((s = br.readLine()) != null) {
            if (s.contains("+")) p++;
            else if (s.contains("-")) p--;
            else {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == ':') {
                        i++;
                        int sum = s.length() - i;
                        c += p * sum;
                    }
                }
            }
        }
        pw.println(c);
        pw.close();
        br.close();

    }
}