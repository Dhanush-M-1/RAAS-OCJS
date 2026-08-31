#include<iostream>
#include<cstdio>
using namespace std;
const int N=105;
const int MOD=1000000007;
int n,q;
int c[N];
int b[N];
long long sb[N];
int f[N][N*N];
int main()
{
    scanf("%d",&n);
    for(int i=1;i<=n;i++)
        scanf("%d",&c[i]);
    for(int i=1;i<n;i++)
        scanf("%d",&b[i]);
    for(int i=1;i<n;i++)
        sb[i]=sb[i-1]+b[i];
    for(int i=1;i<n;i++)
        sb[i]+=sb[i-1];
    scanf("%d",&q);
    while(q--)
    {
        int x;
        scanf("%d",&x);
        f[0][0]=1;
        for(int i=1;i<=n;i++)
            for(int j=0;j<=100*(i);j++)
                if(f[i-1][j])
                    for(int k=0;k<=c[i];k++)
                        if(j+k>=i*x+sb[i-1]) f[i][j+k]=(f[i][j+k]+f[i-1][j])%MOD;
        int ans=0;
        for(int j=0;j<=100*n;j++)
            ans=(ans+f[n][j])%MOD;
        printf("%d\n",ans);
    }
    return 0;
}