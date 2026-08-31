import java.util.Scanner;
import java.util.Arrays;
public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int [] a = new int[4];
    Arrays.fill(a,0);
    for(int i = 0; i<N; i++){
      String S = sc.next();
      if(S.equals("AC")) a[0]++;
      else if(S.equals("WA")) a[1]++;
      else if(S.equals("TLE")) a[2]++;
      else a[3]++;
    }    
    System.out.println("AC x "+ a[0]);
    System.out.println("WA x "+ a[1]);
    System.out.println("TLE x "+ a[2]);
    System.out.println("RE x "+ a[3]);
  }
}