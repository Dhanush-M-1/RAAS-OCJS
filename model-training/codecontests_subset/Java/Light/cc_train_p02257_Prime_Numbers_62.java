import java.util.Scanner;

class Main {

  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    int ans = 0;
    int n = sc.nextInt();

    for (int j = 0; j < n; j++){
      if (isPrime(sc.nextInt())) ans++;
    }
    System.out.println(ans);
  }

  public static boolean isPrime(int x){

    /* 引数が２ならtrue */
    if (x == 2)
      return true;
    if (x % 2 == 0)
      return false;

    int i = 3;
    while (i <= Math.sqrt(x)){
      if (x % i == 0)
        return false;
      i += 2;
    }
    return true;
  }

}
