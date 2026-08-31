import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution{
  static long mod = 1000000007;
  public static void main(String[] args) throws IOException{
    StringBuilder print = new StringBuilder();
    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    long n = Long.parseLong(input.readLine());
    long total = 0;

    total = total(n);
    print.append(total + "\n");
    System.out.println(print.toString());
  }

  public static long total(long n){
    long output = perm(n);
    long power2 = 1;
    while(n-- > 1){
      power2 = Math.floorMod(power2 * 2, mod);
    }
    output = Math.floorMod(output - power2, mod);
    return output;
  }
  public static long perm(long n){
    long output = 1;
    for(long i = 1; i <= n; i++){
      output *= i;
      output = Math.floorMod(output,mod);
    }
    return output;
  }
}
