#include <bits/stdc++.h>
int main() {
  int n, a[110], c, i, d[110], max;
  scanf("%d%d", &n, &c);
  for (i = 0; i < n; i++) scanf("%d", &a[i]);
  for (i = 0; i < n - 1; i++) {
    d[i] = a[i] - a[i + 1];
  }
  max = -1001;
  for (i = 0; i < n - 1; i++) {
    if (d[i] > max) {
      max = d[i];
    }
  }
  max = max - c;
  if (max < 0)
    printf("0\n");
  else
    printf("%d\n", max);
  return 0;
}
