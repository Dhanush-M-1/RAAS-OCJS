import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    Scanner sc = new Scanner();

    int n = Integer.parseInt(sc.next());
    boolean prevRight = false;
    int positions[] = new int[n];
    int heights[] = new int[n];

    int current = 0;
    int answer = 0;
    for (int i = 0; i < n; i++) {
      positions[i] = Integer.parseInt(sc.next());
      heights[i] = Integer.parseInt(sc.next());

      if (i > 0) {
        if (i == 1) {
          answer++;
        } else if (prevRight) {
          if ((positions[current] - heights[current]) > (positions[current - 1] + heights[current - 1])) {
            answer++;
            prevRight = false;
          } else if ((positions[current] + heights[current]) < positions[i]) {
            answer++;
            prevRight = true;
          } else {
            prevRight = false;
          }
        } else if ((positions[current] - heights[current]) > positions[current - 1]) {
          answer++;
          prevRight = false;
        } else if ((positions[current] + heights[current]) < positions[i]) {
          answer++;
          prevRight = true;
        }
      }

      current = i;
    }
     answer++;
     System.out.println(answer);
  }

  static class Scanner {
    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(isr);
    StringTokenizer st = new StringTokenizer("");
    int espacios = 0;

    public String nextLine() throws IOException {
      if (espacios > 0) {
        espacios--;
        return "";
      } else if (st.hasMoreTokens()) {
        StringBuilder salida = new StringBuilder();
        while (st.hasMoreTokens()) {
          salida.append(st.nextToken());
          if (st.countTokens() > 0) {
            salida.append(" ");
          }
        }
        return salida.toString();
      }
      return br.readLine();
    }

    public String next() throws IOException {
      espacios = 0;
      while (!st.hasMoreTokens()) {
        st = new StringTokenizer(br.readLine());
      }
      return st.nextToken();
    }

    public boolean hasNext() throws IOException {
      while (!st.hasMoreTokens()) {
        String linea = br.readLine();
        if (linea == null) {
          return false;
        }
        if (linea.equals("")) {
          espacios++;
        }
        st = new StringTokenizer(linea);
      }
      return true;
    }
  }
}
