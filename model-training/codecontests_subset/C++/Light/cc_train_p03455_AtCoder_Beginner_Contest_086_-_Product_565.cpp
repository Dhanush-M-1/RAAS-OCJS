#include<stdio.h>

int main(void){
	int x, y;
	scanf("%d%d", &x, &y);
	int z = x * y;
	if(z % 2 == 1)puts("Odd");
	else puts("Even");
}