#include <bits/stdc++.h>

using namespace std;

typedef long long ll;
typedef pair<ll,int> pii;

#define fi first
#define se second
#define mp make_pair
#define fastIO ios::sync_with_stdio(false);cin.tie(0);cout.tie(0);

const int N = (int)2e5 + 9;
int par[N];

int fin(int x){ 
  if(x == par[x]) return x;
  return par[x]=fin(par[x]);
}

int unite(int a, int b){ 
  a = fin(a);
  b = fin(b);
  if(a == b) return 0;
  par[a]=b;
  return 1;
}

struct Edge{  
  int ai;
  int bi;
  ll wei;
  bool operator< (const Edge &T) const {
    return wei < T.wei;
  }
};

vector<Edge> check;

ll a[N];
ll d;

void solve(int l, int r){
  if(l == r) return;
  int mid = (l + r) / 2;
  int i1 = l;
  int i2 = mid + 1;
  for(int j = l + 1; j <= mid ; j ++ ){
    if(a[j] - j * 1ll * d < a[i1] - i1 * 1ll * d){
      i1 = j;
    }
  }
  for(int j = mid + 2; j <= r; j ++ ){
    if(a[j] + j * 1ll * d < a[i2] + i2 * 1ll * d){
      i2 = j;
    }
  }
  for(int i = l ; i <= mid ; i ++ ){
    check.push_back({i,i2,a[i]+a[i2]+(i2-i)*1ll*d});
  }
  for(int i = mid + 1; i <= r; i ++ ){
    check.push_back({i,i1,a[i]+a[i1]+(i-i1)*1ll*d});
  }
  solve(l,mid);
  solve(mid+1,r);
}

int main(){
  fastIO;
  int n;
  cin >> n >> d;
  for(int i = 1; i <= n; i ++ ){
    cin >> a[i];
    par[i]=i;
  }
  solve(1,n);
  sort(check.begin(), check.end());
  ll ans = 0;
  for(auto p : check){
    ans += p.wei * 1ll * unite(p.ai, p.bi);
  }
  cout << ans << "\n";
  return 0;
}
