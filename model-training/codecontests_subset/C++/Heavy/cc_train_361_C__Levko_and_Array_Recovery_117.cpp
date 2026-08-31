#include <bits/stdc++.h>
using namespace std;
const int N = 100005;
int n, m, a[N], c[N], Z[N], L[N], R[N], D[N], z, l, r, d, flag;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; ++i) a[i] = 1000000000, c[i] = 0;
  for (int k = 1; k <= m; ++k) {
    scanf("%d%d%d%d", &z, &l, &r, &d);
    Z[k] = z, L[k] = l, R[k] = r, D[k] = d;
    for (int i = l; i <= r; ++i)
      if (z == 1)
        c[i] += d;
      else
        a[i] = min(a[i], d - c[i]);
  }
  for (int i = 1; i <= n; ++i) c[i] = 0;
  for (int k = 1; k <= m; ++k) {
    z = Z[k], l = L[k], r = R[k], d = D[k], flag = z != 2;
    for (int i = l; i <= r; ++i)
      if (z == 1)
        c[i] += d;
      else if (a[i] + c[i] == d)
        flag = 1;
    if (!flag) return puts("NO"), 0;
  }
  puts("YES");
  for (int i = 1; i <= n; ++i) printf("%d ", a[i]);
  return 0;
}
