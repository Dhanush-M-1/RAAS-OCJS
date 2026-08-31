#include <bits/stdc++.h>
int n, k, a[1001];
int main() {
  scanf("%d %d", &n, &k);
  int i, min = k;
  for (i = 1; i <= n; i++) {
    scanf("%d", &a[i]);
    if (k / a[i] * a[i] == k && k / a[i] < min) min = k / a[i];
  }
  printf("%d", min);
}
