import java.util.*;


public class caps {
	public static void main(String[] args)  
	{
	Scanner in= new Scanner( System.in);
	String a= in.next();
	int[] array = new int[a.length()/2+1];
	int count=0;
	for(int i = 0; i<a.length();i+=2)
	{
		array[count++] = (int) a.charAt(i)-48;
	}
	Arrays.sort(array);
	if(array.length==1)
	{
	System.out.print(array[0]);
	}
	else
	{
	System.out.print(array[0]);
	for(int i = 1; i<a.length()/2+1;i++)
	{
		System.out.print("+"+array[i]);
	}
	}
   }
}