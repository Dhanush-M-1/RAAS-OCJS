#include<stdio.h>
int main()
{
    int a,b,c;
    scanf("%d %d",&a,&b);
    c=a*b;
    if(c%2) printf("Odd");
    else printf("Even");
}
