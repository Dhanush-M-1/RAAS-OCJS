#include <bits/stdc++.h>
using namespace std;
int a[5005], b[5005];
int k;
struct elem {
  int t, l, r, m;
} p[5005];
int n, m;
bool solve() {
  int i, j;
  for (i = 1; i <= n; i++) a[i] = 1000000000;
  memset(b, 0, sizeof(b));
  for (i = 1; i <= m; i++) {
    if (p[i].t == 1) {
      for (j = p[i].l; j <= p[i].r; j++) b[j] += p[i].m;
    } else if (p[i].t == 2) {
      for (j = p[i].l; j <= p[i].r; j++) a[j] = min(a[j], p[i].m - b[j]);
    }
  }
  memset(b, 0, sizeof(b));
  for (i = 1; i <= m; i++) {
    if (p[i].t == 1) {
      for (j = p[i].l; j <= p[i].r; j++) b[j] += p[i].m;
    } else if (p[i].t == 2) {
      k = -1000000007;
      for (j = p[i].l; j <= p[i].r; j++) k = max(k, a[j] + b[j]);
      if (k != p[i].m) return false;
    }
  }
  return true;
}
int main() {
  while (~scanf("%d%d", &n, &m)) {
    int i;
    for (i = 1; i <= m; i++) {
      scanf("%d%d%d%d", &p[i].t, &p[i].l, &p[i].r, &p[i].m);
    }
    bool flag;
    flag = solve();
    if (!flag)
      printf("NO");
    else {
      printf("YES\n");
      for (i = 1; i <= n; i++)
        i == 1 ? printf("%d", a[i]) : printf(" %d", a[i]);
    }
    printf("\n");
  }
  return 0;
}
