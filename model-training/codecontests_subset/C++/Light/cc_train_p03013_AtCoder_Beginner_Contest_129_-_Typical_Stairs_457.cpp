#include<cstdio>
bool a[100005];
long long b[100005];
long long MOD = 1e9+7;
int main(void)
{
    long long n,m,t;
    scanf("%lld %lld" ,&n,&m);
    for(int i=1;i<=m;i++)
    {
        scanf("%lld" ,&t);
        a[t]=true;
    }
    b[0]=1;
    if(!a[1]) b[1]=1;
    for(int i=2;i<=n;i++)
    {
        if(!a[i])
            b[i]=(b[i-1]+b[i-2])%MOD;
    }
    printf("%lld" ,b[n]);
    return 0;
}
