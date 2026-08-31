#include<bits/stdc++.h>
#define int long long
using namespace std;
int n;
int a[11];
void dfs(string s,int x,int y)
{
	if(x==n)
	{
		cout<<s<<endl;
		return;
	}
	for(int i=1;i<=y+1;i++)
	dfs(s+(char)(i+'a'-1),x+1,max(i,y));
}
signed main()
{
	string s;
	scanf("%lld",&n);
	dfs(s,0,0);
    return 0;
}