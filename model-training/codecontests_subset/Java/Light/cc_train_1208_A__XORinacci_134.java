import java.util.Scanner;

public class XORinacci {

  public static void main(String[] args) {
    Scanner xScanner = new Scanner(System.in);
    int iNumTestCases = xScanner.nextInt();

    for(int i = 0; i < iNumTestCases; i++) {
      int a = xScanner.nextInt();
      int b = xScanner.nextInt();
      int n = xScanner.nextInt();

      //-- the sequence is a, b, a ^ b, a, b, a ^ b, ...
      if(n % 3 == 0)
        System.out.println(a);
      else if( n % 3 == 1)
        System.out.println(b);
      else
        System.out.println(a ^ b);
    }
  }

  //-- rekursiv
  private static int XORinacciRecursive(int a, int b, int n) {
    if(n == 0)
      return a;
    if(n == 1)
      return b;
    return XORinacciRecursive(a, b, n-1) ^ XORinacciRecursive(a, b, n-2);
  }

  private static int XORinacciIterative(int a, int b, int n) {
    if(n == 0)
      return a;
    else if(n == 1)
      return b;
    else if (n == 2)
      return a ^ b;
    else {
      int[] aXORinacciNumbers = new int[n];
      aXORinacciNumbers[0] = a;
      aXORinacciNumbers[1] = b;
      for(int i = 2; i < n ; i++) {
        aXORinacciNumbers[i] = aXORinacciNumbers[i-1] ^ aXORinacciNumbers[i-2];
      }
      return aXORinacciNumbers[n-1];
    }
  }
}
