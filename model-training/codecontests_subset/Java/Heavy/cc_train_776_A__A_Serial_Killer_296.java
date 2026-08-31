//package graphs;
import java.util.*;

public class codeforces {
	//public static HashMap<Integer,List<Integer>> map;
	public static int flag=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		String str1=s.next();
		String str2=s.next();
		int n=s.nextInt();
		System.out.println(str1+" "+str2);
		for(int i=0;i<n;i++)
		{
			String st1=s.next();
			String st2=s.next();
			
			if(st1.equals(str1))
			{
				str1=st2;
			}
			else if(st1.equals(str2))
				str2=st2;
			System.out.println(str1+" "+str2);
			
		}
		
		
		
	}
	
	
	
	public static void ps(int ns[],int a[])
	{
		Stack<Integer> s=new Stack<>();
		ns[0]=-1;
		s.push(0);
		for(int i=1;i<a.length-1;i++)
		{
			int eql=0;
			if(a[i]==a[i-1])
				eql=1;
			
			if(eql==1)
			{
				
				while(s.size()>0&&a[i]<=a[s.peek()])
				{
					s.pop();
				}
				if(s.size()==0)
					ns[i]=-1;
				else
					ns[i]=s.peek();
				
				s.push(i);
			}
			else
			{
				while(s.size()>0&&a[i]<a[s.peek()])
				{
					s.pop();
				}
				if(s.size()==0)
					ns[i]=-1;
				else
					ns[i]=s.peek();
				
				s.push(i);
			}
			
		}
		
	}
	
	public static void ns(int ns[],int a[])
	{
		Stack<Integer> s=new Stack<>();
		ns[a.length-1]=-1;
		s.push(a.length-1);
		for(int i=a.length-2;i>=0;i--)
		{
			int eql=0;
			if(a[i]==a[i+1])
				eql=1;
			
			if(eql==1)
			{
				
				while(s.size()>0&&a[i]<=a[s.peek()])
				{
					s.pop();
				}
				if(s.size()==0)
					ns[i]=-1;
				else
					ns[i]=s.peek();
				
				s.push(i);
			}
			else
			{
				while(s.size()>0&&a[i]<a[s.peek()])
				{
					s.pop();
				}
				if(s.size()==0)
					ns[i]=-1;
				else
					ns[i]=s.peek();
				
				s.push(i);
			}
			
		}
		
	}
		
	
	
//	public static void update(per st[],long a[],int l,int r,int ind,long val,int i)
//	{
//		
//		if(l==r)
//		   {a[i]=val;st[ind].f=val; return ;}
//		
//		int mid=(l+r)/2;
//		if(i<=mid)
//			update(st,a,l,mid,2*ind+1,val,i); //1 l 
//		else
//			update(st,a,mid+1,r,2*ind+2,val,i);
//		
//		//st[ind]=(st[2*ind+1]+st[2*ind+2]);
//		if(st[2*ind+1].f<st[2*ind+2].f)
//		{
//			st[ind]=new per(st[2*ind+1].f,st[2*ind+1].s);
//		
//		}
//		else
//		{
//			st[ind]=new per(st[2*ind+2].f,st[2*ind+2].s);
//		}
//		
//	}
//
//	public static per build(per sg[],long a[],int l,int r,int ind)
//	{
//		if(l==r){
//			//return sg[ind]=a[l];
//			per temp=new per(a[l],l);
//			sg[ind]=temp;
//			return temp;
//		}
//		
//		int mid=(l+r)>>1;
//		//sg[ind].f=Math.min(build(sg, a,l,mid,2*ind+1),build(sg,a,mid+1,r,2*ind+2));
//		per one=build(sg, a,l,mid,2*ind+1);
//		per two=build(sg,a,mid+1,r,2*ind+2);
//		if(one.f<two.f)
//		{
//			sg[ind]=new per(one.f,one.s);
//		}
//		else
//			sg[ind]=new per(two.f,two.s);
//			
//		return sg[ind];
//	}
//	
//	public static per query(per sg[],long a[],int l,int r,int ql,int qr,int ind)
//	{
//		//   ql------qr       (find both)      //   ql 1 2 3 4 5 6 qr   (out)         //   ql --------qr  (inside)
//		// s-------------e          //                                 s--e                     s--e
//		if(l>qr||r<ql)
//			return new per(Long.MAX_VALUE,-1);
//		
//		if(ql<=l&&qr>=r)
//			return sg[ind];
//		
//		int mid=(l+r)>>1;
//		int c1=2*ind+1;
//		int c2=2*ind+2;
//		per one=query(sg,a,l,mid,ql,qr,c1);
//		per two=query(sg,a,mid+1,r,ql,qr,c2);
//		//return Math.max(query(sg,a,l,mid,ql,qr,c1),query(sg,a,mid+1,r,ql,qr,c2));
//		if(one.f<two.f)
//			return one;
//		return two;
//	}
//	
	
	
	public static int opp(String str,int d)
	{
		int count=0;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='1')
				count++;
		}
		if(count<d)
			return 1;
		else
			return 0;
	}
	
	public static int solve(int a[],int b[],int n,int m)
	{
		if(n==0||m==0)
			return 0;
		
		System.out.println("hi");
		int op1=a[n-1]+solve(a,b,n-1,m);
		int op2=b[m-1]+solve(a,b,n,m-1);
		int op3=a[n-1]+b[m-1]+solve(a,b,n-1,m-1);
		return Math.max(op1,Math.max(op2,op3));
		
	}
	
	public static int lcs(String a,String b)
	{
		int dp[][]=new int[a.length()+1][b.length()+1];
		
		for(int i=1;i<dp.length;i++)
		{
			for(int j=1;j<dp[i].length;j++)
			{
				if(a.charAt(i-1)==b.charAt(j-1))
				{
					dp[i][j]=1+dp[i-1][j-1];
				}
				else
					dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
			}
		}
		
		return dp[dp.length-1][dp[0].length-1];
	}
	
	public static long solve(long base,long pow,long mod)
	{
		if(pow==0)
			return 1L;
		
		long temp=solve(base,pow/2,mod);
		temp=((temp%5)*(temp%5))%5;
		if(pow%2==1)
			temp=((base%5)*(temp%5))%5;
		return temp;
		
	}
	
	public static long gcd(long a,long b)
	{
		if(b==0)
			return a+b;
		return gcd(b,a%b);
	}
	public static int solve(int n,int buff,int score)
	{
		if(n<=0)
		{
			return score;
		}
		
		int op1=solve(n-1,buff,score+1);
		int op2=Integer.MIN_VALUE;
		int op3=Integer.MIN_VALUE;
		if(buff!=0)
		{
			op2=solve(n-1,buff,score+buff);
		}
		if(n>=3)
		{
			op3=solve(n-3,score,2*score);
		}
		
		return Math.max(op1,Math.max(op2, op3));
		
		
	}
	
	

}
class per{
	int f;
	int s;
	per(int f,int s)
	{
		this.f=f;
		this.s=s;
	}
}

 
			 	 		  				 			 	  	   	