#include <bits/stdc++.h>
using namespace std;
int main() {
  int n;
  while (~scanf("%d", &n)) {
    int res, ans = 0;
    int st = 1, ed = 1000000, x;
    for (int i = 1; i <= n; i++) {
      scanf("%d", &x);
      res = min(x - st, ed - x);
      ans = max(res, ans);
    }
    printf("%d\n", ans);
  }
  return 0;
}
