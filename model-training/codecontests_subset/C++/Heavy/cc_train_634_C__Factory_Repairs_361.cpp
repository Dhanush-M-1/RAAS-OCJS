#include <bits/stdc++.h>
#pragma GCC target("avx2")
#pragma GCC optimize("O3")
#pragma GCC optimize("unroll-loops")
using namespace std;
using ll = long long;
using lld = long double;
const ll oo = 0x3f3f3f3f;
const ll MOD = 1000000007;
const ll N = 2e5 + 100;
ll tree[2][N << 2];
ll n, k, a, b;
void upd(ll l, ll r, ll t, const ll idx, const ll val) {
  if (l == r) {
    tree[0][t] = min(a, tree[0][t] + val);
    tree[1][t] = min(b, tree[1][t] + val);
    return;
  }
  ll mid = (l + r) >> 1;
  if (idx <= mid)
    upd(l, mid, t << 1, idx, val);
  else
    upd(mid + 1, r, t << 1 | 1, idx, val);
  for (ll o = 0; o < 2; o++) tree[o][t] = tree[o][t << 1] + tree[o][t << 1 | 1];
}
ll qry(ll l, ll r, ll t, ll ql, ll qr, ll o) {
  if (l > qr || r < ql || r < l) return 0;
  if (l >= ql && r <= qr) return tree[o][t];
  ll mid = (l + r) >> 1;
  return qry(l, mid, t << 1, ql, qr, o) +
         qry(mid + 1, r, t << 1 | 1, ql, qr, o);
}
signed main() {
  ios_base::sync_with_stdio(0);
  cin.tie(0);
  memset(tree, 0, sizeof tree);
  cin >> n >> k >> a >> b;
  ll q;
  cin >> q;
  while (q--) {
    ll t;
    cin >> t;
    if (t == 2) {
      ll x;
      cin >> x;
      cout << qry(0, n, 1, 0, max(-1LL, x - 1), 1) +
                  qry(0, n, 1, min(n + 1, x + k), n, 0);
      cout << '\n';
    } else {
      ll di, ai;
      cin >> di >> ai;
      upd(0, n, 1, di, ai);
    }
  }
  return 0;
}
