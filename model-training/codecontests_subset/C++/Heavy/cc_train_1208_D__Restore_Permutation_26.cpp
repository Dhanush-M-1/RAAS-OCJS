#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using pll = pair<int, int>;
using ld = long double;
using pii = pair<int, int>;
using dbl = long double;
using vll = vector<int>;
#pragma GCC optimize("O2")
#pragma GCC optimize("unroll-loops")
const ll mod = 1000000007;
const ll N = 2e5 + 10;
const ll inf = 1e16 + 10;
ll seg[4 * N], lz[4 * N], a[N], n;
ll merge(ll x, ll y) { return min(x, y); }
ll cnt(ll l, ll r) { return 1; }
void build(ll cur, ll s, ll e) {
  if (s == e) {
    seg[cur] = a[s];
    return;
  }
  build(cur + cur, s, (s + e) / 2);
  build(cur + cur + 1, (s + e) / 2 + 1, e);
  seg[cur] = merge(seg[cur + cur], seg[cur + cur + 1]);
}
void propogate(ll cur, ll s, ll e) {
  if (s != e) {
    lz[cur + cur] += lz[cur];
    lz[cur + cur + 1] += lz[cur];
  }
  seg[cur] += cnt(s, e) * lz[cur];
  lz[cur] = 0;
}
void update(ll cur, ll s, ll e, ll l, ll r, ll val) {
  propogate(cur, s, e);
  if (e < l || s > r) return;
  if (l <= s && e <= r) {
    lz[cur] += val;
    propogate(cur, s, e);
    return;
  }
  update(cur + cur, s, (s + e) / 2, l, r, val);
  update(cur + cur + 1, (s + e) / 2 + 1, e, l, r, val);
  seg[cur] = merge(seg[cur + cur], seg[cur + cur + 1]);
}
ll query(ll cur, ll s, ll e, ll l, ll r) {
  propogate(cur, s, e);
  if (e < l || s > r) return inf;
  if (l <= s && e <= r) return seg[cur];
  ll q1 = query(cur + cur, s, (s + e) / 2, l, r);
  ll q2 = query(cur + cur + 1, (s + e) / 2 + 1, e, l, r);
  return merge(q1, q2);
}
ll dfs(ll cur, ll s, ll e) {
  propogate(cur, s, e);
  if (s == e) {
    return s;
  }
  propogate(cur + cur, s, (s + e) / 2);
  propogate(cur + cur + 1, (s + e) / 2 + 1, e);
  if (seg[cur + cur + 1] == 0) {
    return dfs(cur + cur + 1, (s + e) / 2 + 1, e);
  } else {
    return dfs(cur + cur, s, (s + e) / 2);
  }
}
void build() { build(1, 1, n); }
void update(ll pos, ll val) { update(1, 1, n, pos, pos, val); }
void update(ll l, ll r, ll val) { update(1, 1, n, l, r, val); }
ll query(ll l, ll r) { return query(1, 1, n, l, r); }
signed main() {
  cin >> n;
  for (ll i = 1; i <= n; i++) {
    cin >> a[i];
  }
  build();
  ll ans[n];
  for (ll i = 0; i < n; i++) {
    ll x = dfs(1, 1, n);
    update(x, inf);
    update(x + 1, n, -(i + 1));
    ans[x - 1] = i + 1;
  }
  for (ll i = 0; i < n; i++) {
    cout << ans[i] << " ";
  }
}
