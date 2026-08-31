#include <bits/stdc++.h>
int main() {
  int n, h[30 + 1], a[30 + 1], ans = 0;
  std::scanf("%d", &n);
  for (int i = 1; i <= n; ++i) std::scanf("%d %d", &h[i], &a[i]);
  for (int i = 1; i <= n; ++i)
    for (int j = 1; j <= n; ++j)
      if (i != j && h[i] == a[j]) ++ans;
  std::printf("%d\n", ans);
}
