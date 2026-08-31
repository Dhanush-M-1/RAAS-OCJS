#include <bits/stdc++.h>
int d[110];
int main() {
  int n, m;
  scanf("%d%d", &n, &m);
  for (int i = 1; i <= n; i++) {
    int num, tmp;
    scanf("%d", &num);
    for (int k = 1; k <= num; k++) {
      scanf("%d", &tmp);
      d[tmp] = 1;
    }
  }
  for (int i = 1; i <= m; i++)
    if (!d[i]) {
      printf("NO");
      return 0;
    }
  printf("YES");
  return 0;
}
