#include<iostream>
#include<cstdio>
using namespace std;
int a[110];
int main()
{
    int n,c=0;
    scanf("%d",&n);
    for(int i=0;i<n;i++)
    scanf("%d",&a[i]);
    for(int i=0;i<n;i++)
    {int g=i;
    for(int j=i;j<n;j++)
    if(a[j]<a[g])
    g=j;
    swap(a[i],a[g]);
    if(i!=g)c++;
    }
    for(int i=0;i<n;i++)
    {
        if(i>0)printf(" ");;
        printf("%d",a[i]);
    }
    printf("\n%d\n",c);
    return 0;
}