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

struct UnionFind {  
  vector<int> par,sizes;                     // par[i]:iの親の番号(ex)par[3]=2 : 3の親が2
  UnionFind(int n) : par(n),sizes(n,1)  {    //最初は全てが根であるとして初期化
    for(int i=0; i<n; i++){ par[i]=i; }  
  }
  int root(int x) {                       //xが属する木の根を再帰で得る:root(x)={xの木の根}
    if(par[x]==x){ return x; }
    return par[x] = root(par[x]);
  }
  void unite(int x, int y) {                 // xとyの木を併合
    int rx = root(x);                        //xの根をrx
    int ry = root(y);                        //yの根をry
    if(rx == ry){ return; }                  //xとyの根が同じ(=同じ木にある)時はそのまま
    if(sizes[rx]<sizes[ry]){ swap(rx, ry); } //xの木をおおきくする
    par[ry] = rx; 
    sizes[rx] += sizes[ry];                  //sizes[ry]はもう使わない
  }
 
  bool check(int x, int y) {                 // x,yが属する木が同じならtrueを返す
    return root(x) == root(y);
  }
  
  int size(int x){                           //xが含まれる木の大きさを返す
    return sizes[root(x)];
  }
};
 
vector<pair<ll,P>> edges;
vector<ll> a(mx);
ll n,d;

ll dist(int x,int y){ return d*abs(x-y)+a[x]+a[y]; }

void dfs(int l, int r){
  if(l+1>=r){ return; }
  ll mini=longinf, idx=-1;
  int m=(l+r)/2;
  for(int i=l; i<m; i++){ if(dist(i,m)<mini)mini=dist(i,m),idx=i; }
  for(int i=m; i<r; i++){ edges.push_back({dist(idx,i),{idx,i}}); }

  mini=longinf; idx=-1;
  for(int i=m; i<r; i++){ if(dist(i,l)<mini)mini=dist(i,l),idx=i; }
  for(int i=l; i<m; i++){ edges.push_back({dist(idx,i),{idx,i}}); }
  
  dfs(l,m);
  dfs(m,r);
}

int main(){
  cin >> n >> d;
  rep(i,n){ cin>>a[i]; }
  
  dfs(0,n);
  sort(edges.begin(),edges.end());
  
  UnionFind uf(n);
  ll ans=0;
  for(auto e:edges){
    int u=e.S.F,v=e.S.S; ll c=e.F;
    if(!uf.check(u,v)){ uf.unite(u,v); ans+=c;}
  }
  cout << ans << endl;
  return 0;
}
