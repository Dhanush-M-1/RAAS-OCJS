#include <bits/stdc++.h>
int main(void) {
  int aracheck[100] = {0};
  int n, m, i, j, k, l;
  scanf("%d %d", &n, &m);
  for (i = 0; i < n; i++) {
    int n1;
    scanf("%d", &n1);
    for (j = 0; j < n1; j++) {
      int phi;
      scanf("%d", &phi);
      aracheck[phi] = 1;
    }
  }
  int count = 0;
  for (i = 1; i <= m; i++)
    if (aracheck[i] == 1) {
      count++;
    }
  if (count == m)
    printf("YES");
  else
    printf("NO");
  return 0;
}
