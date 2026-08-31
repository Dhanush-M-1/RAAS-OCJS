#include<bits/stdc++.h>
using namespace std;
//https://blog.csdn.net/Phoenix_ZengHao/article/details/113833938

typedef long long LL;
const int maxn=2e5+50;
LL n,m,T;
LL a[maxn],sum[maxn],maxx[maxn],ans[maxn];

int main()
{
	cin>>T;
	while(T--)
	{
		cin>>n>>m;
		memset(maxx,0,sizeof(maxx));
		for(int i=1;i<=n;i++)
		{
			cin>>a[i];
			sum[i]=sum[i-1]+a[i];
			maxx[i]=max(maxx[i-1],sum[i]);	
		}
		for(int i=1;i<=m;i++)
		{
			LL x;
			cin>>x;
			if(x<=maxx[n])
			{
				LL t=lower_bound(maxx+1,maxx+1+n,x)-maxx;
				cout<<t-1<<' ';
			}
			else
			{
				if(sum[n]<=0)
				{
					cout<<-1<<' ';
				}
				else
				{
					LL d=x-maxx[n];
					LL tot=ceil(d*1.0/sum[n]);
					x=x-tot*sum[n];
					LL t=lower_bound(maxx+1,maxx+1+n,x)-maxx;
					t=t+tot*n-1;
					cout<<t<<' ';
				}
			}
		}
		cout<<'\n';
	}
	return 0;
}

