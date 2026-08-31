#include<bits/stdc++.h>

#define rep(i,x,y) for (int i=x;i<=y;i++)

int a[100],b[100],c[100],d[100];

int dis(int i,int j)
{	
	return abs(a[i]-c[j])+abs(b[i]-d[j]);
}
int main()
{
	int n,m;
	scanf("%d%d",&n,&m);
	rep(i,1,n) scanf("%d%d",&a[i],&b[i]);
	rep(i,1,m) scanf("%d%d",&c[i],&d[i]);
	rep(i,1,n)
	{
		int ans=0;
		rep(j,1,m)
			if (ans==0 || dis(i,j)<dis(i,ans)) ans=j;
		printf("%d\n",ans);
	}
}