#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using pii = pair<int, int>;
using db = double;
using vi = vector<int>;
const int inf = 0x3f3f3f3f;
const db eps = 1e-8;
const int mod = 1e9 + 7;
ll qpow(ll a, ll b) {
  ll ret = 1;
  while (a) {
    if (b & 1) ret = ret * a % mod;
    a = a * a % mod;
    b >>= 1;
  }
  return ret;
}
int n, m, k;
vector<pii> a;
const int maxn = 2e5 + 7;
struct node {
  ll b[maxn];
  void update(int i, ll v) {
    for (; i < maxn; i += (i & -i)) b[i] += v;
  }
  ll query(int i) {
    ll ret = 0;
    for (; i > 0; i -= (i & -i)) ret += b[i];
    return ret;
  }
} bit1, bit2;
int main() {
  ios::sync_with_stdio(false);
  cin.tie(0);
  cin >> n;
  a.resize(n);
  vector<ll> co(n);
  for (int i = 0; i < n; ++i) {
    cin >> a[i].first;
  }
  for (int i = 0; i < n; i++) {
    cin >> a[i].second;
    co[i] = a[i].second;
  }
  sort(co.begin(), co.end());
  sort(a.begin(), a.end());
  co.erase(unique(co.begin(), co.end()), co.end());
  for (int i = 0; i < n; i++)
    a[i].second =
        lower_bound(co.begin(), co.end(), a[i].second) - co.begin() + 1;
  ll ans = 0;
  for (int i = 0; i < n; i++) {
    ans += bit2.query(a[i].second) * a[i].first - bit1.query(a[i].second);
    bit1.update(a[i].second, a[i].first);
    bit2.update(a[i].second, 1);
  }
  cout << ans;
}
