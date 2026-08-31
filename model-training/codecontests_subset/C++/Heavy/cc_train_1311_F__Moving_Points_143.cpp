#include <bits/stdc++.h>
using namespace std;
template <typename T>
using pr = pair<T, T>;
const int mod = 1e9 + 7;
struct SegTree {
  vector<pr<long long>> segtree;
  long long N;
  SegTree(long long n) {
    N = 1;
    while (N < n) N <<= 1;
    segtree = vector<pr<long long>>(2 * N);
  }
  void modify(long long k, long long x) {
    k += N;
    segtree[k].second += x;
    segtree[k].first += 1;
    for (k /= 2; k > 0; k /= 2) {
      segtree[k].first = segtree[k * 2].first + segtree[k * 2 + 1].first;
      segtree[k].second = segtree[k * 2].second + segtree[k * 2 + 1].second;
    }
  }
  pr<long long> query(long long b) {
    long long a = 0;
    long long ansx = 0, ansy = 0;
    for (a += N, b += N; a <= b; a /= 2, b /= 2) {
      if (a % 2 == 1) ansx += segtree[a].first, ansy += segtree[a++].second;
      if (b % 2 == 0) ansx += segtree[b].first, ansy += segtree[b--].second;
    }
    return make_pair(ansx, ansy);
  }
};
void solve() {
  long long n;
  cin >> n;
  vector<pr<long long>> xv(n);
  vector<long long> v(n);
  for (signed i = 0; i < n; ++i) cin >> xv[i].first;
  for (signed i = 0; i < n; ++i) cin >> xv[i].second, v[i] = xv[i].second;
  sort((xv).begin(), (xv).end());
  sort((v).begin(), (v).end());
  map<long long, int> cmp;
  for (signed i = 0; i < n; ++i) cmp[v[i]] = i;
  long long ans = 0;
  SegTree x(n);
  x.modify(cmp[xv[0].second], xv[0].first);
  for (signed i = 1; i < n; ++i) {
    pr<long long> qa = x.query(cmp[xv[i].second]);
    ans += qa.first * xv[i].first - qa.second;
    x.modify(cmp[xv[i].second], xv[i].first);
  }
  cout << ans << endl;
}
signed main() {
  signed t = 1;
  while (t--) solve();
}
