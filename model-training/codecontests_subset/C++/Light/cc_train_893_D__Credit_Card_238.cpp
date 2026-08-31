#include <bits/stdc++.h>
int v[100001], s[100001], max[100001];
int main() {
  int n, d, i, nr, cr;
  scanf("%d%d", &n, &d);
  for (i = 1; i <= n; i++) scanf("%d", &v[i]);
  nr = 0;
  for (i = 1; i <= n; i++) {
    s[i] = s[i - 1] + v[i];
    if (s[i] > d) nr = -1;
  }
  max[n] = s[n];
  for (i = n - 1; i > 0; i--) {
    max[i] = max[i + 1];
    if (s[i] > max[i]) max[i] = s[i];
  }
  cr = 0;
  if (nr != -1) {
    for (i = 1; i <= n && nr != -1; i++)
      if (nr != -1 && v[i] == 0 && s[i] + cr < 0) {
        if (d - max[i] - cr >= 0) cr += (d - max[i] - cr);
        nr++;
        if (s[i] + cr < 0) nr = -1;
      }
  }
  printf("%d\n", nr);
  return 0;
}
