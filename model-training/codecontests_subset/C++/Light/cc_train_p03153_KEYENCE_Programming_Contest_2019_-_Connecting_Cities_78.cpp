#include<bits/stdc++.h>
using namespace std;
const int N=2e5+5;
typedef long long ll;
int n,tot,d,a[N],f[N];
struct node
{
    int u,v;
    node(int u=0,int v=0,ll w=0):u(u),v(v),w(w){}
    ll w;
    bool operator<(const node&o)const
    {
        return w<o.w;
    }
}e[N*20];
void solve(int l,int r)
{
    if(l==r) return;
    int m=l+r>>1;
    ll p1=l,p2=m+1,s=1e18;
    for(ll i=l;i<=m;i++)
        if(-i*d+a[i]<s)
        s=-i*d+a[i],p1=i;
    s=1e18;
    for(ll i=m+1;i<=r;i++)
        if(i*d+a[i]<s)
        s=i*d+a[i],p2=i;
    for(ll i=l;i<=m;i++)
    {
        tot++;
        e[tot]=node(i,p2,-i*d+a[i]+p2*d+a[p2]);
    }
    for(ll i=m+1;i<=r;i++)
    {
        tot++;
        e[tot]=node(p1,i,-p1*d+a[p1]+i*d+a[i]);
    }
    solve(l,m);solve(m+1,r);
}
int getf(int x){return f[x]==x?x:f[x]=getf(f[x]);}
int main()
{
    scanf("%d%d",&n,&d);
    for(int i=1;i<=n;i++) scanf("%d",&a[i]);
    solve(1,n);
    sort(e+1,e+1+tot);
    for(int i=1;i<=n;i++) f[i]=i;
    ll ans=0;
    for(int i=1;i<=tot;i++)
    {
        int fu=getf(e[i].u),fv=getf(e[i].v);
        if(fu==fv) continue;
        ans+=e[i].w;
        f[fu]=fv;
    }
    printf("%lld\n",ans);
}
