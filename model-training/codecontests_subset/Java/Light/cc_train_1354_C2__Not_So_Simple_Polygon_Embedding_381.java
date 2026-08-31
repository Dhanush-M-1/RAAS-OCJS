import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int t = console.nextInt();
        while (t-- > 0) {
          int n = console.nextInt();
          double rad = Math.PI / n;
          double diag = .5 * Math.cos(rad / 4) / Math.sin(rad / 2);
          System.out.println(2*diag);
        }
      }
    }
