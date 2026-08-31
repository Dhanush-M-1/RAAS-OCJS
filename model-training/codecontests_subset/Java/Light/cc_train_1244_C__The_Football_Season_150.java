import java.io.*;
public class cf_1244c {

	public static void main(String[] args)  throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().trim().split(" ");
		long n = Long.parseLong(s[0]) , p = Long.parseLong(s[1]);
		long w = Long.parseLong(s[2]) , d = Long.parseLong(s[3]);
		long y=0,z=0,x=0;
		//x+y+z= n 
		//wx + dy = p
		for(y=0;y<=w-1;y++)
		{
			if ((p-d*y)%w==0 && p>=d*y && (p-d*y)/w +y<=n)
			{
				x = (p-d*y)/w;
				System.out.println(x+" "+y+" "+(n-x-y));
				return;
			}
		}
		System.out.println(-1);
	}
}

