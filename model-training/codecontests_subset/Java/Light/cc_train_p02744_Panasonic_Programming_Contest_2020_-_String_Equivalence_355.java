import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    int n = Integer.parseInt(br.readLine());
    StringBuilder result = new StringBuilder();
    for (String s : process(n)){
      result.append(s).append("\n");
    }
    System.out.println(result);
  }
  
  public static List<String> process(int length){
    if (length == 1){
      List<String> result = new ArrayList<>();
      result.add("a");
      return  result;
    } else {
      List<String> result = new ArrayList<>();
      for (String s : process(length - 1)) {
        char append = 'a';
        int maxCodePoint = 0;
        for (char c : s.toCharArray()){
          if (maxCodePoint < c){
            maxCodePoint = c;
          }
        }
        while (append <= maxCodePoint+1) {
          result.add(s + append);
          append++;
        }
      }
      return result;
    }
  }
}
