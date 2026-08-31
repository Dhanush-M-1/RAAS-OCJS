#include <bits/stdc++.h>
#define rc(x) return cout<<x<<endl,0
#define pb push_back
#define mkp make_pair
#define in insert
#define er erase
#define fd find
#define fr first
#define sc second
#define all(x) x.begin(),x.end()
#define lun(x) (int)x.size()
typedef long long ll;
typedef long double ld;
const ll INF=0x3f3f3f3f3f3f3f3f;
const ll llinf=(1LL<<60);
const int inf=(1<<30);
const int nmax=5e5+50;
const ll mod=1e9+7;
using namespace std;
int n,m,i,j,c,vz[nmax],sz[nmax],p[nmax],k,x,y;
ll rs=1;
vector<int>g[nmax],v;
int fnd(int x)
{
    if(p[x]==x)return x;
    return p[x]=fnd(p[x]);
}
int uni(int x,int y)
{
    x=fnd(x),y=fnd(y);
    if(x==y)return 0;
    if(sz[x]<sz[y])swap(x,y);
    sz[x]+=sz[y];
    p[y]=x;
    return 1;
}
void dfs(int x)
{
    vz[x]=1;
    c++;
    for(int i=0;i<lun(g[x]);i++)if(!vz[g[x][i]])dfs(g[x][i]);
}
int main()
{
    //freopen("sol.in","r",stdin);
    //freopen("sol.out","w",stdout);
    //mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
    ios_base::sync_with_stdio(false);cin.tie(0);cerr.tie(0);cout.tie(0);
    cin>>n>>m;
    for(i=1;i<=m+1;i++)
    {
        sz[i]=1;
        p[i]=i;
    }
    for(i=1;i<=n;i++)
    {
        cin>>k;
        if(k==1)
        {
            cin>>x;
            if(uni(x,m+1))
            {
                v.pb(i);
                g[x].pb(m+1);
                g[m+1].pb(x);
            }
        }
        else
        {
            cin>>x>>y;
            if(uni(x,y))
            {
                v.pb(i);
                g[x].pb(y);
                g[y].pb(x);
            }
        }
    }
    for(i=1;i<=m+1;i++)
    {
        if(vz[i])continue;
        c=0;
        dfs(i);
        for(j=1;j<c;j++)rs=(rs*2LL)%mod;
    }
    cout<<rs<<" "<<lun(v)<<'\n';
    for(i=0;i<lun(v);i++)cout<<v[i]<<" ";
    cout<<'\n';
    return 0;
}
