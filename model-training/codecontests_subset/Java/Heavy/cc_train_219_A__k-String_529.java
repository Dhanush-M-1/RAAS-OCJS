import java.util.*;
public class kString {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();char ch=' ';
		String s=sc.next();
		int count=0;boolean flag =true;
		String s1="";
		char temp[]=s.toCharArray();
		Arrays.sort(temp);
		s=new String(temp);
		for(int i=0;i<s.length();i++)
		{
			if(i%k==0)
			{
				ch=s.charAt(i);
			}
			if(s.charAt(i)==ch)
				count++;
			
		}
		if(s.length()==count&&count%k==0)
		{
			for(int i=0;i<k;i++){
		        for(int l=0;l<s.length();l+=k){
		            System.out.print(s.charAt(l));
		            
		        }
			}
		}
		else
			System.out.print("-1");
	}
}
