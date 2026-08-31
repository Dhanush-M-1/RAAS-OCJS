

import java.util.Scanner;

public class C_219A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		
        String iput=sc.nextLine();
        int a[]=new int[26];

        for(int i=0;i<iput.length();i++)
		{
			a[iput.charAt(i)-'a']++;
		}
		
        int flag=0;
        for(int i=0;i<26;i++)
        {
        	if(a[i]!=0&&a[i]%n!=0 )
        	{
        		flag=1;
        		System.out.println(-1);
        		break;
        		/*if(a[i]%n!=0)
        		{
        			flag=1;
        			System.out.println(-1);
        			break;
        		}*/
        	}
        }
    	String result="";

        if(flag==0)
        {
        	for(int i=0;i<26;i++)
        	{
        		if(a[i]!=0)
        		{
        			for(int j=0;j<a[i]/n;j++)
        				result=result+(char)(i+'a');
        		}
        	}
        }
        for(int j=0;j<n;j++)
        System.out.print(result);
		
	}

}
