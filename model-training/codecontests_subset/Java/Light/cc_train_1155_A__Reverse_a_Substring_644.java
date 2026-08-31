import java.util.*;
public class reverse_a_substring 
{
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		char arr[]=in.next().toCharArray();
		int firstindex=0,lastindex=0;
		boolean bool=false;
		for(int i=0;i<n-1;i++)
		{
			if(Character.compare(arr[i],arr[i+1])>0)
			{
				firstindex=i+1;
				lastindex=i+2;
				bool=true;
				break;
			}
		}
		if(bool==false)
		{
			System.out.println("NO");
		}
		else
		{
			System.out.println("YES\n"+firstindex+" "+lastindex);
		}
	}
}