#include<cstdio>
int a,b;
int main(){
	scanf("%d%d",&a,&b);
	if(a*b&1)puts("Odd");else puts("Even");
}