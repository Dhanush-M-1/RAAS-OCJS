#include <bits/stdc++.h>
using namespace std;
int n, m, i, top, b, ans, tmp, j, k;
int f[10010], a[10010];
int main() {
  scanf("%d%d", &n, &m);
  for (i = 1; i <= n; i++) scanf("%d", &a[i]);
  for (i = 1; i <= m; i++) {
    scanf("%d", &b);
    if (top == 0) {
      top++;
      f[top] = b;
    } else {
      tmp = 0;
      for (j = top; j >= 1; j--)
        if (f[j] == b)
          break;
        else
          tmp = tmp + a[f[j]];
      ans = ans + tmp;
      if (j == 0) {
        top++;
        f[top] = b;
      } else {
        for (k = j + 1; k <= top; k++) f[k - 1] = f[k];
        f[top] = b;
      }
    }
  }
  printf("%d\n", ans);
}
