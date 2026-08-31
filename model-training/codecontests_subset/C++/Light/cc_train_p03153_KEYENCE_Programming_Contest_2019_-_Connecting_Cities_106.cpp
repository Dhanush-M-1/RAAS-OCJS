#include <bits/stdc++.h>
using namespace std;
typedef pair<int,int> P;
typedef long long ll;
typedef long double ld;
const int inf=1e9+7;
const ll longinf=1LL<<60;
#define REP(i,m,n) for(int i=(int)(m) ; i < (int) (n) ; ++i )
#define rep(i,n) REP(i,0,n)
#define F first
#define S second

const int mx=200010;
const ll mod=1e9+7;

template<typename T>
struct Kruskal{
  struct edge{
    int from,to;
    T cost;
    int used;
    edge(int from,int to,T cost):
      from(from),to(to),cost(cost),used(0){}
    bool operator<(const edge& e) const{
      return cost<e.cost;
    }
  };
 
  int n;
  vector<int> r,p;
  vector<edge> es;
 
  Kruskal(){}
  Kruskal(int n):n(n),r(n,1),p(n){
    iota(p.begin(),p.end(),0);
  }
 
  int find(int x){ return (x==p[x]?x:p[x]=find(p[x])); }
 
  bool same(int x,int y){ return find(x)==find(y); }
 
  void unite(int x,int y){
    x=find(x);y=find(y);
    if(x==y) return;
    if(r[x]<r[y]) swap(x,y);
    r[x]+=r[y];
    p[y]=x;
  }
 
  void add_edge(int u,int v,T c){ es.emplace_back(u,v,c); }
 
  T build(){
    sort(es.begin(),es.end());
    T res=0;
    for(auto &e:es){
      if(!same(e.from,e.to)){
        res+=e.cost;
        unite(e.from,e.to);
        e.used=1;
      }
    }
    return res;
  }
};
 
vector<pair<P,ll>> edges;
vector<ll> a(mx);
ll n,d;

ll dist(int x,int y){ return d*abs(x-y)+a[x]+a[y]; }

void dfs(int l, int r){
  if(l+1>=r){ return; }
  ll mini=longinf, idx=-1;
  int m=(l+r)/2;
  for(int i=l; i<m; i++){ if(dist(i,m)<mini)mini=dist(i,m),idx=i; }
  for(int i=m; i<r; i++){ edges.push_back({{idx,i},dist(idx,i)}); }

  mini=longinf; idx=-1;
  for(int i=m; i<r; i++){ if(dist(i,l)<mini)mini=dist(i,l),idx=i; }
  for(int i=l; i<m; i++){ edges.push_back({{idx,i},dist(idx,i)}); }
  
  dfs(l,m);
  dfs(m,r);
}

int main(){
  cin >> n >> d;
  rep(i,n){ cin>>a[i]; }
  
  dfs(0,n);
  
  Kruskal<ll> ks(n);
  for(auto e:edges){
    int u=e.F.F,v=e.F.S; ll c=e.S;
    ks.add_edge(v,u,c);
  }
  ll ans=ks.build();
  cout << ans << endl;
  return 0;
}
