import java.util.*;
import java.io.*;

public class Compilation {

	public static void main (String[]args)throws Exception{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	int n=Integer.parseInt(br.readLine());
	StringTokenizer a1=new StringTokenizer(br.readLine());
	StringTokenizer a2=new StringTokenizer(br.readLine());
	StringTokenizer a3=new StringTokenizer(br.readLine());
	long A1=Integer.parseInt(a1.nextToken())+Integer.parseInt(a1.nextToken());
	long A2=Integer.parseInt(a2.nextToken());
	long A3=0;
	while(a3.hasMoreTokens()){
		A1+=Integer.parseInt(a1.nextToken());
		A2+=Integer.parseInt(a2.nextToken());
		A3+=Integer.parseInt(a3.nextToken());
	}
	System.out.println(A1-A2);
	System.out.println(A2-A3);

}
}
