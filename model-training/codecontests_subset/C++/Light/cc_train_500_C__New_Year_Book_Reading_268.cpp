#include <bits/stdc++.h>
int main(void) {
  int n, d, i, j, k, ans = 0;
  scanf("%d %d", &n, &d);
  int w[n + 10], b[d + 10];
  for (i = 0; i < n; i++) scanf("%d", &w[i]);
  for (i = 0; i < d; i++) scanf("%d", &b[i]);
  bool visit[n + 10];
  for (i = 0; i < n + 10; i++) visit[i] = false;
  for (i = 0; i < d; i++) {
    for (k = 0; k < n + 10; k++) visit[k] = false;
    for (j = i - 1; j >= 0 && b[i] != b[j]; j--) {
      if (!visit[b[j]]) {
        ans += w[b[j] - 1];
        visit[b[j]] = true;
      }
    }
  }
  printf("%d", ans);
  return 0;
}
