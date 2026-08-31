#include <cstdio>
int main()
{
 int a,b;
 scanf("%d%d",&a,&b);
 if(a>=10||b>=10)puts("-1");
 else printf("%d\n",a*b);
 return 0;
}