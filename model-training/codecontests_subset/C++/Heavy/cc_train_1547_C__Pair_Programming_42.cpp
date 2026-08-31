#include<iostream>
#include<cstdio>
#include<cstring>
#include<cstdlib>
#include<cmath>
#include<algorithm>
#include<queue>
#include<vector>
#include<stack>
#include<map>
#include<set>
#include<bitset>
#include<ctime>
#define ll long long 
using namespace std;
const int maxx=600010;
const double pi=acos(-1.0);
const double eps=1e-15;
int t,n,m,k;
int ans=0,total=0,sum=0,cnt=0,l1=0,l2=0;
int a[maxx],b[maxx],c[maxx];
int main()
{
    scanf("%d",&t);
    while(t--)
    {
        scanf("%d%d%d",&k,&n,&m);
        l1=l2=1;
        for(int i=1;i<=n;i++)scanf("%d",&a[i]);
        for(int i=1;i<=m;i++)scanf("%d",&b[i]);
        ans=0,cnt=0;
        while(l1<=n||l2<=m)
        {
            while(l1<=n)
            {
                if(!a[l1])k++,c[++cnt]=a[l1++];
                else if(a[l1]<=k)c[++cnt]=a[l1++];
                else break ;
            }
            while(l2<=m)
            {
                if(!b[l2])k++,c[++cnt]=b[l2++];
                else if(b[l2]<=k)c[++cnt]=b[l2++];
                else break ;
            }
            if(l1>n&&l2>m)break ;
            else if(l1>n)
            {
                if(b[l2]>k)
                {
                    ans=1;
                    break ;
                }
            }
            else if(l2>m)
            {
                if(a[l1]>k)
                {
                    ans=1;
                    break ;
                }
            }
            else if(a[l1]>k&&b[l2]>k)
            {
                ans=1;
                break ;
            }
        }
        if(ans)printf("-1\n");
        else 
        {
            for(int i=1;i<=cnt;i++)printf("%d ",c[i]);
            printf("\n");
        }
    }
    return 0;
}