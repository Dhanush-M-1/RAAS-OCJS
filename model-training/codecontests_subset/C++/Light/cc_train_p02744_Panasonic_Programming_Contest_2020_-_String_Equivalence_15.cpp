#include<stdio.h>
char st[15];
void out(int n,int now,int max){
	if(now>=n){
		printf("%s",st);
		puts("");
		return ;
	}
	for(int i=97;i<=max+1;i++){
		st[now]=i;
		out(n,now+1,i>max?i:max);
	}
}
int main(){
	int n;
	scanf("%d",&n);
	out(n,0,96);
	return 0;
	
}