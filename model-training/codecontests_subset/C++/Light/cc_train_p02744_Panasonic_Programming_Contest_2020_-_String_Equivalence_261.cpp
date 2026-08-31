#include<cstdio>
#include<algorithm>
using namespace std;
char seq[15];
int n;
void dfs(int st,int p)
{
	if(st==n+1)
	{
		printf("%s\n",seq+1);
		return;
	}
	for(int i=1;i<=p;i++)
	{
		seq[st]='a'+i-1;
		dfs(st+1,p);
	}
	seq[st]='a'+p;
	dfs(st+1,p+1);
}
int main()
{
	scanf("%d",&n);
	dfs(1,0);
	return 0;
}