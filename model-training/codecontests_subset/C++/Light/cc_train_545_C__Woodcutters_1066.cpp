#include <bits/stdc++.h>
using namespace std;
const int maxn = 100005;
int i, j, k, m, n, last, ans;
struct wood {
  int p, l;
} w[maxn];
inline int cmp(wood a, wood b) { return a.p < b.p; }
int main() {
  scanf("%d", &n);
  for (i = 1; i <= n; i++) scanf("%d%d", &w[i].p, &w[i].l);
  sort(w + 1, w + 1 + n, cmp);
  if (n == 1) {
    puts("1");
    return 0;
  }
  ans = 2, last = w[1].p;
  for (i = 2; i < n; i++) {
    if (w[i].p - w[i].l > last)
      ans++, last = w[i].p;
    else if (w[i].p + w[i].l < w[i + 1].p)
      ans++, last = w[i].p + w[i].l;
    else
      last = w[i].p;
  }
  printf("%d\n", ans);
  return 0;
}
