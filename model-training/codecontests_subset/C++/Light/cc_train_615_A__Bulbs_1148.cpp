#include <bits/stdc++.h>
using namespace std;
int a[105];
int main() {
  int n, m;
  while (~scanf("%d%d", &n, &m)) {
    int flag = 0;
    memset(a, 0, sizeof(a));
    int x, y;
    for (int i = 1; i <= n; i++) {
      scanf("%d", &x);
      for (int i = 1; i <= x; i++) {
        scanf("%d", &y);
        a[y]++;
      }
    }
    for (int i = 1; i <= m; i++) {
      if (a[i] == 0) flag = 1;
    }
    if (flag == 1)
      printf("NO\n");
    else
      printf("YES\n");
  }
  return 0;
}
