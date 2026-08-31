import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
public final class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] s = br.readLine().split("\\+");
            Arrays.sort(s);
            System.out.println(String.join("+",s));
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}