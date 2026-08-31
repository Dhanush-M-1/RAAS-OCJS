import java.util.*;

public class Main {

  public static void main (String[] args) {

    Scanner sc = new Scanner(System.in);
  
    int N = sc.nextInt();

    int[] v = new int[N];

    int answer = 0;
    boolean validate = false;
    for (int i = 0; i < N; i++) {
      int p = sc.nextInt();
      if ((p - 1) == i) {
        v[i] = 1;
        if (validate) {
          validate = false;
        } else {
          answer++;
          validate = true;
        }
      } else {
        validate = false;
      }
    }

    sc.close();

    System.out.println(answer);

  }

}