#include<bits/stdc++.h>
using namespace std;
string s="aaaaaaaaaa";
int n;
void dfs(int i,int j)
{
	if(i>=n)
	{
		for(int k=0;k<n;k++)putchar(s[k]);
		putchar(10);
		return;
	}
	s[i]='a'-1;
	for(int k=0;k<=j;k++)
	{
		++s[i];
		dfs(i+1,max(k,j-1)+1);
		
	}
}
int main()
{
	scanf("%d",&n);
	dfs(0,0);
	return 0;
}
