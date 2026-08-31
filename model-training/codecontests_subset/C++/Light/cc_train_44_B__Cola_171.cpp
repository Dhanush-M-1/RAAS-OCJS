#include <bits/stdc++.h>
using namespace std;
int a, b, c, n, ans;
int main() {
  int i, t, j, w;
  while (scanf("%d%d%d%d", &n, &a, &b, &c) != EOF) {
    ans = 0;
    t = n;
    for (i = 0; i <= c; ++i) {
      t = n;
      t -= (i * 2);
      if (t < 0) break;
      if (t == 0) {
        ans++;
        break;
      }
      for (j = 0; j <= a; j += 2) {
        w = t;
        w -= j / 2;
        if (w < 0) break;
        if (w == 0) {
          ans++;
          break;
        }
        if (w <= b) {
          ans++;
        }
      }
    }
    printf("%d\n", ans);
  }
}
