#include <bits/stdc++.h>
using namespace std;
int i, j, k, n, tp, ans, c[2][210001], m, t1, t2, w, a[210001];
void change(int *c, int x, int d) {
  for (; x <= n; x += x & (-x)) c[x] += d;
}
int query(int *c, int x) {
  int res = 0;
  for (; x; x -= x & (-x)) res += c[x];
  return res;
}
int main() {
  scanf("%d%d%d%d%d", &n, &w, &t1, &t2, &m);
  memset(c, 0, sizeof(c));
  memset(a, 0, sizeof(a));
  for (i = 1; i <= m; i++) {
    scanf("%d", &tp);
    if (tp == 1) {
      scanf("%d%d", &j, &k);
      change(c[0], j, min(t2, a[j] + k) - min(t2, a[j]));
      change(c[1], n - j + 1, min(t1, a[j] + k) - min(t1, a[j]));
      a[j] += k;
    } else {
      scanf("%d", &j);
      ans = query(c[0], j - 1) + query(c[1], n - (j + w) + 1);
      printf("%d\n", ans);
    }
  }
  return 0;
}
