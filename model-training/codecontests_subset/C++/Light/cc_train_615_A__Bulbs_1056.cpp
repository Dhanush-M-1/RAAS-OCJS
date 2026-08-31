#include <bits/stdc++.h>
int arr[101];
int main() {
  int n, m, x, i, j, tmp;
  scanf("%d %d", &n, &m);
  for (i = 0; i < n; i++) {
    scanf("%d", &x);
    for (j = 0; j < x; j++) {
      scanf("%d", &tmp);
      arr[tmp] = 1;
    }
  }
  for (i = 1; i <= m; i++) {
    if (!arr[i]) {
      printf("NO");
      return 0;
    }
  }
  printf("YES");
  return 0;
}
