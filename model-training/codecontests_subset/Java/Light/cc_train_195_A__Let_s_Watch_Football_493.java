import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
      Scanner sc = new Scanner(System.in);
      int a = sc.nextInt();
      int b = sc.nextInt();
      int c = sc.nextInt();
      sc.close();
      System.out.println(solve(a, b, c));
    }

    private static int solve(int a, int b, int c){
      int mod = c*(a - b) % b;
      int result = c*(a - b) / b;
      return mod > 0 ? result + 1 : result;
    }
    
}


