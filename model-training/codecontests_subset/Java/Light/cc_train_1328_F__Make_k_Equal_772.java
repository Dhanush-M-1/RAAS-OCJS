import java.util.*;
public class equalizingarraybydivision {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
int k=sc.nextInt();
ArrayList<Integer> ar[]=new ArrayList[200001];
for(int i=0;i<=200000;i++)
{
	ar[i]=new ArrayList<>();

}
for(int i=0;i<n;i++)
{
int x=sc.nextInt();
int ct=0;
while(x!=0)
{
	ar[x].add(ct++);
	x=x/2;
	
}

}
int min=(int)1e9;
for(int i=0;i<=200000;i++)
{
	Collections.sort(ar[i]);
	if(ar[i].size()<k)
		continue;
	int s=0;
	for(int j=0;j<k;j++)
	{
		s+=ar[i].get(j);
	}
		min=Math.min(min,s);
}
System.out.println(min);
	}

}
