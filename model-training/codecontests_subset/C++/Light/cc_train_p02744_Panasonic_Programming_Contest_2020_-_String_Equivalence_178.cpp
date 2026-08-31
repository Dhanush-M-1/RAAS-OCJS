#include<bits/stdc++.h>
using namespace std;

int n;
int a[22];

void dfs(int dep, int ma) {
	if(dep==n) {
		for(int i=0;i<n;i++) putchar(a[i]+'a');
		puts("");
		return;
	}
	
	for(int i=0;i<ma;i++) {
		a[dep] = i;
		dfs(dep+1, ma);
	}
	a[dep] = ma;
	dfs(dep+1, ma+1);
}

int main() {
	scanf("%d", &n);
	
	dfs(0, 0);
	
	return 0;
}