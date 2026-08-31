import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter p = new PrintWriter(System.out);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        byte numOfTeams = Byte.parseByte(in.readLine());
        StringTokenizer stringTokenizer;
        byte [] h,g;
        h = new byte[numOfTeams];
        g = new byte[numOfTeams];
        short result = 0;
        byte i;
        for (i = 0; i < numOfTeams; i++) {
            stringTokenizer = new StringTokenizer(in.readLine());
            h[i] = Byte.parseByte(stringTokenizer.nextToken());
            g[i] = Byte.parseByte(stringTokenizer.nextToken());
        }
        for ( i = 0; i < numOfTeams; i++)
            for (int j = 0; j < numOfTeams; j++)
                if (g[i] == h[j])
                    result++;
        p.println(result);
        p.close();
    }
}