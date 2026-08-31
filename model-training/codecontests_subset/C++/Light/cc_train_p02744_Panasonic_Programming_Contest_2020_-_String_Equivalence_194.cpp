#include<cstdio>
#include<algorithm>
using namespace std;
typedef long long ll;
const int MAXN = 10 + 5;

int n;
char s[MAXN];

void dfs(int l,char mx)
{
	if(l>n){ printf("%s\n",s+1); return;}
	
	for(s[l]='a'; s[l]<=mx; ++s[l])
		dfs(l+1,mx);
	if(mx<'z') dfs(l+1,mx+1);
}

int main(void)
{
	scanf("%d",&n);
	
	dfs(1,'a'-1);
	return 0;
}