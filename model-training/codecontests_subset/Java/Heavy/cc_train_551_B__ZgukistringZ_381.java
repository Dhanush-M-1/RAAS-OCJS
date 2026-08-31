import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jouke on 6/13/15.
 */
public class CF_551B {

  static int[] ac;
  static int[] bc;
  static int[] cc;

  public static boolean fits(int nb, int nc) {
    for (int i = 0; i < 26; i++) {
      if (ac[i] - nb * bc[i] - nc * cc[i] < 0) {
        return false;
      }
    }
    return true;
  }

  public static int maxFit(boolean b) {
    for (int max = 1; true; max++) {
      if (b) {
        if (!fits(max, 0)) {
          return max - 1;
        }
      } else {
        if (!fits(0, max)) {
          return max - 1;
        }
      }
    }
  }

  public static int[] charCount(String s) {
    int[] counts = new int[26];
    for (int i = 0; i < s.length(); i++) {
      counts[(int) s.charAt(i) - 97]++;
    }
    return counts;
  }

  public static void main(String[] args) {
    try (Scanner s = new Scanner(System.in)) {
      String a = s.next();
      String b = s.next();
      String c = s.next();

      ac = charCount(a);
      bc = charCount(b);
      cc = charCount(c);

      int mfb = maxFit(true);
      int mfc = maxFit(false);
      int maxb = 0, maxc = 0;

      if (mfb == 0 || mfc == 0) {
        maxc = mfc;
        maxb = mfb;
      }
      else {
        int offset = mfc > mfb ? mfc - mfb : 0;
        while(true) {
          boolean foundNewMax = false;
          for (int i = 0; i <= mfc - offset; i++) {
            if (fits(mfb - i, i + offset)) {
              maxb = mfb - i;
              maxc = i + offset;
              foundNewMax = true;
              offset++;
              break;
            }
          }
          if (!foundNewMax)
            break;
        }
      }

      //print result
      StringBuilder k = new StringBuilder(a.length());
      for (int i = 0; i < maxb; i++)
        k.append(b);
      for (int i = 0; i < maxc; i++)
        k.append(c);
      for (int i = 0; i < 26; i++) {
        int count = ac[i] - maxb * bc[i] - maxc * cc[i];
        for (int j = 0; j < count; j++)
          k.append((char) (i + 97));
      }
      System.out.println(k.toString());


      //DEBUG
//      char[] alphabet = new char[26];
//      for (int i = 0; i < 26; i++) {
//        alphabet[i] = (char) (i + 97);
//      }
//      System.out.println(Arrays.toString(alphabet));
//      System.out.println(Arrays.toString(ac));
//      System.out.println(Arrays.toString(bc));
//      System.out.println(Arrays.toString(cc));
//      System.out.println(maxb);
//      System.out.println(maxc);
//      System.out.println(mfb);
//      System.out.println(mfc);

    }
  }
}
