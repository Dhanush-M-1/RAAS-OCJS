import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class Main {
	static ArrayList<Integer> answ;
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		String s=in.next();
		answ=new ArrayList<>();
		int ind=0;
		for(int i = 0; i<s.length(); i++)
			if(s.charAt(i)=='#')
				ind=i;
		int op=0,cl=0;
		for(int i = 0; i<s.length(); i++)
		{
			if(cl>op)
			{
				System.out.println(-1);
				return;
			}
			if(s.charAt(i)=='(')
				op++;
			if(s.charAt(i)==')')
				cl++;
			if(s.charAt(i)=='#')
			{
				if(i==ind)
				{		
					int tempOp=0;
					int tempCl=0;
					for(int j=ind+1; j<s.length(); j++)
						if(s.charAt(j)==')')
							tempCl++;
						else
							tempOp++;
					if(op-cl+tempOp-tempCl<=0)
					{
						System.out.println(-1);
						return;
					}
					answ.add(op-cl+tempOp-tempCl);
					cl=op+tempOp-tempCl;
				}
				else
				{
					cl++;
					answ.add(1);
				}
			}
		}
		for(int i = 0; i<answ.size(); i++)
			System.out.println(answ.get(i));
		
	}
}
