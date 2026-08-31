#include <bits/stdc++.h>
int main() {
  int n, k, ara[100], i, a, min = 100;
  scanf("%d%d", &n, &k);
  for (i = 0; i < n; i++) {
    scanf("%d", &ara[i]);
  }
  for (i = 0; i < n; i++) {
    if (k % ara[i] == 0) a = k / ara[i];
    if (min > a) min = a;
  }
  printf("%d", min);
  return 0;
}
