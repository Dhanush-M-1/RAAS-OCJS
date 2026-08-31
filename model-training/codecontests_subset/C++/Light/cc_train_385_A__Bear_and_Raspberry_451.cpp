#include <bits/stdc++.h>
int main() {
  int n;
  scanf("%d", &n);
  int i;
  int c;
  int a[1001];
  scanf("%d", &c);
  for (i = 0; i < n; i++) scanf("%d", &a[i]);
  int diff = -1;
  int max = 0;
  for (i = 0; i < n - 1; i++) {
    diff = a[i] - a[i + 1] - c;
    if (diff >= max) max = diff;
  }
  printf("%d", max);
  return 0;
}
