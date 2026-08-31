
import java.util.*;

public class metan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner in=new Scanner(System.in);
int n=in.nextInt();long s=in.nextLong();int a[]=new int[n];long t=0;int b[]=new int[n/2+1];
for(int i=0;i<n;i++)
	a[i]=in.nextInt();
Arrays.sort(a);
if(a[n/2]<=s)
{
	for(int i=n/2;i<n;i++)
		if(a[i]<s)
			t+=s-a[i];
		else
			break;
	System.out.println(t);
			
}
else
{
	for(int i=n/2;i>=0;i--)
		if(a[i]>s)
			t+=a[i]-s;
		else
			break;
	System.out.println(t);
}

	}

}
