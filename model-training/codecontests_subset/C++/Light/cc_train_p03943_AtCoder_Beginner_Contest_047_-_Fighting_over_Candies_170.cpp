#include <cstdio>

int a, b, c;

int main()
{
	scanf("%d%d%d", &a, &b, &c);
	if(a+b==c || a+c==b || b+c==a){
		printf("Yes\n");
	}
	else
		printf("No\n");
	return 0;
}