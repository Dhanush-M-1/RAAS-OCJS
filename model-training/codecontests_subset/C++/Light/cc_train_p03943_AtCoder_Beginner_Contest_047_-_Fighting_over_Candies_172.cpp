#include<cstdio>
int main()
{
	int a,b,c,s,max;
	scanf("%d%d%d",&a,&b,&c);
	s=a+b+c;
	max=a>b?a:b;
	max=max>c?max:c;
	if(2*max==s) printf("Yes\n");
	else printf("No\n");
	return 0;
}