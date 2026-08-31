
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Two_gram {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        char[] c = reader.readLine().toCharArray();
        int[] freq = new int[26 + 26 * 26];
        for (int i = 0; i < n - 1; i++) {
            freq[stringToIndex((c[i] + "" + c[i + 1]))]++;
        }
        int max = 0, index = 0;
        for (int i = 0; i < freq.length; i++) {
            if(freq[i] > max){
                max = freq[i];
                index = i;
            }
        }
        System.out.println(indexToString(index));
    }

    public static int stringToIndex(String s) {
        int n = (s.charAt(0) - 'A') * 26 + (s.charAt(1) - 'A');
        return n;
    }
     public static String indexToString(int index){
         String s = ""+ ((char)(index / 26 + 'A'));
         s += ((char)(index % 26 + 'A'));
         return s;
     }
}
