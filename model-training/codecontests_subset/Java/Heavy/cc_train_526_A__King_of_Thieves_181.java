import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main
{

    private static Reader reader;

    public static void main(String[] args)
    throws IOException
    {
        reader = new Reader();

		reader.readLine();
		int l = reader.readInt(0);

		reader.readLine();
		String st = reader.readString(0);

		int v,co;
		boolean f = false;
		for (int i=1;i<l;++i)
		{

			//System.out.println("i " + i);

			for (int j=0;;++j)
			{
				v = j + 4 * i;

				//System.out.println("v " + v);

				if (v >= l)
					break;

				co = 0;
				if (st.charAt(j) == '*')
					for (int k=j;k <= v;k += i)
					{
						if (st.charAt(k) == '*')
							++co;
						else
							break;
					}

				//System.out.println("co " + co);

				if (co == 5)	
				{
					f = true;
					break;
				}
			}

			if (f)
				break;
		}

		if (f)
			System.out.println("yes");
		else
			System.out.println("no");


		reader.close();
    }
}

class Pair implements Comparable<Pair>
{
    int f,s;

    public Pair(int f, int s)
    {
        this.f = f;
        this.s = s;
    }

    @Override
    public int compareTo(Pair p1)
    {
        // TODO: Implement this method
        if (f != p1.f)
            return p1.s - s;
        return p1.f - f;

    }
}

class Reader
{
    private BufferedReader reader;
    private String line[];

    public Reader()
    {
        reader = new BufferedReader(
            new InputStreamReader(System.in));
    }

    public void readLine()
    throws IOException
    {
        line = reader.readLine().split(" ");
    }

    public int readInt(int pos)
    throws IOException
    {
        return Integer.parseInt(line[pos]);
    }

    public double readDouble(int pos)
    throws IOException
    {
        return Double.parseDouble(line[pos]);
    }

    public long readLong(int pos)
    throws IOException
    {
        return Long.parseLong(line[pos]);
    }

    public String readString(int pos)
    throws IOException
    {
        return line[pos];
    }

    public void close()
    throws IOException
    {
        reader.close();
    }
}