import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Antonio "Teo" Alurralde
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    String s = br.readLine();
    int a, in, f;
    a = in = f = 0;
    for (int i = 0; i < n; i++) {
      switch (s.charAt(i)){
        case 'A':
          a++;
          break;
        case 'I':
          in++;
          break;
        case 'F':
          f++;
      }
    }
    System.out.print(in==0?a:(in==1?1:0));
  }
}
