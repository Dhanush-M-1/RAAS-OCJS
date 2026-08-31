import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class TaskB
{
    Scanner in;
    PrintWriter out;

    int a, b;
    int ans = 0;

    public static void main(String[] args)
    {
        TaskB mainTest = new TaskB();

        mainTest.readData();
        mainTest.solve();
        mainTest.outputData();
    }

    public TaskB()
    {
        in = new Scanner(System.in);
        out = new PrintWriter(new OutputStreamWriter(System.out));
    }

    public void readData()
    {
        a = in.nextInt();
        b = in.nextInt();
    }

    public void solve()
    {
        int a2 = 0;
        int a3 = 0;
        int a5 = 0;

        while (a % 2 == 0) {
            a2++;
            a /= 2;
        }

        while (a % 3 == 0) {
            a3++;
            a /= 3;
        }

        while (a % 5 == 0) {
            a5++;
            a /= 5;
        }

        int b2 = 0;
        int b3 = 0;
        int b5 = 0;

        while (b % 2 == 0) {
            b2++;
            b /= 2;
        }

        while (b % 3 == 0) {
            b3++;
            b /= 3;
        }

        while (b % 5 == 0) {
            b5++;
            b /= 5;
        }

        if (a != b) {
            ans = -1;
            return;
        } else {
            ans = Math.abs(a2 - b2) + Math.abs(a3 - b3) + Math.abs(a5 - b5);
        }
    }

    public void outputData()
    {
        out.println(ans);
        out.flush();
    }
}
