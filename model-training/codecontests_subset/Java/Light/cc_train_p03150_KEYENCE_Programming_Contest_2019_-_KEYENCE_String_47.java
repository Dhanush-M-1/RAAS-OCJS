import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        ////if (str == "keyence") {
        //    System.out.println(str.substring(0,3));
        //    System.out.println(str.substring(8,str.length()));
        //    //System.out.println(str);
        ////}

        for (int i = 0; i <= str.length(); i++) {
            for (int j = i; j <= str.length(); j++) {
                //System.out.println(str.substring(0, i) + str.substring(j, str.length()));
                if ((str.substring(0, i) + str.substring(j, str.length())).equals("keyence")) {
                    System.out.println("YES");
                    System.exit(0);
                }
            }
        }
        System.out.println("NO");
    }
}
