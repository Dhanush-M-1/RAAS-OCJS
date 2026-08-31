#include <bits/stdc++.h>
using ll = long long;
using namespace std;
const ll N = 2e5 + 5, mod = 1e9 + 7;
const ll inf = 1e18;
struct cmp {
  bool operator()(pair<int, int> a, pair<int, int> b) {
    if (a.first == b.first) return a.second < b.second;
    return a.first > b.first;
  }
};
ll power(ll x, ll p) {
  ll r = 1ll;
  x = x % mod;
  while (p > 0) {
    if (p & 1) r = (r * x) % mod;
    p = p >> 1;
    x = (x * x) % mod;
  }
  return r;
}
void solve() {
  ll n, l, r;
  cin >> n >> l >> r;
  ll firstrow = n + (n - 2);
  ll ele = 0, i = 0;
  bool edge = 0;
  while (ele < l) {
    if (firstrow - 2ll * i > 0)
      ele += firstrow - 2ll * i;
    else {
      ele++;
      edge = 1;
    }
    i++;
  }
  if (!edge) ele -= firstrow - 2ll * (i - 1);
  bool flag = 0;
  ll j = 1;
  if (!edge) ele++;
  while (ele <= r) {
    ll ans;
    if (flag == 0)
      ans = i;
    else {
      ans = i + j;
      j++;
    }
    flag = 1 - flag;
    if (ele >= l && !edge) cout << ans << " ";
    if (edge) {
      cout << 1 << endl;
      return;
    }
    if (i + j - 1 >= n) {
      i++;
      j = 1;
      flag = 0;
      if (i >= n) i = 1;
    }
    ele++;
  }
  cout << endl;
}
int main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  int t = 1, p;
  cin >> t;
  for (p = 1; p <= t; p++) {
    solve();
  }
  return 0;
}
