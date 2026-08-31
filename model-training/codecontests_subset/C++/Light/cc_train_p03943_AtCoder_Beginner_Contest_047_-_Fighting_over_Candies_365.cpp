#include <cstdio>
int main()
{
	int a,b,c;
	scanf("%d %d %d", &a, &b, &c);
if(a+b==c || b+c==a || a+c==b){
	if((a+b+c)%2==0){
		printf("Yes");
	}
}
else{
		printf("No");
	}
	
}