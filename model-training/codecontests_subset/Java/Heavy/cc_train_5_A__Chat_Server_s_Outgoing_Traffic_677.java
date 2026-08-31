import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        solve(System.in, System.out);
    }

    public static void solve(InputStream inStream, PrintStream outStream)
    {
        Scanner scanner = new Scanner(inStream);

        int people = 0;
        int data = 0;
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            //if (line == null)
              //  break;

            if (line.charAt(0) == '+')
                people++;
            else if (line.charAt(0) == '-')
                people--;
            else
            {
                data += people * (line.length() - line.indexOf(':') - 1);
            }
        }
        outStream.print(data);
    }
}