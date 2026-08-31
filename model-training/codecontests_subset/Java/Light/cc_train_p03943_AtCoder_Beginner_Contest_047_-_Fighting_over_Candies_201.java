import java.util.*;
 
public class Main {
  public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);
    int [] N = new int[3];
    int nmax = 0;
    int goukei = 0;
    String ans = "No";

    for(int i = 0 ; i < N.length ; i ++){
      N[i] = sc.nextInt();
      nmax = Math.max(nmax,N[i]);
      goukei = goukei + N[i];
    }
    
    ans = (goukei == nmax * 2 ) ? "Yes" : "No";

    System.out.println(ans);
  }
}
