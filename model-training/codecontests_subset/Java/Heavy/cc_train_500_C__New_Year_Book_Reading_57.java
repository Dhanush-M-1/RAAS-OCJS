import java.util.*;
public class ProC {
	static int n,m,ct,ans,x;
	static int[] aa=new int[505];
	static int[] bb=new int[1005];
	static int[] cc=new int[505];
	static int[] mm=new int[505];
	static Stack<Integer> ss=new Stack<Integer>();
	static Stack<Integer> pp=new Stack<Integer>();

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();m=in.nextInt();
		for(int i=1;i<=n;i++)
			aa[i]=in.nextInt();
		for(int i=1;i<=m;i++)
		{
			bb[i]=in.nextInt();
			if(mm[bb[i]]==0)
			{
				cc[++ct]=bb[i];
				mm[bb[i]]=1;
			}
		}
		for(int i=ct;i>0;i--)
			ss.add(cc[i]);
		for(int i=1;i<=m;i++)
		{
			x=ss.pop();
			while(x!=bb[i])
			{
				ans+=aa[x];
				pp.add(x);
				x=ss.pop();
			}
			while(!pp.isEmpty())
				ss.add(pp.pop());
			ss.add(bb[i]);
		}
		System.out.println(ans);
	}
}
