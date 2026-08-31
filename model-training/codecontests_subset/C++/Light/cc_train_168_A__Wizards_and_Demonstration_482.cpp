#include <bits/stdc++.h>
using namespace std;
int n, x, y;
int main() {
  while (scanf("%d%d%d", &n, &x, &y) == 3) {
    int a = max(0, n * y - 100 * x), b = 100;
    printf("%d\n", a % b ? a / b + 1 : a / b);
  }
  return 0;
}
