#include<cstdio>
int main()
{
	int a, b;
	scanf("%d%d", &a, &b);
	a & b & 1 ? puts("Odd") : puts("Even");
}