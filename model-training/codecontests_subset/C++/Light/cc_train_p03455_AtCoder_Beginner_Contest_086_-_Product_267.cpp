#include<cstdio>
int a,b;
int main(){
	scanf("%d%d",&a,&b);
	if(a%2==1 and b%2==1)
		printf("Odd");
	else
		printf("Even");

	return 0;
}