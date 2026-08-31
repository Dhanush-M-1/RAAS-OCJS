#include <map>
#include <queue>
#include <cmath>
#include <vector>
#include <cstdio>
#include <cstring>
#include <algorithm>
#define itt map<int,int>::iterator 
#define ll long long
#define ull unsigned long long 
#define dd double
using namespace std;
const int maxn=5000,N1=maxn+5; const int inf=0x3f3f3f3f,p=998244353;

template <typename _T> void read(_T &ret)
{
    ret=0; _T fh=1; char c=getchar();
    while(c<'0'||c>'9'){ if(c=='-') fh=-1; c=getchar(); }
    while(c>='0'&&c<='9'){ ret=ret*10+c-'0'; c=getchar(); }
    ret=ret*fh;
}

int T,n,q; 
int tag[N1];
ll f[2][N1] ,g[N1], s[N1];

int main()
{
    scanf("%d",&T);
    while(T--){
        
    scanf("%d",&n);
    for(int i=1;i<=n;i++) read(tag[i]);;
    for(int i=1;i<=n;i++) read(s[i]);
    for(int i=1;i<=n;i++) f[0][i]=f[1][i]=g[i]=0;
    int now=1, pst=0;
    f[pst][1]=0;
    for(int i=2;i<=n;i++)
    {
        for(int j=1;j<i;j++) f[now][j]=f[pst][j], g[j]=0;
        for(int j=1;j<i;j++) 
        {
            if(tag[i]==tag[j]) continue;
            f[now][i]=max(f[now][i],f[pst][j]+abs(s[i]-s[j]));
            if(j>1) g[j-1]=f[pst][j]+abs(s[i]-s[j]);
        }
        for(int j=i-1;j>=1;j--)
        {
            g[j]=max(g[j],g[j+1]);
            if(tag[i]==tag[j]) continue;
            f[now][j]=max(f[pst][j],g[j]+abs(s[i]-s[j]));
        }
        // for(int j=1;j<=i;j++) printf("%d ",f[now][j]); puts("");
        swap(now,pst);
    }
    ll ans=0;
    for(int i=1;i<=n;i++) ans=max(ans,f[pst][i]);
    printf("%lld\n",ans);
    
    }
    return 0;
}
