#include <bits/stdc++.h>
using namespace std;
struct quer {
  int typ, l, r, d;
} q[5009];
int a[5009], b[5009], diff[5009], final[5009];
int main() {
  int i, j, t1, t2, t3, t4, n, m;
  scanf("%d %d", &n, &m);
  for (i = 0; i < m; i++) {
    scanf("%d %d %d %d", &q[i].typ, &q[i].l, &q[i].r, &q[i].d);
  }
  for (i = 1; i <= n; i++) {
    diff[i] = 0;
    b[i] = 1e9;
  }
  for (i = 0; i < m; i++) {
    if (q[i].typ == 1) {
      for (j = q[i].l; j <= q[i].r; j++) {
        diff[j] += q[i].d;
      }
    } else {
      for (j = q[i].l; j <= q[i].r; j++) {
        b[j] = min(b[j], q[i].d - diff[j]);
      }
    }
  }
  for (i = 1; i <= n; i++) {
    a[i] = b[i];
    final[i] = a[i];
  }
  for (i = 0; i < m; i++) {
    if (q[i].typ == 1) {
      for (j = q[i].l; j <= q[i].r; j++) {
        a[j] += q[i].d;
      }
    } else {
      t1 = -2e9;
      for (j = q[i].l; j <= q[i].r; j++) {
        t1 = max(t1, a[j]);
      }
      if (t1 != q[i].d) {
        printf("NO\n");
        return 0;
      }
    }
  }
  printf("YES\n");
  for (i = 1; i <= n; i++) {
    printf("%d ", final[i]);
  }
  printf("\n");
  return 0;
}
