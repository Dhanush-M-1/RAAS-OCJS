#include <bits/stdc++.h>
using namespace std;
using ll = long long;
template <class T>
using V = vector<T>;
template <class T, class U>
using P = pair<T, U>;
using vll = V<ll>;
using vvll = V<vll>;
template <class T>
inline bool chmax(T& a, T b) {
  if (a < b) {
    a = b;
    return true;
  }
  return false;
}
template <class T>
inline bool chmin(T& a, T b) {
  if (a > b) {
    a = b;
    return true;
  }
  return false;
}
constexpr ll MOD = 1000000007;
constexpr ll HIGHINF = (ll)1e18;
constexpr int INF = 1e9;
int main() {
  cin.tie(0);
  ios::sync_with_stdio(false);
  int n, m, k;
  cin >> n >> m >> k;
  V<int> block(n + 1, 0), a(k);
  for (int i = 0; i < m; i++) {
    int s;
    cin >> s;
    block[s] = 1;
  }
  for (int i = 0; i < k; i++) cin >> a[i];
  V<int> goback(n + 1, -1);
  if (block[0] == 0) goback[0] = 0;
  for (int i = 1; i <= n; i++) {
    if (block[i] == 0)
      goback[i] = i;
    else
      goback[i] = goback[i - 1];
  }
  if (goback[0] == -1) {
    cout << -1 << '\n';
    return 0;
  }
  ll ans = HIGHINF;
  for (int i = 1; i <= k; i++) {
    ll cost = a[i - 1];
    int cur = 0, step = 0;
    while (cur < n) {
      int nxt = goback[min(cur + i, n)];
      if (nxt <= cur) {
        step = INF;
        break;
      }
      step++;
      cur = nxt;
    }
    if (step == INF) continue;
    chmin(ans, ll(step) * cost);
  }
  if (ans == HIGHINF) ans = -1;
  cout << ans << '\n';
  return 0;
}
