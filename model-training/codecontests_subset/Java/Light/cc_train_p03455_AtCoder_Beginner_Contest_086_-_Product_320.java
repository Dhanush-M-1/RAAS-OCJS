import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int A = sc.nextInt();
    int B = sc.nextInt();
    int pro = A*B;

    if(pro%2 == 0) {
      System.out.println("Even");
    }else {
      System.out.println("Odd");
    }
  }
}
