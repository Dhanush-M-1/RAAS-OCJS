#include <bits/stdc++.h>
using namespace std;
int n, m, w[600], a[1200], k[600], q[600], u[600], qs, ans;
int main() {
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) scanf("%d", w + i);
  for (int i = 1; i <= m; i++) {
    scanf("%d", a + i);
    if (!u[a[i]]) q[++qs] = a[i], u[a[i]] = 1;
  }
  for (int i = 1; i <= m; i++) {
    int s = 1, l = a[i];
    while (q[s] != a[i]) {
      k[q[s]]++;
      swap(l, q[s]);
      s++;
    }
    q[s] = l;
  }
  for (int i = 1; i <= n; i++) ans += k[i] * w[i];
  printf("%d\n", ans);
  return 0;
}
