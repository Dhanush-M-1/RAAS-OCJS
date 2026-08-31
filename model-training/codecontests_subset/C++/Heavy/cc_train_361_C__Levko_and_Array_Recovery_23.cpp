#include <bits/stdc++.h>
using namespace std;
const int N = 5005;
const int inf = 1e9;
struct T {
  int t, l, r, v;
} q[N];
int a[N];
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 0; i < int(m); ++i) {
    int t;
    int l, r, v;
    scanf("%d%d%d%d", &t, &l, &r, &v);
    q[i] = {t, l - 1, r - 1, v};
  }
  for (int i = 0; i < int(n); ++i) a[i] = inf;
  for (int i = 0; i < int(m); ++i) {
    if (q[i].t == 1) {
      for (int j = q[i].l; j <= q[i].r; ++j) a[j] += q[i].v;
    } else {
      for (int j = q[i].l; j <= q[i].r; ++j) a[j] = min(q[i].v, a[j]);
    }
  }
  for (int i = m - 1; i >= 0; --i)
    if (q[i].t == 1)
      for (int j = q[i].l; j <= q[i].r; ++j) a[j] -= q[i].v;
  for (int i = 0; i < int(n); ++i)
    if (a[i] > inf || a[i] < -inf) {
      puts("NO");
      return 0;
    }
  for (int i = 0; i < int(m); ++i) {
    if (q[i].t == 1) {
      for (int j = q[i].l; j <= q[i].r; ++j) a[j] += q[i].v;
    } else {
      int mx = -inf;
      for (int j = q[i].l; j <= q[i].r; ++j) mx = max(a[j], mx);
      if (mx != q[i].v) {
        puts("NO");
        return 0;
      }
    }
  }
  for (int i = m - 1; i >= 0; --i)
    if (q[i].t == 1)
      for (int j = q[i].l; j <= q[i].r; ++j) a[j] -= q[i].v;
  puts("YES");
  for (int i = 0; i < int(n); ++i)
    printf("%d%c", a[i], i + 1 == n ? '\n' : ' ');
}
