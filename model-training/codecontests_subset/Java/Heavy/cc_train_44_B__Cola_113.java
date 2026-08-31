import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.PrintWriter;

public class Main
{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		br.close();
		PrintWriter pw = new PrintWriter(System.out);
		int count = 0;
		    for (int j=0 ; j<=b ; j++)
		    {
		        for (int k=0 ; k<=c ; k++)
		        {  
		            if (n-j-2*k>0 && n-j-2*k>0.5*a)
		            continue;
		            if (n-j-2*k>=0)
		            count++;
		        }
	    	}
		pw.println(count);
		pw.flush();
		pw.close();
	}
}