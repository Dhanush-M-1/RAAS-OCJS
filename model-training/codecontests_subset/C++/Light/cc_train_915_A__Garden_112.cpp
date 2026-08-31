#include <bits/stdc++.h>
int main() {
  int n, k, i;
  scanf("%d %d", &n, &k);
  int a[n];
  for (i = 0; i < n; i++) {
    scanf("%d", &a[i]);
  }
  int min = k;
  for (i = 0; i < n; i++) {
    if (k % a[i] == 0 && k / a[i] < min) min = k / a[i];
  }
  printf("%d", min);
  return 0;
}
