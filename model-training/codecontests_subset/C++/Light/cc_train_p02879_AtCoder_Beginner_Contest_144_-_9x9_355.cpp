#include<cstdio>
int main()
{
    int m,n;
    scanf("%d%d",&m,&n);
    if(0<m&&m<10&&0<n&&n<10)printf("%d",m*n);
    else printf("-1");
}