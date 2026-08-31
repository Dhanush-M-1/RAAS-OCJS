#include<bits/stdc++.h>
using namespace std;
long long n,m,mn,mi,x1[100],y11[100],x2[100],y2[100];
int main()
{
	cin>>n>>m;
	for(int i=1;i<=n;i++) scanf("%lld%lld",&x1[i],&y11[i]);
	for(int i=1;i<=m;i++) scanf("%lld%lld",&x2[i],&y2[i]);
	for(int i=1;i<=n;i++)
	{
		mn=900000010;mi=1;
		for(int j=1;j<=m;j++)
		{
			if(abs(x1[i]-x2[j])+abs(y11[i]-y2[j])<mn)
			  mn=abs(x1[i]-x2[j])+abs(y11[i]-y2[j]),mi=j;
		}
		cout<<mi<<"\n";
	 } 
	return 0;
 } 