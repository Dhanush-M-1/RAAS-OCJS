#include <bits/stdc++.h>
using namespace std;
const int N = 1e5 + 5;
const int P = 998244353;
int n, m, a[N], pre[N], rec[N], f[N];
inline void add(int &x, int y) {
  x += y;
  if (x >= P) x -= P;
}
inline void sub(int &x, int y) {
  x -= y;
  if (x < 0) x += P;
}
struct BL {
  int bel[N], tag[450], w[N], size, cnt, sum[450][N], ans[450];
  void init() {
    sum[1][0] = ans[1] = 1;
    size = sqrt(n);
    for (int i = 1; i <= n; ++i) bel[i] = (i - 1) / size + 1;
    cnt = bel[n];
    for (int i = 1; i <= cnt; ++i) tag[i] = m;
  }
  void update(int pos, int x) {
    int px = bel[pos];
    sub(sum[px][w[pos]], f[pos - 1]);
    if (w[pos] <= tag[px]) sub(ans[px], f[pos - 1]);
    w[pos] = x;
    add(sum[px][x], f[pos - 1]);
    if (x <= tag[px]) add(ans[px], f[pos - 1]);
  }
  void ins(int x, int y, int d) {
    if (x > y) return;
    if (bel[x] + 1 >= bel[y]) {
      for (int i = x; i <= y; ++i) update(i, w[i] + d);
      return;
    }
    for (int i = x; i <= bel[x] * size; ++i) update(i, w[i] + d);
    for (int i = (bel[y] - 1) * size + 1; i <= y; ++i) update(i, w[i] + d);
    for (int i = bel[x] + 1; i <= bel[y] - 1; ++i) {
      if (d > 0) sub(ans[i], sum[i][tag[i]]);
      tag[i] -= d;
      if (d < 0) add(ans[i], sum[i][tag[i]]);
    }
  }
  int qry(int x) {
    int res = 0;
    for (int i = x; bel[i] == bel[x]; --i)
      if (w[i] <= tag[bel[x]]) add(res, f[i - 1]);
    for (int i = bel[x] - 1; i >= 1; --i) add(res, ans[i]);
    return res;
  }
} bl;
int main() {
  scanf("%d%d", &n, &m);
  bl.init();
  f[0] = 1;
  for (int i = 1; i <= n; ++i) {
    scanf("%d", &a[i]);
    pre[i] = rec[a[i]], rec[a[i]] = i;
    bl.ins(pre[pre[i]] + 1, pre[i], -1), bl.ins(pre[i] + 1, i, 1);
    f[i] = bl.qry(i);
    add(bl.sum[bl.bel[i + 1]][0], f[i]);
    add(bl.ans[bl.bel[i + 1]], f[i]);
  }
  printf("%d\n", f[n]);
  return 0;
}
