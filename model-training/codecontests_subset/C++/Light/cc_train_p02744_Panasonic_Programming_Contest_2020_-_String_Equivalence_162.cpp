#include<bits/stdc++.h>
using namespace std;
using ll = long long;

int n;
string ans;

void dfs(int now,int nn)
{
	if(now==n)
	{
		cout<<ans<<endl;
		return ;
	}
	for(int i = 0;i<=nn+1;i++)
	{
		ans[now] = 'a'+i;
		dfs(now+1,max(nn,i));
	}
}

int main()
{
	cin >> n;
	ans = string(n,'a');
	dfs(0,-1);
}