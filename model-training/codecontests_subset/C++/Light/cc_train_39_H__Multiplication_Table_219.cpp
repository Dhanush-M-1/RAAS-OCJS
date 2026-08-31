#include <bits/stdc++.h>
using namespace std;
int base(int a, int x) {
  int cnt = 0, zz = 1;
  while (a) {
    cnt += (a % x) * zz;
    zz *= 10;
    a /= x;
  }
  return cnt;
}
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 1; i <= n - 1; i++) {
    for (int j = 1; j <= n - 1; j++) printf("%d ", base(i * j, n));
    printf("\n");
  }
  return 0;
}
