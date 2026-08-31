#include<iostream>
#include<cstdio>
#include<vector>
#include<algorithm>
const int N=2e5+5;
typedef long long ll;
struct Edge {
    int u,v;ll c;
    bool operator < (const Edge &b) const {
        return c<b.c;
    }
};
std::vector<Edge> g;
int par[N],n;ll a[N],D;
void init() {
    for(int i=1;i<=n;i++) par[i]=i;
}
int fd(int x) {
    return par[x]==x?x:par[x]=fd(par[x]);
}
void solve(int l,int r) {
    if(l>=r) return;
    int mid=(l+r)>>1;
    int L=l,R=mid+1;
    for(int i=l+1;i<=mid;i++) {
        if(a[i]-D*i<a[L]-L*D) L=i;
    }
    for(int i=mid+2;i<=r;i++) {
        if(a[i]+D*i<a[R]+R*D) R=i;
    }
    for(int i=l;i<=r;i++) {
        if(i<=mid) g.push_back((Edge){i,R,a[i]+a[R]+(R-i)*D});
        else g.push_back((Edge){L,i,a[L]+a[i]+(i-L)*D});
    }
    solve(l,mid);
    solve(mid+1,r);
}
ll kruskal() {
    init();
    std::sort(g.begin(),g.end());
    ll ans=0;
    for(Edge &w:g) {
        int u=fd(w.u),v=fd(w.v);
        if(u!=v) par[u]=v,ans+=w.c;
    }
    return ans;
}
int main() {
    scanf("%d%lld",&n,&D);
    for(int i=1;i<=n;i++) scanf("%d",a+i);
    solve(1,n);printf("%lld\n",kruskal());
    return 0;
}
