#include <bits/stdc++.h>
using namespace std;
const long double eps = 1e-2;
int n;
int main() {
  scanf("%d", &n);
  int i, j, a, b;
  int num = 0, big = -1;
  for (i = 1; i <= n; i++) {
    scanf("%d", &a);
    num += a;
    big = max(big, a);
  }
  for (i = big;; i++) {
    if (i * n - num > num) break;
  }
  printf("%d", i);
  return 0;
}
