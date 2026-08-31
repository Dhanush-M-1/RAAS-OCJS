import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Compilation_Errors {
	public static void main(String[] args)throws Throwable {
		BufferedReader bf = new BufferedReader(new InputStreamReader (System.in));
		PrintWriter pw = new PrintWriter(System.out, true);
		bf.readLine();
		String[] first=bf.readLine().split(" ");
		int firstsum=0;
		String[] second=bf.readLine().split(" ");
		int secondsum=0;
		String[] third=bf.readLine().split(" ");
		int thirdsum=0;
		for(int i=0;i!=first.length;i++)
		{
			firstsum+=Integer.parseInt(first[i]);
		}
		for(int i=0;i!=second.length;i++)
		{
			secondsum+=Integer.parseInt(second[i]);
		}
		for(int i=0;i!=third.length;i++)
		{
			thirdsum+=Integer.parseInt(third[i]);
		}
		pw.println(firstsum-secondsum);
		pw.println(secondsum-thirdsum);
	}
}
