import java.util.*;
import java.io.*;

public class practice {
	public static void main(String[] args) throws Exception {
            Scanner in = new Scanner(System.in);
            
            String str = in.nextLine();
            int n = Integer.parseInt(str.substring(0, str.indexOf(" ")));
            int x = Integer.parseInt(str.substring(str.indexOf(" ") + 1, str.lastIndexOf(" ")));
            int y = Integer.parseInt(str.substring(str.lastIndexOf(" ") + 1));
            
            int num = (int) Math.ceil(y / 100.0 * n);
            System.out.println(Math.max(0, num - x));
        }
}