import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class A {

  public static void main(String args[]) throws FileNotFoundException {
    try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
         PrintWriter out = new PrintWriter(System.out)) {
         new A().solve(in,out);
    }


  }

  private void solve(Scanner in, PrintWriter out) {
    int [] arr = new int[5];
    for (int i = 0; i < 5; i++) {
      arr[i] = in.nextInt();
    }
    double sum = Arrays.stream(arr).sum();
    if (sum / 5 == (int)(sum / 5) && sum != 0){
      out.print((int)(sum / 5));
    }else {
      out.print(-1);
    }
  }


}


