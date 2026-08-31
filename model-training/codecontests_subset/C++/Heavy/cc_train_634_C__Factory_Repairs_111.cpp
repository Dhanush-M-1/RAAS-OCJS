#include <bits/stdc++.h>
using namespace std;
const int MAXN = 1 << 19;
int n, k, a, b, q;
struct Seg {
  int upper;
  int a[MAXN];
  int t[MAXN];
  void update(int i, int dex) {
    for (; i <= n; i += i & -i) {
      t[i] += dex;
    }
  }
  int query(int i) {
    int ret = 0;
    for (; i > 0; i -= i & -i) {
      ret += t[i];
    }
    return ret;
  }
  void import(int i, int dex) {
    int next = min(upper, a[i] + dex);
    update(i, next - a[i]);
    a[i] = next;
  }
};
Seg ls, rs;
int main() {
  scanf("%d%d%d%d%d", &n, &k, &a, &b, &q);
  ls.upper = b;
  rs.upper = a;
  for (int i = 0; i < q; i++) {
    int opt;
    scanf("%d", &opt);
    if (opt == 1) {
      int d, dex;
      scanf("%d%d", &d, &dex);
      ls.import(d, dex);
      rs.import(n - d + 1, dex);
    } else {
      int p;
      scanf("%d", &p);
      int ans = ls.query(p - 1);
      ans += rs.query(n - k - p + 1);
      printf("%d\n", ans);
    }
  }
  return 0;
}
