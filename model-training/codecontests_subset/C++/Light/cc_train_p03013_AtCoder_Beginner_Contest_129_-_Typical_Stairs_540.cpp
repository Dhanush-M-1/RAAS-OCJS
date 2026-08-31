#include <bits/stdc++.h>
#define ll long long
#define ull unsigned long long
using namespace std;
const int M=1e5+10,MOD=1e9+7;
int n,m,x,a[M],f[M];
int main()
{
    cin>>n>>m;
    for(int i=0;i<m;i++)
        cin>>x,a[x]=1;
    f[0]=1;
    f[1]=a[1]?0:1;
    for(int i=2;i<=n;i++)
        if(!a[i])
            f[i]=((ll)f[i-1]+f[i-2])%MOD;
    printf("%d\n",f[n]);
    return 0;
}
