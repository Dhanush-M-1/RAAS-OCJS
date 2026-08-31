#include<bits/stdc++.h>
using namespace std;
int n,a[13];
void dfs(int x,int maxx)
{
	if(x==n+1)
	{
		for(int i=1;i<=n;i++)
			cout<<(char)(a[i]+'a'-1);
		cout<<endl;
		return;
	}
	for(int i=1;i<=maxx+1;i++)
	{
		a[x]=i;
		dfs(x+1,max(maxx,i));
	}
}
int main()
{
	cin>>n;
	dfs(1,0);
	return 0;
}
