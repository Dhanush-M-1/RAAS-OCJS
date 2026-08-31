import java.util.Arrays;
import java.util.Scanner;

/**
 * @author vmad
 */
public class C551B {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String a = input.nextLine().trim();
    String b = input.nextLine().trim();
    String c = input.nextLine().trim();

    int[] ac = new int[26];
    int[] bc = new int[26];
    int[] cc = new int[26];

    int n = a.length();

    for(int i = 0; i < a.length(); i++) {
      ac[a.charAt(i) - 'a']++;
    }

    for(int i = 0; i < b.length(); i++) {
      bc[b.charAt(i) - 'a']++;
    }

    for(int i = 0; i < c.length(); i++) {
      cc[c.charAt(i) - 'a']++;
    }

    int max = Integer.MIN_VALUE;
    int maxb = -1;
    int maxc = -1;
    for(int i = 0; i <= n; i++) {
      boolean ok = true;
      for(int j = 0; j < 26; j++) {
        if(ac[j] < bc[j] * i) { ok = false; }
      }
      if(!ok) break;
      int minc = Integer.MAX_VALUE;
      for(int j = 0; j < 26; j++) {
        if(cc[j] != 0) {
          minc = Math.min(minc, (ac[j] - bc[j] * i) / cc[j]);
        }
      }
      if(minc >= 0 && i + minc > max) {
        max = i + minc;
        maxb = i;
        maxc = minc;
      }
    }

    for(int i = 0; i < maxb; i++) {
      System.out.print(b);
    }
    for(int i = 0; i < maxc; i++) {
      System.out.print(c);
    }

    for(int i = 0; i < 26; i++) {
      for(int j = 0; j < ac[i] - maxb * bc[i] - maxc * cc[i]; j++) {
        System.out.print((char)(i + 'a'));
      }
    }
    
    System.out.println();
  }
}
