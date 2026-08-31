#include<bits/stdc++.h>
using namespace std;
string str="aaaaaaaaaa";
int n;
void dfs(int i,int j)
{
	if(i>=n)
	{
		for(int k=0;k<n;k++)
			putchar(str[k]);
		putchar(10);
		return;
	}
	str[i]='a'-1;
	for(int k=0;k<=j;k++)
	{
		str[i]++;
		dfs(i+1,max(k,j-1)+1);	
	}
}
int main()
{
	scanf("%d",&n);
	dfs(0,0);
	return 0;
}