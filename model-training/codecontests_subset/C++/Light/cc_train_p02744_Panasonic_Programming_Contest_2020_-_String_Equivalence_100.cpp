#include <cstdio>
using namespace std;
int n,i,a[100];
void dfs(int dep,int now)
{
	if (dep==n+1){
		for (i=1;i<=n;i++) printf("%c",a[i]+'a'-1);
		puts("");return;
	}
	for (int ii=1;ii<now;ii++){
		a[dep]=ii;dfs(dep+1,now);
	}a[dep]=now;dfs(dep+1,now+1);
}
int main()
{
	scanf("%d",&n);
	dfs(1,1);
	return 0;
}