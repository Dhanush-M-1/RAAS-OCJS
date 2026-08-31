import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.concurrent.RecursiveAction;
import java.io.File;
import java.lang.*;
import java.math.BigInteger;

import javax.naming.ldap.HasControls;
import org.omg.CORBA.FREE_MEM;
public class Main {
	static int[][] p;
	static int[] a;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int[] w=new int[n];
		int[] b=new int[m];
		for(int i = 0; i<n; i++)
			w[i]=sc.nextInt();
		Stack<Integer> st=new Stack<>();
		Stack<Integer> tem=new Stack<>();
		long answ=0;
		for(int i = 0; i<m; i++)
		{
			int tm=sc.nextInt();
			while(!(st.isEmpty() || st.peek()==tm))
			{
				int x=st.peek();
				answ+=w[x-1];
				st.pop();
				tem.push(x);
			}
			if(!st.isEmpty())
				st.pop();
			while(!tem.isEmpty())
				st.push(tem.pop());
			st.push(tm);
		}
		System.out.println(answ);
	} 
}
