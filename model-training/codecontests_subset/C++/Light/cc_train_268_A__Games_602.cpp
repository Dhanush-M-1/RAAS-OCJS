#include <bits/stdc++.h>
int main() {
  int n, i, count = 0;
  scanf("%d", &n);
  int a[n], c[105] = {0};
  for (i = 0; i < n; i++) {
    int b = 0;
    scanf("%d%d", &a[i], &b);
    c[b]++;
  }
  for (i = 0; i < n; i++) count = count + c[a[i]];
  printf("%d", count);
}
