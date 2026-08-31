#include<bits/stdc++.h>
using namespace std;

typedef long long ll;
typedef pair<int,int> pi;
typedef pair<ll,pi> pii;
typedef vector<int> vi;

#define f first
#define s second
#define all(x) (x).begin(), (x).end()
#define pb push_back
#define mp make_pair
#define forn(i, n) for(register int i=0; i<n; i++)
#define Forn(i, n) for(register int i=1; i<=n; i++)
#define foreach(it, a) for(__typeof((a).begin()) it=(a).begin(); it!=(a).end(); it++)
#define Foreach(it, a) for(__typeof((a).rbegin()) it=(a).rbegin(); it!=(a).rend(); it++)
#define INF 1999999999999999999LL

inline int in()
{
    char c=getchar();
    int neg=1, x=0;
    while(!isdigit(c)) (c=='-')?neg=-1, c=getchar():c=getchar();
    while(isdigit(c)) x=(x<<3)+(x<<1)+(c^48), c=getchar();
    return neg*x;
}

const int MAX=2e5+5;

int N;
ll A[MAX], D, ret;
vector<pii> e;

namespace DSU
{
    int par[MAX];
    inline void init()
    {
        Forn(i, MAX-1)
            par[i]=i;
    }
    inline int find(int x)
    {
        return x==par[x]?x:par[x]=find(par[x]);
    }
    inline int unite(int x, int y)
    {
        x=find(x), y=find(y);
        if(x==y)
            return 0;
        par[x]=y;
        return 1;
    }
}

inline void solve(int l, int r)
{
    if(l==r)
        return;
    int m=l+r>>1, pl=-1, pr=-1;
    ll mnl=INF, mnr=INF;
    for(int i=l; i<=m; i++)
    {
        ll vl=A[i]-1LL*D*i;
        if(mnl>vl)
            mnl=vl, pl=i;
    }
    for(int i=m+1; i<=r; i++)
    {
        ll vr=A[i]+1LL*D*i;
        if(mnr>vr)
            mnr=vr, pr=i;
    }
    for(int i=l; i<=m; i++)
    {
        ll vl=A[i]-1LL*D*i;
        e.pb(mp(vl+mnr, mp(i, pr)));
    }
    for(int i=m+1; i<=r; i++)
    {
        ll vr=A[i]+1LL*D*i;
        e.pb(mp(mnl+vr, mp(pl, i)));
    }
    solve(l, m);
    solve(m+1, r);
}

int main()
{
    DSU::init();
    N=in(), D=in();
    Forn(i, N)
        A[i]=in();
    solve(1, N);
    sort(all(e));/*
    foreach(it, e)
        cout<<it->f<<" "<<it->s.f<<" "<<it->s.s<<endl;*/
    foreach(it, e)
        ret+=DSU::unite(it->s.f, it->s.s)*it->f;
    printf("%lld\n", ret);
    return 0;
}