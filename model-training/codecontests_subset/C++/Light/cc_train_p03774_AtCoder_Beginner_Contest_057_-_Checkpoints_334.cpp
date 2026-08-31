#include<bits/stdc++.h>
using namespace std;

struct stu
{
	int a,b;
}s[1000];
struct point
{
	int x,y;
}w[1000];
inline int dis(stu a,point b)
{
	return abs(a.a-b.x)+abs(a.b-b.y);
}
int main()
{
	int n,m;
	cin>>n>>m;
	for(int i=1;i<=n;i++)cin>>s[i].a>>s[i].b;
	for(int i=1;i<=m;i++)cin>>w[i].x>>w[i].y;
	for(int i=1;i<=n;i++)
	{
		int num,maxn=1e9;
		for(int j=1;j<=m;j++)
		{
			if(dis(s[i],w[j])<maxn)
			{
				num=j;
				maxn=dis(s[i],w[j]);
			}
		}
		cout<<num<<endl;
	}
	return 0;
}