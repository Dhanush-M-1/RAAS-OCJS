/*
ID: ethan.z2
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

public class BearAndRaspberry {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)/*new FileReader("friday.in")*/);
    //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    StringTokenizer s1 = new StringTokenizer(br.readLine()), s2 = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(s1.nextToken()), c = Integer.parseInt(s1.nextToken()), x1 = Integer.parseInt(s2.nextToken()), max = 0;
    for (int i = 1; i < n; i++){
        int input = Integer.parseInt(s2.nextToken());
        max = Math.max(max, x1 - input);
        x1 = input;
    }
    System.out.println((max < c) ? "0" : max - c);




  }

}
