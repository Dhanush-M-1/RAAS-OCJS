#include<cstdio>
int main()
{
	int A,B,C;
	while(scanf("%d %d %d",&A,&B,&C)!=EOF){
		if(A+B==C||C+B==A||A+C==B)	printf("Yes\n");
		else		printf("No\n");
	}
	return 0;
}