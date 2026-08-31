#include<bits/stdc++.h>
using namespace std;
int main()
{
    int n,m,i,j,a[100],b[100],c[100],d[100],mini,in;
    scanf("%d %d",&n,&m);
    for(i=0;i<n;i++)
    scanf("%d %d",&a[i],&b[i]);
    for(i=0;i<m;i++)
    scanf("%d %d",&c[i],&d[i]);
    for(i=0;i<n;i++)
    {
        in=0,mini=2e9;;
        for(j=0;j<m;j++)
        {
            if((abs(a[i]-c[j])+abs(b[i]-d[j]))<mini)
            mini=(abs(a[i]-c[j])+abs(b[i]-d[j])),in=j;
        }
        printf("%d\n",in+1);

    }
}
