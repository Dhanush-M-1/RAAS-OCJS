import java.lang.*;
import java.io.*;
import java.util.*;


public class code
{
    public static void main(String args[])
    {
     	Scanner scn = new Scanner(System.in);
    	MutableInt a = new MutableInt(scn.nextInt());
    	MutableInt b = new MutableInt(scn.nextInt());

    	int a_2 = findNumber(a, 2); 	
    	int a_3 = findNumber(a, 3);
    	int a_5 = findNumber(a, 5);

    	int b_2 = findNumber(b, 2);
    	int b_3 = findNumber(b, 3);
    	int b_5 = findNumber(b, 5);

    	if(b.data !=a.data)
    	{
    		System.out.println(-1);
    		return;
    	}
    	int result = 0;
    	result = Math.abs(a_5 - b_5) + Math.abs(a_3 - b_3) + Math.abs(a_2 - b_2);


     	System.out.println(result);
    }	

    public static int findNumber(MutableInt x, int p)
    {
    	int count = 0;
    	while(x.data%p==0)
    	{
    		count++;
    		x.data = x.data/p;
    	}
    	return count;
    }
}


class MutableInt
{
	int data;
	public MutableInt(int data)
	{
		this.data = data;
	}
}
