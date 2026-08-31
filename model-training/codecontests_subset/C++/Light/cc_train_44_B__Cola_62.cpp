#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, i, j, a, b, c, ans;
  while (~scanf("%d%d%d%d", &n, &a, &b, &c)) {
    ans = 0;
    for (i = 0; i <= c; i++)
      for (j = 0; j <= b; j++) {
        int t = n - i * 2 - j;
        if (t >= 0 && a / 2 >= t) ans++;
      }
    printf("%d\n", ans);
  }
  return 0;
}
