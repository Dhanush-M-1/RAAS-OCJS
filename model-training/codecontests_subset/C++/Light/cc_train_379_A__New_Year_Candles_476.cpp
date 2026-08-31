#include <bits/stdc++.h>
int main() {
  int n, m;
  scanf("%d %d", &n, &m);
  for (int i = 1; i <= n; i++) {
    if (i % m == 0) n++;
  }
  printf("%d", n);
  return 0;
}
