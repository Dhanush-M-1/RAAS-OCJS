#include <bits/stdc++.h>
int main() {
  int n;
  scanf("%d", &n);
  int h[n], g[n];
  for (int i(0); i < n; i++) {
    scanf("%d%d", &h[i], &g[i]);
  }
  int ans(0);
  for (int i(0); i < n; i++) {
    for (int j(i + 1); j < n; j++) {
      if (h[i] == g[j]) ans++;
      if (g[i] == h[j]) ans++;
    }
  }
  printf("%d\n", ans);
  return 0;
}
