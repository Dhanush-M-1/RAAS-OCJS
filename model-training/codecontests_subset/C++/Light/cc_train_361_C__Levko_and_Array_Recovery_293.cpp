#include <bits/stdc++.h>
using namespace std;
const int N = 5e3 + 10;
const int inf = 1e9;
int n, m;
int x[N], t[N];
struct xxx {
  int t, l, r, d;
} q[N];
inline bool check() {
  for (int i = 0; i < m; i++) {
    int mak = -inf - 1;
    for (int j = q[i].l; j <= q[i].r; j++) {
      if (q[i].t == 1) {
        t[j] += q[i].d;
      } else {
        mak = max(mak, t[j]);
      }
    }
    if (q[i].t == 2 and mak != q[i].d) {
      return false;
    }
  }
  return true;
}
int main() {
  scanf("%d %d", &n, &m);
  for (int i = 0; i < m; i++) {
    scanf("%d %d %d %d", &q[i].t, &q[i].l, &q[i].r, &q[i].d);
  }
  for (int i = 1; i <= n; i++) {
    x[i] = inf;
  }
  for (int i = m - 1; i >= 0; i--) {
    for (int j = q[i].l; j <= q[i].r; j++) {
      if (q[i].t == 1) {
        x[j] -= q[i].d;
      } else {
        x[j] = min(x[j], q[i].d);
      }
    }
  }
  for (int i = 1; i <= n; i++) {
    x[i] = min(max(x[i], -inf), inf);
    t[i] = x[i];
  }
  if (check()) {
    printf("YES\n");
    for (int i = 1; i <= n; i++) {
      printf("%d ", x[i]);
    }
    printf("\n");
  } else {
    printf("NO\n");
  }
}
