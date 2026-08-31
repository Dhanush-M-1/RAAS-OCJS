import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author gark87 <arkady.galyash@gmail.com>
 */
public class SecondTask {
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String str = reader.readLine();
    int n = Integer.parseInt(str);
    String text = reader.readLine();
    int a = 0,i = 0 ,f = 0;
    for(int j =0 ; j< n; j++) {
      switch (text.charAt(j)) {
        case 'A': a++;
          break;
        case 'I': i ++;
          break;
        case 'F': f++;
          break;
      }
    }
    int result = 0;
    if (i == 1)
      result = 1;
    else if (i ==0) {
      result = a + i;
    }
    System.out.println(result);
  }
}
