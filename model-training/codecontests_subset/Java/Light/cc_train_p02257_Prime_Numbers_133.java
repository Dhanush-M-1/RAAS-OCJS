import java.util.Scanner;

public class Main {
  static int counter;

  public static void main(String[] args) {
    Scanner scanInt = new Scanner(System.in);
    int N = scanInt.nextInt();
    int i;
    for(i = 0; i < N; i++){
      prime(scanInt.nextInt());
    }
    System.out.println(counter);
  }

  public static void prime(int num){
    int mini_c = 0;
    for(int j=2; j <= Math.sqrt(num); j++){
      if(num % j == 0) mini_c++;
    }
    if(mini_c == 0) counter++;
  }
}





