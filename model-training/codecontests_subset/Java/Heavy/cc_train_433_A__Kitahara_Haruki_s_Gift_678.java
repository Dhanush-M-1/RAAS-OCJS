import java.io.Console;
import java.util.Arrays;
import java.io.*;
import java.lang.Integer;

public class problemA  {
	
	public static void main (String args[]) throws IOException {

		BufferedReader in;

		if (System.getProperty("ONLINE_JUDGE") != null) {
                in = new BufferedReader(new InputStreamReader(System.in));
        } else {
                in = new BufferedReader(new FileReader("input.txt"));
        }


        String numApplesString = in.readLine();
        int n = Integer.parseInt(numApplesString);
        String [] weights = in.readLine().split(" ");
        in.close();

        int i = 0;
        int sum = 0;

        while (i < n) {
        	sum += Integer.parseInt(weights[i]);
        	i++;
        }

        if ((sum == n * 200) && (n % 2 == 1)) {
        	System.out.println("NO");
        }
        else if ((sum % 200 == 0 && n > 1))  {
        	System.out.println("YES");
        } else {
        	System.out.println("NO");
        }

                
    }


}