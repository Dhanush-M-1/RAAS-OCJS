#include <bits/stdc++.h>
int main() {
  int n, c, max = 0;
  scanf("%d%d", &n, &c);
  int ar[n];
  for (int i = 0; i < n; i++) scanf("%d", &ar[i]);
  for (int i = 0; i < n - 1; i++) {
    if (ar[i] >= ar[i + 1]) {
      if (ar[i] - ar[i + 1] - c > max) max = ar[i] - ar[i + 1] - c;
    }
  }
  printf("%d", max);
  return 0;
}
