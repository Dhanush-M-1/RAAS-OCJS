#include<bits/stdc++.h>
using namespace std;
int n,m;
struct hhh
{
	long long l,k;
}x[1000],y[1000];
int main()
{
	cin>>n>>m;
	for(int i=1;i<=n;i++)
		cin>>x[i].l>>x[i].k;
	for(int i=1;i<=m;i++)
		cin>>y[i].l>>y[i].k;
	long long legm,minn=1<<30;	
	for(int i=1;i<=n;i++)		
	{
		for(int j=1;j<=m;j++)
		{
			long long pop=abs(x[i].l-y[j].l)+abs(x[i].k-y[j].k);
			if(pop<minn)
			{
				minn=pop;
				legm=j;
			}
		}
		cout<<legm<<endl;
		minn=1<<30;
	}	
	return 0;
}