import java.io.*;
import java.util.*;
 
 
 public class A5 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String s =new String();
		int m=0; 
		int tra=0;
		while((s=br.readLine())!=null)
		{
			if(s.charAt(0)=='+')
			{m++;continue;}
			else
				if(s.charAt(0)=='-')
				{m--;continue;}
				else
				{
					if(s.split(":").length==1)
					{}
					else
					tra+=s.split(":")[1].length()*m;
				}
		}
		pw.println(tra);
		
		
		
		pw.close();
	}

}
