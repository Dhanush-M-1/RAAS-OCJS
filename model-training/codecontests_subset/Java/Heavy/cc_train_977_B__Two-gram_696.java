import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
public final class TwoGram{
        public static void main(String[] args) throws IOException{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            char[] theString = s.toCharArray();
            HashMap<String, Integer> twoGrams = new HashMap<String, Integer>();

            for(int i=0; i<theString.length-1; i++){
                StringBuilder strB = new StringBuilder();
                strB.append(theString[i]);
                strB.append(theString[i+1]);
                String str = strB.toString();
                if(!twoGrams.containsKey(str)){
                    twoGrams.put(str, 0);
                }else{
                    int x = twoGrams.get(str);
                    x++;
                    twoGrams.replace(str, x);
                }
            }
            String maxKey = "";
            int max = Integer.MIN_VALUE;
            for(String key : twoGrams.keySet()){
                if(max < twoGrams.get(key)){
                    max = twoGrams.get(key);
                    maxKey = key;
                }
            }
            System.out.println(maxKey);
        }
}
