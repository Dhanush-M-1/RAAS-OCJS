#include<cstdio>

int main()
{
   int a,b;
   scanf("%d%d",&a,&b);
    printf("%s\n",a*b%2==0?"Even":"Odd");
   return 0;
}