#include <bits/stdc++.h>
#define INF (1LL<<55)
#define INF2 (1LL<<55)
using namespace std;
typedef long long ll;
typedef pair<ll,int> P;

struct edge{
    int u,v;
    ll c;
    edge(){}
    edge(int uu,int vv,ll cc){
        u=uu;
        v=vv;
        c=cc;
    }
    bool operator<(const edge &e)const{
        return c<e.c;
    }
};

struct uftree{
    int par[200005];
    int rank[200005];
    uftree(){
    }
    void init(int n){
        for(int i=0;i<n;i++){
            par[i]=i;
            rank[i]=0;
        }
    }
    int find(int x){
        if(par[x]==x)return x;
        return par[x]=find(par[x]);
    }

    void unite(int x,int y){
        x=find(x);
        y=find(y);
        if(x==y)return;
        if(rank[x]<rank[y]){
            par[x]=y;
        }else{
            if(rank[x]==rank[y])rank[x]++;
            par[y]=x;
        }
    }

    bool same(int x,int y){
        return find(x)==find(y);
    }
};

int n;
ll d;
ll a[200005];
uftree uf;
vector<edge> e;

void dfs(int l,int r){
    if(l>=r)return;
    int mid=(l+r)/2;
    int lv=mid,rv=mid;
    for(int i=l;i<=mid;i++){
        if((a[mid]+a[lv]+d*(mid-lv))>(a[mid]+a[i])+d*(mid-i)){
            lv=i;
        }
    }
    for(int i=mid;i<r;i++){
        if((a[mid]+a[rv]+d*(rv-mid))>(a[mid]+a[i])+d*(i-mid)){
            rv=i;
        }
    }
    for(int i=l;i<=mid;i++){
        e.push_back(edge(i,rv,a[i]+a[rv]+d*(rv-i)));
    }
    for(int i=mid;i<r;i++){
        e.push_back(edge(i,lv,a[i]+a[lv]+d*(i-lv)));
    }
    if(l+1==r)return;
    dfs(l,mid);
    dfs(mid,r);
}

int main(void){
    scanf("%d%lld",&n,&d);
    for(int i=0;i<n;i++){
        scanf("%lld",&a[i]);
    }
    if(n==1){
        printf("0\n");
        return 0;
    }
    dfs(0,n);
    ll ans=0;
    uf.init(n);
    sort(e.begin(),e.end());
    for(int i=0;i<e.size();i++){
        if(!uf.same(e[i].u,e[i].v)){
            //printf("%d %d %lld\n",e[i].u,e[i].v,e[i].c);
            uf.unite(e[i].u,e[i].v);
            ans+=e[i].c;
        }
    }
    printf("%lld\n",ans);
    return 0;
}