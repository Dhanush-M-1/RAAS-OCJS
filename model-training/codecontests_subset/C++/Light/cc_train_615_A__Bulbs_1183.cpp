#include <bits/stdc++.h>
using namespace std;
int main() {
  int n, m;
  while (scanf("%d %d", &n, &m) != EOF) {
    int a[1001];
    memset(a, 0, sizeof(a));
    for (int i = 1; i <= n; i++) {
      int j;
      scanf("%d", &j);
      while (j--) {
        int h;
        scanf("%d", &h);
        a[h] = 1;
      }
    }
    int ans = 0;
    for (int i = 1; i <= m; i++) {
      if (a[i] == 1) ans++;
    }
    if (ans == m)
      printf("YES\n");
    else
      printf("NO\n");
  }
  return 0;
}
