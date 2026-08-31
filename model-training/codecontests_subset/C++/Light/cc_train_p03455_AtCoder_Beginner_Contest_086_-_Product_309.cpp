#include<cstdio>
int a,b;
int main()
{
    scanf("%d%d",&a,&b);
    if((a*b)&1) printf("Odd\n");
    else printf("Even\n");
}