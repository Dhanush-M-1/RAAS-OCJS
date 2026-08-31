#include <bits/stdc++.h>
int main() {
  int n, m, i, j;
  scanf("%d %d", &n, &m);
  int ara[m + 1];
  for (i = 1; i < m + 1; i++) {
    ara[i] = 0;
  }
  for (i = 0; i < n; i++) {
    int t;
    scanf("%d", &t);
    for (j = 0; j < t; j++) {
      int l;
      scanf("%d", &l);
      ara[l] = 1;
    }
  }
  int count = 0;
  for (i = 1; i < m + 1; i++) {
    if (ara[i] != 0) {
      count++;
    }
  }
  if (count == m)
    printf("YES\n");
  else
    printf("NO\n");
  return 0;
}
