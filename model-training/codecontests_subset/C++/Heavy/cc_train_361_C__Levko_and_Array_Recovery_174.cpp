#include <bits/stdc++.h>
using namespace std;
struct node {
  int ty, l, r, d;
} a[5005];
long long num[5005];
long long ans[5005];
const long long inf = 999999999999999;
int main() {
  int n, m;
  while (~scanf("%d%d", &n, &m)) {
    for (int i = 1; i <= n; i++) num[i] = inf;
    for (int i = 1; i <= m; i++) {
      int ty, l, r, d;
      scanf("%d%d%d%d", &ty, &l, &r, &d);
      a[i].ty = ty;
      a[i].l = l;
      a[i].r = r;
      a[i].d = d;
    }
    for (int i = m; i >= 1; i--) {
      long long ty, l, r, d;
      ty = a[i].ty;
      l = a[i].l;
      r = a[i].r;
      d = a[i].d;
      if (ty == 1) {
        for (int j = l; j <= r; j++) {
          if (num[j] != inf) num[j] -= d;
        }
      } else {
        for (int j = l; j <= r; j++) {
          num[j] = min(d, num[j]);
        }
      }
    }
    int f = 1;
    for (int i = 1; i <= n; i++) {
      if (num[i] == inf) num[i] = 0;
      ans[i] = num[i];
    }
    for (int i = 1; i <= m; i++) {
      int ty, l, r, d;
      ty = a[i].ty;
      l = a[i].l;
      r = a[i].r;
      d = a[i].d;
      if (ty == 1) {
        for (int j = l; j <= r; j++) {
          num[j] += d;
        }
      } else {
        long long maxn = -inf;
        for (int j = l; j <= r; j++) {
          maxn = max(maxn, num[j]);
        }
        if (maxn != d) {
          f = 0;
          break;
        }
      }
    }
    if (f == 1) {
      printf("YES\n");
      for (int i = 1; i < n; i++) printf("%lld ", ans[i]);
      printf("%lld\n", ans[n]);
    } else
      printf("NO\n");
  }
}
