#include<cstdio>
int n;
char a[10];
void dfs(int x,int max){
	if(x==n){
		puts(a);
		return;
	}
	for(int i=0;i<=max;++i)
		a[x]=i+'a',dfs(x+1,max);
	a[x]=max+'a'+1,dfs(x+1,max+1);
	return;
}
int main(){
	scanf("%d",&n);
	dfs(0,-1);
}