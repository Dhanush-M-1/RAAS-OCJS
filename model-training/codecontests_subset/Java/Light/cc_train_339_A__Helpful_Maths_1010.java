import java.util.*;


public class caps {
	public static void main(String[] args)  
	{
	Scanner in= new Scanner( System.in);
	String a= in.next();
	String[] arr=a.split("[+]");
	Arrays.sort(arr);
	String res="";
	for(int i = 0;i<arr.length;i++)
	{
		res += arr[i];
		if(i+1<arr.length)
		{
			res +="+";
		}
	}
	System.out.println(res);
	
   }
}