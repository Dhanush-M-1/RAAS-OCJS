import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class MultiplicationTable_H {
  public static void main(String[] args)throws Exception {
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	int k =Integer.parseInt(br.readLine());
	for(int i=1;i<k;i++)
		for(int j=1;j<k;j++)
			{
			out.print(Integer.toString(i*j, k)+" ");
			if(j==k-1)
	    	 out.println();
			}
	     
	out.flush();
	out.close();
}
}
