#include<cstdio>
int main(){
	int a,b,c;
	scanf("%d%d%d",&a,&b,&c);
	int sum = a + b + c;
	if(sum==2*a||sum==2*b||sum==2*c) printf("Yes\n");
	else printf("No\n");
}
