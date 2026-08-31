#include<bits/stdc++.h>
#define For(i,x,y) for (register int i=(x);i<=(y);i++)
#define FOR(i,x,y) for (register int i=(x);i<(y);i++)
#define Dow(i,x,y) for (register int i=(x);i>=(y);i--)
#define Debug(v) for (auto i:v) cout<<i<<" ";puts("")
#define mp make_pair
#define fi first
#define se second
#define pb push_back
#define ep emplace_back
#define siz(x) ((int)(x).size())
#define all(x) (x).begin(),(x).end()
#define fil(a,b) memset((a),(b),sizeof(a))
using namespace std;
typedef long long ll;
typedef unsigned long long ull;
typedef pair<int,int> pa;
typedef pair<ll,ll> PA;
typedef vector<int> poly;
inline ll read(){
    ll x=0,f=1;char c=getchar();
    while ((c<'0'||c>'9')&&(c!='-')) c=getchar();
    if (c=='-') f=-1,c=getchar();
    while (c>='0'&&c<='9') x=x*10+c-'0',c=getchar();
    return x*f;
}
const int N = 5e5+10, mod = 1e9+7;
int n,m,f[N],vis[N];
vector<int> ans;
int cnt=1;

int fa[N];
inline int Find(int x){
    return fa[x]==x?x:fa[x]=Find(fa[x]);
}

int main(){
    n=read(),m=read();
    For(i,1,m) fa[i]=i;
    For(i,1,n){
        int k=read();
        if (k==1){
            int x=Find(read());
            if (!vis[x]) vis[x]=1,ans.pb(i),cnt=2ll*cnt%mod;
        } else {
            int x=read(),y=read();
            x=Find(x),y=Find(y);
            if (vis[x]&&vis[y]) continue;
            if (x!=y){
                ans.pb(i),cnt=2ll*cnt%mod;
                fa[x]=y,vis[y]|=vis[x];
            }
        }
    }
    printf("%d %d\n",cnt,siz(ans));
    for (auto i:ans) printf("%d ",i);
}