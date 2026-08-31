#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m, diff[5001] = {}, a[5001], b[5001], t[5000], l[5000], r[5000],
            dm[5000];
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; ++i) a[i] = 1000000000;
  for (int i = 0; i < m; ++i) {
    scanf("%d%d%d%d", t + i, l + i, r + i, dm + i);
    for (int j = l[i]; j <= r[i]; ++j)
      if (t[i] == 1)
        diff[j] += dm[i];
      else
        a[j] = min(a[j], dm[i] - diff[j]);
  }
  for (int i = 1; i <= n; ++i) b[i] = a[i];
  for (int i = 0; i < m; ++i) {
    if (t[i] == 1)
      for (int j = l[i]; j <= r[i]; ++j) a[j] += dm[i];
    else if (*max_element(a + l[i], a + r[i] + 1) != dm[i]) {
      printf("NO\n");
      return 0;
    }
  }
  puts("YES");
  for (int i = 1; i <= n; ++i) printf("%d ", b[i]);
  puts("");
  return 0;
}
