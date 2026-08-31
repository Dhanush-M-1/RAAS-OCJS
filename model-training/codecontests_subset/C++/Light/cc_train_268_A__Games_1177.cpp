#include <bits/stdc++.h>
int main() {
  int i, j, n, data[35][2], cnt = 0;
  scanf("%d", &n);
  for (i = 1; i <= n; i++) {
    scanf("%d %d", &data[i][0], &data[i][1]);
  }
  for (i = 1; i <= n; i++) {
    for (j = 1; j <= n; j++) {
      if (i != j && data[i][0] == data[j][1]) cnt++;
    }
  }
  printf("%d", cnt);
  return 0;
}
