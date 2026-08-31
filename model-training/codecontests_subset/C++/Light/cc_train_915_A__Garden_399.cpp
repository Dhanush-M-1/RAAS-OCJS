#include <bits/stdc++.h>
int n, k;
int a[110];
int max(int a, int b) {
  if (a >= b)
    return a;
  else
    return b;
}
int main() {
  scanf("%d%d", &n, &k);
  for (int i = 0; i < n; i++) scanf("%d", &a[i]);
  int ma = -1;
  for (int i = 0; i < n; i++) {
    if (k % a[i] == 0) ma = max(ma, a[i]);
  }
  printf("%d\n", k / ma);
  return 0;
}
