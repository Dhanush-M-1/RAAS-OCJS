#include <bits/stdc++.h>
int min(int x, int y) { return x > y ? y : x; }
int max(int x, int y) { return x > y ? x : y; }
int abs(int x) { return x > 0 ? x : -x; }
int a[105];
int main() {
  int n, m;
  while (~scanf("%d %d", &n, &m)) {
    memset(a, 0, sizeof(a));
    for (int i = 1, x, q; i <= n; i++) {
      scanf("%d", &x);
      for (int i = 1; i <= x; i++) {
        scanf("%d", &q);
        a[q] = 1;
      }
    }
    bool f = true;
    for (int i = 1; i <= m; i++) {
      if (a[i] == 0) f = false;
    }
    printf("%s\n", f ? "YES" : "NO");
  }
}
