




			import java.io.*;
			public class lastA
			{
				public static void main(String args[])
				throws IOException
				{
					BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
					PrintWriter pw=new PrintWriter(System.out);
					String in[]=br.readLine().split(" ");
					int a=Integer.parseInt(in[0]);
					int b=Integer.parseInt(in[1]);
					int candles=a;
					int sum=a;
					int bout=a;
					while(bout>=b)
					{
						int newcandles=bout/b;
						sum+=newcandles;
						bout=bout%b;
						bout+=newcandles;
					}
					
					System.out.println(sum);
					
				}
			}