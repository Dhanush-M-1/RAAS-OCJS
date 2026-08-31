#include<bits/stdc++.h>
using namespace std;
int n;
char s[20];
void dfs(int x,int lim){
	if(x==n){printf("%s\n",s);return;}
	for(int i=0;i<=lim;i++)s[x]=i+'a',dfs(x+1,max(lim,i+1));
}
int main(){
	scanf("%d",&n),s[n]='\0';
	dfs(0,0);
	return 0;
}