import java.util.Scanner;
import java.util.Vector;
import java.util.*;

public class zeptolab {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int temp=0;
		int temp1=0;
		char [] a=new char[n];
		Vector<Integer> b=new Vector<Integer>();
		String s=sc.next();
		a=s.toCharArray();
		for(int i=0;i<n;i++)
			if(a[i]=='*')
				b.add(i+1);
		int [] c=new int[b.size()];
		for(int i=0;i<b.size();i++)
			c[i]=b.get(i);
		for(int i=0;i<c.length;i++)
			for(int j=i+1;j<c.length;j++){
				temp = c[j]-c[i];
				int count=0;
				temp1=temp+c[j];
				while(count != 3 ){
					Arrays.sort(c);
				if(Arrays.binarySearch(c,temp1) >= 0)
				{
					temp1= temp1+temp;
					count++;
				}
				else
					break;
				}
					if(count==3)
					{
						System.out.println("yes");
						System.exit(0);
					}
			}
		System.out.println("no");
		
		
		
			
	}

}
