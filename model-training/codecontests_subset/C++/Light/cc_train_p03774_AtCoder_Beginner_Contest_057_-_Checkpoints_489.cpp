#include<iostream>
#include<cstdio>
#include<cmath>
using namespace std;
int main()
{
	int m,n,i,k,j,ans;
	cin>>n>>m;
	long long a[n][2],b[m+1][2];
	for(i=0;i<n;i++)cin>>a[i][0]>>a[i][1];
	for(i=1;i<=m;i++)cin>>b[i][0]>>b[i][1];
	for(i=0;i<n;i++)
	{
		ans=1;k=abs(a[i][0]-b[1][0])+abs(a[i][1]-b[1][1]);
		for(j=2;j<=m;j++)
		{
			if(k>abs(a[i][0]-b[j][0])+abs(a[i][1]-b[j][1]))
			{
				ans=j;
				k=abs(a[i][0]-b[j][0])+abs(a[i][1]-b[j][1]);
			}
		}
		cout<<ans<<endl;
	}
	return 0;
} 