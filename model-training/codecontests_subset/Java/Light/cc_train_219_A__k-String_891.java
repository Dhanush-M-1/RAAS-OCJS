import java.util.*;

public class GFG 
{ 
	public static void main(String[] args)
	{
	    Scanner scanner = new Scanner(System.in);
	    int n = scanner.nextInt();
	    String s1 = scanner.nextLine();
	    String s = scanner.nextLine();
	    int[] arr = new int[26];
	    boolean flag = true;
	    StringBuilder str = new StringBuilder();
	    for(int i=0;i<s.length();i++)
	    {
	        arr[s.charAt(i)-97]++;
	    }

	    for(int i=0;i<26;i++)
	    {
	        if(arr[i]%n!=0)
	        {
	            flag = false;
	            break;
	        }
	    }
	    if(flag)
	    {
	        for(int i=0;i<26;i++)
	        {
	            arr[i] = arr[i]/n;
	        }
	        for(int i=0;i<26;i++)
	        {
	            for(int j=0;j<arr[i];j++)
	            str.append((char) (i+97));
	        }
	        for(int i=0;i<n;i++)
	        {
	            System.out.print(str);
	        }
	    }
	    else
	    System.out.println(-1);
	}
} 