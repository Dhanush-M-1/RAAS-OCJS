import java.io.*;
import java.util.*;

public class A5{
	public static void main(String args[])throws IOException{
		Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter pw=new PrintWriter(System.out);
		long count=0;
		int part=0;
		while(sc.hasNext()){
			String a=sc.nextLine();
			if(a.charAt(0)=='+'){
				part++;
			}
			else if(a.charAt(0)=='-'){
				part--;
			}
			else{
				int p=a.indexOf(':');
				p=a.substring(p+1).trim().length();
				count+=(p*part);
			}
		}
		pw.println(count);
		pw.close();
	}
}