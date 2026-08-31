import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)
    {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;

        InputReader1 in = new InputReader1(inputStream);
        PrintWriter out = new PrintWriter(outputStream);

        TaskA a = new TaskA();
        a.solve(in, out);

        out.close();
    }
}

class TaskA
{
    public void solve(InputReader1 in, PrintWriter out)
    {
        int t = in.nextInt();
        int m = in.nextInt();
        int memory[] = new int[m];
        int id = 0;

        while (t >= 1)
        {
            String operation = in.next();
            if (operation.equals("alloc"))
            {
                int size = in.nextInt();
                int counter = 0;
                boolean found = false;
                for (int i = 0; i <= memory.length - size;)
                {
                    counter = 0;
                    for (int j = i; j < memory.length; j++)
                    {
                        if (memory[j] == 0)
                        {
                            counter++;
                        }
                        else
                        {
                            break;
                        }
                    }
                    if (size <= counter)
                    {
                        found = true;
                        id += 1;
                        for (int k = i; k < i + size; k++)
                        {
                            memory[k] = id;
                        }
                        out.println(id);
                        break;
                    }
                    i += (counter == 0 ? 1 : counter);

                }
                if (!found)
                {
                    out.println("NULL");
                }
            }
            else if (operation.equals("erase"))
            {
                int tempID = in.nextInt();
                
                boolean found = false;
                for (int i = 0; i < memory.length; i++)
                {
                    if (memory[i] == tempID)
                    {
                        memory[i] = 0;
                        found = true;
                    }
                    else if (memory[i] != tempID && found)
                    {
                        break;
                    }
                }
                if (tempID <= 0 || !found)
                {
                    out.println("ILLEGAL_ERASE_ARGUMENT");
                }
            }
            else
            {
                int temp[] = new int[m];
                int counter = 0;
                for (int i = 0; i < memory.length; i++)
                {
                    if (memory[i] != 0)
                    {
                        temp[counter++] = memory[i];
                    }
                }
                memory = temp;
            }
            t--;
        }

    }
}

class InputReader1
{
    BufferedReader br;
    StringTokenizer st;

    InputReader1(InputStream inputStream)
    {
        br = new BufferedReader(new InputStreamReader(inputStream), 32768);
        st = null;
    }

    public String next()
    {
        while (st == null || !st.hasMoreTokens())
        {
            try
            {
                st = new StringTokenizer(br.readLine());
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    public int nextInt()
    {
        return Integer.parseInt(next());
    }
}
