#include<iostream>
#include<algorithm>
#include<cstdio>
#include<cstring>
#include<string>
#include<cmath>
#define ll long long
using namespace std;
const int INF = 0x3f3f3f3f;
ll t,ans,k,n,m;
ll a[505];
ll b[505];
ll c[1005];
int main()
{
	cin>>t;
	while(t--)
	{
		bool f=true;
		cin>>k>>n>>m;
		for(int i=1;i<=n;i++)
			cin>>a[i];

		for(int i=1;i<=m;i++)
			cin>>b[i];
	
		int x=1,y=1;
		for(int i=1;i<=n+m;i++)
		{
			if(k>=a[x]&&x<=n)
			{
				if(a[x]==0)		k++;
				c[i]=a[x];
				x++;
				continue;
			}
			if(k>=b[y]&&y<=m)
			{
				if(b[y]==0)		k++;
				c[i]=b[y];
				y++;
				continue;
			}
			f=false;
			break;

		}
		if(f==true)
		{
			for(int i=1;i<=n+m;i++)
			{
				cout<<c[i]<<' ';
			}
			cout<<endl;
		}
		else
		{
			cout<<-1<<endl;
		} 
	}
	return 0;
}
