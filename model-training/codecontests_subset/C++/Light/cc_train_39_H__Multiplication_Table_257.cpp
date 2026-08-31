#include <bits/stdc++.h>
using namespace std;
int n, i, j, t, p;
void cg(int x) {
  t = 0;
  p = 1;
  while (x > 0) {
    t = t + x % n * p;
    x /= n;
    p *= 10;
  }
  printf("%d ", t);
  return;
}
int main() {
  scanf("%d", &n);
  for (i = 1; i < n; ++i) {
    for (j = 1; j < n; ++j) cg(i * j);
    printf("\n");
  }
  return 0;
}
