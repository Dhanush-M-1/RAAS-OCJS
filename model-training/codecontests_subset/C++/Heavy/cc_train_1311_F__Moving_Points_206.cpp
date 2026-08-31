#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using ii = pair<int, int>;
constexpr int MAXN = 5 + 200000;
struct Bit {
  ll b[MAXN];
  Bit() { fill(b, b + MAXN, 0); }
  void upd(int x, ll val) {
    for (; x < MAXN; x += (x & -x)) b[x] += val;
  }
  ll query(int x) {
    ll ans = 0LL;
    for (; x; x -= (x & -x)) ans += b[x];
    return ans;
  }
};
ii a[MAXN];
namespace comp {
int v[MAXN];
void compress(ii arr[], int n, int BEG) {
  for (int i = (int)0; i < (int)n; ++i) v[i] = arr[i].second;
  sort(v, v + n);
  int sz = unique(v, v + n) - v;
  for (int i = (int)0; i < (int)n; ++i) {
    arr[i].second = BEG + lower_bound(v, v + sz, arr[i].second) - v;
  }
}
}  // namespace comp
int main() {
  ios::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  int n;
  cin >> n;
  for (int i = (int)0; i < (int)n; ++i) {
    cin >> a[i].first;
  }
  for (int i = (int)0; i < (int)n; ++i) {
    cin >> a[i].second;
  }
  sort(a, a + n,
       [](const ii& p, const ii& q) -> bool { return p.first < q.first; });
  ll tot = 0LL, pre = 0LL;
  for (int i = (int)0; i < (int)n; ++i) {
    tot += ((1LL * i * a[i].first) - pre);
    pre += a[i].first;
  }
  comp::compress(a, n, 1);
  Bit suma, cuenta;
  ll ans = 0LL;
  for (int i = n - 1; i >= 0; --i) {
    ans += (suma.query(a[i].second - 1) -
            1LL * cuenta.query(a[i].second - 1) * a[i].first);
    suma.upd(a[i].second, a[i].first);
    cuenta.upd(a[i].second, 1);
  }
  cout << tot - ans << '\n';
  return 0;
}
