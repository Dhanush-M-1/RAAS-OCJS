import java.io.*;

public class A513Div1_2
{
    public static void main(String[] args)
    {
        new A513Div1_2(System.in, System.out);
    }

    private static class Solver implements Runnable
    {
        int n;
        char[] s;
        BufferedReader in;
        PrintWriter out;

        void solve() throws IOException
        {
            n = Integer.parseInt(in.readLine());
            s = in.readLine().toCharArray();

            int eights = 0;

            for (char ch : s)
            {
                if (ch == '8')
                    eights++;
            }

            int others = n - eights;
            int cnt = 0;

            while (true)
            {
                if (eights == 0)
                    break;

                int digits = Math.min(10, others);

                others -= digits;

                if (digits < 10)
                {
                    if (eights < 11 - digits)
                        break;

                    eights -= (11 - digits);
                    cnt++;
                }
                else
                {
                    eights--;
                    cnt++;
                }
            }

            out.println(cnt);
        }

        public Solver(BufferedReader in, PrintWriter out)
        {
            this.in = in;
            this.out = out;
        }

        @Override
        public void run()
        {
            try
            {
                solve();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

    }

    private A513Div1_2(InputStream inputStream, OutputStream outputStream)
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter out = new PrintWriter(outputStream);
        Thread thread = new Thread(null, new Solver(in, out), "Solver", 1 << 29);

        try
        {
            thread.start();
            thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        try
        {
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        out.flush();
        out.close();
    }

}
