import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwoGram {

  public static int count(String s, String tg) {
    int counter = 0;
    System.out.println(tg);
    System.out.println(s);
    for (int i = 0; i < s.length(); i++) {
      System.out.println(i);
      for (int j = 0; j < s.length(); j++) {
        System.out.println(j);
        System.out.println(s.substring(i,j+1) );
        if (s.substring(i,j+1) == tg)
            counter +=1;
      }
    }
    return counter;
  }
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(bf.readLine()), count = 0, max = Integer.MIN_VALUE;
    String line = bf.readLine(), twoGram = "", temp;

    for (int i = 0; i < line.length() - 1; i++ ) {
        temp = String.valueOf(line.charAt(i)) + String.valueOf(line.charAt(i+1));
        count = line.length() - line.replaceAll(Pattern.quote(temp.substring(0,1)) + "(?=" + Pattern.quote(temp.substring(1)) + ")", "").length();
        if (count > max) {
          max = count;
          twoGram = temp;
        }
    }

    System.out.println(twoGram);
  }
}
