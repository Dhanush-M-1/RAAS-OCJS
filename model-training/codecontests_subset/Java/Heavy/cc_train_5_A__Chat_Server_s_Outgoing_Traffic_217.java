import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        int online = 0;
        int size = 0;
        while (scan.hasNextLine()) {
            String str = scan.nextLine();

            if (str.charAt(0) == '+') {
                online++;
            } else {
                if (str.charAt(0) == '-') {
                    online--;

                } else {
                    size += (str.substring(str.indexOf(":") + 1).length()) * online;
                }
            }
        }
        System.out.println(size);

    }
}
