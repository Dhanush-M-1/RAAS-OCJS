#include <bits/stdc++.h>
int main(void) {
  int t;
  scanf("%d\n", &t);
  while (t--) {
    int n, m;
    scanf("%d %d\n", &n, &m);
    int a[n], b[m];
    for (int i = 0; i < n; i++) scanf("%d ", a + i);
    for (int i = 0; i < m; i++) scanf("%d ", b + i);
    int flag = 0, ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (a[i] == b[j]) {
          flag = 1;
          ans = a[i];
          break;
        }
      }
      if (flag) break;
    }
    if (flag)
      printf("YES\n1 %d\n", ans);
    else
      printf("NO\n");
  }
  return 0;
}
