#include <bits/stdc++.h>
using namespace std;
int n;
void dfs(string s,char x)
{
	if(s.size()==n)
	{
		cout<<s<<endl;
		return;
	}
	for(char i='a';i<x;i++)
		dfs(s+i,x);
	dfs(s+x,x+1);
}
int main()
{
	cin>>n;
	dfs("",'a');

	return 0;
}