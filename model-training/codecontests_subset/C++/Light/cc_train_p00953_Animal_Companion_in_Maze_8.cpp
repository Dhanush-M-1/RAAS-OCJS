#include<bits/stdc++.h>
using namespace std;

#define int long long

#define rep(i,n) for(int i=0;i<(n);i++)
#define pb push_back
#define all(v) (v).begin(),(v).end()
#define fi first
#define se second
typedef vector<int>vint;
typedef pair<int,int>pint;
typedef vector<pint>vpint;

template<typename A,typename B>inline void chmin(A &a,B b){if(a>b)a=b;}
template<typename A,typename B>inline void chmax(A &a,B b){if(a<b)a=b;}

int N,M;

struct UnionFindTree{
    vector<int>par,sz;
    UnionFindTree(int n){
        par.resize(n);
        sz.resize(n);
        for(int i=0;i<n;i++){
            par[i]=i;
            sz[i]=1;
        }
    }
    int find(int x){
        return x==par[x]?x:par[x]=find(par[x]);
    }
    void unite(int x,int y){
        x=find(x);y=find(y);
        if(x==y)return;
        if(sz[x]<sz[y])swap(x,y);
        sz[x]+=sz[y];
        par[y]=x;
    }
    bool areSame(int x,int y){
        return find(x)==find(y);
    }
    int size(int x){
        return sz[find(x)];
    }
};
UnionFindTree uf(0);

int dp[111111],dp2[111111];
vint G[111111];
void dfs(int v,int p,int r){
    for(auto u:G[v]){
        if(u==p)continue;
        if(uf.find(u)!=r){
            chmax(dp2[v],dp[u]+1);
        }
        else{
            dfs(u,v,r);
            chmax(dp2[v],dp2[u]+1);
        }
    }
}

void dfs2(int v,int p,int r,int x){
    vint lis={x};
    for(auto u:G[v]){
        if(u==p)continue;
        if(uf.find(u)==r){
            lis.pb(dp2[u]+1);
        }
        else{
            lis.pb(dp[u]+1);
        }
    }
    sort(all(lis));reverse(all(lis));
    dp[v]=lis[0];

    for(auto u:G[v]){
        if(u==p||uf.find(u)!=r)continue;
        int xx;
        if(lis[0]==dp2[u]+1)xx=lis[1];
        else xx=lis[0];

        dfs2(u,v,r,xx+1);
    }
}

signed main(){
    cin>>N>>M;
    vpint es,es2;

    rep(i,M){
        int a,b,w;
        cin>>a>>b>>w;
        a--;b--;
        if(w==1)es.pb({a,b});
        else es2.pb({a,b});
    }

    uf=UnionFindTree(N);
    for(auto &p:es2){
        if(uf.areSame(p.fi,p.se)){
            cout<<"Infinite"<<endl;
            return 0;
        }
        uf.unite(p.fi,p.se);
    }


    vector<vint>D(N);
    vint deg(N);
    for(auto &p:es){
        D[uf.find(p.fi)].pb(uf.find(p.se));
        deg[uf.find(p.se)]++;
    }


    vint ord;
    rep(i,N)if(uf.find(i)==i&&deg[i]==0)ord.pb(i);
    rep(i,ord.size()){
        int v=ord[i];
        for(auto u:D[v]){
            if(--deg[u]==0)ord.pb(u);
        }
    }

    if(count(all(deg),0)!=N){
        cout<<"Infinite"<<endl;
        return 0;
    }


    for(auto &p:es)G[p.fi].pb(p.se);
    for(auto &p:es2)G[p.fi].pb(p.se),G[p.se].pb(p.fi);

    for(int i=(int)ord.size()-1;i>=0;i--){
        dfs(ord[i],-1,ord[i]);
        dfs2(ord[i],-1,ord[i],0);
    }

    cout<<*max_element(dp,dp+N)<<endl;
    return 0;
}