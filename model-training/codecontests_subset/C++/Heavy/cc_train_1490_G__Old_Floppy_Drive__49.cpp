#include <bits/stdc++.h>
#define F first
#define S second
#define all(x) x.begin(),x.end()
#define endl '\n'

using namespace std;

using ll = long long;
using pii = pair<int, int>;
const int INF = 0x3f3f3f3f;
const ll INFLL = 0x3f3f3f3f3f3f3f3fLL;
const int MOD = 1000000007;
const int dx[] = { 0, 0, -1, 1, 1, -1,  1, -1};
const int dy[] = {-1, 1,  0, 0, 1, -1, -1,  1};

int main() {
  ios_base::sync_with_stdio(false); cin.tie(NULL);

  int t;
  cin >> t;
  while(t--){
    int n, m;
    cin >> n >> m;
    vector<ll> v(n);
    for(int i=0; i<n; i++){
      cin >> v[i];
    }
    ll sum = 0, mx=-INFLL;
    for(int i=0; i<n; i++){
      sum += v[i];
      mx = max(mx, sum);
      v[i] = mx;
    }
    for(int i=0; i<m; i++){
      ll x;
      cin >> x;
      if(x <= mx){
        ll p = lower_bound(all(v), x) - v.begin();
        cout << p << " ";
      }else{
        if(sum <= 0){
          cout << -1 << " ";
        }else{
          ll y = (x-mx)/sum;
          ll ans = y*n;
          x -= y*sum;
          while(x > mx){
            ans += n;
            x -= sum;
          }
          ll p = lower_bound(all(v), x) - v.begin();
          cout << ans + p << " ";
        }
      }
    }
    cout << endl; 
  }
  return 0;
}
