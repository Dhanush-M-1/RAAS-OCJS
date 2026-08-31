#include <bits/stdc++.h>
int m, n, wei[600], day[1020], mark[600] = {0}, set[600], i, j, k, total = 0,
                               temp;
int main(int argc, char** argv) {
  scanf("%d%d", &m, &n);
  for (i = 1; i <= m; i++) scanf("%d", &wei[i]);
  for (i = 0, j = 0; i < n; i++) {
    scanf("%d", &day[i]);
    if (mark[day[i]] == 0) {
      set[j++] = day[i];
      mark[day[i]] = 1;
    }
  }
  for (i = 0; i < n; i++) {
    for (j = 0; j < m; j++) {
      if (day[i] == set[j]) {
        temp = set[j];
        for (k = j; k > 0; k--) set[k] = set[k - 1];
        set[0] = temp;
        break;
      } else
        total += wei[set[j]];
    }
  }
  printf("%d\n", total);
  return 0;
}
