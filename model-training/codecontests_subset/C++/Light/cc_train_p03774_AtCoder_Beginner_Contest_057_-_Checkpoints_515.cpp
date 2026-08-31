#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<cmath>
using namespace std;

int a[100],b[100],c[100],d[100];

int n,m;

int main()
{
	cin>>n>>m;
	for(int i=1;i<=n;i++) cin>>a[i]>>b[i];
	for(int i=1;i<=m;i++) cin>>c[i]>>d[i];
	for(int i=1;i<=n;i++)
	{
		int mx=1e9;
		int t;
		for(int j=1;j<=m;j++)
		{
			int D=abs(c[j]-a[i])+abs(d[j]-b[i]);
			if(D<mx) t=j,mx=D;
		}
		cout<<t<<endl;
	}
	return 0;
}