import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    String str = br.readLine();
    String keyence = "keyence";
    String start;
    String end;
    
    for(int i=0; i<=keyence.length(); i++){
      start = keyence.substring(0, i);
      end = keyence.substring(i, keyence.length());
      Pattern pattern = Pattern.compile("^" + start + ".*" + end + "$");
      Matcher matcher = pattern.matcher(str);
      if (matcher.matches()){
        System.out.println("YES");
        return;
      }
    }
    System.out.println("NO");
  }
}
