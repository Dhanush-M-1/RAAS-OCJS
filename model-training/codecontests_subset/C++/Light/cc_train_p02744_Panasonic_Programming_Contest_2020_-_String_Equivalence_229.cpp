#include <cstdio>
#include <cstring>
char s[12];int a[27];int n;
void sel(int u,int cur)
{
	if(u==n+1)
	{
		printf("%s\n",s+1);return;
	}
	for(int i=1;i<=cur;++i)
	{
		s[u]=i+'a'-1;
		sel(u+1,cur);
	}
	s[u]=++cur+'a'-1;sel(u+1,cur);
}
int main()
{
	scanf("%d",&n);sel(1,0);return 0;
}