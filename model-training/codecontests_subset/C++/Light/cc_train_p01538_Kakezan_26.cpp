#include<cstdio>
#include<algorithm>

using namespace std;

int dfs(int n){
	if(n<10) return 0;
	int res=0,a,ten=1;
	for(a=n%10,n/=10;n>0;ten*=10,a+=n%10*ten,n/=10) res=max(res,a*n);
	return dfs(res)+1;
}

int main(){
	int q; scanf("%d",&q);
	while(q--){ int n; scanf("%d",&n); printf("%d\n",dfs(n)); }
	return 0;
}