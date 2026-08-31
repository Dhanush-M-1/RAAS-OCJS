#include <bits/stdc++.h>
using namespace std;
int n;
void dfs(string s,char mx)
{
	if(s.size()==n)
	{
		cout<<s<<endl;
	}
	else
	{
		for(char c='a';c<=mx;c++)
		{
			if(c==mx)
			dfs(s+c,mx+1);
			else
			dfs(s+c,mx);
		}
	}
}
int main()
{
	cin>>n;
	dfs("",'a'); 
	return 0;
}