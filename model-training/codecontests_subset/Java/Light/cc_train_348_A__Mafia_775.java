import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.*;

public class TaskMafia {
  public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    StringTokenizer st = new StringTokenizer(f.readLine());
    
    int nPlayers = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(f.readLine());
    
    long[] lnGames = new long[nPlayers];
    long lnSigGames = 0L, lnMaxGames=0L;
    for(int i=0;i<nPlayers;i++) {
      lnGames[i]=Long.parseLong(st.nextToken());
      lnMaxGames = Math.max(lnMaxGames,lnGames[i]);
      lnSigGames += lnGames[i];
    }
    long answer = Math.max(lnMaxGames,(long)Math.ceil((lnSigGames)/(nPlayers-1.0)));
    out.println(answer);
    out.close();
    System.exit(0);
  }
}