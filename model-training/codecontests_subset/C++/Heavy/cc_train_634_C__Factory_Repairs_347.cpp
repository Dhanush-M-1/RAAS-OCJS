#include <bits/stdc++.h>
using namespace std;
const int MAXN = 2e5 + 5;
const int MAXA = 1e4 + 4;
const int MAXQ = 2e5 + 5;
int n, k, a, b, q;
void init() { scanf("%d%d%d%d%d", &n, &k, &a, &b, &q); }
struct BIT {
  int dat[MAXN];
  void init() { memset(dat, 0, sizeof(dat)); }
  void add(int x, int v) {
    for (int i = x; i <= n; i += i & -i) dat[i] += v;
  }
  int sum(int x) {
    int res = 0;
    for (int i = x; i > 0; i -= i & -i) res += dat[i];
    return res;
  }
} pre, suf;
int val[MAXN];
void solve() {
  pre.init();
  suf.init();
  for (int i = 0; i < q; ++i) {
    int type;
    scanf("%d", &type);
    if (type == 1) {
      int d, v;
      scanf("%d%d", &d, &v);
      int x = min<int>(b, val[d] + v) - min<int>(b, val[d]);
      int y = min<int>(a, val[d] + v) - min<int>(a, val[d]);
      val[d] += v;
      pre.add(d, min<int>(b, x));
      suf.add(n - d + 1, min<int>(a, y));
    } else {
      int p;
      scanf("%d", &p);
      int ans = 0;
      if (p - 1 >= 1) ans += pre.sum(p - 1);
      if (n - p + 1 - k >= 1) ans += suf.sum(n - p + 1 - k);
      printf("%d\n", ans);
    }
  }
}
int main() {
  init();
  solve();
  return 0;
}
