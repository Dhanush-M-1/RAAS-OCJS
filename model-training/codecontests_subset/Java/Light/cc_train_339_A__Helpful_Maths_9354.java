import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * @author dpalreddy
 * Jun 13, 2021
 */
public class HelpfulMaths {

  public static void main(String[] args) throws IOException {
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      String[] strs = reader.readLine().trim().split("\\+");
      int count1 = 0;
      int count2 = 0;
      int count3 = 0;

      for (String k : strs) {
        switch (k) {
          case "1":
            count1++;
            break;
          case "2":
            count2++;
            break;
          case "3":
            count3++;
            break;
        }
      }
      //System.out.println(count1 + " " + count2 + " " + count3);
        StringBuilder sb = new StringBuilder();
        while (count1-- > 0) {
          sb.append("1+");
        }

        while (count2-- > 0) {
          sb.append("2+");
        }

        while (count3-- > 0) {
          sb.append("3+");
        }

        if (sb.toString().endsWith("+")) {//10
          System.out.println(sb.toString().substring(0, sb.toString().length() - 1));//0 to 9
        } else {
          System.out.println(sb.toString());
        }



    }
  }

}
