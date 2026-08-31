#include <bits/stdc++.h>
using namespace std;
int c[1005];
int main() {
  int t;
  scanf("%d", &t);
  while (t--) {
    int n, m;
    scanf("%d%d", &n, &m);
    int cnt = 0;
    memset(c, 0, sizeof(c));
    for (int i = 1; i <= n; i++) {
      int x;
      scanf("%d", &x);
      if (c[x] == 0) c[x] = 1;
    }
    for (int i = 1; i <= m; i++) {
      int x;
      scanf("%d", &x);
      if (c[x] == 1) c[x] = 2, cnt++;
    }
    if (cnt == 0)
      printf("NO\n");
    else {
      printf("YES\n");
      for (int i = 1; i <= 1000; i++) {
        if (c[i] == 2) {
          printf("1 %d\n", i);
          break;
        }
      }
    }
  }
}
