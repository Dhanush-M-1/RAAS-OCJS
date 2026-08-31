import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main (String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int res = 0;
        for (int i = 0; i < 5; i++) res += in.nextInt();
        System.out.println(res != 0 && res % 5 == 0 ? res / 5 : -1);
        in.close();
    }

}