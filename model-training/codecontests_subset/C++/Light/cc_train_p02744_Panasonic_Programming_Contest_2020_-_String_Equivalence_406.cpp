#include<stdio.h>
#include<string>
using namespace std;
int n;
void dfs(string s,char high)
{
	if(s.size()==n)
		printf("%s\n",s.c_str());
	else
		for(char c='a';c<=high;++c)
			dfs(s+c,high>c?high:high+1);
}
int main()
{
	scanf("%d",&n);
	dfs("",'a');
	return 0;
}