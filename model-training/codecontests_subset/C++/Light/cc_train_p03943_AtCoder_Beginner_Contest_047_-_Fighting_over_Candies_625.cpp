#include<stdio.h>

int a,b,c;

int main(void){
	scanf("%d%d%d",&a,&b,&c);
	if(a+b==c||a+c==b||b+c==a)
		puts("Yes");
	else
		puts("No");
	return 0;
}