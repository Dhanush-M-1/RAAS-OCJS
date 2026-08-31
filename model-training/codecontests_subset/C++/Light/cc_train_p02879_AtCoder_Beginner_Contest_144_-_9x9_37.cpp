#include<cstdio>
int n,m;
int main(){
	scanf("%d%d",&n,&m);
	if(n<=9&&n>=1&&m<=9&&m>=1)printf("%d",n*m);
	else printf("-1");
}