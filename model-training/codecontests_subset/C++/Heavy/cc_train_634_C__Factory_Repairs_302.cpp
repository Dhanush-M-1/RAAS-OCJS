#include <bits/stdc++.h>
using namespace std;
using ll = long long;
struct BIT {
  vector<ll> bit;
  vector<ll> a;
  ll n;
  BIT(ll n) {
    this->n = n;
    bit.assign(n, 0);
    a.assign(n, 0);
  }
  void add(ll idx, ll del) {
    for (; idx < n; idx |= idx + 1) {
      bit[idx] += del;
    }
  }
  void update(ll idx, ll val) {
    add(idx, val - a[idx]);
    a[idx] = val;
  }
  ll sum(ll r) {
    ll res = 0;
    for (; r >= 0; r = (r & (r + 1)) - 1) {
      res += bit[r];
    }
    return res;
  }
  ll sum(ll l, ll r) { return sum(r) - sum(l - 1); }
};
void solve() {
  ll n, k, a, b, q;
  cin >> n >> k >> a >> b >> q;
  BIT bit1(n), bit2(n);
  vector<ll> v(n, 0);
  while (q--) {
    ll x;
    cin >> x;
    if (x == 1) {
      ll d, e;
      cin >> d >> e;
      v[d - 1] += e;
      bit1.update(d - 1, min(v[d - 1], b));
      bit2.update(d - 1, min(v[d - 1], a));
    } else {
      ll p;
      cin >> p;
      cout << bit1.sum(p - 2) + bit2.sum(p + k - 1, n - 1) << endl;
    }
  }
}
int main() {
  ios_base::sync_with_stdio(false);
  cin.tie(NULL);
  int t = 1;
  while (t--) {
    solve();
  }
  return 0;
}
