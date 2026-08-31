#include <bits/stdc++.h>
using namespace std;
struct tree {
  vector<int64_t> t;
  int n;
  tree(int _n) : n(_n), t(2 * _n) {}
  void modify(int p, int64_t value) {
    for (t[p += n] = value; p > 1; p >>= 1) t[p >> 1] = t[p] + t[p ^ 1];
  }
  int64_t query(int l, int r, int64_t res = 0) {
    for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
      if (l & 1) res += t[l++];
      if (r & 1) res += t[--r];
    }
    return res;
  }
};
void solve() {
  int n, k, q;
  int64_t a, b;
  cin >> n >> k >> a >> b >> q;
  tree ta(n), tb(n);
  for (int i = 0; i < q; ++i) {
    int t;
    cin >> t;
    if (t == 1) {
      int d, v;
      cin >> d >> v;
      --d;
      int64_t cura = ta.query(d, d + 1) + v;
      int64_t curb = tb.query(d, d + 1) + v;
      ta.modify(d, min(a, cura));
      tb.modify(d, min(b, curb));
    } else {
      int p;
      cin >> p;
      --p;
      int64_t ans = tb.query(0, p);
      ans += ta.query(p + k, n);
      cout << ans << endl;
    }
  }
}
int main() {
  std::ios::sync_with_stdio(false);
  solve();
  return 0;
}
