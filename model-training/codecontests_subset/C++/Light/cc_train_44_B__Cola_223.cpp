#include <bits/stdc++.h>
using namespace std;
int n, a, b, c;
int calc(int x) {
  if (x == 0) return 1;
  if (a * 0.5 + b < x) return 0;
  return min(x, a / 2) - max(0, (x - b)) + 1;
}
int main() {
  scanf("%d%d%d%d", &n, &a, &b, &c);
  int tot = 0;
  for (int i = 0; i * 2 <= n && i <= c; ++i) {
    tot += calc(n - i * 2);
  }
  printf("%d\n", tot);
  return 0;
}
