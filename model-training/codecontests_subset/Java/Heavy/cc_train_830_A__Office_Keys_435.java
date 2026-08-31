import java.util.*;
import java.io.*;

public class Main
{
	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

	public static void main (String[] args)
	{
		FastReader reader = new FastReader();
		int totalPeople = reader.nextInt();
		int totalKeys = reader.nextInt();
		long offfice = reader.nextInt();

		long[] people = new long[totalPeople];
		long[] keys = new long[totalKeys];

		for (int i=0; i<totalPeople; i++)
			people[i] = reader.nextInt();

		for (int i=0; i<totalKeys; i++)
			keys[i] = reader.nextInt();

		Arrays.sort (people);
		Arrays.sort (keys);

		long answer = Long.MAX_VALUE;;

		for (int i=0; i+totalPeople-1<totalKeys; i++)
		{
			long temp1=0;

			for (int j=0; j<totalPeople; j++)
			{
				long temp2=0;
				temp2 += Math.abs (keys[i+j] - people[j]);
				temp2 += Math.abs (keys[i+j] - offfice);

				temp1 = Math.max (temp1, temp2);
			}

			answer = Math.min (answer, temp1);
		}

		System.out.println (answer);
	}
}
