#include <bits/stdc++.h>
using namespace std;
const int N(5010);
int n, m;
int t[N], l[N], r[N], v[N], x[N], d[N];
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; ++i) x[i] = 1000000000;
  for (int i = 0; i != m; ++i) {
    scanf("%d%d%d%d", &t[i], &l[i], &r[i], &v[i]);
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; ++j) d[j] += v[i];
    } else {
      for (int j = l[i]; j <= r[i]; ++j) x[j] = min(x[j], v[i] - d[j]);
    }
  }
  memset(d, 0, sizeof(d));
  for (int i = 0; i != m; ++i)
    if (t[i] == 1) {
      for (int j = l[i]; j <= r[i]; ++j) d[j] += v[i];
    } else {
      int m = -1 << 30;
      for (int j = l[i]; j <= r[i]; ++j) m = max(m, x[j] + d[j]);
      if (m != v[i]) {
        printf("NO\n");
        return 0;
      }
    }
  printf("YES\n");
  for (int i = 1; i <= n; ++i)
    if (i == n)
      printf("%d\n", x[i]);
    else
      printf("%d ", x[i]);
  return 0;
}
