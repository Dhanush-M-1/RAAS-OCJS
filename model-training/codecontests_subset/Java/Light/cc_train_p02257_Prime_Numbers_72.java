import java.util.*;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int count = 0;

    for(int i = 0; i < n; i++){
      int x = scan.nextInt();
      if (CheckPrime(x)){
        count++;
      }
    }

    System.out.println(count);
  }

  static boolean CheckPrime(int x){
    if(x == 1) return false;
    else if(x == 2) return true;
    else if(x % 2 == 0) return false;

    for(int i = 3; i <= Math.sqrt(x); i += 2){
      if(x % i == 0){
        return false;
      }
    }

    return true;
  }
}

