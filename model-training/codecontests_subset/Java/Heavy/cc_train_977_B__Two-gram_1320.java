import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
  
  public static void main(String args[]) throws IOException {
    BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
    //BufferedReader bi = new BufferedReader(new FileReader(new File("E:\\test.txt")));
    
    /*String[] paramsStr = bi.readLine().split(" ");
    int n = Integer.parseInt(paramsStr[0]);
    int nDecrement = Integer.parseInt(paramsStr[1]);*/
    
    bi.readLine();
    
    String toAnalyze = bi.readLine();
    Map<String, Integer> bigrams = new HashMap<>();
    int max = 0;
    String ret = null;
    
    for (int i = 0; i < toAnalyze.length() - 1; ++i) {
      String curBigram = toAnalyze.substring(i, i + 2);
      Integer occurences = bigrams.get(curBigram);
      if (occurences == null) {
        bigrams.put(curBigram, 1);
        occurences = 1;
      } else {
        occurences += 1;
        bigrams.put(curBigram, occurences);
      }
      if (occurences > max) {
        max = occurences;
        ret = curBigram;
      }
    }
    
    System.out.println(ret);
    
    //long startTime = System.currentTimeMillis();
    
    bi.close();
    
    //System.out.println("Time in ms : " + (System.currentTimeMillis() - startTime));
  }

}
