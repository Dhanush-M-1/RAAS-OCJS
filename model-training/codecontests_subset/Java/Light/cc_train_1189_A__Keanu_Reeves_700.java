import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s = new Scanner(System.in);
		int N=0;
		if(s.hasNextInt()){
			N = s.nextInt();
		}
		String str="";
		if(s.hasNext()){
			str = s.next();
		}
		if(N%2==1){
			System.out.println(1);
			System.out.println(str);
			return;
		}
		int count=0;
		for(int i=0;i<N;i++){
			if(str.substring(i,i+1).equals("0"))
				count++;
		}
		if(count==N/2){
			System.out.println(2);
			System.out.println(str.substring(0,N-1)+" "+str.substring(N-1,N));
			return;
		}else{
			System.out.println(1);
			System.out.println(str);
			return;
		}
	}
}