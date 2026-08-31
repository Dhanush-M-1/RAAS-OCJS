#include<bits/stdc++.h>
using namespace std;
const int N=11;
int n;
char s[N];
void dfs(int x,int up){
	if(x==n){
		printf("%s\n",s);
		return;
	}
	for(int i=1;i<=up;++i){
		s[x]=i-1+'a';
		dfs(x+1,up);
	}
	s[x]=up+'a';
	dfs(x+1,up+1);
}
int main(){
	scanf("%d",&n);
	dfs(0,0);
	return 0;
}