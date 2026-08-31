import java.util.Scanner;

class Main {
  public static void main(String... args) {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int count = 0;

    for (int i = 0; i < size; i++) {
      if(checkPrime(sc.nextInt())) {
        count++;
      }
    }

    System.out.println(count);
  }

  public static boolean checkPrime(int num) {
    int count = 0;
    if (num == 1) {
      return false;
    } else if (num == 2) {
      return true;
    }

    if(num % 2 == 0) {
      return false;
    }

    for (int i = 3; i <= num / i; i+=2) {
      if (num % i == 0) {
        return false;
      }
    }
    return true;
  }
}

