#include <bits/stdc++.h>
using namespace std;
int base(int l, int n) {
  int basic = 1, t = 0;
  while (l > 0) {
    int r = l % n;
    t += r * basic;
    basic *= 10;
    l /= n;
  }
  return t;
}
int main() {
  int n, m, i, j, k, l;
  scanf("%d", &n);
  for (i = 1; i < n; i++) {
    for (j = 1; j < n; j++) {
      l = i * j;
      if (l < k)
        printf("%d ", l);
      else {
        printf("%d ", base(l, n));
      }
    }
    printf("\n");
  }
}
