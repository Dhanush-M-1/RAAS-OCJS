#include <bits/stdc++.h>
int max(int, int);
int main() {
  int n, i, k, a[100000], s = 1;
  scanf("%d %d", &n, &k);
  for (i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  for (i = 0; i < n; i++) {
    if (k % a[i] == 0) s = max(a[i], s);
  }
  printf("%d", k / s);
  return 0;
}
int max(int a, int b) {
  if (a > b)
    return a;
  else
    return b;
}
