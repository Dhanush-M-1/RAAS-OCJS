#include <bits/stdc++.h>
int main() {
  int i, n, res = 0, j;
  scanf("%d", &n);
  int h[n], g[n];
  for (i = 0; i < n; i++) scanf("%d %d", &h[i], &g[i]);
  for (i = 0; i < n; i++)
    for (j = 0; j < n; j++)
      if (h[i] == g[j]) res++;
  printf("%d", res);
}
