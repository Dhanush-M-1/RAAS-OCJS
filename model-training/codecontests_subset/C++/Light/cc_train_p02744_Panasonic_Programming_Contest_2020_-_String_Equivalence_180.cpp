#include <bits/stdc++.h>
using namespace std;
typedef long long LL;
int n;
char s[12];
void dfs(int now,int mx){
	if(now==n+1){
		printf("%s\n", s+1); return;
	}
	for(int i=0;i<=mx+1;i++){
		s[now]=('a'+i);
		dfs(now+1,max(i,mx));
	}
}
int main() {
	cin >> n;
	dfs(1,-1);
}