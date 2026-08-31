#include <bits/stdc++.h>
using namespace std;
struct zz {
  int type, l, r, data;
} a[(5005)];
int n, m, limit[(5005)], t[(5005)];
inline void t_add(int l, int r, int delta) {
  for (register int i = l; i <= r; ++i) t[i] += delta;
}
void limit_get() {
  for (register int i = 1; i <= n; ++i) t[i] = 0;
  for (register int i = 1; i <= n; ++i) limit[i] = 1000000000;
  for (int i = 1; i <= m; ++i) {
    if (a[i].type == 1)
      t_add(a[i].l, a[i].r, a[i].data);
    else
      for (int j = a[i].l; j <= a[i].r; ++j)
        if (a[i].data - t[j] < limit[j]) limit[j] = a[i].data - t[j];
  }
}
bool limit_check() {
  for (register int i = 1; i <= n; ++i) t[i] = 0;
  for (int i = 1; i <= m; ++i) {
    if (a[i].type == 1)
      t_add(a[i].l, a[i].r, a[i].data);
    else {
      int maxnum = -(1050000000);
      for (int j = a[i].l; j <= a[i].r; ++j)
        if (limit[j] + t[j] > maxnum) maxnum = limit[j] + t[j];
      if (maxnum != a[i].data) return false;
    }
  }
  return true;
}
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= m; ++i)
    scanf("%d%d%d%d", &a[i].type, &a[i].l, &a[i].r, &a[i].data);
  limit_get();
  if (limit_check()) {
    puts("YES");
    for (int i = 1; i <= n; ++i) printf("%d ", limit[i]);
  } else
    puts("NO");
  return 0;
}
