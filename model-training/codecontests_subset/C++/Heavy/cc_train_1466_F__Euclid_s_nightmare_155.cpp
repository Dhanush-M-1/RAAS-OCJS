#include "bits/stdc++.h"
using namespace std;

#define rep(i, a, b) for(int i=a; i<=b; i++)
#define trav(a, x) for(auto& a : x)
#define all(x) begin(x), end(x)
#define sz(x) (int) x.size()
#define pb push_back
#define f first
#define s second
#define nl "\n"
typedef long long ll;
typedef pair<int, int> pii;
typedef vector<int> vi;
const int MOD = 1e9+7;
template<class T> using pqg = priority_queue<T,vector<T>,greater<T>>;

int n, m;
vector<pii> e;
bool self[500001];
int par[500001];
int sz[500001];
bool del[500001];
bool vis[500001];
bool has[500001];

int find(int x){
  if(x==par[x]) return x;
  return par[x]=find(par[x]);
}

void join(int x, int y){
  int a=find(x);
  int b=find(y);
  if(a!=b){
    sz[a]+=sz[b];
    par[b]=a;
    has[a] |= has[b];
  }
}

ll bpow(ll a, ll b){
  if(b==0) return 1;
  ll y=bpow(a, b/2);
  y=(y*y)%MOD;
  if(b&1) y=(y*a)%MOD;
  return y;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);
  // freopen("input.txt", "r", stdin); 
  // freopen("output.txt", "w", stdout);

  cin >> n >> m;
  rep(i, 1, m){
    par[i]=i;
    sz[i]=1;
  }
  rep(i, 1, n){
    int x=-1; int y=-1;
    int a;
    cin >> a;
    cin >> x;
    if(a>1) cin >> y;
    if(y==-1){
      e.pb({x, x});
    }
    else e.pb({x, y});
  }
  ll ans=1;
  rep(i, 0, sz(e)-1) {
    pii p=e[i];
    if(p.f!=p.s){
      if(find(p.f)==find(p.s) || (has[find(p.f)] && has[find(p.s)])) del[i]=true;
    }
    else{
      if(has[find(p.f)]) del[i]=true;
      has[(find(p.f))]=true;
    }
    join(p.f, p.s);
  }
  rep(i, 1, m){
    int p=find(i);
    if(vis[p]) continue;
    ans=(ans*bpow(2, sz[p]-1))%MOD;
    if(has[p]) ans=(ans*2)%MOD;
    vis[p]=true;
  }
  cout << ans << " ";
  vi vec;
  rep(i, 0, n-1){
    if(!del[i]) vec.pb(i);
  }
  cout << sz(vec) << nl;
  trav(k, vec) cout << k+1 << " ";
}